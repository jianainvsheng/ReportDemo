package com.report.demo.imessage.holder

import android.view.View
import android.widget.TextView
import com.report.demo.holder.BaseHolder
import com.report.demo.imessage.IMessage

/**
 * Created by yangjian on 2018/7/13.
 */
open class BaseEventHolder<E>(view : View , val message:IMessage) : BaseHolder<E>(view) {


    fun getTargetMessage() : IMessage = message


    fun setTextView(text : String? ,disVisibliity : Int, textView: TextView){

        if(!isEmpty(text)){
            textView.visibility = View.VISIBLE
            textView.text = text
        }else{

            textView.visibility = disVisibliity
        }
    }

    fun isEmpty(s : String?) : Boolean {

        if(s != null && !"".equals(s)){

            return false
        }
        return true
    }
}