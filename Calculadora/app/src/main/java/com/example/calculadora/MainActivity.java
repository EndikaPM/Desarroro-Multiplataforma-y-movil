package com.example.calculadora;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private StringBuilder texPantalla = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // capturamos el id de la pantalla de xml y la almacenamos en esl Text view
        TextView pantalla = findViewById(R.id.pantallaCal);

        //almacenamos los botones igual que antes
        // acuerdate endica de que ara el id es necesario llamar desde la R.
        Button uno = findViewById(R.id.uno);
        Button dos = findViewById(R.id.dos);
        Button tres = findViewById(R.id.tres);
        Button cuatro = findViewById(R.id.cuatro);
        Button cinco = findViewById(R.id.cinco);
        Button sies = findViewById(R.id.seis);
        Button siete = findViewById(R.id.siete);
        Button ocho = findViewById(R.id.ocho);
        Button nuece = findViewById(R.id.nueve);
        Button cero = findViewById(R.id.cero);

        //almacenamos los botones de funcion
        Button suma = findViewById(R.id.suma);
        Button reta = findViewById(R.id.menos);
        Button multipli = findViewById(R.id.multipli);
        Button divi = findViewById(R.id.divi);
        Button igual = findViewById(R.id.equal);

        Button coma = findViewById(R.id.coma);

        View.OnClickListener bot = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button boto = (Button) v;
                texPantalla.append(boto.getText());
                pantalla.setText(texPantalla.toString());
            }
        };

        //asignamos los listener a cada uno de los botones
        uno.setOnClickListener(bot);
        dos.setOnClickListener(bot);
        tres.setOnClickListener(bot);
        cuatro.setOnClickListener(bot);
        cinco.setOnClickListener(bot);
        sies.setOnClickListener(bot);
        siete.setOnClickListener(bot);
        ocho.setOnClickListener(bot);
        nuece.setOnClickListener(bot);
        cero.setOnClickListener(bot);
        //tambien a los botones de funcion ver como hacer que no entren en el metodo
        suma.setOnClickListener(bot);
        reta.setOnClickListener(bot);
        multipli.setOnClickListener(bot);
        divi.setOnClickListener(bot);

        //---coma--- no se aun como gestionarla
        coma.setOnClickListener(bot);

        // el igual mirar a ver otro modo paraque no de problemas
        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //no permite el split directamente porque no lo se...
                String signoOperacion = texPantalla.toString();
                float resultado;
                String [] partes;

                if (signoOperacion.contains("+")){
                    //da error si no pones la barras de escape porque no lo coge como texto sino suma o concatena
                    // eso tienes que tenerlo en cuenta tonto
                    partes = signoOperacion.split("\\+");
                    resultado = suma(Float.parseFloat(partes[0]),Float.parseFloat(partes[2]));
                    pantalla.setText(String.valueOf(resultado));
                } else if (signoOperacion.contains("-")) {
                    partes = signoOperacion.split("-");
                    resultado = resta(Float.parseFloat(partes[0]),Float.parseFloat(partes[2]));
                    pantalla.setText(String.valueOf(resultado));
                }else if (signoOperacion.contains("*")) {
                    partes = signoOperacion.split("\\*");
                    resultado = multi(Float.parseFloat(partes[0]),Float.parseFloat(partes[2]));
                    pantalla.setText(String.valueOf(resultado));
                }else if (signoOperacion.contains("/")) {
                    partes = signoOperacion.split("/");
                    resultado = divi(Float.parseFloat(partes[0]),Float.parseFloat(partes[2]));
                    pantalla.setText(String.valueOf(resultado));
                }else {
                    pantalla.setText("Error");
                }
            }
        });
    }

    private float suma(float a, float b){
        return a + b;
    }
    private float resta(float a, float b){
        return a - b;
    }
    private float multi(float a, float b){
        return a * b;
    }
    private float divi(float a, float b){
        return a / b;
    }
}