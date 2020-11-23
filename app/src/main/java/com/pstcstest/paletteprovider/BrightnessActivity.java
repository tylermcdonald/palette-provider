package com.pstcstest.paletteprovider;
// Brightness adjustment code references https://www.youtube.com/watch?v=MyL4AUBbB2w&ab_channel=FilipVujovic
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.pstcstest.paletteprovider.R;
public class BrightnessActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brightness);
        ImageView imageView = findViewById(R.id.editPhotoImage);
        Bitmap bitmap = (Bitmap) getIntent().getParcelableExtra("Image");
        imageView.setImageBitmap(bitmap);
        ImageButton HomeButtonBrightness = (ImageButton) findViewById(R.id.homebutton_brightness_photo);
        ImageButton BackButtonBrightness = (ImageButton) findViewById(R.id.backbutton_brightness_photo);
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.alma465);
//        ImageView imageView = (ImageView) findViewById(R.id.editPhotoImage);
//        imageView.setImageBitmap(bitmap);
        PictureThread pictureThread = new PictureThread(imageView, bitmap);
        pictureThread.start();
        SeekBar seekbar = (SeekBar) findViewById(R.id.seekbar);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                pictureThread.adjustBrightness(seekBar.getProgress()-255);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        Button okButton = (Button) findViewById(R.id.okayBrightness);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BrightnessActivity.this, EditPhotoActivity.class);
                imageView.invalidate();
                BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                intent.putExtra("Image", bitmap);
                startActivity(intent);
            }
        });
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


//package com.pstcstest.paletteprovider;
//
//import androidx.appcompat.app.AppCompatActivity;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.SeekBar;
//import com.pstcstest.paletteprovider.R;
//public class BrightnessActivity extends AppCompatActivity{
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_brightness);
//        ImageButton HomeButtonBrightness = (ImageButton) findViewById(R.id.homebutton_brightness_photo);
//        ImageButton BackButtonBrightness = (ImageButton) findViewById(R.id.backbutton_brightness_photo);
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.alma465);
//        ImageView imageView = (ImageView) findViewById(R.id.editPhotoImage);
//        imageView.setImageBitmap(bitmap);
//        PictureThread pictureThread = new PictureThread(imageView, bitmap);
//        pictureThread.start();
//        SeekBar seekbar = (SeekBar) findViewById(R.id.seekbar);
//        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                pictureThread.adjustBrightness(seekBar.getProgress()-255);
//            }
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//            }
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//            }
//        });
//        BackButtonBrightness.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startEditActivity();
//            }
//        });
//        HomeButtonBrightness.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startHomeScreenActivity();
//            }
//        });
//    }
//    private void startHomeScreenActivity() {
//        Intent intent = new Intent(this, HomeActivity.class);
//        startActivity(intent);
//    }
//    private void startEditActivity() {
//        Intent intent = new Intent(this, EditPhotoActivity.class);
//        startActivity(intent);
//    }
//}