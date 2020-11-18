package com.pstcstest.paletteprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ExtractColorActivity extends AppCompatActivity {
    public static final int PICK_IMAGE = 1;

    Button mixThisColorButton;
    View lightVibrantColorView, vibrantColorView, darkVibrantColorView, lightMutedColorView, mutedColorView, darkMutedColorView;

    public Bitmap parsePickImageResult(Intent data) {
        Uri selectedImage = data.getData();
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        if (selectedImage != null) {
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();
                return BitmapFactory.decodeFile(picturePath);
            }
        }
        return null;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE) {
            Bitmap bitmap = parsePickImageResult(data);

//            ImageView mImg = (ImageView) findViewById(R.id.extractColorImage);
//            mImg.setImageBitmap(bitmap);
            Palette p = Palette.from(bitmap).generate();

            if(p.getLightVibrantSwatch() != null){
                lightVibrantColorView.setBackgroundColor(p.getLightVibrantSwatch().getRgb());
            }
            if(p.getVibrantSwatch() != null){
                vibrantColorView.setBackgroundColor(p.getVibrantSwatch().getRgb());
            }
            if(p.getDarkVibrantSwatch() != null){
                darkVibrantColorView.setBackgroundColor(p.getDarkVibrantSwatch().getRgb());
            }
            if(p.getLightMutedSwatch() != null){
                lightMutedColorView.setBackgroundColor(p.getLightMutedSwatch().getRgb());
            }
            if(p.getMutedSwatch() != null){
                mutedColorView.setBackgroundColor(p.getMutedSwatch().getRgb());
            }
            if(p.getDarkMutedSwatch() != null){
                darkMutedColorView.setBackgroundColor(p.getDarkMutedSwatch().getRgb());
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extract_color_colorwheel);


        mixThisColorButton = (Button) findViewById(R.id.mixThisColorButton);
        lightVibrantColorView = (View) findViewById(R.id.lightVibrantColorView);
        vibrantColorView = (View) findViewById(R.id.vibrantColorView);
        darkVibrantColorView = (View) findViewById(R.id.darkVibrantColorView);
        lightMutedColorView = (View) findViewById(R.id.lightMutedColorView);
        mutedColorView = (View) findViewById(R.id.mutedColorView);
        darkMutedColorView = (View) findViewById(R.id.darkMutedColorView);

        mixThisColorButton.setOnClickListener(view -> {
            Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(pickPhoto, 1);
        });
    }


}