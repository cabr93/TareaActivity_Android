package com.cabr93.tareaactivity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button siguiente;
    private EditText nombre, telefono, email,descripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        siguiente = (Button) findViewById(R.id.siguiente);
        siguiente.setOnClickListener(Bsiguiente);
        Bundle parametros = getIntent().getExtras();

        if (parametros!= null && !parametros.isEmpty()){

            nombre = (EditText) findViewById(R.id.nombre);
            telefono = (EditText) findViewById(R.id.telefono);
            email = (EditText) findViewById(R.id.email);
            descripcion = (EditText) findViewById(R.id.descripcion);
            DatePicker fecha =(DatePicker) findViewById(R.id.datePicker);


            fecha.init(Integer.parseInt(parametros.getString("año")),Integer.parseInt(parametros.getString("mes")),Integer.parseInt(parametros.getString("dia")),null);
            nombre.setText(parametros.getString("nombre"));
            telefono.setText(parametros.getString("telefono"));
            email.setText(parametros.getString("email"));
            descripcion.setText(parametros.getString("descripcion"));

        }


        //Log.i("HOLHOLA",parametros.getString("nombre"));
        //nombre.setText(parametros.getString("nombre"));
        //telefono.setText(parametros.getString("telefono"));
        //email.setText(parametros.getString("email"));
        //descripcion.setText(parametros.getString("descripcion"));
    }
    View.OnClickListener Bsiguiente= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            nombre = (EditText) findViewById(R.id.nombre);
            telefono = (EditText) findViewById(R.id.telefono);
            email = (EditText) findViewById(R.id.email);
            descripcion = (EditText) findViewById(R.id.descripcion);
            DatePicker fecha =(DatePicker) findViewById(R.id.datePicker);

            String fcalendario =   String.valueOf(fecha.getDayOfMonth())+"/" +String.valueOf(fecha.getMonth())+"/"+String.valueOf(fecha.getYear());


            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            intent.putExtra("nombre",nombre.getText().toString());
            intent.putExtra("telefono",telefono.getText().toString());
            intent.putExtra("email",email.getText().toString());
            intent.putExtra("descripcion",descripcion.getText().toString());
            intent.putExtra("fecha", fcalendario);
            intent.putExtra("dia", String.valueOf(fecha.getDayOfMonth()));
            intent.putExtra("mes", String.valueOf(fecha.getMonth()));
            intent.putExtra("año", String.valueOf(fecha.getYear()));
            startActivity(intent);
            Log.i("HOL3","dsc");
            finish();
        }
    };
}
