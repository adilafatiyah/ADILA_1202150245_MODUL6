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

public class gridadaptor extends BaseAdapter {//digunakan untuk public class gridadaptor extends BaseAdapter {
    private Context mContext; //private Context mContext;
    // private final String[] web;
    // private final int[] Imageid;
    ArrayList<String> judul = new ArrayList<>();//digunakan untuk ArrayList<String> judul = new ArrayList<>();
    ArrayList<String> post =new ArrayList<>();//digunakan untuk  ArrayList<String> post =new ArrayList<>();
    ArrayList<Uri> gambar = new ArrayList<>();//digunakan untuk  ArrayList<Uri> gambar = new ArrayList<>();
    //List<ImageUploadInfo> list = new ArrayList<>();
    public gridadaptor(Context c,ArrayList judul,ArrayList post,ArrayList gambar ) {//digunakan untuk  public gridadaptor(Context c,ArrayList judul,ArrayList post,ArrayList gambar ) {
        mContext = c;//digunakan untuk  mContext = c;
        this.gambar = gambar;//digunakan untuk  this.gambar = gambar;
        this.judul = judul;//digunakan untuk this.judul = judul;
        this.post=post;//digunakan untuk this.post=post;/
    }

    @Override
    public int getCount() {//digunakan untuk  public int getCount() {
        // TODO Auto-generated method stub
        //return web.length;
        return judul.size();//digunakan untuk return judul.size();
    }

    @Override
    public Object getItem(int position) {//digunakan untuk  public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;//digunakan untuk  return null;
    }

    @Override
    public long getItemId(int position) {//digunakan untuk  public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;//digunakan   return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {//digunakan untuk public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        View grid;//digunakan untuk View grid;
        LayoutInflater inflater = (LayoutInflater) mContext//digunakan untuk  LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);//digunakan untuk  .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {//digunakan untuk if (convertView == null) {

            grid = new View(mContext);//digunakan untuk grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_single, null);//digunakan untuk grid = inflater.inflate(R.layout.grid_single, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text_judul);//digunakan untuk TextView textView = (TextView) grid.findViewById(R.id.grid_text_judul);
            TextView textView_post =(TextView)grid.findViewById(R.id.grid_text_post);//digunakan untuk  TextView textView_post =(TextView)grid.findViewById(R.id.grid_text_post);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);//digunakan untuk  ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            textView.setText(judul.get(position));//digunakan untuk  textView.setText(judul.get(position));
            textView_post.setText(post.get(position));//digunakan untuk textView_post.setText(post.get(position));
            //ImageUploadInfo UploadInfo = list.get(position);
            //Glide.with(mContext).load(UploadInfo.getImageURL()).into(imageView);
            //textView.setText(web[position]);
            //     imageView.setImageURI(gambar.get(position));
            //imageView.setImageResource(Imageid[position]);
        } else {//digunakan untuk } else {
            grid = (View) convertView;//digunakan untuk  grid = (View) convertView;
        }

        return grid;//digunakan untuk return grid;
    }
}

