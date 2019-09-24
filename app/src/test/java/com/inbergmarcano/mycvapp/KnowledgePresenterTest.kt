package com.inbergmarcano.mycvapp

import com.inbergmarcano.mycvapp.rest.events.GetExperienceFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetExperienceSuccessEvent
import com.inbergmarcano.mycvapp.rest.events.GetKnowledgeFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetKnowledgeSuccessEvent
import com.inbergmarcano.mycvapp.ui.experience.presenter.ExperienceContract
import com.inbergmarcano.mycvapp.ui.experience.presenter.ExperiencePresenter
import com.inbergmarcano.mycvapp.ui.knowledge.presenter.KnowledgeContract
import com.inbergmarcano.mycvapp.ui.knowledge.presenter.KnowledgePresenter
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
class KnowledgePresenterTest {

    @Mock
    private lateinit var mView: KnowledgeContract.View
    @Mock
    private lateinit var mPresenter: KnowledgeContract.Presenter
    @Mock
    private lateinit var mDataManager: KnowledgeContract.DataManager
    @Mock
    private lateinit var mExperienceSuccessEvent: GetKnowledgeSuccessEvent
    @Mock
    private lateinit var mExperienceFailureEvent: GetKnowledgeFailureEvent

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mPresenter = KnowledgePresenter()
        mPresenter.subscribe(mView,
            mDataManager
        )
    }


    @Test
    fun loadData_success() {
        Mockito.`when`(mDataManager.getResumeKnowledge()).thenAnswer {
            EventBus.getDefault().post(mExperienceSuccessEvent)
            mPresenter.unsubscribe()
            return@thenAnswer mock(Unit::class.java)
        }
        mPresenter.loadData()
        Mockito.verify(mView, Mockito.atLeast(1)).loadDataSuccess(mExperienceSuccessEvent.knowledge)
    }

    @Test
    fun loadData_failure() {
        Mockito.`when`(mDataManager.getResumeKnowledge()).thenAnswer {
            EventBus.getDefault().post(mExperienceFailureEvent)
            mPresenter.unsubscribe()
            return@thenAnswer mock(Unit::class.java)
        }
        mPresenter.loadData()
        Mockito.verify(mView, Mockito.atLeast(1)).showErrorMessage(mExperienceFailureEvent.message)
    }
}