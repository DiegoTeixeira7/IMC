package com.example.diegoteixeira.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void gerarRelatorio(View view) {
        String nome = ((EditText)findViewById(R.id.name)).getText().toString();
        int idade = parseInt(((EditText)findViewById(R.id.age)).getText().toString());
        double peso = parseDouble(((EditText)findViewById(R.id.weight)).getText().toString());
        double altura = parseDouble(((EditText)findViewById(R.id.height)).getText().toString());

        if(nome.length() == 0) {
            // exibir toast
        } else {
            if(idade < 0 || idade > 140) {
                //exibir toast
            }

            if(peso < 1 || peso > 400) {
                //exibir toast
            }

            if(altura < 1 || altura > 3) {
                //exibir toast
            }

            double IMC = peso/pow(altura,2);
            String classificacao = classification(IMC);

            Intent it = new Intent(getBaseContext(), ReportNutritional.class);

            it.putExtra("nome", nome);
            it.putExtra("idade", idade);
            it.putExtra("peso", peso);
            it.putExtra("altura", altura);
            it.putExtra("IMC", IMC);
            it.putExtra("classificacao", classificacao);

            startActivity(it);
        }
    }
}