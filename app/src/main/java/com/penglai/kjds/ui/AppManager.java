package com.penglai.kjds.ui;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.os.Bundle;

import com.penglai.kjds.utils.AppUtils;
import com.penglai.kjds.utils.LogUtils;

import java.util.LinkedList;

/**
 * Activity及Service管理，以便实现退出功能
 *
 *  * 作者：朋来-GZQ on 2017/1/9 11:22
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class AppManager extends Application {
    //本类的实例
    private static AppManager instance;
    //保存所有Activity
    private LinkedList<Activity> activities = new LinkedList<Activity>();
    //保存所有Service
    private LinkedList<Service> services = new LinkedList<Service>();

    ///////////////////////////////////////////////////
    //自己添加的，不知道对不对
/*    private static Context mContext;*/

    @Override
    public void onCreate() {
        super.onCreate();

        AppUtils.init(this);
    }
/////////////////////////////////////////////////////////
    public static AppManager getInstance() {
        if (instance == null) {
            instance = new AppManager();
        }
        ////////////////////////////

        ///////
        ////////////////////////////
        return instance;
    }

    /**
     * 注册Activity以便集中“finish()”
     *
     * @param activity the activity
     * @see Activity#onCreate(Bundle)
     * @see Activity#onStart()
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * 移除Activity.
     *
     * @param activity the activity
     * @see Activity#onDestroy()
     * @see Activity#onStop()
     */
    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /**
     * 所有的Activity
     *
     * @return the activities
     */
    public LinkedList<Activity> getActivities() {
        return activities;
    }

    /**
     * 最后加入的Activity
     *
     * @return the activity
     */
    public Activity getLastActivity() {
        Activity activity = activities.getLast();
        LogUtils.debug(this, "last activity is " + activity.getClass().getName());
        return activity;
    }

    /**
     * 注册Service以便集中“stopSelf()”
     *
     * @param service the service
     */
    public void addService(Service service) {
        services.add(service);
    }

    /**
     * Remove service.
     *
     * @param service the service
     */
    public void removeService(Service service) {
        services.remove(service);
    }

    /**
     * 所有的Service
     *
     * @return the services
     */
    public LinkedList<Service> getServices() {
        return services;
    }

    /**
     * 退出软件
     */
    public void exitApp() {
        clearActivitiesAndServices();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);//normal exit application
    }

    /**
     * 当内存不足时，需要清除已打开的Activity及Service
     *
     * @see android.app.Application#onLowMemory()
     */
    public void clearActivitiesAndServices() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        for (Service service : services) {
            service.stopSelf();
        }
    }
}
