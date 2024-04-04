package com.example.kalbangun.bangunRuang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kalbangun.R;

public class balok extends AppCompatActivity {
    EditText editTextPanjang,editTextLebar,editTextTinggi;
    TextView textViewHasil;
    Button buttonHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.balok);

        editTextPanjang = findViewById(R.id.panjangBalok);
        editTextLebar = findViewById(R.id.lebarBalok);
        editTextTinggi = findViewById(R.id.tinggiBalok);
        textViewHasil = findViewById(R.id.tvhasil);
        buttonHitung = findViewById(R.id.btnhitung);

        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String panjangText = editTextPanjang.getText().toString().trim();
                String lebarText = editTextLebar.getText().toString().trim();
                String tinggiText = editTextTinggi.getText().toString().trim();

                if (panjangText.isEmpty() || lebarText.isEmpty() || tinggiText.isEmpty()) {
                    Toast.makeText(balok.this, "Masukan semua input dengan benar!", Toast.LENGTH_SHORT).show();
                    return;
                }
                double panjang = Double.parseDouble(panjangText);
                double lebar = Double.parseDouble(lebarText);
                double tinggi = Double.parseDouble(tinggiText);
                double volume = 2 * (panjang * lebar + panjang * tinggi + lebar * tinggi);

                textViewHasil.setText(String.valueOf(volume));
            }
        });
    }
}