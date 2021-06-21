package com.example.parcialmovil2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static androidx.core.location.LocationManagerCompat.isLocationEnabled;

public class WebviewPagina extends AppCompatActivity {
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_pagina);
        wv = findViewById(R.id.Webviewactivity);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl("https://medicosdoc.com/especialidad/clinicas-barranquilla");
    }

    public void Regresa(View view) {
        finish();
    }

    public void Ubicacion_GPS_Restaurante(View view) {

        String direccionCompleta = "";
        String error="";
        double longitudeGPS;
        double latitudeGPS;
        String URL = "http://maps.google.com/maps?&z=15&mrt=loc&t=m&q=";
        ActivityCompat.requestPermissions(WebviewPagina.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(this,"SIN PERMISOS",Toast.LENGTH_SHORT).show();

        } else {
            /*Se asigna a la clase LocationManager el servicio a nivel de sistema a partir del nombre.*/
            LocationManager locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            Location loc = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            longitudeGPS = loc.getLongitude();
            latitudeGPS = loc.getLatitude();

            //OBTENER DIRECCION
            try {
                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                List<Address> list = geocoder.getFromLocation(latitudeGPS, longitudeGPS, 1);
                if (!list.isEmpty()) {
                    Address DirCalle = list.get(0);
                    String direccion = DirCalle.getAddressLine(0);
                    direccionCompleta = "Estoy en " + URL + latitudeGPS + "+" + longitudeGPS;
                    Toast.makeText(this,direccionCompleta,Toast.LENGTH_SHORT).show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.i("Posicion GPS: ",direccionCompleta);
        }
    }
}