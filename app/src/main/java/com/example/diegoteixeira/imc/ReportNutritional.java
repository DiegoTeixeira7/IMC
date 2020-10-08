package com.example.diegoteixeira.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

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
        String age =  String.valueOf(it.getIntExtra("idade",0));
        if(age.equals("0") || age.equals("1")) {
            idade.setText(age + " ano");
        } else {
            idade.setText(age + " anos");
        }

        TextView peso = (TextView)findViewById(R.id.weightText);
        peso.setText(findVirgula(new DecimalFormat("#,##0.0").format(it.getDoubleExtra("peso",0)) + " Kg")) ;

        TextView altura = (TextView)findViewById(R.id.heightText);
        altura.setText(findVirgula(new DecimalFormat("#,##0.00").format(it.getDoubleExtra("altura",0)) + " m"));

        TextView IMC = (TextView)findViewById(R.id.IMCText);
        IMC.setText(String.valueOf(it.getDoubleExtra("IMC",0)) + " Kg/m²");

        TextView classificacao = (TextView)findViewById(R.id.reportText);
        classificacao.setText(it.getStringExtra("classificacao"));
    }

    public void voltar(View view) {
        finish();
    }

    private String findVirgula(String valor) {
        int index = valor.indexOf(",");
        String resp = "";
        if(index != -1) {
            resp = valor.substring(0,index)+"."+valor.substring(index+1);
            return resp;
        }

        return valor;
    }
}