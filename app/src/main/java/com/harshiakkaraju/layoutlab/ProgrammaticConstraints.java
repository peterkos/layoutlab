package com.harshiakkaraju.layoutlab;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.constraint.Constraints;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class ProgrammaticConstraints extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ConstraintLayout layout = new ConstraintLayout(this);
        ConstraintLayout.LayoutParams params = new Constraints.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT);
        layout.setId(0);

        this.addContentView(layout, params);
        for (int i = 0; i < 4; i++) {
            Button button = new Button(this);
            button.setId(i + 1);
            button.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            button.setTextColor(getResources().getColor(R.color.white));

            CharSequence text = "Button " + button.getId();
            button.setText(text);

            layout.addView(button);

            ConstraintSet constraints = new ConstraintSet();
            constraints.clone(layout);

            // center the buttons horizontally
            constraints.connect(i + 1, ConstraintSet.LEFT, layout.getId(), ConstraintSet.LEFT);
            constraints.connect(i + 1, ConstraintSet.RIGHT, layout.getId(), ConstraintSet.RIGHT);

            // add vertical constraints
            if (i == 0) {
                constraints.connect(i + 1, ConstraintSet.TOP, layout.getId(), ConstraintSet.TOP, dpToPixels(this, 20));
            } else {
                constraints.connect(i + 1, ConstraintSet.TOP, i, ConstraintSet.BOTTOM, dpToPixels(this, 20));
            }

            constraints.applyTo(layout);
        }
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
