package com.report.demo.imessage

import com.report.demo.imessage.event.BaseEvent

/**
 * Created by yangjian on 2018/7/13.
 */
interface IMessage {

    open fun onMessage(event : BaseEvent)
}