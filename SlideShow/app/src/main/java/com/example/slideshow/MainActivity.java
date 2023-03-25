package com.example.slideshow;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private int currentImageIndex = 0;
    private int[] images = {R.drawable.deolane, R.drawable.blogueirinha, R.drawable.pipokinha,R.drawable.konka};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(images[currentImageIndex]);

        Button buttonProximo = findViewById(R.id.button_proximo);
        buttonProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentImageIndex++;
                if(currentImageIndex==images.length){
                     currentImageIndex = 0;
                }
                imageView.setImageResource(images[currentImageIndex]);
            }
        });
        Button button_anterior = findViewById(R.id.button_anterior);
        button_anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentImageIndex--;
                if(currentImageIndex<0){
                    currentImageIndex = images.length -1;
                }
                imageView.setImageResource(images[currentImageIndex]);
            }
        });
        Button buttonHome = findViewById(R.id.button_home);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentImageIndex = 0;
                imageView.setImageResource(images[currentImageIndex]);
            }
        });
    }
}