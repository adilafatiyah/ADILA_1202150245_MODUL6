package com.example.adilapc.adilachusnul_1202150245_studycase6;

import java.io.Serializable;

/**
 * Created by adila pc on 01/04/2018.
 */

public class data implements Serializable {//digunakan untuk public class data implements Serializable {
    String judul;//digunakan untuk  String judul;
    String post;//digunakan untuk String post;

    data(String judul, String post){//digunakan untuk  data(String judul, String post){
        this.judul=judul;//digunakan untuk this.judul=judul;
        this.post=post;//digunakan  this.post=post;

    }
    public void setJudul(String judul) {
        this.judul = judul;
    }//digunakan   public void setJudul(String judul) { this.judul = judul;}

    public void setPost(String post) {// public void setPost(String post) {
        this.post = post;
    }//digunakan untuk this.post = post;

    public String getJudul() { // public String getJudul() {
        return judul;// return judul;
    }//digunakan untuk

    public String getPost() {//public String getPost() {
        return post;
    }//digunakan untuk return post;

}

