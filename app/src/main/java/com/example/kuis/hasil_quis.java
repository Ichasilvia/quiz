package com.example.kuis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class hasil_quis extends AppCompatActivity {

    private TextView hasilNilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_quis);

        Intent intent = getIntent();

        hasilNilai = (TextView) findViewById(R.id.hasilNilai);
        hasilNilai.setText("" + Soal.nilai_akhir);
    }

    public void backHome(View view) {
        finish();
    }
}