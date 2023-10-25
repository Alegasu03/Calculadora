package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.textView); //
        Button buttonclear=findViewById(R.id.buttonClear);
        Button buttonsum=findViewById(R.id.buttonPlus);
        int[] botonesid = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};

        for (int botonId : botonesid) {
            Button boton = findViewById(botonId);
            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String numero = ((Button) view).getText().toString(); // Obtén el texto del botón

                    String textoActual = textView.getText().toString();

                    textoActual += numero;
                    textView.setText(textoActual);
                }
            });
        }
        buttonclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               TextView textView=findViewById(R.id.textView);
               String textoactual=textView.getText().toString();
               if (!textoactual.isEmpty()){
                   textoactual=textoactual.substring(0, 0);
                   textView.setText(textoactual);
               }
            }
        });
        buttonsum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}