package com.example.adilapc.adilachusnul_1202150245_studycase6;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {//digunakan untuk
    FirebaseAuth mAuth;//digunakan untuk
    FirebaseAuth.AuthStateListener mAuthListener;//digunakan untuk
    EditText email_edittext, password_editetxt;//digunakan untuk

    @Override
    protected void onCreate(Bundle savedInstanceState) {//digunakan untuk
        super.onCreate(savedInstanceState);//digunakan untuk
        setContentView(R.layout.activity_login);//digunakan untuk
        mAuth = FirebaseAuth.getInstance();//digunakan untuk

        email_edittext=(EditText)findViewById(R.id.email_login);//digunakan untuk
        password_editetxt = (EditText)findViewById(R.id.password_login);//digunakan untuk


        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override

            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {//digunakan untuk

                if (firebaseAuth.getCurrentUser() != null) {//digunakan untuk

                    startActivity(new Intent(LoginActivity.this, BerandaActivity.class) );//digunakan untuk
                    finish();//digunakan untuk
                }

            }

        };
    }
    @Override
    protected void onStart() {//digunakan untuk
        super.onStart();//digunakan untuk
        mAuth.addAuthStateListener(mAuthListener);//digunakan untuk
    }
    void startSing(){//digunakan untuk
        String email = email_edittext.getText().toString();//digunakan untuk
        String password = password_editetxt.getText().toString();//digunakan untuk


        if (TextUtils.isEmpty(email) | TextUtils.isEmpty(password)) {//digunakan untuk

            Toast.makeText(LoginActivity.this, "Fields are Empty", Toast.LENGTH_SHORT).show();//digunakan untuk

        } else {//digunakan untuk



            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener() {

                @Override

                public void onComplete(@NonNull Task task) {
                    //digunakan untuk



                    if (!task.isSuccessful()) { //digunakan untuk

                        Toast.makeText(LoginActivity.this, "Login Problem", Toast.LENGTH_SHORT).show();//digunakan untuk

                    }



                }

            });

        }

    }


    public void masuk(View view) {
        startSing();
    }//digunakan untuk

    public void daftar(View view) {//digunakan untuk
        Intent i = new Intent(LoginActivity.this,DaftarActivity.class);//digunakan untuk
        startActivity(i);//digunakan untuk
    }
}

