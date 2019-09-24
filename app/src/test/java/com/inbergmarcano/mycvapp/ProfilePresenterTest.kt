package com.inbergmarcano.mycvapp

import com.inbergmarcano.mycvapp.rest.events.*
import com.inbergmarcano.mycvapp.ui.experience.presenter.ExperienceContract
import com.inbergmarcano.mycvapp.ui.experience.presenter.ExperiencePresenter
import com.inbergmarcano.mycvapp.ui.knowledge.presenter.KnowledgeContract
import com.inbergmarcano.mycvapp.ui.knowledge.presenter.KnowledgePresenter
import com.inbergmarcano.mycvapp.ui.profile.presenter.ProfileContract
import com.inbergmarcano.mycvapp.ui.profile.presenter.ProfilePresenter
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
class ProfilePresenterTest {

    @Mock
    private lateinit var mView: ProfileContract.View
    @Mock
    private lateinit var mPresenter: ProfileContract.Presenter
    @Mock
    private lateinit var mDataManager: ProfileContract.DataManager
    @Mock
    private lateinit var mExperienceSuccessEvent: GetProfileSuccessEvent
    @Mock
    private lateinit var mExperienceFailureEvent: GetProfileFailureEvent

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mPresenter = ProfilePresenter()
        mPresenter.subscribe(mView,
            mDataManager
        )
    }


    @Test
    fun loadData_success() {
        Mockito.`when`(mDataManager.getResumeProfile()).thenAnswer {
            EventBus.getDefault().post(mExperienceSuccessEvent)
            mPresenter.unsubscribe()
            return@thenAnswer mock(Unit::class.java)
        }
        mPresenter.loadData()
        Mockito.verify(mView, Mockito.atLeast(1)).loadDataSuccess(mExperienceSuccessEvent.data)
    }

    @Test
    fun loadData_failure() {
        Mockito.`when`(mDataManager.getResumeProfile()).thenAnswer {
            EventBus.getDefault().post(mExperienceFailureEvent)
            mPresenter.unsubscribe()
            return@thenAnswer mock(Unit::class.java)
        }
        mPresenter.loadData()
        Mockito.verify(mView, Mockito.atLeast(1)).showErrorMessage(mExperienceFailureEvent.message)
    }
}