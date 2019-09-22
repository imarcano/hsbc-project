package com.inbergmarcano.mycvapp.rest.events

import com.inbergmarcano.mycvapp.ui.knowledge.model.Knowledge

data class GetKnowledgeSuccessEvent (val knowledge: ArrayList<Knowledge>)