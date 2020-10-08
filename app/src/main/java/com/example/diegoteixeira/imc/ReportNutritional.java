package com.example.diegoteixeira.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

import static java.lang.Double.parseDouble;
import static java.lang.Math.pow;

public class ReportNutritional extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("Ciclo De Vida", getClassName() + "onCreate() chamando.");

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

        double weigth = it.getDoubleExtra("peso",0);
        weigth = parseDouble(findVirgula(new DecimalFormat("#,##0.0").format(weigth)));
        TextView peso = (TextView)findViewById(R.id.weightText);
        peso.setText(weigth + " Kg") ;

        double height = it.getDoubleExtra("altura",0);
        height = parseDouble(findVirgula(new DecimalFormat("#,##0.00").format(height)));
        TextView altura = (TextView)findViewById(R.id.heightText);
        altura.setText( height + " m");

        double IMC =  weigth / (pow(height, 2));
        IMC = parseDouble(findVirgula(new DecimalFormat("#,##0.0").format(IMC)));
        String classificacao = classification(IMC);

        TextView IMCText = (TextView)findViewById(R.id.IMCText);
        IMCText.setText(String.valueOf(IMC) + " Kg/m²");

        TextView classificacaoText = (TextView)findViewById(R.id.reportText);
        classificacaoText.setText(classificacao);
    }

    protected void onStart() {
        super.onStart();
        Log.i("Ciclo De Vida", getClassName() + " onStart() TELA 2 chamando.");
    }

    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo De Vida", getClassName() + " onRestart() TELA 2 chamando.");
    }

    protected void onResume() {
        super.onResume();
        Log.i("Ciclo De Vida", getClassName() + " onResume() TELA 2 chamando.");
    }

    protected void onPause() {
        super.onPause();
        Log.i("Ciclo De Vida", getClassName() + " onPause() TELA 2 chamando.");
    }

    protected void onStop() {
        super.onStop();
        Log.i("Ciclo De Vida", getClassName() + " onStop() TELA 2 chamando.");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo De Vida", getClassName() + " onDestroy() TELA 2 chamando.");
    }

    public void voltar(View view) {
        Intent it = new Intent(getBaseContext(), MainActivity.class);
        it.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(it);
    }

    private String classification(double IMC) {
        if(IMC < 18.5) {
            return "Abaixo do Peso";
        } else if(IMC >= 18.5 && IMC < 25) {
            return "Saudável";
        } else if(IMC >= 25 && IMC < 30) {
            return "Sobrepeso";
        } else if(IMC >= 30 && IMC < 35) {
            return "Obesidade Grau I";
        } else if(IMC >= 35 && IMC < 40) {
            return "Obesidade Grau II (severa)";
        } else {
            return "Obesidade Grau III (mórbida)";
        }
    }

    private String getClassName() {
        String s = getClass().getName();
        return s;
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