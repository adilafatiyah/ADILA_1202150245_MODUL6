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

public class LoginActivity extends AppCompatActivity {//digunakan untuk public class LoginActivity extends AppCompatActivity {
    FirebaseAuth mAuth;//digunakan untuk FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;//digunakan untuk  FirebaseAuth.AuthStateListener mAuthListener;
    EditText email_edittext, password_editetxt;//digunakan untuk EditText email_edittext, password_editetxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//digunakan untuk protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//digunakan untuk super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);//digunakan untuk  setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();//digunakan untuk mAuth = FirebaseAuth.getInstance();

        email_edittext=(EditText)findViewById(R.id.email_login);//digunakan untuk email_edittext=(EditText)findViewById(R.id.email_login);
        password_editetxt = (EditText)findViewById(R.id.password_login);//digunakan untuk  password_editetxt = (EditText)findViewById(R.id.password_login);


        mAuthListener = new FirebaseAuth.AuthStateListener() {//mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override

            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {//digunakan   public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (firebaseAuth.getCurrentUser() != null) {//digunakan untuk if (firebaseAuth.getCurrentUser() != null) {

                    startActivity(new Intent(LoginActivity.this, BerandaActivity.class) );//digunakan   startActivity(new Intent(LoginActivity.this, BerandaActivity.class) );
                    finish();//digunakan untuk finish();
                }

            }

        };
    }
    @Override
    protected void onStart() {//digunakan untuk  protected void onStart() {
        super.onStart();//digunakan untuk super.onStart();
        mAuth.addAuthStateListener(mAuthListener);//digunakan untuk mAuth.addAuthStateListener(mAuthListener);
    }
    void startSing(){//digunakan untuk void startSing(){
        String email = email_edittext.getText().toString();//digunakan untuk  String email = email_edittext.getText().toString();/
        String password = password_editetxt.getText().toString();//digunakan untuk  String password = password_editetxt.getText().toString();


        if (TextUtils.isEmpty(email) | TextUtils.isEmpty(password)) {//digunakan untuk if (TextUtils.isEmpty(email) | TextUtils.isEmpty(password)) {/

            Toast.makeText(LoginActivity.this, "Fields are Empty", Toast.LENGTH_SHORT).show();//digunakan untuk  Toast.makeText(LoginActivity.this, "Fields are Empty", Toast.LENGTH_SHORT).show();

        } else {//digunakan untuk  } else {



            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener() {
// mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener() {
                @Override

                public void onComplete(@NonNull Task task) {
                    //digunakan untuk  public void onComplete(@NonNull Task task) {



                    if (!task.isSuccessful()) { //digunakan untuk if (!task.isSuccessful()) {

                        Toast.makeText(LoginActivity.this, "Login Problem", Toast.LENGTH_SHORT).show();//digunakan untuk
// Toast.makeText(LoginActivity.this, "Login Problem", Toast.LENGTH_SHORT).show();
                    }



                }

            });

        }

    }


    public void masuk(View view) { //public void masuk(View view) {
        startSing();
    }//digunakan untuk startSing();

    public void daftar(View view) {//digunakan untuk public void daftar(View view) {
        Intent i = new Intent(LoginActivity.this,DaftarActivity.class);//digunakan untuk Intent i = new Intent(LoginActivity.this,DaftarActivity.class);
        startActivity(i);//digunakan untuk startActivity(i);
    }
}

