package com.example.user.salidorcommandes;

import android.app.Activity;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;

/**
 */

public class CustomListAdapter extends BaseAdapter {

    public ArrayList<Commande> listitm = new ArrayList<Commande>();
    Context con = null;
    int res = 0;


    public CustomListAdapter(Context context, int ressource, ArrayList<Commande> items ){
        this.listitm = items;
        this.con = context;
        this.res = ressource;
    }

    @Override
    public int getCount() {
        return listitm.size();
    }

    @Override
    public Object getItem(int position) {
        return listitm.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater linf = ((Activity) con).getLayoutInflater();
        View v = linf.inflate(res,parent, false);

        final Commande i = listitm.get(position);

        TextView titre = (TextView) v.findViewById(R.id.reff );
        TextView text = (TextView) v.findViewById(R.id.tv_cdd);
        TextView date = (TextView) v.findViewById(R.id.tv_date);

        titre.setText(" "+i.ref);
        text.setText(i.code);
        date.setText(i.date);





        return v;
    }
}
