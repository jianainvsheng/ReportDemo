package com.report.demo.business.holder

import android.view.View
import android.widget.ListView
import android.widget.TextView
import com.report.demo.R
import com.report.demo.business.adapter.BottomAdapter
import com.report.demo.business.adapter.model.BottomData
import com.report.demo.business.event.TopEvent
import com.report.demo.imessage.IMessage
import com.report.demo.imessage.event.BuildEvent
import com.report.demo.imessage.holder.BaseEventHolder

/**
 * Created by yangjian on 2018/7/13.
 */
class BottomHolder(view : View, message: IMessage) : BaseEventHolder<List<BottomData>>(view,message){

    private var mListView : ListView

    private var mAdapter : BottomAdapter

    init {
        mListView = view.findViewById(R.id.activity_mian_bottom_listview) as ListView
        mAdapter = BottomAdapter()
        mListView.adapter = mAdapter
    }


    fun setListViewTop() = mListView.setSelection(0)

    override fun setData(data: List<BottomData>?) {
        super.setData(data)
        mAdapter.setDataList(data)
    }
}