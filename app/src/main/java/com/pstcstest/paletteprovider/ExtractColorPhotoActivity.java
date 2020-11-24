package com.pstcstest.paletteprovider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.skydoves.colorpickerview.ColorPickerView;
import com.skydoves.colorpickerview.listeners.ColorListener;
import com.skydoves.colorpickerview.sliders.AlphaSlideBar;
import com.skydoves.colorpickerview.sliders.BrightnessSlideBar;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class ExtractColorPhotoActivity extends AppCompatActivity {
    final Map<Integer, HashMap<Integer, PaletteColor>> POSSIBLE_COLORS = new HashMap<>();

    private void createPossibleColors(){

        HashMap<Integer, PaletteColor> lightGrey = new HashMap<>();

        lightGrey.put(Color.rgb(255, 255, 255), new PaletteColor(80, "White"));
        lightGrey.put(Color.rgb(0, 0, 0), new PaletteColor(20, "Black"));
        POSSIBLE_COLORS.put(Color.rgb(200, 200, 200), lightGrey);

        HashMap<Integer, PaletteColor> darkGrey = new HashMap<>();
        darkGrey.put(Color.rgb(255, 255, 255), new PaletteColor(20, "White"));
        darkGrey.put(Color.rgb(0, 0, 0), new PaletteColor(80, "Black"));
        POSSIBLE_COLORS.put(2631720, darkGrey);

        HashMap<Integer, PaletteColor> darkBlue = new HashMap<>();
        darkBlue.put(Color.rgb(0, 0, 255), new PaletteColor(70, "True Blue"));
        darkBlue.put(Color.rgb(0, 0, 0), new PaletteColor(15, "Black"));
        darkBlue.put(Color.rgb(255, 158, 0), new PaletteColor(15, "Bright Orange"));
        POSSIBLE_COLORS.put(Color.rgb(0, 0, 185), darkBlue);

        HashMap<Integer, PaletteColor> purple = new HashMap<>();
        purple.put(Color.rgb(158, 0, 0),  new PaletteColor(45, "Santa Red"));
        purple.put(Color.rgb(0, 0, 255), new PaletteColor(45, "True Blue"));
        purple.put(Color.rgb(0, 55, 255),  new PaletteColor(10, "Ocean Blue"));
        POSSIBLE_COLORS.put(Color.rgb(160, 0, 158), purple);

        HashMap<Integer, PaletteColor> pink = new HashMap<>();
        pink.put(Color.rgb(0, 0, 158),  new PaletteColor(45, "Primary Blue"));
        pink.put(Color.rgb(255, 0, 0),  new PaletteColor(45, "True Red"));
        pink.put(Color.rgb(0, 155, 0),  new PaletteColor(10, "Avocado"));
        POSSIBLE_COLORS.put(Color.rgb(255, 155, 158), pink);

        HashMap<Integer, PaletteColor> orange = new HashMap<>();
        orange.put(Color.rgb(255, 0, 0),  new PaletteColor(70, "True Red"));
        orange.put(Color.rgb(0, 145, 0),  new PaletteColor(25, "Avocado"));
        orange.put(Color.rgb(0, 0, 150),  new PaletteColor(5, "Primary Blue"));
        POSSIBLE_COLORS.put(Color.rgb(255, 145, 54), orange);

        HashMap<Integer, PaletteColor> teal = new HashMap<>();
        teal.put(Color.rgb(0, 255, 0), new PaletteColor(70, "Festive Green"));
        teal.put(Color.rgb(0, 0, 193), new PaletteColor(25, "True Blue"));
        teal.put(Color.rgb(222, 222, 222), new PaletteColor(5, "Slate"));
        POSSIBLE_COLORS.put(Color.rgb(15, 255, 193), teal);


        HashMap<Integer, PaletteColor> darkRed = new HashMap<>();

        darkRed.put(Color.rgb(255, 0, 0),  new PaletteColor(70, "True Red"));
        darkRed.put(Color.rgb(0, 55, 255),  new PaletteColor(20, "Ocean Blue"));
        darkRed.put(Color.rgb(0, 0, 0), new PaletteColor(10, "Black"));
        POSSIBLE_COLORS.put(Color.rgb(131, 52, 52), darkRed);

        HashMap<Integer, PaletteColor> lightBlue = new HashMap<>();

        lightBlue.put(Color.rgb(0, 0, 255), new PaletteColor(70, "True Blue"));
        lightBlue.put(Color.rgb(255, 255, 255), new PaletteColor(20, "White"));
        lightBlue.put(Color.rgb(0, 255, 0), new PaletteColor(10, "Festive Green"));
        POSSIBLE_COLORS.put(Color.rgb(0xa2, 0xd7, 0xdd), lightBlue);

        HashMap<Integer, PaletteColor> lightGreen = new HashMap<>();

        lightGreen.put(Color.rgb(255, 255, 255), new PaletteColor(80, "White"));
        lightGreen.put(Color.rgb(0, 255, 0), new PaletteColor(20, "Festive Green"));
        POSSIBLE_COLORS.put(Color.rgb(0xf1, 0xff, 0xed), lightGreen);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extract_color_photo);

        createPossibleColors();
        ImageView imageView = findViewById(R.id.extractColorImage);
//        Bitmap bitmap = (Bitmap) getIntent().getParcelableExtra("Image");
//        imageView.setImageBitmap(bitmap);
        ImageButton HomeButton = (ImageButton) findViewById(R.id.homebutton_extract_photo);
        ImageButton BackToExtractButton = (ImageButton) findViewById(R.id.backbutton_extract_photo);

        ColorPickerView colorPickerView = (ColorPickerView) findViewById(R.id.colorPickerViewImage);
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.alma465);

