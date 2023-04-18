package com.example.ejercicio6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et1,et2;
    private TextView tv1;
    private Spinner sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.txt_valor1);
        et2 = (EditText) findViewById(R.id.txt_valor2);
        tv1 = (TextView) findViewById(R.id.tv_resultado);
        sp1 = (Spinner) findViewById(R.id.spinner);

        String[] opciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_rcorp, opciones);
        sp1.setAdapter(adapter);
    }

    public void Calcular(View view) {
        String valor1_String = et1.getText().toString();
        String valor2_String = et2.getText().toString();

        int valor1_int = Integer.parseInt(valor1_String);
        int valor2_int = Integer.parseInt(valor2_String);

        String seleccion = sp1.getSelectedItem().toString();


        if (seleccion.equals("Sumar")) {
            int operacion = valor1_int + valor2_int;
            String resultado = String.valueOf(operacion);
            tv1.setText(resultado);
        }
        if (seleccion.equals("Restar")) {
            int operacion = valor1_int - valor2_int;
            String resultado = String.valueOf(operacion);
            tv1.setText(resultado);
        }
        if (seleccion.equals("Multiplicar")) {
            int operacion = valor1_int * valor2_int;
            String resultado = String.valueOf(operacion);
            tv1.setText(resultado);
        }
        if (seleccion.equals("Dividir")) {
            if (valor2_int != 0) {
                int operacion = valor1_int / valor2_int;
                String resultado = String.valueOf(operacion);
                tv1.setText(resultado);
            } else {
                Toast.makeText(this, "No se puede introducir el 0", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
