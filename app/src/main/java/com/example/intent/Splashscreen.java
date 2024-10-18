package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splashscreen extends AppCompatActivity {
ImageView imageView;
TextView textView;
Animation imanim, teanim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splashscreen);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        imanim = AnimationUtils.loadAnimation(this, R.anim.imageanim);
        teanim = AnimationUtils.loadAnimation(this, R.anim.textanim);
        imageView.setAnimation(imanim);
        textView.setAnimation(teanim);
        final Handler myhandler = new Handler();
        myhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
            startActivity(new Intent(Splashscreen.this, MainActivity.class));
            finish();
            }
        },3000);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}