//            final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
        Drawable drawable = new BitmapDrawable(getResources(), bm);
        colorPickerView.setPaletteDrawable(drawable);

        colorPickerView.setColorListener(new ColorListener() {
            @Override
            public void onColorSelected(int color, boolean fromUser) {
                // SliderBars seems to only work when given a ColorListener
            }
        });

        AlphaSlideBar alphaSlideBar = findViewById(R.id.alphaSlideBarPhoto);
        colorPickerView.attachAlphaSlider(alphaSlideBar);

        BrightnessSlideBar brightnessSlideBar = findViewById(R.id.brightnessSlidePhoto);
        colorPickerView.attachBrightnessSlider(brightnessSlideBar);

        Button mixThisColorButtonPhoto = (Button) findViewById(R.id.mixThisColorButtonPhoto);
        mixThisColorButtonPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = colorPickerView.getColor();
                startResultsActivity(color);
            }
        });
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

    private HashMap<Integer, PaletteColor> divideSelectedColor(int targetColor){
        int targetGreen = Color.green(targetColor);
        int targetRed = Color.red(targetColor);
        int targetBlue = Color.blue(targetColor);

        Integer bestApproxColor = -1;
        Integer smallestDiff = Integer.MAX_VALUE;
        for(Integer color : POSSIBLE_COLORS.keySet()){
            int green = Color.green(color);
            int red = Color.red(color);
            int blue = Color.blue(color);
            int diff = Math.abs(targetBlue-blue) + Math.abs(targetRed-red) +Math.abs(targetGreen-green);
            if(diff < smallestDiff){
                smallestDiff = diff;
                bestApproxColor = color;
            }
        }
        if(bestApproxColor == -1){
            System.out.println("HERE");
            return POSSIBLE_COLORS.get(Color.rgb(200, 200, 200));
        }

        return POSSIBLE_COLORS.get(bestApproxColor);
    }

    private void startResultsActivity(int targetColor){
        Intent intent = new Intent(this, ResultsActivity.class);

        HashMap<Integer, PaletteColor> dividedColors = divideSelectedColor(targetColor);

        System.out.println(dividedColors);
        intent.putExtra(getString(R.string.target_color_key), targetColor);
        intent.putExtra(getString(R.string.divided_colors_key), dividedColors);
        startActivity(intent);
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