package com.pstcstest.paletteprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class EditPhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_photo);

        ImageButton HomeButton = (ImageButton) findViewById(R.id.homebutton_edit_photo);
        ImageButton BackToExtractButton = (ImageButton) findViewById(R.id.backbutton_edit_photo);
        Button ContinueButton = (Button) findViewById(R.id.continueButton);
        Button ZoomButton = (Button) findViewById(R.id.zoomButton);
        Button BrightnessButton = (Button) findViewById(R.id.brightnessButton);
        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startHomeScreenActivity();
            }
        });
        BackToExtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startHomeScreenActivity();
            }
        });
        ContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startExtractColorPhotoActivity();
            }


        });
        ZoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startZoomActivity();
            }
        });
        BrightnessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startBrightnessActivity();
            }
        });
    }
    private void startHomeScreenActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    private void startExtractColorPhotoActivity() {
        Intent intent = new Intent(this, ExtractColorPhotoActivity.class);
        startActivity(intent);
    }
    private void startZoomActivity() {
        Intent intent = new Intent(this, ZoomActivity.class);
        startActivity(intent);

    }
    private void startBrightnessActivity() {
        Intent intent = new Intent(this, BrightnessActivity.class);
        startActivity(intent);

    }
}