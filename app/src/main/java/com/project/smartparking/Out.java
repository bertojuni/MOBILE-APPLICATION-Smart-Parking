package com.project.smartparking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Out extends AppCompatActivity  {
    private ImageButton logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out);
        Toolbar toolbar = findViewById(R.id.toolbar);

         logout = (ImageButton) findViewById(R.id.lgout);
        logout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText (getApplicationContext (), "Anda Telah Logout",
                Toast.LENGTH_SHORT).show ();
        Intent intent = new Intent(Out.this, MainActivity.class);
        Out.this.startActivity(intent);
        finish ();
    }
});

    }

}
