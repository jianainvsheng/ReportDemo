package com.report.demo.application

import android.app.Application
import com.report.reportmodle.manager.ReportManager

/**
 * Created by yangjian on 2018/7/16.
 */
class ReportApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ReportManager.getIntance().registerActivity(this)
    }
}