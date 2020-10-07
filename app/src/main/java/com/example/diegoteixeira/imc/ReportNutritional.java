package com.example.diegoteixeira.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ReportNutritional extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_nutritional);

        Intent it = getIntent();

        TextView nome = (TextView)findViewById(R.id.nameText);
        nome.setText(it.getStringExtra("nome"));

        TextView idade = (TextView)findViewById(R.id.ageText);
        idade.setText(String.valueOf(it.getIntExtra("idade",0)) + " anos");

        TextView peso = (TextView)findViewById(R.id.weightText);
        peso.setText(String.valueOf(it.getDoubleExtra("peso",0)) + " Kg") ;

        TextView altura = (TextView)findViewById(R.id.heightText);
        altura.setText(String.valueOf(it.getDoubleExtra("altura",0)) + " m");

        TextView IMC = (TextView)findViewById(R.id.IMCText);
        IMC.setText(String.valueOf(it.getDoubleExtra("IMC",0)) + " Kg/m^2");

        TextView classificacao = (TextView)findViewById(R.id.reportText);
        classificacao.setText(it.getStringExtra("classificacao"));
    }

    public void voltar(View view) {
        finish();
    }
}