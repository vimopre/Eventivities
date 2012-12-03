package com.eventivities.android;

import com.eventivities.android.handlers.ProductoHandler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EjemploActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo);
        
        final Button buttonAdd = (Button) findViewById(R.id.buttonEjemploAdd);
        buttonAdd .setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				new ProductoHandler(EjemploActivity.this).insertarEjemplos();
				Toast.makeText(EjemploActivity.this, R.string.ejemplo_msg_insertados_productos, Toast.LENGTH_SHORT).show();
			}
		});
        
        final Button buttonShow = (Button) findViewById(R.id.buttonEjemploShow);
        buttonShow .setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent i = new Intent(EjemploActivity.this, ListaProductosActivity.class);
				startActivity(i);				
			}
		});
        
        final Button buttonDelete = (Button) findViewById(R.id.buttonEjemploRemove);
        buttonDelete .setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				new ProductoHandler(EjemploActivity.this).borrarTodos();
				Toast.makeText(EjemploActivity.this, R.string.ejemplo_msg_eliminados_productos, Toast.LENGTH_SHORT).show();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_ejemplo, menu);
        return true;
    }
}
