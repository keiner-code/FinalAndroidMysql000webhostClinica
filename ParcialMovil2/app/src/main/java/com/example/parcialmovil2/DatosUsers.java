package com.example.parcialmovil2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class DatosUsers extends AppCompatActivity {
     private EditText Nombre,Apellido,Teléfono,Dirección,estadocivil,profesión,estrato,Cargo, nivelfestudio,id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_users);
         Nombre= findViewById(R.id.editTextTextNombre);
         Apellido = findViewById(R.id.editTextTextapellido);
         Teléfono = findViewById(R.id.editTextTelefono);
         Dirección = findViewById(R.id.editTextTextDirrecion);
         estadocivil = findViewById(R.id.editTextTextEstadocivil);
         profesión = findViewById(R.id.editTextTextprofesion);
         estrato = findViewById(R.id.editTextTextestrato);
         Cargo = findViewById(R.id.editTextTextcargo);
         nivelfestudio = findViewById(R.id.editTextTextnivelestudio);
         id = findViewById(R.id.editTextTextid);
    }
    public void InsertarDatos(View v){

        Bundle bundle = this.getIntent().getExtras();
        final String res1 = bundle.getString("Respuesta1");
        final String res2 = bundle.getString("Respuesta2");
        final String res3 = bundle.getString("Respuesta3");
        final String res4 = bundle.getString("Respuesta4");
        final String res5 = bundle.getString("Respuesta5");


        if (res1.isEmpty()){
            Toast.makeText(this, "Falta La Pregunta Numero 1", Toast.LENGTH_SHORT).show();
            return;
        }else if (res2.isEmpty()){
            Toast.makeText(this, "Falta La Pregunta Numero 2", Toast.LENGTH_SHORT).show();
            return;
        }else if (res3.isEmpty()){
            Toast.makeText(this, "Falta La Pregunta Numero 3", Toast.LENGTH_SHORT).show();
            return;
        }else if (res4.isEmpty()){
            Toast.makeText(this, "Falta La Pregunta Numero 4", Toast.LENGTH_SHORT).show();
            return;
        }else if (res5.isEmpty()){
            Toast.makeText(this, "Falta La Pregunta Numero 5", Toast.LENGTH_SHORT).show();
            return;
        }else{

            StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://final-movil-clinica.000webhostapp.com/agregar_encuesta_clinica.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equalsIgnoreCase("encuesta_agregada")){
                                Toast.makeText(DatosUsers.this," Encuesta Agregada", Toast.LENGTH_SHORT).show();
                            }else{

                                Toast.makeText(DatosUsers.this,response, Toast.LENGTH_SHORT).show();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(DatosUsers.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> parametros= new HashMap<String,String>();
                    parametros.put("respuesta1",res1);
                    parametros.put("respuesta2",res2);
                    parametros.put("respuesta3",res3);
                    parametros.put("respuesta4",res4);
                    parametros.put("respuesta5",res5);
                    return parametros;
                }
            };

            // Add the request to the RequestQueue.
            RequestQueue queue= Volley.newRequestQueue(DatosUsers.this);
            queue.add(stringRequest);
        }
        Agregar_Datos_Usuario_Encuesta();

        Intent intent = new Intent(DatosUsers.this,Main.class);
        startActivity(intent);
        finish();

    }
    public void Agregar_Datos_Usuario_Encuesta(){

        final String nombre= Nombre.getText().toString().trim();
        final String apellido= Apellido.getText().toString().trim();
        final String telefono= Teléfono.getText().toString().trim();
        final String dirrecion= Dirección.getText().toString().trim();
        final String Estadocivil= estadocivil.getText().toString().trim();
        final String profesion= profesión.getText().toString().trim();
        final String Estracto= estrato.getText().toString().trim();
        final String cargo= Cargo.getText().toString().trim();
        final String Nivelestudio= nivelfestudio.getText().toString().trim();
        final String Id= id.getText().toString().trim();

        if (nombre.isEmpty()){
            Toast.makeText(this, "Ingresa el Nombre", Toast.LENGTH_SHORT).show();
            return;
        }else if (apellido.isEmpty()){
            Toast.makeText(this, "Ingresa el Apellido", Toast.LENGTH_SHORT).show();
            return;
        }else if (telefono.isEmpty()){
            Toast.makeText(this, "Ingresa el Telefono", Toast.LENGTH_SHORT).show();
            return;
        }else if (dirrecion.isEmpty()){
            Toast.makeText(this, "Ingresa La Direccion", Toast.LENGTH_SHORT).show();
            return;
        }else if (Estadocivil.isEmpty()){
            Toast.makeText(this, "Ingresa el Estado Civil", Toast.LENGTH_SHORT).show();
            return;
        }else if (profesion.isEmpty()){
            Toast.makeText(this, "Ingresa La Profesion", Toast.LENGTH_SHORT).show();
            return;
        }else if (Estracto.isEmpty()){
            Toast.makeText(this, "Ingresa el Estracto", Toast.LENGTH_SHORT).show();
            return;
        }else if (cargo.isEmpty()){
            Toast.makeText(this, "Ingresa el Cargo", Toast.LENGTH_SHORT).show();
            return;
        }else if (Nivelestudio.isEmpty()){
            Toast.makeText(this, "Ingresa el Nivel De Estudio", Toast.LENGTH_SHORT).show();
            return;
        }else if (Id.isEmpty()){
            Toast.makeText(this, "Ingresa el Id", Toast.LENGTH_SHORT).show();
            return;
        }else{

            StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://final-movil-clinica.000webhostapp.com/agregar_usuario_clinica.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equalsIgnoreCase("encuesta_agregada")){
                                Toast.makeText(DatosUsers.this," Encuesta Agregada", Toast.LENGTH_SHORT).show();
                            }else{

                                Toast.makeText(DatosUsers.this,response, Toast.LENGTH_SHORT).show();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(DatosUsers.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> parametros= new HashMap<String,String>();
                    parametros.put("nombre",nombre);
                    parametros.put("apellido",apellido);
                    parametros.put("telefono",telefono);
                    parametros.put("direccion",dirrecion);
                    parametros.put("estadocivil",Estadocivil);
                    parametros.put("profesion",profesion);
                    parametros.put("estrato",Estracto);
                    parametros.put("cargo",cargo);
                    parametros.put("nivelestudio",Nivelestudio);
                    return parametros;
                }
            };

            // Add the request to the RequestQueue.
            RequestQueue queue= Volley.newRequestQueue(DatosUsers.this);
            queue.add(stringRequest);
        }
    }
}