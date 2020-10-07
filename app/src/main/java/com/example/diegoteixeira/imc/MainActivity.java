package com.example.diegoteixeira.imc;

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

    public void gerarRelatorio(View view) {
        Intent it = new Intent(getBaseContext(), ReportNutritional.class);
        startActivity(it);
    }
}