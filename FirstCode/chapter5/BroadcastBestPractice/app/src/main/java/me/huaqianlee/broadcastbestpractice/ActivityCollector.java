package me.huaqianlee.broadcastbestpractice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee on 2017/3/24.
 */

public class ActivityCollector {

    public static List<Activity>  activityLists = new ArrayList<>();

    public static void addActivity (Activity activity) {
        activityLists.add(activity);
    }

    public static void removeActivity (Activity activity) {
        activityLists.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activityLists) {
            if (!activity.isFinishing())
            activity.finish();
        }
    }

}
