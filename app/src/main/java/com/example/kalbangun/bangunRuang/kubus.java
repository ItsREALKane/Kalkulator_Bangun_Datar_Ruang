package com.example.kalbangun.bangunRuang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kalbangun.R;

public class kubus extends AppCompatActivity {

    EditText input;
    TextView hasil;
    Button jumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kubus);

        // Initialize views after setting the content view
        input = findViewById(R.id.input);
        hasil = findViewById(R.id.tvhasil);
        jumlah = findViewById(R.id.btnhitung);

        jumlah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungRuangKubus();
            }
        });
    }

    private void hitungRuangKubus() {
        String sideLengthStr = input.getText().toString();

        if (!sideLengthStr.isEmpty()) {
            double sideLength = Double.parseDouble(sideLengthStr);
            double volume = Math.pow(sideLength, 3);

            hasil.setText("Ruang kubus adalah: " + volume);
        } else {
            hasil.setText("Masukkan nilai panjang sisi terlebih dahulu!");
        }
    }
}