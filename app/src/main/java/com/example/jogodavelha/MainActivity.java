package com.example.jogodavelha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void HomemHomem(View view) {
        Intent intent = new Intent(MainActivity.this, HomemHomemActivity.class);
        startActivity(intent);
    }

    public void HomemMaquina(View view) {
        Intent intent = new Intent(MainActivity.this, HomemMaquinaActivity.class);
        startActivity(intent);
    }

}