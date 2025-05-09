package com.example.proyecto1_muozrojas;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private TextView tvCounter;
    private Button btnIncrement;
    private Button btnDecrement;
    private Button btnReset;
    private int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Cargar el layout activity_main.xml
        setContentView(R.layout.activity_main);
        //Referenciamos las vistas
        tvCounter = findViewById(R.id.tvCounter);
        btnIncrement = findViewById(R.id.btnIncrement);
        btnDecrement = findViewById(R.id.btnDecrement);
        btnReset = findViewById(R.id.btnReset);

        //Listener para el boton Incrementar
        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aumentarContador();
            }
        });

        //Listener para el boton Resetear
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetearContador();
            }
        });

        //Listener para el boton Decrementar
        btnDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarContador();
            }
        });
    }

    // Método para aumentar el contador
    private void aumentarContador() {
        cont++;
        tvCounter.setText("Contador: " + cont);
    }

    // Método para resetear el contador
    private void resetearContador() {
        cont = 0;
        tvCounter.setText("Contador: " + cont);
    }

    // Método para decrementar el contador
    private void decrementarContador() {
        if (cont > 0) {
            cont--;
            tvCounter.setText("Contador: " + cont);
        } else {
            tvCounter.setText("Contador: 0");
        }
    }

}

