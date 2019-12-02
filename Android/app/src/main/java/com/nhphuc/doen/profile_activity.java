package com.nhphuc.doen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class profile_activity extends AppCompatActivity {

    ImageView imgAvatar;
    int REQUEST_CODE_CAMERA = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);

        AnhXa();

        ChangeAvt();
    }

    public void AnhXa(){
        imgAvatar = (ImageView) findViewById(R.id.imageViewAvatarProfile);
    }

    public void  ChangeAvt(){
        imgAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(profile_activity.this, new String[]{Manifest.permission.CAMERA},REQUEST_CODE_CAMERA);
            }
        });
    }

    public void onRequestPermissionsResult(int requestCode,String[] permissions, int[] grantResult){
        if(requestCode == REQUEST_CODE_CAMERA && grantResult.length > 0 && grantResult[0] == PackageManager.PERMISSION_GRANTED){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, REQUEST_CODE_CAMERA);
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResult);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data != null){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgAvatar.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
