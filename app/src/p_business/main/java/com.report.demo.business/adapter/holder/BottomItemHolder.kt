package com.report.demo.business.adapter.holder

import android.view.View
import android.widget.TextView
import com.report.demo.R
import com.report.demo.business.adapter.model.BottomData
import com.report.demo.holder.BaseHolder

/**
 * Created by yangjian on 2018/7/13.
 */
class BottomItemHolder(view : View) : BaseHolder<BottomData>(view){


    override fun setData(data: BottomData?) {
        super.setData(data)
        setTextView(data,View.INVISIBLE,mTextView)
    }
    var mTextView : TextView

    init {
        mTextView = view.findViewById(R.id.activity_main_item_button) as TextView
        mTextView.setOnClickListener({ v ->

        })
    }

    fun setTextView(text : BottomData? ,disVisibliity : Int, textView: TextView){

        if(text!= null && !isEmpty(text?.name)){
            textView.visibility = View.VISIBLE
            textView.text = text.name
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