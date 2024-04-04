package com.example.kalbangun.bangunRuang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kalbangun.R;

public class bola extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Button Hitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bola);

        editText = findViewById(R.id.jarijari);
        textView = findViewById(R.id.textHasil);
        Hitung = findViewById(R.id.btnhitung);

        Hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textjari = editText.getText().toString().trim();

                if (textjari.isEmpty()) {
                    Toast.makeText(bola.this, "Please fill in the field", Toast.LENGTH_SHORT).show();
                    return;
                }

                float jariJari = Float.parseFloat(textjari);

                float surfaceArea = (4 * Math.round(Math.PI * jariJari * jariJari));

                textView.setText(String.valueOf(surfaceArea));
            }
        });
    }
}