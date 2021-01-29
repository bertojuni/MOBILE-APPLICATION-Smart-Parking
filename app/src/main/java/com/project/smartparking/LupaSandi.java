package com.project.smartparking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LupaSandi extends AppCompatActivity {
    private Button verif;
    private EditText nope, otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_sandi);
        verif = (Button) findViewById (R.id.verif);
        nope = (EditText) findViewById (R.id.nope);
        otp = (EditText) findViewById (R.id.otp);
        verif.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Verifikasi",
                        Toast.LENGTH_SHORT).show();



            String nopeKey = nope.getText().toString();
            String otpKey = otp.getText().toString();

                if (nopeKey.equals ("123") && otpKey.equals ("123")) {
                    Toast.makeText (getApplicationContext (), "Sukses Verifikasi",
                            Toast.LENGTH_SHORT).show ();
                    Intent intent = new Intent(LupaSandi.this, SetelUlangSandi.class);
                    LupaSandi.this.startActivity(intent);
                    finish ();
                }

                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder (LupaSandi.this);
                    builder.setMessage ("OTP / Nohp Salah !")
                            .setNegativeButton ("Kirim Ulang", null).create ().show ();
                }



                if(otpKey.equals("")&&nopeKey.equals("")) {

                Toast.makeText(LupaSandi.this, " Semua Bidang Kosong", Toast.LENGTH_SHORT).show();

            }
                else if(otpKey.equals(""))

            {
                Toast.makeText(LupaSandi.this, "OTP Kosong", Toast.LENGTH_SHORT).show();
            }

                else if(nopeKey.equals(""))

            {
                Toast.makeText(LupaSandi.this, "Nomor Hp Kosong", Toast.LENGTH_SHORT).show();
            }


        }
        });




    }
}
