package com.example.diegoteixeira.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ReportNutritional extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_nutritional);

        Intent it = getIntent();

        TextView nome = (TextView)findViewById(R.id.nameText);
        nome.setText(it.getStringExtra("nome"));

        TextView idade = (TextView)findViewById(R.id.ageText);
        idade.setText(it.getIntExtra("idade",0)); //arrumar

        TextView peso = (TextView)findViewById(R.id.weightText);
        peso.setText(it.getIntExtra("peso",0)); // arrumar

        TextView altura = (TextView)findViewById(R.id.heightText);
        altura.setText(it.getStringExtra("altura"));

        TextView IMC = (TextView)findViewById(R.id.IMCText);
        IMC.setText(it.getStringExtra("IMC"));

        TextView classificacao = (TextView)findViewById(R.id.reportText);
        classificacao.setText(it.getStringExtra("classificacao"));
    }

    public void voltar(View view) {
        finish();
    }
}