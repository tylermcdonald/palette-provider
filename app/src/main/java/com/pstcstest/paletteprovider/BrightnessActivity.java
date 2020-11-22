package com.pstcstest.paletteprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.pstcstest.paletteprovider.R;

public class BrightnessActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brightness);
        ImageButton HomeButtonBrightness = (ImageButton) findViewById(R.id.homebutton_brightness_photo);
        ImageButton BackButtonBrightness = (ImageButton) findViewById(R.id.backbutton_brightness_photo);

        BackButtonBrightness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startEditActivity();
            }
        });
        HomeButtonBrightness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startHomeScreenActivity();
            }
        });
    }
    private void startHomeScreenActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    private void startEditActivity() {
        Intent intent = new Intent(this, EditPhotoActivity.class);
        startActivity(intent);

    }
}
