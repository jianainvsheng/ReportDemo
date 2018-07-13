package com.report.demo.holder

import android.content.Context
import android.view.View

/**
 * Created by yangjian on 2018/7/13.
 */
open class BaseHolder<T>( val view : View) {

    private var mData : T? = null

    fun getContextView() : View = view

    fun getContext() : Context = view.context

    open fun setData(data : T?) {

        this.mData = data
    }

}