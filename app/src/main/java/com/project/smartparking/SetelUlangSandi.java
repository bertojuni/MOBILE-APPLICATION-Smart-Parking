package com.project.smartparking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SetelUlangSandi extends AppCompatActivity {
    private Button aturulang;
    private EditText repass, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setel_ulang_sandi);
        aturulang = (Button) findViewById (R.id.aturulang);
        pass = (EditText) findViewById (R.id.password);
        repass = (EditText) findViewById (R.id.repassword);



        aturulang.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {


            String repasswordKey = repass.getText ().toString ();
            String passwordKey = pass.getText ().toString ();

                if (repasswordKey.equals("") && passwordKey.equals("")){

                    Toast.makeText(SetelUlangSandi.this, " Semua Bidang Kosong", Toast.LENGTH_SHORT).show();

                }
                else if(repasswordKey.equals("")){
                    Toast.makeText(SetelUlangSandi.this, "RePassword Kosong", Toast.LENGTH_SHORT).show();
                }

                else if (passwordKey.equals("")){
                    Toast.makeText(SetelUlangSandi.this, "Password Kosong", Toast.LENGTH_SHORT).show();
                }
                else if(!passwordKey.equals(repasswordKey)){
                    Toast.makeText(SetelUlangSandi.this,"Password Tidak sama",Toast.LENGTH_SHORT).show();
                }

                else if (repasswordKey.equals ("user123") && passwordKey.equals ("user123")) {
                    Toast.makeText (getApplicationContext (), "Atur Ulang Password Berhasil",
                            Toast.LENGTH_SHORT).show ();
                Intent intent2 = new Intent (SetelUlangSandi.this, MainActivity.class);
                SetelUlangSandi.this.startActivity (intent2);
                finish ();
            }




        }












        });
    }
}
