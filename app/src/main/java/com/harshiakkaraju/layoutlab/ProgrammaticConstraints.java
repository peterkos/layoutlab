package com.harshiakkaraju.layoutlab;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class ProgrammaticConstraints extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Converts from dp to px
     * @param context
     * @param dp
     * @return
     */
    public static int dpToPixels(Context context, int dp) {
        return Math.round(dp * context.getResources().getDisplayMetrics().density);
    }
}
