package com.pstcstest.paletteprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.pstcstest.paletteprovider.R;

public class ZoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);
        ImageButton HomeButton = (ImageButton) findViewById(R.id.homebutton_zoom_photo);
        ImageButton BackToExtractButton = (ImageButton) findViewById(R.id.backbutton_zoom_photo);
        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startHomeScreenActivity();
            }
        });
        BackToExtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startEditPhotoActivity();
            }
        });

    }
    private void startHomeScreenActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    private void startEditPhotoActivity() {
        Intent intent = new Intent(this, EditPhotoActivity.class);
        startActivity(intent);
    }
}