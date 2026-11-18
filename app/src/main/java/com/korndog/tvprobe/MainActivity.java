package com.korndog.tvprobe;

import android.app.Activity;
import android.os.Bundle;
import android.os.Build;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.content.pm.PackageManager;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

        boolean isTV = getPackageManager().hasSystemFeature(
            PackageManager.FEATURE_LEANBACK
        );

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        root.setPadding(48, 48, 48, 48);
        root.setBackgroundColor(Color.rgb(12, 12, 18));

        TextView text = new TextView(this);
        text.setTextColor(Color.rgb(160, 255, 65));
        text.setTextSize(23);
        text.setGravity(Gravity.CENTER);
        text.setText(
            "KORNDOG TV PROBE\n\n" +
            "Device: " + Build.MANUFACTURER +
            " " + Build.MODEL + "\n" +
            "Android: " + Build.VERSION.RELEASE + "\n" +
            "SDK: " + Build.VERSION.SDK_INT + "\n" +
            "Leanback: " + isTV + "\n\n" +
            "Standalone diagnostic build\n" +
            "Press BACK to exit"
        );

        root.addView(text);
        setContentView(root);
    }
}
