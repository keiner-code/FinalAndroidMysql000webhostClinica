package com.example.parcialmovil2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListarEncuesta extends AppCompatActivity {
    private EditText codigo, nombre, apellido, valoracion, cobertura;
    Usuarios usu = null;
    Encuesta enc = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_encuesta);
        codigo = findViewById(R.id.editTextTextcodigo);
        nombre = findViewById(R.id.editTextTextnombre);
        apellido = findViewById(R.id.editTextTextapellido2);
        valoracion = findViewById(R.id.editTextTextvaloracion);
        cobertura = findViewById(R.id.editTextTextcobertura);

    }

    public void MostrarDatos(View v) {

        String url = "https://final-movil-clinica.000webhostapp.com/consultar_usuario_clinica.php?id=" + codigo.getText().toString();

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("usuarios");

                            if (!(response.isEmpty())) {
                                JSONObject object = jsonArray.getJSONObject(0);
                                usu = new Usuarios(object.getString("nombre"),
                                        object.getString("apellido"),
                                        object.getString("telefono"),
                                        object.getString("direccion"),
                                        object.getString("estadocivil"),
                                        object.getString("profesion"),
                                        object.getString("estrato"),
                                        object.getString("cargo"),
                                        object.getString("nivelestudio"),
                                        object.getString("id"));

                                nombre.setText(usu.getNombre());
                                apellido.setText(usu.getApellido());

                                if (!(usu.getId().isEmpty())) {
                                       MostrarEncuesta(usu.getId());

                                }
                            } else {
                                Toast.makeText(ListarEncuesta.this, "El Usuario " + usu.getId() + " No Esta Registrado", Toast.LENGTH_SHORT);
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ListarEncuesta.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public void MostrarEncuesta(String id) {

        String url = "https://final-movil-clinica.000webhostapp.com/consultar_encuesta_clinica.php?id=" + id;

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("datosencuesta");

                            JSONObject object = jsonArray.getJSONObject(0);
                            enc = new Encuesta(object.getString("id"),
                                    object.getString("respuesta1"),
                                    object.getString("respuesta2"),
                                    object.getString("respuesta3"),
                                    object.getString("respuesta4"),
                                    object.getString("respuesta5"));

                               cobertura.setText(enc.getRespuesta5());
                               int valor = ValoracionPromedio(enc.getRespuesta1(),enc.getRespuesta2(),enc.getRespuesta3(),enc.getRespuesta4());

                            if (valor==1) valoracion.setText("Nada Satisfecho");
                            if (valor==2) valoracion.setText("Poco Satisfecho");
                            if (valor==3) valoracion.setText("Neutral");
                            if (valor==4) valoracion.setText("Muy Satisfecho");
                            if (valor==5) valoracion.setText("Totalmente Satisfecho");


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ListarEncuesta.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public int ValoracionPromedio(String r0,String r1, String r2, String r3){
        int pregunta1=0,pregunta2=0,pregunta3=0,pregunta4=0,suma=0,promedio=0;
        //Log.d("datos obtenidos",r0+" "+r1+" "+r2+" "+r3);

        if (r0.equals("Nada Satisfecho")) pregunta1=1;
        if (r0.equals("Poco Satisfecho")) pregunta1=2;
        if (r0.equals("Neutral")) pregunta1=3;
        if (r0.equals("Muy Satisfecho"))  pregunta1=4;
        if (r0.equals("Totalmente Satisfecho"))  pregunta1=5;

        if (r1.equals("Nada Satisfecho")) pregunta2=1;
        if (r1.equals("Poco Satisfecho")) pregunta2=2;
        if (r1.equals("Neutral")) pregunta2=3;
        if (r1.equals("Muy Satisfecho"))  pregunta2=4;
        if (r1.equals("Totalmente Satisfecho"))  pregunta2=5;

        if (r2.equals("Nada Satisfecho")) pregunta3=1;
        if (r2.equals("Poco Satisfecho")) pregunta3=2;
        if (r2.equals("Neutral")) pregunta3=3;
        if (r2.equals("Muy Satisfecho"))  pregunta3=4;
        if (r2.equals("Totalmente Satisfecho"))  pregunta3=5;

        if (r3.equals("Nada Satisfecho")) pregunta4=1;
        if (r3.equals("Poco Satisfecho")) pregunta4=2;
        if (r3.equals("Neutral")) pregunta4=3;
        if (r3.equals("Muy Satisfecho"))  pregunta4=4;
        if (r3.equals("Totalmente Satisfecho"))  pregunta4=5;

        suma = pregunta1+pregunta2+pregunta3+pregunta4;
        //Log.d("Suma Promedio", String.valueOf(suma));
        promedio= suma/4;
        return promedio;
    }
    public void regresarmain(View v){
        Intent intent = new Intent(ListarEncuesta.this,Main.class);
        startActivity(intent);
        finish();
    }
}