package com.example.adilapc.adilachusnul_1202150245_studycase6;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adila pc on 01/04/2018.
 */

public class gridadaptor extends BaseAdapter {//digunakan untuk
    private Context mContext;
    // private final String[] web;
    // private final int[] Imageid;
    ArrayList<String> judul = new ArrayList<>();//digunakan untuk
    ArrayList<String> post =new ArrayList<>();//digunakan untuk
    ArrayList<Uri> gambar = new ArrayList<>();//digunakan untuk
    //List<ImageUploadInfo> list = new ArrayList<>();
    public gridadaptor(Context c,ArrayList judul,ArrayList post,ArrayList gambar ) {//digunakan untuk
        mContext = c;//digunakan untuk
        this.gambar = gambar;//digunakan untuk
        this.judul = judul;//digunakan untuk
        this.post=post;//digunakan untuk
    }

    @Override
    public int getCount() {//digunakan untuk
        // TODO Auto-generated method stub
        //return web.length;
        return judul.size();//digunakan untuk
    }

    @Override
    public Object getItem(int position) {//digunakan untuk
        // TODO Auto-generated method stub
        return null;//digunakan untuk
    }

    @Override
    public long getItemId(int position) {//digunakan untuk
        // TODO Auto-generated method stub
        return 0;//digunakan untuk
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {//digunakan untuk
        // TODO Auto-generated method stub

        View grid;//digunakan untuk
        LayoutInflater inflater = (LayoutInflater) mContext//digunakan untuk
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);//digunakan untuk

        if (convertView == null) {//digunakan untuk

            grid = new View(mContext);//digunakan untuk
            grid = inflater.inflate(R.layout.grid_single, null);//digunakan untuk
            TextView textView = (TextView) grid.findViewById(R.id.grid_text_judul);//digunakan untuk
            TextView textView_post =(TextView)grid.findViewById(R.id.grid_text_post);//digunakan untuk
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);//digunakan untuk
            textView.setText(judul.get(position));//digunakan untuk
            textView_post.setText(post.get(position));//digunakan untuk
            //ImageUploadInfo UploadInfo = list.get(position);
            //Glide.with(mContext).load(UploadInfo.getImageURL()).into(imageView);
            //textView.setText(web[position]);
            //     imageView.setImageURI(gambar.get(position));
            //imageView.setImageResource(Imageid[position]);
        } else {//digunakan untuk
            grid = (View) convertView;//digunakan untuk
        }

        return grid;//digunakan untuk
    }
}

