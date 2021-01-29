package com.project.smartparking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class BuatAkun extends AppCompatActivity {
    private EditText email ,pass, repass;
    private Button signup, reset;
    FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_akun);
        mFirebaseAuth = FirebaseAuth.getInstance();
        email = (EditText) findViewById (R.id.email);
        pass = (EditText) findViewById (R.id.password);
        repass = (EditText) findViewById (R.id.repassword);
        signup = (Button) findViewById (R.id.signup);
        reset = (Button) findViewById (R.id.reset);

        reset.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                email.setText("");
                pass.setText("");
                repass.setText("");
            }
        });

        signup.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String emailKey = email.getText ().toString ();
                String repasswordKey = repass.getText ().toString ();
                String passwordKey = pass.getText ().toString ();

                if ( emailKey.equals("") && passwordKey.equals("")&& repasswordKey.equals("")){

                    Toast.makeText(BuatAkun.this, " Semua Bidang Kosong", Toast.LENGTH_SHORT).show();

                }

                else if (passwordKey.equals("")){
                    Toast.makeText(BuatAkun.this, "Ada Bidang Kosong", Toast.LENGTH_SHORT).show();
                }
                else if(repasswordKey.equals("")){
                    Toast.makeText(BuatAkun.this, "Re-Password Kosong", Toast.LENGTH_SHORT).show();
                }

                else if(!passwordKey.equals(repasswordKey)){
                    Toast.makeText(BuatAkun.this,"Password Tidak sama",Toast.LENGTH_SHORT).show();
                }
                if ( !(emailKey.equals("") && passwordKey.equals(""))){

                  mFirebaseAuth.createUserWithEmailAndPassword(emailKey,passwordKey).addOnCompleteListener(BuatAkun.this, new OnCompleteListener<AuthResult>() {
                      @Override
                      public void onComplete(@NonNull Task<AuthResult> task) {
                          if(!task.isSuccessful()){
                              Toast.makeText(BuatAkun.this,"SignUp Gagal",Toast.LENGTH_SHORT).show();
                          }
                          else{
                              startActivity(new Intent(BuatAkun.this,MainActivity.class));
                          }
                      }
                  });
                }
                else{Toast.makeText(BuatAkun.this,"Eror Gagal",Toast.LENGTH_SHORT).show();


                }

            }

        });



    }
}
