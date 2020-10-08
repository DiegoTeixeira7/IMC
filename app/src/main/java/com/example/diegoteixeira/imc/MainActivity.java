package com.example.diegoteixeira.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
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

        Log.i("Ciclo De Vida", getClassName() + " onCreate() TELA 1 chamando.");

        setContentView(R.layout.activity_main);
    }

    protected void onStart() {
        super.onStart();
        Log.i("Ciclo De Vida", getClassName() + " onStart() TELA 1 chamando.");
    }

    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo De Vida", getClassName() + " onRestart() TELA 1 chamando.");
    }

    protected void onResume() {
        super.onResume();
        Log.i("Ciclo De Vida", getClassName() + " onResume() TELA 1 chamando.");
    }

    protected void onPause() {
        super.onPause();
        Log.i("Ciclo De Vida", getClassName() + " onPause() TELA 1 chamando.");
    }

    protected void onStop() {
        super.onStop();
        Log.i("Ciclo De Vida", getClassName() + " onStop() TELA 1 chamando.");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo De Vida", getClassName() + " onDestroy() TELA 1 chamando.");
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
                        Intent it = new Intent(getBaseContext(), ReportNutritional.class);

                        it.putExtra("nome", nome);
                        it.putExtra("idade", age);
                        it.putExtra("peso", weigth);
                        it.putExtra("altura", height);

                        startActivity(it);
                    }
                }
            }
        }
    }

    private String getClassName() {
        String s = getClass().getName();
        return s;
    }
}