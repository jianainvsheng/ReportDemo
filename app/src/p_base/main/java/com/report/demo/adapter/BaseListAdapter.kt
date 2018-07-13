package com.report.demo.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.report.demo.R
import com.report.demo.adapter.data.ListData
import com.report.demo.holder.BaseHolder

/**
 * Created by yangjian on 2018/7/13.
 */
open abstract class  BaseListAdapter<T : ListData,H : BaseHolder<T>> : BaseAdapter(){

    private var mDataList : ArrayList<T>? = null

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var viewHolder : H? = null

        if(convertView == null){

            viewHolder = onCreateViewHolder(parent,getItemViewType(position))
            viewHolder?.getContextView()?.setTag(R.id.id_type_listview,viewHolder)
        }else{
            viewHolder = convertView?.getTag(R.id.id_type_listview) as H
        }

        onBindViewHolder(viewHolder,position)
        return viewHolder?.getContextView()
    }

    override fun getItem(position: Int): Any {

        return mDataList?.get(position)?: throw NullPointerException("数据为空")
    }

    fun setDataList(dataList : List<T> ? ){

        if(mDataList == null){

            mDataList = ArrayList()
        }
        mDataList?.clear()
        if(dataList == null){
            notifyDataSetChanged()
            return
        }
        mDataList?.addAll(dataList)
        notifyDataSetChanged()
    }

    fun addDataList(dataList : List<T> ?){
        if(mDataList == null){
            mDataList = ArrayList()
        }
        if(dataList == null){
            return
        }
        mDataList?.addAll(dataList)
        notifyDataSetChanged()
    }

    fun getListData() = mDataList


    override fun getItemId(position: Int): Long {

        return position.toLong()
    }

    override fun getCount(): Int {

        return mDataList?.size?: 0
    }

    override fun getItemViewType(position: Int): Int {

        val type = mDataList?.get(position)?.type

        return type?: 0
    }

    override fun getViewTypeCount(): Int {

        val typeCount = getTypeCount()
        if(typeCount <= 1){
            return super.getViewTypeCount()
        }else{
            return typeCount
        }

    }
    abstract fun getTypeCount() : Int

    abstract fun onCreateViewHolder(parent: ViewGroup?,type : Int) : H

    abstract fun onBindViewHolder(holder: H , position : Int)

}