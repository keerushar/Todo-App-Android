package com.todoapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyListAdapter extends ArrayAdapter<String> {
    Activity context;
    ArrayList<String> title;

    public MyListAdapter(Activity context, ArrayList<String> title){
        super(context, R.layout.my_list, title);
        this.context = context;
        this.title = title;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.my_list,null,true);

        TextView  txtTitle = rowView.findViewById(R.id.titleTv);

        txtTitle.setText(title.get(position));
        return rowView;
    }
}
