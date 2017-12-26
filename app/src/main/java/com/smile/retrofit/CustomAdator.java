package com.smile.retrofit;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 05-10-2017.
 */

public class CustomAdator extends ArrayAdapter<Banner> {
    List<Banner> arrr;
    Activity context;
    public CustomAdator(Activity context, List<Banner> arrr) {
        super(context, R.layout.list_item, arrr);
       this.arrr = arrr;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //ImageView imgflag;
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_item, null, false);
       // TextView textViewId = (TextView) listViewItem.findViewById(R.id.txt);

       Banner details=getItem(position);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.txt);
        textViewName.setText(details.getTitle());
        TextView textView=(TextView)listViewItem.findViewById(R.id.txt1);
        textView.setText(details.getCategory());
        //textViewName.setSingleLine(false);
        //ImageView img =(ImageView)listViewItem.findViewById(R.id.nitika);
        //Picasso.with(listViewItem.getContext()).load(details.getImage()).into(img);
        //TextView textViewEmail = (TextView) listViewItem.findViewById(R.id.textViewEmail);
        return listViewItem;
    }

}
