package com.report.demo.imessage.event

import com.report.demo.imessage.IMessage

/**
 * Created by yangjian on 2018/7/13.
 */
open class BaseEvent {

    var eventAction : Int = -1

    fun sentMessage(target : IMessage){

        target.onMessage(this)
    }
}