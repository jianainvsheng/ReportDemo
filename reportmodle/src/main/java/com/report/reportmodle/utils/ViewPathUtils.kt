package com.report.reportmodle.utils

import android.support.design.widget.TabLayout
import android.support.v7.widget.ContentFrameLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.HorizontalScrollView
import android.widget.ListView


/**
 * Created by yangjian on 2018/7/13.
 */
class ViewPathUtils(){

    companion object {

     public fun buildViewPath(view : View) : String{

         val start = System.currentTimeMillis();
         var tempView = view
         var sb =  StringBuilder()
         try {
             //当前view类型
             val viewType = view.javaClass.simpleName
             sb.append("|" + viewType)
             val id = view.id
             if (id != View.NO_ID) {
                 sb.append("." + view.resources.getResourceEntryName(id))
             }

             while (tempView.parent is View) {
                 val viewGroup : View =  tempView.parent as View
                 val viewGroupId = viewGroup.id
                 if (viewGroup is ListView) {
                     if (viewGroupId != View.NO_ID) {
                         sb.insert(0, "[" + viewGroup.getPositionForView(tempView) + "]")
                     }
                 } else if (viewGroup is android.support.v4.view.ViewPager) {
                     if (viewGroupId != View.NO_ID) {
                         sb.insert(0, "[" + (viewGroup).currentItem + "]")
                     }
                 } else if (viewGroup is RecyclerView) {
                     if (viewGroupId != View.NO_ID) {
                         sb.insert(0, "[" + viewGroup.getChildAdapterPosition(tempView) + "]")
                     }
                 } else if (viewGroup is GridView) {
                     if (viewGroupId != View.NO_ID) {
                         sb.insert(0, "[" + viewGroup.getPositionForView(tempView) + "]")
                     }
                 } else if (viewGroup is HorizontalScrollView) {
                     if (viewGroupId != View.NO_ID) {
                         if(viewGroup is TabLayout){
                             val tabViewParent = view.parent
                             if(tabViewParent != null && tabViewParent is ViewGroup){
                                 val tab =  tabViewParent
                                 sb.insert(0, "[" + ((tab.getParent()) as ViewGroup).indexOfChild(tab) + "]")
                             }
                         }else{
                             sb.insert(0, "[" + (view.parent as ViewGroup).indexOfChild(view) + "]")
                         }
                     }
                 } else if (viewGroup is ContentFrameLayout) {
//                break;
                 }
                 //父view类型
                 val viewGroupType = viewGroup.javaClass.simpleName
                 if (viewGroupId != View.NO_ID) {
                     sb.insert(0, "|" + viewGroupType)
                 }
                 tempView =  tempView.parent as View
             }
//            Logger.e(Utils.TAG, "buildViewPath 计算view路径 耗时：" + (System.currentTimeMillis() - start));
         } catch (e : Exception) {

         }
         return sb.toString()
     }
    }
}