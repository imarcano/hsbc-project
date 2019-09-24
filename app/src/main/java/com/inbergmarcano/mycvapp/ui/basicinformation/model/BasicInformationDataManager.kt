package com.inbergmarcano.mycvapp.ui.basicinformation.model

import androidx.annotation.NonNull
import com.inbergmarcano.mycvapp.rest.ResumeEndpoints
import com.inbergmarcano.mycvapp.rest.events.GetBasicInformationFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetBasicInformationSuccessEvent
import com.inbergmarcano.mycvapp.rest.models.BasicInformationList
import com.inbergmarcano.mycvapp.ui.basicinformation.presenter.BasicInformationContract
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import javax.inject.Singleton

@Singleton
class BasicInformationDataManager (private val resumeEndpoints: ResumeEndpoints): BasicInformationContract.DataManager {

        override fun getResumeBasicInformation() {
            val callback = object : Callback<BasicInformationList> {
                override fun onResponse(@NonNull call: Call<BasicInformationList>, @NonNull response: retrofit2.Response<BasicInformationList>) {
                    if (response.isSuccessful) {
                        EventBus.getDefault().post(GetBasicInformationSuccessEvent(response.body()!!.basicInformations))
                    } else {
                        EventBus.getDefault().post(GetBasicInformationFailureEvent(response.message()))
                    }
                }

                override fun onFailure(@NonNull call: Call<BasicInformationList>, @NonNull t: Throwable) {
                    EventBus.getDefault().post(GetBasicInformationFailureEvent(t.localizedMessage))
                }
            }
            resumeEndpoints.getBasicInformation().enqueue(callback)
        }

}