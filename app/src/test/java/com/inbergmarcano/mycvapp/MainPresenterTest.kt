package com.inbergmarcano.mycvapp

import com.inbergmarcano.mycvapp.rest.events.*
import com.inbergmarcano.mycvapp.ui.main.model.Header
import com.inbergmarcano.mycvapp.ui.main.presenter.MainContract
import com.inbergmarcano.mycvapp.ui.main.presenter.MainPresenter
import org.greenrobot.eventbus.EventBus
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Answers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations


@RunWith(JUnit4::class)
class MainPresenterTest {

    @Mock
    private lateinit var mView: MainContract.View
    @Mock
    private lateinit var mPresenter: MainContract.Presenter
    @Mock
    private lateinit var mDataManager: MainContract.DataManager
    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private lateinit var mHeaderSuccessEvent: GetHeaderSuccessEvent
    @Mock
    private lateinit var mHeaderFailureEvent: GetHeaderFailureEvent

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mPresenter = MainPresenter()
        mPresenter.subscribe(mView,
            mDataManager
        )
    }


    @Test
    fun loadData_success() {
        Mockito.`when`(mDataManager.getResumeHeader()).thenAnswer {
            EventBus.getDefault().post(mHeaderSuccessEvent)
            return@thenAnswer mock(Unit::class.java)
        }
        mPresenter.loadData()
        Mockito.verify(mView, Mockito.atLeast(1)).customizeHeaderName(mHeaderSuccessEvent.data.name)
        Mockito.verify(mView, Mockito.atLeast(1)).customizeHeaderEmail(mHeaderSuccessEvent.data.email)
        Mockito.verify(mView, Mockito.atLeast(1)).customizeHeaderPicture(mHeaderSuccessEvent.data.picture)
    }

    @Test
    fun loadData_failure() {
        Mockito.`when`(mDataManager.getResumeHeader()).thenAnswer {
            EventBus.getDefault().post(mHeaderFailureEvent)
            mPresenter.unsubscribe()
            return@thenAnswer mock(Unit::class.java)
        }
        mPresenter.loadData()
        Mockito.verify(mView, Mockito.atLeast(1)).showErrorMessage(mHeaderFailureEvent.message)
    }
}