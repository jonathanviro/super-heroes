package com.javr.super_heroes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.javr.super_heroes.databinding.ActivityDetailBinding;
import com.javr.super_heroes.databinding.ActivityMainBindingImpl;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //FORMA 1: RECIBIR DATOS POR PARAMETRO DESDE OTRO ACTIVITY
        /*Bundle extras = getIntent().getExtras();
        binding.txtHeroName.setText(extras.getString("strHeroName"));
        binding.txtDescAlterEgo.setText(extras.getString("strAlterEgo"));
        binding.txtDescBio.setText(extras.getString("strShortBio"));
        binding.rtbPowerDetail.setRating(extras.getFloat("fltPower"));*/

        //FORMA 2: RECIBIR DATOS POR UN OBJETO DESDE OTRO ACTIVITY
        Bundle extras = getIntent().getExtras();
        Hero objHero = extras.getParcelable("objHero");
        Bitmap bitmap = extras.getParcelable("photoHero");
        /*binding.setObjHero(objHero);*/
        if (bitmap != null){
            binding.imageView.setImageBitmap(bitmap);
        }

        //Se comenta por que al utilizar Data Binding no es necesario hacerlo desde el .java sino que directamente desde el .xml
        binding.txtHeroName.setText(objHero.getName());
        binding.txtDescAlterEgo.setText(objHero.getAlterEgo());
        binding.txtDescBio.setText(objHero.getShortBio());
        binding.rtbPowerDetail.setRating(objHero.getPower());


    }
}