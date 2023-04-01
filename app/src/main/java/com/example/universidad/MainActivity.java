package com.example.universidad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView jtvtotal, jtvingles, jtvmateria;
    RadioButton jrbinteligenegocio, jrbemprendimiento, jrbauditoriasistem, jrbseguridadinfo;
    EditText jetnumerocredit,jetcredito;
    CheckBox jcbingles;
    DecimalFormat formato=new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();//ocultar la barra de titulo por defecto

        jtvtotal = findViewById(R.id.tvtotal);
        jetcredito = findViewById(R.id.etcredito);
        jtvingles = findViewById(R.id.tvingles);
        jtvmateria = findViewById(R.id.tvmateria);
        jrbinteligenegocio = findViewById(R.id.rbinteligenegocio);
        jrbemprendimiento = findViewById(R.id.rbemprendimiento);
        jrbauditoriasistem = findViewById(R.id.rbauditoriasistem);
        jrbseguridadinfo = findViewById(R.id.rbseguridadinfo);
        jcbingles = findViewById(R.id.cbingles);
        jetnumerocredit = findViewById(R.id.etnumerocredit);

    }

    public void Calcular(View View) {

        //NUMERO DE CREDITOS DIGITADOS
        String numerocredit;
        numerocredit = jetnumerocredit.getText().toString();
        float total;
        if (numerocredit.isEmpty()) {
            Toast.makeText(this, "El numero de creditos es requerido", Toast.LENGTH_SHORT).show();
            jetnumerocredit.requestFocus();
            return;
        }

        int numero_credit, valor_materia, valor_ingles;
        numero_credit = Integer.parseInt(numerocredit);
        if (numero_credit == 0) {
            Toast.makeText(this, "El numero de creditos debe ser mayor a cero", Toast.LENGTH_SHORT).show();
            jetnumerocredit.setText("");
            jetnumerocredit.requestFocus();
            return;
        }//FIN NUMERO DE CREDITOS DIGITADOS

        //VALOR DE UN CREDITO DIGITADO
        String credito;
        credito = jetcredito.getText().toString();
        if (credito.isEmpty()) {
            Toast.makeText(this, "El valor del credito es requerido", Toast.LENGTH_SHORT).show();
            jetcredito.requestFocus();
            return;
        }
        int valor_credito;
        valor_credito = Integer.parseInt(credito);
        if (valor_credito == 0) {
            Toast.makeText(this, "El valor del credito debe ser mayor a cero", Toast.LENGTH_SHORT).show();
            jetcredito.setText("");
            jetcredito.requestFocus();
            return;
        }//FIN VALOR DE UN CREDITO DIGITADO


        if (jrbemprendimiento.isChecked()) {
            valor_materia = 500000;
        } else if (jrbinteligenegocio.isChecked()) {
            valor_materia = 500000;
        } else if (jrbauditoriasistem.isChecked()) {
            valor_materia = 700000;
        } else {//esta seria rbseguridadinfo
            valor_materia = 900000;
        }
        jtvmateria.setText(formato.format(valor_materia));

        if (jcbingles.isChecked()) {
            valor_ingles = 300000;
        } else {
            valor_ingles = 0;
        }
        jtvingles.setText(formato.format(valor_ingles));
        //TERMINA NUMERO DE CREDITOS DIGITADOS

        total = valor_materia + valor_ingles + (numero_credit * valor_credito);
        //aca faltan variables

        jtvtotal.setText(formato.format(total));

    }//fin calcular

    public void Limpiar(View View){
        jrbinteligenegocio.setChecked(true);
        jtvmateria.setText("500000");
        jcbingles.setChecked(false);
        jtvingles.setText("0");
        jetnumerocredit.setText("");
        jetcredito.setText("");
        jtvtotal.setText("");
        jetnumerocredit.requestFocus();
    }
}