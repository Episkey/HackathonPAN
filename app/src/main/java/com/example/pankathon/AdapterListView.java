package com.example.pankathon;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class AdapterListView extends ArrayAdapter<Egg> {


    public AdapterListView(Context context, List<Egg> eggList) {
        super(context, 0, eggList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Egg item = getItem(position);

        if(null == convertView) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_egglist, parent, false);
        }

        TextView textName = convertView.findViewById(R.id.tvItemJson);
        textName.setText(item.getName());

        TextView textRare = convertView.findViewById(R.id.tvrare);
        textRare.setText(item.getRarity());

        ImageView eggView = convertView.findViewById(R.id.imgEgg);
        Glide.with(getContext()).load(item.getPicture()).into(eggView);

        return convertView;
    }
}
