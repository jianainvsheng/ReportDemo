package com.report.demo.business.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.report.demo.R
import com.report.demo.adapter.BaseListAdapter
import com.report.demo.business.adapter.holder.BottomItemHolder
import com.report.demo.business.adapter.model.BottomData

/**
 * Created by yangjian on 2018/7/13.
 */
class BottomAdapter : BaseListAdapter<BottomData,BottomItemHolder>() {

    override fun getTypeCount(): Int {

        return 1
    }

    override fun onCreateViewHolder(parent: ViewGroup?, type: Int): BottomItemHolder {

        val view = LayoutInflater.from(parent?.context).inflate(
                R.layout.activity_main_bottom_item_type_1,
                parent,false)
        return BottomItemHolder(view)
    }

    override fun onBindViewHolder(holder: BottomItemHolder, position: Int) {

        holder.setData(getListData()?.get(position))
    }
}