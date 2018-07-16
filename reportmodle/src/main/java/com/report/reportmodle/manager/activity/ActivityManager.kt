package com.report.reportmodle.manager.activity

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.report.reportmodle.manager.ReportManager

/**
 * Created by yangjian on 2018/7/16.
 */
class ActivityManager {

    companion object {

        private var mBinder:ActitivityBinder? = null

        fun registerActivity(application:Application) {

            if(mBinder == null){

                mBinder = ActitivityBinder()
            }else
                return

            application.registerActivityLifecycleCallbacks(mBinder)
        }

        fun unregisterActivity(application: Application){

            if(mBinder != null){
                application.unregisterActivityLifecycleCallbacks(mBinder)
                mBinder= null
            }
        }

        class ActitivityBinder : Application.ActivityLifecycleCallbacks{

            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {

                if(activity != null){

                    ReportManager.getIntance().onActivityCreated(activity,savedInstanceState)
                }
            }

            override fun onActivityDestroyed(activity: Activity?) {

                if(activity != null){
                    ReportManager.getIntance().onActivityDestroyed(activity)
                }
            }

            override fun onActivityPaused(activity: Activity?) {

                if(activity != null){
                    ReportManager.getIntance().onActivityPaused(activity)
                }
            }

            override fun onActivityResumed(activity: Activity?) {

                if(activity != null){
                    ReportManager.getIntance().onActivityResumed(activity)
                }
            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {

                if(activity != null){

                    ReportManager.getIntance().onActivitySaveInstanceState(activity,outState)
                }
            }

            override fun onActivityStarted(activity: Activity?) {

                if(activity != null){

                    ReportManager.getIntance().onActivityStarted(activity)
                }
            }

            override fun onActivityStopped(activity: Activity?) {

                if(activity != null){

                    ReportManager.getIntance().onActivityStopped(activity)
                }
            }
        }
    }
}