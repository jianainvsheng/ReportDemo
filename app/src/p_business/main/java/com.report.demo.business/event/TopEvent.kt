package com.report.demo.business.event

import com.report.demo.imessage.event.BuildEvent

/**
 * Created by yangjian on 2018/7/13.
 */
class TopEvent : BuildEvent<TopEvent>() {

    companion object {

        val ACTIVITY_BOTTOM_UPDATA = 1
    }
}