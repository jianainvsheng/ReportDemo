package com.report.reportmodle.manager

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.report.reportmodle.manager.activity.ActivityManager
import com.report.reportmodle.manager.listener.PluginListener
import com.report.reportmodle.utils.ViewPathUtils

/**
 * Created by yangjian on 2018/7/16.
 */
 class ReportManager : Application.ActivityLifecycleCallbacks , PluginListener{

    private constructor()

    companion object {

        private var mReportManager : ReportManager? = null

        fun getIntance() : ReportManager{

            if(mReportManager == null){

                synchronized(ReportManager.javaClass){

                    if(mReportManager == null){

                        mReportManager = ReportManager()
                    }
                }
            }
            return mReportManager?: throw NullPointerException("单利创建失败")
        }
    }

    fun registerActivity(application: Application){

       ActivityManager.registerActivity(application)
    }

    fun unregisterActivity(application: Application){

        ActivityManager.unregisterActivity(application)
    }

    override fun onActivityPaused(activity: Activity) {

        Toast.makeText(activity, "activity : " + activity.javaClass.canonicalName + " | 生命周期为 ： onActivityPaused "  , Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResumed(activity: Activity) {

        Toast.makeText(activity, "activity : " + activity.javaClass.canonicalName + " | 生命周期为 ： onActivityResumed "  , Toast.LENGTH_SHORT).show()
    }

    override fun onActivityStarted(activity: Activity) {

        Toast.makeText(activity, "activity : " + activity.javaClass.canonicalName + " | 生命周期为 ： onActivityStarted "  , Toast.LENGTH_SHORT).show()
    }

    override fun onActivityDestroyed(activity: Activity) {

        Toast.makeText(activity, "activity : " + activity.javaClass.canonicalName + " | 生命周期为 ： onActivityDestroyed "  , Toast.LENGTH_SHORT).show()
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {

        Toast.makeText(activity, "activity : " + activity.javaClass.canonicalName + " | 生命周期为 ： onActivitySaveInstanceState "  , Toast.LENGTH_SHORT).show()
    }

    override fun onActivityStopped(activity: Activity) {

        Toast.makeText(activity, "activity : " + activity.javaClass.canonicalName + " | 生命周期为 ： onActivityStopped "  , Toast.LENGTH_SHORT).show()
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {

        Toast.makeText(activity, "activity : " + activity.javaClass.canonicalName + " | 生命周期为 ： onActivityCreated "  , Toast.LENGTH_SHORT).show()
    }


    override fun onClickEvent(view: View) {

        val viewId = ViewPathUtils.buildViewPath(view)
        Toast.makeText(view.context, "view path: " + viewId, Toast.LENGTH_SHORT).show()
    }

}