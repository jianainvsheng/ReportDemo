package com.report.demo.business

import android.os.Bundle
import com.report.demo.BaseActivity
import com.report.demo.R
import com.report.demo.business.adapter.model.BottomData
import com.report.demo.business.event.TopEvent
import com.report.demo.business.holder.BottomHolder
import com.report.demo.business.holder.TopHolder
import com.report.demo.imessage.event.BaseEvent

/**
 * Created by yangjian on 2018/7/13.
 */
class MainActivity :BaseActivity(){

    private lateinit var mTopHolder : TopHolder

    private lateinit var mBottomHolder : BottomHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTopHolder = TopHolder(this.findViewById(R.id.activity_main_top_layout),this)

        var data : BottomData ? = null
        val list = ArrayList<BottomData>()
        for(i in 0..30){

            data = BottomData()
            data?.name = "item : " + i
            list.add(data)
        }
        mBottomHolder = BottomHolder(this.findViewById(R.id.activity_main_bottom_layout),this)
        mBottomHolder.setData(list)
    }
    override fun onMessage(event: BaseEvent) {

        when (event.eventAction){

            TopEvent.ACTIVITY_BOTTOM_UPDATA ->{

                mBottomHolder.setListViewTop()
            }
        }
    }
}