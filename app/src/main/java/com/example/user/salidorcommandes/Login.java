package com.example.user.salidorcommandes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.R.attr.data;
import static android.R.id.list;

public class Login extends AppCompatActivity {

    TextView textview;
    EditText login,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        textview = (TextView) findViewById(R.id.tvv);
        login = (EditText) findViewById(R.id.loginn);
        pass = (EditText) findViewById(R.id.pass);


    }

    public void doLogin(View view) {
        String lgn = login.getText().toString();
        String pss = pass.getText().toString();
        if(lgn.equals("client") && pss.equals("client") ){

            Intent i = new Intent(getApplicationContext(),ListCommande.class);
            startActivity(i);

        }else{
            textview.setText("Invalid login and password");
        }



    }
}
