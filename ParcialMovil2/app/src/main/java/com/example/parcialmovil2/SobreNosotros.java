package com.example.parcialmovil2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SobreNosotros extends AppCompatActivity {
      private Button paginaweb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre_nosotros);
        paginaweb = findViewById(R.id.buttonpaginaweb);
    }
    public void regresar(View v){
        Intent intent = new Intent(SobreNosotros.this,Main.class);
        startActivity(intent);
        finish();
    }
    public void abrirPaginaWeb(View view){
        Intent intent = new Intent(SobreNosotros.this, WebviewPagina.class);
        startActivity(intent);
        finish();
    }

}