package com.example.user.salidorcommandes;

import android.app.Notification;
import android.app.PendingIntent;
import android.support.v4.app.RemoteInput;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

import static android.R.id.list;


public class ListCommande extends AppCompatActivity {

    ProgressBar progressbar;
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //MainActivity  :  une listeview pour afficher l'historique des notifications
        progressbar = (ProgressBar) findViewById(R.id.progressBar);
        lv = (ListView) findViewById(R.id.listview);
        ArrayList<Commande> list = new ArrayList<Commande>();
        CustomListAdapter cls = new CustomListAdapter( this, R.layout.lv_model  ,list );
        lv.setAdapter(cls);

        //lacer l' asyncTask qui nous permet de remplire la liste d'historique des Notification
        new ClassAsyncT(cls, list, progressbar).execute();

    }


    public void doAdd(View view) {

        Intent i = new Intent(getApplicationContext(),addCommande.class);
        startActivity(i);

    }
}

