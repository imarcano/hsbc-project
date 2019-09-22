package com.inbergmarcano.mycvapp.rest.events

import com.inbergmarcano.mycvapp.ui.basicinformation.model.BasicInformation
import com.inbergmarcano.mycvapp.ui.experience.model.Experience

data class GetExperienceSuccessEvent (val experiences: ArrayList<Experience>)