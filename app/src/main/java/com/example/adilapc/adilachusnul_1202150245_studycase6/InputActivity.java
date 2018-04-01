package com.example.adilapc.adilachusnul_1202150245_studycase6;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

public class InputActivity extends AppCompatActivity {//digunakan untuk public class InputActivity extends AppCompatActivity {

    private DatabaseReference database;//digunakan untuk  private DatabaseReference database;
    EditText editText_judul,editText_post;//digunakan untuk EditText editText_judul,editText_post;
    Button button_chooser;//digunakan untuk  Button button_chooser;
    String m_chosen;//digunakan untuk String m_chosen;
    ImageView imageView_input;//digunakan untuk ImageView imageView_input;
    private static final int SELECT_PHOTO = 100;//digunakan untuk private static final int SELECT_PHOTO = 100;
    private Uri filePath;//digunakan untuk private Uri filePath;
    FirebaseStorage storage;//digunakan untuk     FirebaseStorage storage;
    StorageReference storageReference;//digunakan untuk  StorageReference storageReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {//digunakan untuk protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//digunakan untuk  super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_input);//digunakan untuk setContentView(R.layout.activity_input);
        editText_judul =(EditText)findViewById(R.id.judul_input);//digunakan untuk editText_judul =(EditText)findViewById(R.id.judul_input);
        editText_post = (EditText)findViewById(R.id.post_input);//digunakan untuk editText_post = (EditText)findViewById(R.id.post_input);
        database = FirebaseDatabase.getInstance().getReference();//digunakan untuk database = FirebaseDatabase.getInstance().getReference();
        button_chooser =(Button)findViewById(R.id.chooser_button);//digunakan untuk button_chooser =(Button)findViewById(R.id.chooser_button);/
        imageView_input =(ImageView)findViewById(R.id.image_input);//digunakan untuk imageView_input =(ImageView)findViewById(R.id.image_input);
        storage = FirebaseStorage.getInstance();//digunakan untuk storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();//digunakan untuk  storageReference = storage.getReference();
        button_chooser.setOnClickListener(new View.OnClickListener() {//digunakan untuk button_chooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//digunakan untuk  public void onClick(View view) {
                chose_foto();//digunakan untuk chose_foto();

            }
        });//digunakan untuk
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.tombol_fab_submit);//digunakan untuk  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.tombol_fab_submit);
        fab.setOnClickListener(new View.OnClickListener() { // fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//digunakan untuk  public void onClick(View view) {/
                // Click action
                String judul = editText_judul.getText().toString();//digunakan untuk  String judul = editText_judul.getText().toString();
                String post = editText_post.getText().toString();//digunakan untuk String post = editText_post.getText().toString();
                submitBarang( new data(judul,post));//digunakan untuk submitBarang( new data(judul,post));
                upload_foto();//digunakan untuk upload_foto();

            }
        });
    }

    private void submitBarang(data dat) {//digunakan untuk private void submitBarang(data dat) {
        /**
         * Ini adalah kode yang digunakan untuk mengirimkan data ke Firebase Realtime Database
         * dan juga kita set onSuccessListener yang berisi kode yang akan dijalankan
         * ketika data berhasil ditambahkan
         */
        database.child("POST").push().setValue(dat).addOnSuccessListener(this, new OnSuccessListener<Void>() {//digunakan  database.child("POST").push().setValue(dat).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {//digunakan   public void onSuccess(Void aVoid) {
                Toast.makeText(InputActivity.this, "Data berhasil ditambahkan", Toast.LENGTH_LONG).show();//digunakan untuk Toast.makeText(InputActivity.this, "Data berhasil ditambahkan", Toast.LENGTH_LONG).show();
            }
        });
    }

    public static Intent getActIntent(Activity activity) {//digunakan untuk  public static Intent getActIntent(Activity activity) {
        // kode untuk pengambilan Intent
        return new Intent(activity, InputActivity.class);//digunakan   return new Intent(activity, InputActivity.class);
    }
    void chose_foto(){//digunakan untuk void chose_foto(){

        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);//digunakan untuk  Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");//digunakan untuk photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, SELECT_PHOTO);//digunakan untuk startActivityForResult(photoPickerIntent, SELECT_PHOTO);

    }

    void file_chose(){//digunakan untuk  void file_chose(){
        SimpleFileDialog FileOpenDialog =  new SimpleFileDialog(InputActivity.this, "FileOpen",//digunakan untuk SimpleFileDialog FileOpenDialog =  new SimpleFileDialog(InputActivity.this, "FileOpen",
                new SimpleFileDialog.SimpleFileDialogListener()
                {
                    @Override
                    public void onChosenDir(String chosenDir)
                    {
                        // The code in this function will be executed when the dialog OK button is pushed
                        m_chosen = chosenDir;//digunakan untuk  m_chosen = chosenDir;
                        Toast.makeText(InputActivity.this, "Chosen FileOpenDialog File: " +//digunakan untuk Toast.makeText(InputActivity.this, "Chosen FileOpenDialog File: " +/
                                m_chosen, Toast.LENGTH_LONG).show();//digunakan untuk m_chosen, Toast.LENGTH_LONG).show();
                    }
                });

        //You can change the default filename using the public variable "Default_File_Name"
        FileOpenDialog.Default_File_Name = "";//digunakan untuk  FileOpenDialog.Default_File_Name = "";
        FileOpenDialog.chooseFile_or_Dir();//digunakan untuk FileOpenDialog.chooseFile_or_Dir();/
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {//digunakan untuk protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);//digunakan untuk super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {//digunakan untuk  switch(requestCode) {
            case SELECT_PHOTO://digunakan untuk case SELECT_PHOTO:
                if(resultCode == RESULT_OK){//digunakan untuk if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();//digunakan untuk Uri selectedImage = imageReturnedIntent.getData();/
                    InputStream imageStream = null;//digunakan  InputStream imageStream = null;
                    try {// try {
                        imageStream = getContentResolver().openInputStream(selectedImage);//digunakan untuk imageStream = getContentResolver().openInputStream(selectedImage);

                    } catch (FileNotFoundException e) {//digunakan untuk } catch (FileNotFoundException e) {
                        e.printStackTrace();//digunakan untuk e.printStackTrace();
                    }
                    Bitmap yourSelectedImage = BitmapFactory.decodeStream(imageStream);//digunakan untuk Bitmap yourSelectedImage = BitmapFactory.decodeStream(imageStream);
                    imageView_input.setImageURI(selectedImage);//digunakan untuk  imageView_input.setImageURI(selectedImage);
                    filePath=selectedImage;//digunakan   filePath=selectedImage;


                }
        }
    }
    void upload_foto(){//digunakan untuk  void upload_foto(){/
        if(filePath != null)//digunakan untuk  if(filePath != null)
        {
            final ProgressDialog progressDialog = new ProgressDialog(this);//digunakan untuk final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");//digunakan untuk progressDialog.setTitle("Uploading...");
            progressDialog.show();//digunakan untuk progressDialog.show();

            StorageReference ref = storageReference.child("images/"+ UUID.randomUUID().toString());//digunakan untuk  StorageReference ref = storageReference.child("images/"+ UUID.randomUUID().toString());
            ref.putFile(filePath)//digunakan untuk ref.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {//digunakan untuk  .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {/
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {//digunakan untuk public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();//digunakan   progressDialog.dismiss();
                            Toast.makeText(InputActivity.this, "Uploaded", Toast.LENGTH_SHORT).show();//digunakan  Toast.makeText(InputActivity.this, "Uploaded", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {// .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {//digunakan   public void onFailure(@NonNull Exception e) {/
                            progressDialog.dismiss();//digunakan untuk progressDialog.dismiss();
                            Toast.makeText(InputActivity.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();//digunakan untuk Toast.makeText(InputActivity.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {// .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {//digunakan untuk public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot//digunakan untuk  double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                    .getTotalByteCount());//digunakan untuk .getTotalByteCount());
                            progressDialog.setMessage("Uploaded "+(int)progress+"%");//digunakan untuk  progressDialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });
        }

    }
}
