package com.javr.super_heroes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.javr.super_heroes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Bitmap bitmapFoto;
    public static int PHOTO_REQUEST_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSave.setOnClickListener(v -> {
            String strHeroName = binding.edtHeroName.getText().toString();
            String strAlterEgo = binding.edtAlterEgo.getText().toString();
            String strShortBio = binding.edtDescription.getText().toString();
            float fltPower = binding.rtbPower.getRating();

            Hero objHero = new Hero(strHeroName, strAlterEgo, strShortBio, fltPower);
            openDetailActivity(objHero);
        });

        binding.imgHero.setOnClickListener(v -> {
            openCamera();
        });
    }

    private void openCamera(){
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, PHOTO_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && requestCode == PHOTO_REQUEST_CODE){
            if(data != null){
                bitmapFoto = data.getExtras().getParcelable("data");
                binding.imgHero.setImageBitmap(bitmapFoto);
            }else{
                Toast.makeText(this, "Error al tomar foto", Toast.LENGTH_SHORT).show();
            }
            
        }
    }

    private void openDetailActivity(Hero objHero) {
        Intent intent = new Intent(this, DetailActivity.class);
        /*intent.putExtra("strHeroName", strHeroName);
        intent.putExtra("strAlterEgo", strAlterEgo);
        intent.putExtra("strShortBio", strShortBio);
        intent.putExtra("fltPower", fltPower);*/
        intent.putExtra("objHero", objHero);
        intent.putExtra("photoHero", bitmapFoto);
        startActivity(intent);
    }
}