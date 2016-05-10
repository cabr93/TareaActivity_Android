package com.cabr93.tareaactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;
    private TextView tvFecha;
    private Button editar;

    private String nombre;
    private String telefono;
    private String email;
    private String descripcion;
    private String dia, mes, año;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle parametros = getIntent().getExtras();

        nombre = parametros.getString("nombre");
        telefono = parametros.getString("telefono");
        email = parametros.getString("email");
        descripcion = parametros.getString("descripcion");
        String fecha = parametros.getString("fecha");
        dia = parametros.getString("dia");
        mes = parametros.getString("mes");
        año = parametros.getString("año");

        editar = (Button) findViewById(R.id.editar);
        editar.setOnClickListener(edita);

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelfono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        tvFecha = (TextView) findViewById(R.id.tvFecha);

        tvFecha.setText(fecha);
        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(Main2Activity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    View.OnClickListener edita= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Main2Activity.this,MainActivity.class);
            intent.putExtra("nombre",nombre);
            intent.putExtra("telefono",telefono);
            intent.putExtra("email",email);
            intent.putExtra("descripcion",descripcion);
            intent.putExtra("dia", dia);
            intent.putExtra("mes", mes);
            intent.putExtra("año", año);
            Log.i("edita","Bueno");
            startActivity(intent);
            finish();
        }
    };
}
