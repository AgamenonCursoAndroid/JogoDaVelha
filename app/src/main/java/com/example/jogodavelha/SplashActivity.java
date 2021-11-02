package com.example.jogodavelha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        trocarTela();
    }

    private void trocarTela() {
        int tempo = 5000 * 1;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent trocar = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(trocar);
                finish();
            }
        }, tempo);
    }
}