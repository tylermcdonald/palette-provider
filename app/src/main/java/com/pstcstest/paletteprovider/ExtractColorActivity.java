package com.pstcstest.paletteprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.palette.graphics.Palette;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ExtractColorActivity extends AppCompatActivity {

    Button mixThisColorButton;


    boolean isPictureExtraction;

    private HashMap<Integer, Integer> divideSelectedColor(Integer rgb){
        HashMap<Integer, Integer> colorDivisionMap = new HashMap<>();

        colorDivisionMap.put(Color.BLUE, 40);
        colorDivisionMap.put(Color.GREEN, 40);
        colorDivisionMap.put(Color.RED, 20);

        return colorDivisionMap;
    }

    private void startResultsActivity(){

        Integer targetColor = Color.YELLOW;

        Intent intent = new Intent(this, ResultsActivity.class);

        HashMap<Integer, Integer> dividedColors = divideSelectedColor(targetColor);

        intent.putExtra(getString(R.string.target_color_key), targetColor);
        intent.putExtra(getString(R.string.divided_colors_key), dividedColors);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extract_color);


        isPictureExtraction = getIntent().getBooleanExtra(getString(R.string.is_picture_extraction_key), false);
        if(isPictureExtraction){
            // Handle turning activity into picture extraction activity
        }else{
            // Handle turning activity into color wheel extraction activity
        }

        mixThisColorButton = (Button) findViewById(R.id.mixThisColorButton);

        mixThisColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startResultsActivity();
            }
        });
    }


}