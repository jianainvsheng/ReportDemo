package com.report.reportmodle;

import android.view.View;
import com.annotate.report.develop.onclick.OnClickReport;
import com.report.reportmodle.manager.ReportManager;

/**
 * Created by yangjian on 2018/7/5.
 */

public class EventMain{

    @OnClickReport
    public static void onClickEvent(View view){

        ReportManager.Companion.getIntance().onClickEvent(view);
    }


}
