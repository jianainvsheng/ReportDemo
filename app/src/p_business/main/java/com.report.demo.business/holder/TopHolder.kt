package com.report.demo.business.holder

import android.view.View
import android.widget.TextView
import com.report.demo.R
import com.report.demo.business.event.TopEvent
import com.report.demo.imessage.IMessage
import com.report.demo.imessage.event.BuildEvent
import com.report.demo.imessage.holder.BaseEventHolder

/**
 * Created by yangjian on 2018/7/13.
 */
class TopHolder(view : View,message: IMessage) : BaseEventHolder<String>(view,message){

    var mTextView : TextView

    init {
        mTextView = view.findViewById(R.id.activity_main_top_button) as TextView
        mTextView.setOnClickListener({ v ->
            BuildEvent.builder(TopEvent::class.java).
                    setEventAction(TopEvent.ACTIVITY_BOTTOM_UPDATA).
                    sentMessage(getTargetMessage())
        })
    }

    override fun setData(data: String?) {
        super.setData(data)
        setTextView(data,View.INVISIBLE,mTextView)
    }
}