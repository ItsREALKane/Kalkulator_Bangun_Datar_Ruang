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

public class lingkaran extends AppCompatActivity {

    EditText editTextJari;
    TextView textViewHasil;

    Button buttonHitung;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lingkaran);

        editTextJari = findViewById(R.id.jariJari);
        textViewHasil = findViewById(R.id.tvhasil);
        buttonHitung = findViewById(R.id.btnhitung);

        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editTextJari.getText().toString();
                if (text.isEmpty()) {
                    Toast.makeText(lingkaran.this, "Harap masukkan jari-jari!", Toast.LENGTH_SHORT).show();
                } else {
                    float radius = Float.parseFloat(text);
                    float area = (float) Math.round(Math.PI * Math.pow(radius, 2));
                    textViewHasil.setText("Luas: " + area);
                }
            }
        });

    }
}
