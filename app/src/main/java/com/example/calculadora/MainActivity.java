package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Double> numeros = new ArrayList<>();
    private char operador = ' ';
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        Button buttonclear = findViewById(R.id.buttonClear);
        Button buttonsum = findViewById(R.id.buttonPlus);
        Button buttonigual = findViewById(R.id.buttonEquals);
        Button buttonmen = findViewById(R.id.buttonMinus);
        Button buttonmul = findViewById(R.id.buttonMultiply);
        Button buttondiv = findViewById(R.id.buttonDivide);
        int[] botonesid = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};

        for (int botonId : botonesid) {
            Button boton = findViewById(botonId);
            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String numero = ((Button) view).getText().toString();
                    String textoActual = textView.getText().toString();
                    textoActual += numero;
                    textView.setText(textoActual);
                }
            });
        }

        buttonclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoActual = textView.getText().toString();
                if (!textoActual.isEmpty()) {
                    textoActual = textoActual.substring(0, 0);
                    textView.setText(textoActual);
                }
            }
        });

        buttonsum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoActual = textView.getText().toString();
                if (!textoActual.isEmpty() && textoActual.charAt(textoActual.length() - 1) != '+') {
                    textView.append("+");
                }
            }
        });

        buttonmen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoActual = textView.getText().toString();
                if (!textoActual.isEmpty() && textoActual.charAt(textoActual.length() - 1) != '-') {
                    textView.append("-");
                }
            }
        });

        buttonmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoActual = textView.getText().toString();
                if (!textoActual.isEmpty() && textoActual.charAt(textoActual.length() - 1) != 'x') {
                    textView.append("x");
                }
            }
        });

        buttondiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoActual = textView.getText().toString();
                if (!textoActual.isEmpty() && textoActual.charAt(textoActual.length() - 1) != '/') {
                    textView.append("/");
                }
            }
        });

        buttonigual.setOnClickListener(new View.OnClickListener() { //El igual llama al método realizar operación
            @Override
            public void onClick(View view) {
                realizarOperacion();
            }
        });
    }

    private void realizarOperacion() {
        String textoActual = textView.getText().toString();

        // Realiza law operaciones
        String[] partes = textoActual.split("[-+x/]");
        double resultado = Double.parseDouble(partes[0]); //Añade la parte numérica al array

        for (int i = 1; i < partes.length; i++) {
            char operador = textoActual.charAt(partes[i - 1].length());
            double numero = Double.parseDouble(partes[i]);

            switch (operador) {
                case '+':
                    resultado += numero;
                    break;
                case '-':
                    resultado -= numero;
                    break;
                case 'x':
                    resultado *= numero;
                    break;
                case '/':
                    resultado /= numero;
                    break;
            }
        }

        textView.setText(String.valueOf(resultado));
    }
}
