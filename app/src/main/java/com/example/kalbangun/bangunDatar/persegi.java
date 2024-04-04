package com.example.kalbangun.bangunDatar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kalbangun.R;


public class persegi extends AppCompatActivity {

    EditText editTextSisi;
    TextView textViewHasil;
    Button buttonHitung;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.persegi);

        editTextSisi = findViewById(R.id.Sisi);
        textViewHasil = findViewById(R.id.tvhasil);
        buttonHitung = findViewById(R.id.btnhitung);

        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editTextSisi.getText().toString();
                if (text.isEmpty()) {
                    Toast.makeText(persegi.this, "Harap masukkan sisi!", Toast.LENGTH_SHORT).show();
                } else {
                    float side = Float.parseFloat(text);
                    float area = (float) Math.round(side * side);
                    textViewHasil.setText("Luas: " + area);
                }
            }
        });
    }
}
