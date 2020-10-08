package com.example.diegoteixeira.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

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

    @SuppressLint("WrongConstant")
    public void gerarRelatorio(View view) {
        String nome = ((EditText)findViewById(R.id.name)).getText().toString();
        String idade = ((EditText)findViewById(R.id.age)).getText().toString();
        String peso = ((EditText)findViewById(R.id.weight)).getText().toString();
        String altura = ((EditText)findViewById(R.id.height)).getText().toString();

        if(nome.length() == 0 || idade.length() == 0 || peso.length() == 0 || altura.length() == 0) {
            Toast.makeText(this,"Preencha todos os campos", 2000).show();
        } else {
            int age = parseInt(idade);
            if(age < 0 || age > 140) {
                Toast.makeText(this,"Idade deve ser de 0 a 140 anos", 2000).show();
            } else {
                double weigth = parseDouble(peso);
                if(weigth < 0.2 || weigth > 400) {
                    Toast.makeText(this,"Peso deve ser de 0.2kg a 400kg", 2000).show();
                } else {
                    double height = parseDouble(altura);
                    if(height < 0.3 || height > 3) {
                        Toast.makeText(this,"Altura deve ser de 0.3m a 3 metros", 2000).show();
                    } else {
                        double IMC = weigth/pow(height,2);
                        IMC = parseDouble(findVirgula(new DecimalFormat("#,##0.0").format(IMC)));
                        String classificacao = classification(IMC);

                        Intent it = new Intent(getBaseContext(), ReportNutritional.class);

                        it.putExtra("nome", nome);
                        it.putExtra("idade", age);
                        it.putExtra("peso", weigth);
                        it.putExtra("altura", height);
                        it.putExtra("IMC", IMC);
                        it.putExtra("classificacao", classificacao);

                        startActivity(it);
                    }
                }
            }
        }
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