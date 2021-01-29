package com.project.smartparking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private EditText email, pass;
    private Button login,lupa,buat, reset;
    FirebaseAuth mFirebaseAuth;
    private  FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseAuth = FirebaseAuth.getInstance();
        email = (EditText) findViewById (R.id.email);
        pass = (EditText) findViewById (R.id.password);
        login = (Button) findViewById (R.id.login);
        lupa = (Button) findViewById (R.id.lupa);
        buat = (Button) findViewById (R.id.buat);
        reset = (Button) findViewById (R.id.reset);


        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if(mFirebaseUser != null){



                }
            }
        };

        reset.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                email.setText("");
                pass.setText("");
            }
        });
        lupa.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText (getApplicationContext (), "Lupa Sandi!!",
                        Toast.LENGTH_SHORT).show ();
                Intent intent = new Intent (MainActivity.this, LupaSandi.class);
                MainActivity.this.startActivity (intent);
            }
        });

        login.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                String emailKey = email.getText ().toString ();
                String passwordKey = pass.getText ().toString ();

                if ( emailKey.equals("") && passwordKey.equals("")){

                    Toast.makeText(MainActivity.this, " Semua Bidang Kosong", Toast.LENGTH_SHORT).show();

                }

                else if (passwordKey.equals("")){
                    Toast.makeText(MainActivity.this, "Ada Bidang Kosong", Toast.LENGTH_SHORT).show();
                }



                if ( !(emailKey.equals("") && passwordKey.equals(""))){

                    mFirebaseAuth.signInWithEmailAndPassword(emailKey,passwordKey).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(MainActivity.this, "Login Eror", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Intent i = new Intent(MainActivity.this, menu2.class);
                                startActivity(i);
                            }
                        }
                    });
                }
                else{Toast.makeText(MainActivity.this,"Eror Gagal",Toast.LENGTH_SHORT).show();


                }

            }

        });


        buat.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText (getApplicationContext (), "Buat!!",
                        Toast.LENGTH_SHORT).show ();
                Intent intent = new Intent (MainActivity.this, BuatAkun.class);
                MainActivity.this.startActivity (intent);
            }
        });






    }
    protected void onStart(){
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}
