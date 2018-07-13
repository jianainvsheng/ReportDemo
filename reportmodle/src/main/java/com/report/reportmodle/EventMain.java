package com.report.reportmodle;

import android.view.View;
import android.widget.Toast;
import com.annotate.report.develop.onclick.OnClickReport;
import com.report.reportmodle.utils.ViewPathUtils;

/**
 * Created by yangjian on 2018/7/5.
 */

public class EventMain {

    @OnClickReport
    public static void onClickEvent(View view){

        String viewId = ViewPathUtils.Companion.buildViewPath(view);
        Toast.makeText(view.getContext(),"view path: " + viewId,Toast.LENGTH_SHORT).show();
    }
}
