package com.inbergmarcano.mycvapp

import com.inbergmarcano.mycvapp.rest.events.GetBasicInformationFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetBasicInformationSuccessEvent
import com.inbergmarcano.mycvapp.ui.basicinformation.presenter.BasicInformationContract
import com.inbergmarcano.mycvapp.ui.basicinformation.presenter.BasicInformationPresenter
import org.greenrobot.eventbus.EventBus
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations


@RunWith(JUnit4::class)
class BasicInformationPresenterTest {

    @Mock
    private lateinit var mView: BasicInformationContract.View
    @Mock
    private lateinit var mPresenter: BasicInformationContract.Presenter
    @Mock
    private lateinit var mDataManager: BasicInformationContract.DataManager
    @Mock
    private lateinit var mBasicInformationSuccessEvent: GetBasicInformationSuccessEvent
    @Mock
    private lateinit var mBasicInformationFailureEvent: GetBasicInformationFailureEvent

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mPresenter = BasicInformationPresenter()
        mPresenter.subscribe(mView,
            mDataManager
        )
    }


    @Test
    fun loadData_success() {
        Mockito.`when`(mDataManager.getResumeBasicInformation()).thenAnswer {
            EventBus.getDefault().post(mBasicInformationSuccessEvent)
            mPresenter.unsubscribe()
            return@thenAnswer mock(Unit::class.java)
        }
        mPresenter.loadData()
        Mockito.verify(mView, Mockito.atLeast(1)).loadDataSuccess(mBasicInformationSuccessEvent.basicInformations)
    }

    @Test
    fun loadData_failure() {
        Mockito.`when`(mDataManager.getResumeBasicInformation()).thenAnswer {
            EventBus.getDefault().post(mBasicInformationFailureEvent)
            mPresenter.unsubscribe()
            return@thenAnswer mock(Unit::class.java)
        }
        mPresenter.loadData()
        Mockito.verify(mView, Mockito.atLeast(1)).showErrorMessage(mBasicInformationFailureEvent.message)
    }
}