package com.anwesome.ui.dotrotmodule;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.ViewGroup;

/**
 * Created by anweshmishra on 03/01/17.
 */
public class AddDotRotHelper {
    private Point dimension = new Point();
    private Activity activity;
    public AddDotRotHelper(Activity activity) {
        this.activity = activity;
    }
    public void setup() {
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        DisplayManager displayManager = (DisplayManager)activity.getSystemService(Context.DISPLAY_SERVICE);
        Display display = displayManager.getDisplay(0);
        if(display!=null) {
            display.getRealSize(dimension);
        }
    }
    public void addView() {
        if(dimension!=null) {
            DotRotView dotRotView = new DotRotView(activity.getApplicationContext());
            dotRotView.setX(dimension.x / 2-dimension.x/8);
            dotRotView.setElevation(20);
            activity.addContentView(dotRotView, new ViewGroup.LayoutParams(dimension.x / 4, dimension.x / 4));
        }
    }
}
