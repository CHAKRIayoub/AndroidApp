package com.example.user.salidorcommandes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class addCommande extends AppCompatActivity {

    TextView textview;
    EditText ref,cd, prx, artc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_commande);

        textview = (TextView) findViewById(R.id.tvc);
        ref = (EditText) findViewById(R.id.ref);
        cd = (EditText) findViewById(R.id.cd);
        prx = (EditText) findViewById(R.id.prx);
        artc = (EditText) findViewById(R.id.artc);



    }

    public void doAddCommande(View view) {

        String lien = "http://salidorcommandes.co.nf/addCommande.php?ref=" + ref.getText()+
                "&code=" + cd.getText()+
                "&prix=" + prx.getText()+
                "&article=" + artc.getText()  ;

        RequestQueue queue = Volley.newRequestQueue(this);


        StringRequest stringRequest = new StringRequest(Request.Method.GET, lien , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                textview.setText("Commande bien ajouté");

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textview.setText(" erreur ");
              }
        });

        queue.add(stringRequest);






    }
}
