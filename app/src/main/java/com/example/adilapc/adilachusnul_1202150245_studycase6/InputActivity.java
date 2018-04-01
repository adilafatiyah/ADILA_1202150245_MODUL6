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

public class InputActivity extends AppCompatActivity {//digunakan untuk

    private DatabaseReference database;//digunakan untuk
    EditText editText_judul,editText_post;//digunakan untuk
    Button button_chooser;//digunakan untuk
    String m_chosen;//digunakan untuk
    ImageView imageView_input;//digunakan untuk
    private static final int SELECT_PHOTO = 100;//digunakan untuk
    private Uri filePath;//digunakan untuk
    FirebaseStorage storage;//digunakan untuk
    StorageReference storageReference;//digunakan untuk
    @Override
    protected void onCreate(Bundle savedInstanceState) {//digunakan untuk
        super.onCreate(savedInstanceState);//digunakan untuk

        setContentView(R.layout.activity_input);//digunakan untuk
        editText_judul =(EditText)findViewById(R.id.judul_input);//digunakan untuk
        editText_post = (EditText)findViewById(R.id.post_input);//digunakan untuk
        database = FirebaseDatabase.getInstance().getReference();//digunakan untuk
        button_chooser =(Button)findViewById(R.id.chooser_button);//digunakan untuk
        imageView_input =(ImageView)findViewById(R.id.image_input);//digunakan untuk
        storage = FirebaseStorage.getInstance();//digunakan untuk
        storageReference = storage.getReference();//digunakan untuk
        button_chooser.setOnClickListener(new View.OnClickListener() {//digunakan untuk
            @Override
            public void onClick(View view) {//digunakan untuk
                chose_foto();//digunakan untuk

            }
        });//digunakan untuk
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.tombol_fab_submit);//digunakan untuk
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//digunakan untuk
                // Click action
                String judul = editText_judul.getText().toString();//digunakan untuk
                String post = editText_post.getText().toString();//digunakan untuk
                submitBarang( new data(judul,post));//digunakan untuk
                upload_foto();//digunakan untuk

            }
        });
    }

    private void submitBarang(data dat) {//digunakan untuk
        /**
         * Ini adalah kode yang digunakan untuk mengirimkan data ke Firebase Realtime Database
         * dan juga kita set onSuccessListener yang berisi kode yang akan dijalankan
         * ketika data berhasil ditambahkan
         */
        database.child("POST").push().setValue(dat).addOnSuccessListener(this, new OnSuccessListener<Void>() {//digunakan untuk
            @Override
            public void onSuccess(Void aVoid) {//digunakan untuk
                Toast.makeText(InputActivity.this, "Data berhasil ditambahkan", Toast.LENGTH_LONG).show();//digunakan untuk
            }
        });
    }

    public static Intent getActIntent(Activity activity) {//digunakan untuk
        // kode untuk pengambilan Intent
        return new Intent(activity, InputActivity.class);//digunakan untuk
    }
    void chose_foto(){//digunakan untuk

        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);//digunakan untuk
        photoPickerIntent.setType("image/*");//digunakan untuk
        startActivityForResult(photoPickerIntent, SELECT_PHOTO);//digunakan untuk

    }

    void file_chose(){//digunakan untuk
        SimpleFileDialog FileOpenDialog =  new SimpleFileDialog(InputActivity.this, "FileOpen",//digunakan untuk
                new SimpleFileDialog.SimpleFileDialogListener()
                {
                    @Override
                    public void onChosenDir(String chosenDir)
                    {
                        // The code in this function will be executed when the dialog OK button is pushed
                        m_chosen = chosenDir;//digunakan untuk
                        Toast.makeText(InputActivity.this, "Chosen FileOpenDialog File: " +//digunakan untuk
                                m_chosen, Toast.LENGTH_LONG).show();//digunakan untuk
                    }
                });

        //You can change the default filename using the public variable "Default_File_Name"
        FileOpenDialog.Default_File_Name = "";//digunakan untuk
        FileOpenDialog.chooseFile_or_Dir();//digunakan untuk
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {//digunakan untuk
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);//digunakan untuk

        switch(requestCode) {//digunakan untuk
            case SELECT_PHOTO://digunakan untuk
                if(resultCode == RESULT_OK){//digunakan untuk
                    Uri selectedImage = imageReturnedIntent.getData();//digunakan untuk
                    InputStream imageStream = null;//digunakan untuk
                    try {
                        imageStream = getContentResolver().openInputStream(selectedImage);//digunakan untuk

                    } catch (FileNotFoundException e) {//digunakan untuk
                        e.printStackTrace();//digunakan untuk
                    }
                    Bitmap yourSelectedImage = BitmapFactory.decodeStream(imageStream);//digunakan untuk
                    imageView_input.setImageURI(selectedImage);//digunakan untuk
                    filePath=selectedImage;//digunakan untuk


                }
        }
    }
    void upload_foto(){//digunakan untuk
        if(filePath != null)//digunakan untuk
        {
            final ProgressDialog progressDialog = new ProgressDialog(this);//digunakan untuk
            progressDialog.setTitle("Uploading...");//digunakan untuk
            progressDialog.show();//digunakan untuk

            StorageReference ref = storageReference.child("images/"+ UUID.randomUUID().toString());//digunakan untuk
            ref.putFile(filePath)//digunakan untuk
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {//digunakan untuk
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {//digunakan untuk
                            progressDialog.dismiss();//digunakan untuk
                            Toast.makeText(InputActivity.this, "Uploaded", Toast.LENGTH_SHORT).show();//digunakan untuk
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {//digunakan untuk
                            progressDialog.dismiss();//digunakan untuk
                            Toast.makeText(InputActivity.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();//digunakan untuk
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {//digunakan untuk
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot//digunakan untuk
                                    .getTotalByteCount());//digunakan untuk
                            progressDialog.setMessage("Uploaded "+(int)progress+"%");//digunakan untuk
                        }
                    });
        }

    }
}
