package com.inbergmarcano.mycvapp.rest.events

import com.inbergmarcano.mycvapp.ui.basicinformation.model.BasicInformation

data class GetBasicInformationsSuccessEvent (val basicInformations: ArrayList<BasicInformation>)