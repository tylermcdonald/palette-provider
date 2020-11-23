package com.pstcstest.paletteprovider;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
public class ExtractColorPhotoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extract_color_photo);
        ImageView imageView = findViewById(R.id.extractColorImage);
        Bitmap bitmap = (Bitmap) getIntent().getParcelableExtra("Image");
        imageView.setImageBitmap(bitmap);
        ImageButton HomeButton = (ImageButton) findViewById(R.id.homebutton_extract_photo);
        ImageButton BackToExtractButton = (ImageButton) findViewById(R.id.backbutton_extract_photo);
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


//package com.pstcstest.paletteprovider;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ImageButton;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class ExtractColorPhotoActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_extract_color_photo);
//        ImageButton HomeButton = (ImageButton) findViewById(R.id.homebutton_extract_photo);
//        ImageButton BackToExtractButton = (ImageButton) findViewById(R.id.backbutton_extract_photo);
//
//        HomeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startHomeScreenActivity();
//            }
//        });
//        BackToExtractButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startEditPhotoActivity();
//            }
//        });
//
//    }
//
//    private void startHomeScreenActivity() {
//        Intent intent = new Intent(this, HomeActivity.class);
//        startActivity(intent);
//    }
//    private void startEditPhotoActivity() {
//        Intent intent = new Intent(this, EditPhotoActivity.class);
//        startActivity(intent);
//    }
//}
