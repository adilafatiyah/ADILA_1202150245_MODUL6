package com.example.adilapc.adilachusnul_1202150245_studycase6;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class DaftarActivity extends AppCompatActivity {//digunakan untuk
    FirebaseAuth mAuth;//digunakan untuk
    EditText editText_email,editText_password,editText_Repassword;//digunakan untuk
    private ProgressDialog mProgress;//digunakan untuk

    private DatabaseReference mDatabase;//digunakan untuk
    @Override
    protected void onCreate(Bundle savedInstanceState) {//digunakan untuk
        super.onCreate(savedInstanceState);//digunakan untuk
        setContentView(R.layout.activity_daftar);//digunakan untuk
        editText_email = (EditText)findViewById(R.id.daftar_email);//digunakan untuk
        editText_password = (EditText)findViewById(R.id.daftar_password);//digunakan untuk
        editText_Repassword = (EditText)findViewById(R.id.daftar_repassword);//digunakan untuk
        mAuth = FirebaseAuth.getInstance();//digunakan untuk
    }


    public void masukDaftar(View view) {//digunakan untuk
    }

    public void daftarDaftar(View view) {//digunakan untuk
        String email = editText_email.getText().toString();//digunakan untuk
        String password =editText_password.getText().toString();//digunakan untuk
        String  repassword = editText_Repassword.getText().toString();//digunakan untuk
        if(email.isEmpty()|| password.isEmpty()||repassword.isEmpty()){//digunakan untuk
            Toast.makeText(DaftarActivity.this, "ada belum mengisi ",Toast.LENGTH_SHORT).show();//digunakan untuk
        }if (!password.equals(repassword)){//digunakan untuk
            Toast.makeText(DaftarActivity.this, "password tidak sama ",Toast.LENGTH_SHORT).show();//digunakan untuk


        }else {//digunakan untuk
            register_user(email,password);//digunakan untuk

        }


    }

    private void register_user( String email, String password) {//digunakan untuk


        //create user
        mAuth.createUserWithEmailAndPassword(email, password)//digunakan untuk
                .addOnCompleteListener(DaftarActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(DaftarActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
//digunakan untuk
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {//digunakan untuk
                            Toast.makeText(DaftarActivity.this, "Authentication failed." + task.getException(),//digunakan untuk
                                    Toast.LENGTH_SHORT).show();//digunakan untuk
                        } else {//digunakan untuk
                            Toast.makeText(DaftarActivity.this, "benar " + task.getException(),//digunakan untuk
                                    Toast.LENGTH_SHORT).show();//digunakan untuk

                        }
                    }
                });

    }



}

