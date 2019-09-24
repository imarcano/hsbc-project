package com.inbergmarcano.mycvapp

import com.inbergmarcano.mycvapp.rest.events.GetExperienceFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetExperienceSuccessEvent
import com.inbergmarcano.mycvapp.ui.experience.presenter.ExperienceContract
import com.inbergmarcano.mycvapp.ui.experience.presenter.ExperiencePresenter
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
class ExperiencePresenterTest {

    @Mock
    private lateinit var mView: ExperienceContract.View
    @Mock
    private lateinit var mPresenter: ExperienceContract.Presenter
    @Mock
    private lateinit var mDataManager: ExperienceContract.DataManager
    @Mock
    private lateinit var mExperienceSuccessEvent: GetExperienceSuccessEvent
    @Mock
    private lateinit var mExperienceFailureEvent: GetExperienceFailureEvent

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mPresenter = ExperiencePresenter()
        mPresenter.subscribe(mView,
            mDataManager
        )
    }


    @Test
    fun loadData_success() {
        Mockito.`when`(mDataManager.getResumeExperience()).thenAnswer {
            EventBus.getDefault().post(mExperienceSuccessEvent)
            mPresenter.unsubscribe()
            return@thenAnswer mock(Unit::class.java)
        }
        mPresenter.loadData()
        Mockito.verify(mView, Mockito.atLeast(1)).loadDataSuccess(mExperienceSuccessEvent.experiences)
    }

    @Test
    fun loadData_failure() {
        Mockito.`when`(mDataManager.getResumeExperience()).thenAnswer {
            EventBus.getDefault().post(mExperienceFailureEvent)
            mPresenter.unsubscribe()
            return@thenAnswer mock(Unit::class.java)
        }
        mPresenter.loadData()
        Mockito.verify(mView, Mockito.atLeast(1)).showErrorMessage(mExperienceFailureEvent.message)
    }
}