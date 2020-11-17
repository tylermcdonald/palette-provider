package com.pstcstest.paletteprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;

public class ResultsActivity extends AppCompatActivity {

    private LinearLayout colorBreakdownLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenHeight = displayMetrics.heightPixels;
        int screenWidth = displayMetrics.widthPixels;

        Intent intent = getIntent();
        HashMap<Integer, Integer> dividedColors = (HashMap<Integer, Integer>)intent.getSerializableExtra(getString(R.string.divided_colors_key));

        int targetColor = intent.getIntExtra(getString(R.string.target_color_key), 0);

        colorBreakdownLayout = (LinearLayout) findViewById(R.id.colorBreakdownLayout);

        RelativeLayout.LayoutParams colorRowLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        colorRowLayoutParams.setMargins(screenWidth / 8, 32, screenWidth / 8, 32);
        colorRowLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);

        RelativeLayout.LayoutParams colorSquareLayoutParams = new RelativeLayout.LayoutParams(172, 172);
        colorSquareLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        colorSquareLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);

        RelativeLayout.LayoutParams targetColorTextLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        targetColorTextLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        targetColorTextLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);

        RelativeLayout.LayoutParams colorTextLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        colorTextLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        RelativeLayout targetColorRow = new RelativeLayout(this);
        targetColorRow.setLayoutParams(colorRowLayoutParams);
        targetColorRow.setGravity(Gravity.CENTER_VERTICAL);

        TextView targetColorSquareView = createColorSquareView(targetColor, "", colorSquareLayoutParams);

        targetColorSquareView.setLayoutParams(colorSquareLayoutParams);

        TextView targetColorTextView = createColorTextView(getString(R.string.target_color), targetColorTextLayoutParams);

        targetColorRow.addView(targetColorSquareView);
        targetColorRow.addView(targetColorTextView);

        colorBreakdownLayout.addView(targetColorRow);

        char colorIndex = 'A';
        for(Integer color : dividedColors.keySet()){
            String colorPercentage = dividedColors.get(color)+"%";
            String colorString = "Color "+colorIndex;

            RelativeLayout colorRow = new RelativeLayout(this);
            colorRow.setLayoutParams(colorRowLayoutParams);
            colorRow.setGravity(Gravity.CENTER_VERTICAL);

            TextView colorSquareView = createColorSquareView(color, colorPercentage, colorSquareLayoutParams);
            TextView colorTextView = createColorTextView(colorString, colorTextLayoutParams);

            colorRow.addView(colorSquareView);
            colorRow.addView(colorTextView);

            colorBreakdownLayout.addView(colorRow);

            colorIndex += 1;
        }

        colorBreakdownLayout.invalidate();
    }

    TextView createColorTextView(String text, RelativeLayout.LayoutParams lp){
        TextView colorTextView = new TextView(this);

        colorTextView.setTextSize(36);
        colorTextView.setTextColor(ContextCompat.getColor(this, R.color.theme_text));
        colorTextView.setText(text);
        colorTextView.setLayoutParams(lp);

        return colorTextView;
    }
    TextView createColorSquareView(int color, String text, RelativeLayout.LayoutParams lp){
        TextView colorSquareView = new TextView(this);
        colorSquareView.setBackground(ContextCompat.getDrawable(this, R.drawable.color_square));
        GradientDrawable gradientDrawable = (GradientDrawable) colorSquareView.getBackground().mutate();
        gradientDrawable.setColor(color);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);

        if((red*0.299 + green*0.587 + blue*0.114) > 145) {
            colorSquareView.setTextColor(Color.BLACK);
        }else {
            colorSquareView.setTextColor(Color.WHITE);
        }

        colorSquareView.setTextSize(24);
        colorSquareView.setGravity(Gravity.CENTER);
        colorSquareView.setText(text);

        colorSquareView.setLayoutParams(lp);
        return colorSquareView;
    }
}