package com.czm.xcindenttextview;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;

/**
 */
public class PhoneUtil {
    public static int TAB_BOTTOM_TYPE = 0;
    public static int TAB_TOP_TYPE = 0;
    private static boolean deviceDataInited = false;
    private static float displayMetricsDensity;
    private static int displayMetricsWidthPixels;
    private static int displayMetricsHeightPixels;
    private static int SCREEN_WIDTH_PX_CACHE = -1;
    private static int SCREEN_HEIGHT_PX_CACHE = -1;

    public static void initDeviceData(Context context) {
        DisplayMetrics displayMetrics = null;
        if (context.getResources() != null && (displayMetrics = context.getResources().getDisplayMetrics()) != null) {
            displayMetricsDensity = displayMetrics.density;
            displayMetricsWidthPixels = displayMetrics.widthPixels;
            displayMetricsHeightPixels = displayMetrics.heightPixels;
        }
        deviceDataInited = true;
    }

    public static int dip2px(Context context, float dipValue) {
        if (!deviceDataInited) {
            initDeviceData(context);
        }

        return (int) (dipValue * displayMetricsDensity + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        if (!deviceDataInited) {
            initDeviceData(context);
        }

        return (int) (pxValue / displayMetricsDensity + 0.5f);
    }

    public static int getScreenWidthPx(Context context) {
        if (SCREEN_WIDTH_PX_CACHE < 0) {
            Display display = ((Activity) context).getWindowManager().getDefaultDisplay();
            SCREEN_WIDTH_PX_CACHE = display.getWidth();
        }

        return SCREEN_WIDTH_PX_CACHE;
    }

    public static int getScreenHeightPx(Context context) {
        if (SCREEN_HEIGHT_PX_CACHE < 0) {
            Display display = ((Activity) context).getWindowManager().getDefaultDisplay();
            SCREEN_HEIGHT_PX_CACHE = display.getHeight();
        }

        return SCREEN_HEIGHT_PX_CACHE;
    }


}
