package com.example.customadapterlist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;

    int[] images = {R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground};
    String[] name = {"bfd","dhbfd","hdfg","yeybc"};
    int[] power = {60,30,40,80};
    int[] star = {1,2,3,4};

    CustomAdapter(Context context)
    {
       this.context = context;
       layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        convertView = layoutInflater.inflate(R.layout.data_item,null);



        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        final TextView names = convertView.findViewById(R.id.name);
        final TextView powers = convertView.findViewById(R.id.power);
        final TextView stars = convertView.findViewById(R.id.star);

        String oldName = names.getText().toString();
        String oldPower = powers.getText().toString();
        String oldStar = stars.getText().toString();

                imageView.setImageResource(images[position]);

                names.setText(oldName + name[position]);
                powers.setText(oldPower + power[position]);
                stars.setText(oldStar + star[position]);

           convertView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Toast.makeText(context, names.getText()+" \n"+powers.getText()+" \n"+stars.getText(), Toast.LENGTH_SHORT).show();
               }
           });



        return convertView;
    }
}
