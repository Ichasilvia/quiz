package com.example.bankquis;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    TextView kuis;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    //pertanyaan
    String[] pertanyaan_kuis = new String[]{
             "1. 3 x 3",
             "2.  Pada dasarnya tujuan gerakan 30 september 1965 adalah",
             "3. Ibukota Indonesia adalah",
             "4. Salah seorang perwira TNI yang gugur dalam pemberontakan APRA adalah",

    };

    //pilihan jawaban a, b, c, d
    String[] pilihan_jawaban = new String[]{
              "Tidak setuju dengan bentuk negara", "Tidak setuju dengan sistem pemerintahan", "Adanya ketidak cocokan diantara para penguasa", "pertentangan antara pemerintah pusat dan daerah mengenai otonomi",
              "Merebut kekuasaan yang sah", "Menakut-nakuti rakyat indonesia", "Menunjukkan kekuatan RI", "Menguji kekuatan ABRI",
              "Jakarta", "Bogor", "Tangerang", "Bekasi",
              "Letnan Kolonel Slamet Riyadi", "Letnan Kolonel Worang", "Letkol Lembong ", "Letkol Suherman ",

    };

    //jawaban benar
    String[] jawaban_benar = new String[]{
             "pertentangan antara pemerintah pusat dan daerah mengenai otonomi",
             "Merebut kekuasaan yang sah",
             "Jakarta",
             "Letkol Lembong",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        kuis = (TextView) findViewById(R.id.kuis);
        rg = (RadioGroup) findViewById(R.id.pilihan);
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) findViewById(R.id.pilihanD);

        kuis.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0;
        salah = 0;
    }

    public void next(View view) {
        if (PilihanA.isChecked() || PilihanB.isChecked() || PilihanC.isChecked() || PilihanD.isChecked()) {

            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < pertanyaan_kuis.length) {
                kuis.setText(pertanyaan_kuis[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                PilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                PilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                PilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);

            } else {
                hasil = benar * 20;
                Intent selesai = new Intent(getApplicationContext(), HasilKuis3.class);
                startActivity(selesai);
            }
        }
        else {
            Toast.makeText(this,"Kamu Jawab Dulu",Toast.LENGTH_LONG).show();
        }
    }
}