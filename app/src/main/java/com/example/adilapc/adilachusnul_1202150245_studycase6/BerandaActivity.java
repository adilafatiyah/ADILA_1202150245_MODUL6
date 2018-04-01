package com.example.adilapc.adilachusnul_1202150245_studycase6;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class BerandaActivity extends AppCompatActivity {
    GridView grid; //digunakan untuk GridView grid;
    FirebaseStorage storage; //digunakan untuk
    StorageReference storageReference;//digunakan untuk
    String nama[] = {"ini", "itu"};//digunakan untuk
    ArrayList<Uri> gam = new ArrayList<>();//digunakan untuk
    ArrayList<String> judul = new ArrayList<>();//digunakan untuk
    ArrayList<String> post = new ArrayList<>();//digunakan untuk
    //List<ImageUploadInfo> list = new ArrayList<>();

    //int gambar[] = {R.drawable.ic_3d_rotation, R.drawable.ic_accessibility};
    DatabaseReference databaseReference;//digunakan untuk
    public static final String Database_Path = "POST";//digunakan untuk
    public static final String file_Path = "images/";//digunakan untuk

    @Override
    protected void onCreate(Bundle savedInstanceState) {//digunakan untuk
        super.onCreate(savedInstanceState);//digunakan untuk
        setContentView(R.layout.activity_beranda);//digunakan untuk


        get_data();//digunakan untuk

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.tombolFAB);//digunakan untuk
        fab.setOnClickListener(new View.OnClickListener() {//digunakan untuk
            @Override
            public void onClick(View view) {//digunakan untuk
                // Click action
                Intent intent = new Intent(BerandaActivity.this, InputActivity.class);//digunakan untuk
                startActivity(intent);//digunakan untuk
            }
        });//digunakan untuk


    }

    @Override
    protected void onStart() {//digunakan untuk
        super.onStart();//digunakan untuk


    }//digunakan untuk

    void get_data() {//digunakan untuk
        databaseReference = FirebaseDatabase.getInstance().getReference(BerandaActivity.Database_Path);//digunakan untuk
        databaseReference.addValueEventListener(new ValueEventListener() {//digunakan untuk
            @Override
            public void onDataChange(DataSnapshot snapshot) {//digunakan untuk

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {//digunakan untuk

                    String jdl = dataSnapshot.child("judul").getValue().toString();//digunakan untuk
                    String pst = dataSnapshot.child("post").getValue().toString();//digunakan untuk
                    judul.add(jdl);//digunakan untuk
                    post.add(pst);//digunakan untuk
                    Log.d("ini adalah judul", jdl);//digunakan untuk
                }
                getFoto();//digunakan untuk
                grid();//digunakan untuk


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {//digunakan untuk

            }
        }

        );
    }

    void grid() {//digunakan untuk
        gridadaptor adapter = new gridadaptor(BerandaActivity.this, judul, post, gam);//digunakan untuk
        grid = (GridView) findViewById(R.id.grid);//digunakan untuk
        grid.setAdapter(adapter);//digunakan untuk
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {//digunakan untuk

            @Override
            public void onItemClick(AdapterView<?> parent, View view,//digunakan untuk
                                    int position, long id) {//digunakan untuk
                Toast.makeText(BerandaActivity.this, "You Clicked at " + judul.get(position), Toast.LENGTH_SHORT).show();
//digunakan untuk
            }
        });


    }

    void getFoto() {
        /*
        FirebaseStorage storage = FirebaseStorage.getInstance();
        //storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        storageRef.child("image/*").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Got the download URL for 'users/me/profile.png'
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });
    */
        storage = FirebaseStorage.getInstance();//digunakan untuk
        storageReference = storage.getReference();//digunakan untuk
        StorageReference ref = storageReference.child("images/");//digunakan untuk
        ref.getFile(Uri.parse("gs://modul6-6f5bd.appspot.com/images"));//digunakan untuk

        Log.d("ini anama file ", ref.getName());//digunakan untuk
        Log.d("ini adalah peth ", ref.getPath());//digunakan untuk

    }
}