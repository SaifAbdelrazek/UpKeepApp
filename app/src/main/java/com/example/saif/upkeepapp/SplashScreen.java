package com.example.saif.upkeepapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class SplashScreen extends AppCompatActivity {
   private GifImageView splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
            actionBar.hide();
        getWindow().setBackgroundDrawableResource(R.drawable.splash_screen1);



        splash =(GifImageView)findViewById(R.id.splash);
        try {
            InputStream inputStream=getAssets().open("splash.gif");
            byte[] bytes= IOUtils.toByteArray(inputStream);
            splash.setBytes(bytes);
            splash.startAnimation();
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(SplashScreen.this,LoginActivity.class);
                SplashScreen.this.startActivity(i);
                SplashScreen.this.finish();
            }
        },3000);

    }
}
