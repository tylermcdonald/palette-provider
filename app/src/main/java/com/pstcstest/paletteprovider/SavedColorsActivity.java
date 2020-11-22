package com.pstcstest.paletteprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SavedColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_colors);
        ImageButton HomeSC = (ImageButton) findViewById(R.id.homebutton_sc_photo);
        ImageButton BackSC = (ImageButton) findViewById(R.id.backbutton_sc_photo);
        HomeSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startHomeScreenActivity();
            }
        });
        BackSC.setOnClickListener(new View.OnClickListener() {
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
}