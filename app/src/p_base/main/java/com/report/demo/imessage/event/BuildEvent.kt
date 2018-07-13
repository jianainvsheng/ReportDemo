package com.report.demo.imessage.event

/**
 * Created by yangjian on 2018/7/13.
 */
open class BuildEvent<E : BuildEvent<E>> : BaseEvent() {

    fun setEventAction(eventAction:Int) : E {

        this.eventAction = eventAction
        return this as E
    }

    companion object {

         fun <E : BuildEvent<E>> builder(cls : Class<E>) : E {

            return cls.newInstance()
        }
    }
}