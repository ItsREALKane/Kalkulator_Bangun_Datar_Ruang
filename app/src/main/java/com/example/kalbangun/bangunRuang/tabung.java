package com.example.kalbangun.bangunRuang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kalbangun.R;

public class tabung extends AppCompatActivity {
    EditText radius, tinggi;
    TextView hasil;
    Button jumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabung);

        // Initialize views after setting the content view
        radius = findViewById(R.id.jari);
        tinggi = findViewById(R.id.tingggi);
        hasil = findViewById(R.id.tvhasil);
        jumlah = findViewById(R.id.btnhitung);

        jumlah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungRuangTabung();
            }
        });
    }

    private void hitungRuangTabung() {
        String radiusStr = radius.getText().toString();
        String heightStr = tinggi.getText().toString();

        if (!radiusStr.isEmpty() && !heightStr.isEmpty()) {
            double radius = Double.parseDouble(radiusStr);
            double height = Double.parseDouble(heightStr);
            double volume = Math.PI * Math.pow(radius, 2) * height;
            hasil.setText("Ruang tabung adalah: " + volume);
        } else {
            hasil.setText("Masukkan nilai jari-jari dan tinggi terlebih dahulu!");
        }
    }
}