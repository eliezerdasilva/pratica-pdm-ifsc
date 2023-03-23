package com.example.pratica_10_03;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    private View Sorteio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciaNovaActivity(v);
            }
        });

    }
    public void iniciaNovaActivity(View view){
        Intent i = new Intent(getApplicationContext(), Sorteio.class);
        startActivity(i);
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d("metodoscallback","onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("metodoscallback","onResume");

    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d("metodoscallback","onPause");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("metodoscallback","onRestart");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d("metodoscallback","onStop");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("metodoscallback","onDestroy");
    }



}