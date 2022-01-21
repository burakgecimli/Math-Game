package com.bugcompany.matematikoyunu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    TextView textViewSlogan, textViewAppName;
    ImageView imageViewLogo;
    Animation bottomAnimation, topAnimation, leftAnimation, rightAnimation;

    private static int time = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        leftAnimation = AnimationUtils.loadAnimation(this, R.anim.left_anim);
        rightAnimation = AnimationUtils.loadAnimation(this, R.anim.right_anim);

        imageViewLogo = findViewById(R.id.imageViewLogo);
        textViewAppName = findViewById(R.id.textViewAppName);
        textViewSlogan = findViewById(R.id.textViewSlogan);

        imageViewLogo.setAnimation(bottomAnimation);
        textViewAppName.setAnimation(leftAnimation);
        textViewSlogan.setAnimation(rightAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, time);
    }
}
