package com.example.adilapc.adilachusnul_1202150245_studycase6;

import java.io.Serializable;

/**
 * Created by adila pc on 01/04/2018.
 */

public class data implements Serializable {//digunakan untuk
    String judul;//digunakan untuk
    String post;//digunakan untuk

    data(String judul, String post){//digunakan untuk
        this.judul=judul;//digunakan untuk
        this.post=post;//digunakan untuk

    }
    public void setJudul(String judul) {
        this.judul = judul;
    }//digunakan untuk

    public void setPost(String post) {
        this.post = post;
    }//digunakan untuk

    public String getJudul() {
        return judul;
    }//digunakan untuk

    public String getPost() {
        return post;
    }//digunakan untuk

}

