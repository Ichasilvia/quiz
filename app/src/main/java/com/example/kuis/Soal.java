package com.example.kuis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Soal extends AppCompatActivity {
    private TextView NomorSoal;
    private TextView Soalnya;

    private RadioButton pilih1;
    private RadioButton pilih2;
    private RadioButton pilih3;
    private RadioButton pilih4;

    private RadioButton selected_radio;

    private RadioGroup seleksi;

    private Button hasilBtn;
    private Button nextBtn;

    private int curr_soal;
    private int sub_soal = 0;
    private int nomor_soal = 1;
    public static int nilai_akhir = 0;

    private String[][][][][] soal = {
            //Matematika
            {
                    {
                            {{"Bilangan A berada di antara 355 dan 357. Bilangan A jika ditambah 100 maka hasilnya adalah?"}},
                            {
                                    {"455", "salah"},
                                    {"456", "benar"},
                                    {"457", "salah"},
                                    {"458", "salah"}
                            }
                    },
                    {
                            {{"5 – 17 – 29 – 41 – 53 – 65"}},
                            {
                                     {"5", "salah"},
                                     {"17", "salah"},
                                     {"12", "benar"},
                                     {"15", "salah"}
                            }
                    },
                    {
                            {{"Barisan bilangan meloncat 6 dimulai dari 6 adalah"}},
                            {
                                     {"6 – 12 – 18 – 21 – 27", "salah"},
                                     {"6 – 12 – 18 – 24 – 30", "benar"},
                                     {"6 – 12 – 15 – 22 – 30", "salah"},
                                     {"6 – 12 – 18 – 22 – 30", "salah"}
                            }
                    },
                    {
                            {{"Hasil dari 3.147 + 1.897 adalah"}},
                            {
                                    {"5.134", "salah"},
                                    {"5.244", "salah"},
                                    {"5.044", "benar"},
                                    {"5.174", "salah"}
                            }
                    },
                    {
                            {{"Bilangan tujuh ribu delapan ratus enam puluh lima ditulis"}},
                            {
                                    {"7.865", "benar"},
                                    {"7.568", "salah"},
                                    {"70.568", "salah"},
                                    {"78.605", "salah"}
                            }
                    },
            },
            //Teknologi Informasi
            {
                    {
                            {{"Faktor yang sangat berpengaruh terhadap munculnya berbagai teknologi komunikasi jarak  jauh adalah...?"}},
                            {
                                    {"Ditemukannya gelombang elektromagnetik", "benar"},
                                    {"Ditemukannya telepon", "salah"},
                                    {"Ditemukannya komputer", "salah"},
                                    {"Ditemukannya internet", "salah"}
                            }
                    },
                    {
                            {{"Manakah dari teknologi ini yang tidak memanfaatkan gelombang elektromagnetik?"}},
                            {
                                    {"Radio", "salah"},
                                    {"Televisi", "salah"},
                                    {"Komputer", "benar"},
                                    {"Ponsel", "salah"}
                            }
                    },
                    {
                            {{"Siapakah yan mempelopori penemuan radio?"}},
                            {
                                    {"Samuel F.B Morse", "salah"},
                                    {"Alex Graham Bell", "salah"},
                                    {"Paul Gottlieb Nipkow", "salah"},
                                    {"Nikola Tesla","benar"},
                            }


                    },
                    {
                            {{"Komputer ENIAC merupakan komputer generasi ke?"}},
                            {
                                    {"pertama", "benar"},
                                    {"kedua", "salah"},
                                    {"ketiga", "salah"},
                                    {"keempat", "salah"},
                            }
                    },
                    {
                            {{"Munculmya teknologi SMS diawali oleh ponsel?"}},
                            {
                                    {"Generasi Pertama (1G)", "salah"},
                                    {"Generasi kedua (2G)", "benar"},
                                    {"Generasi kedua (3G)", "salah"},
                                    {"Generasi 3.5G", "salah"}
                            }
                    },
            },
            // Geografi
            {
                    {
                            {{"Pulau Sumatera sebelah selatan dan barat berbatasan dengan ?"}},
                            {
                                    {"Selat Sunda dan Samudera Pasifik", "salah"},
                                    {"Selat Sunda dan Samudera Indonesia", "salah"},
                                    {"Selat Sunda dan Samudera Hindia", "benar"},
                                    {"Selat Sunda dan Samudera Arktik", "salah"}
                            }
                    },
                    {
                            {{"Salah satu pelabuhan yang terdapat di Provinsi Sumatera Barat adalah Pelabuhan?"}},
                            {
                                    {"Teluk Bayur", "benar"},
                                    {"Bakauheni", "salah"},
                                    {"Tanjung Emas", "salah"},
                                    {"Gilimanuk", "salah"}
                            }
                    },
                    {
                            {{"Sebelah Timur Pulau Sumatera berbatasan dengan?"}},
                            {
                                    {"Selat Malaka", "benar"},
                                    {"Samudera Hindia", "salah"},
                                    {"Teluk Benggala", "salah"},
                                    {"Selat Sunda", "salah"}
                            }
                    },
                    {
                            {{"Di bawah ini yang merupakan pegunungan yang terletak di Pulau Jawa antara lain?"}},
                            {
                                    {"Pegunungan Sewu, Pegunungan Kendeng, dan Pegunungan Kapur Utara", "benar"},
                                    {"Pegunungan Sewu, Pegunungan Kendeng, dan Pegunungan Bukit Barisan", "salah"},
                                    {"Pegunungan Sewu, Pegunungan Bukit Barisan, dan Pegunungan Kapur Utara", "salah"},
                                    {"Pegunungan Sewu, Pegunungan Bukit Barisan, dan Pegunungan Muller", "salah"}
                            }
                    },
                    {
                            {{"Di wilayah Indonesia terdapat banyak gunung api yang masih aktif. salah satu contoh gunung api aktif di Indonesia yaitu Gunung Merapi. Gunung tersebut terletak di wilayah provinsi?"}},
                            {
                                    {"DKI Jakarta dan Banten", "salah"},
                                    {"Jawa Tengah dan Daerah Istimewa Jogjakarta", "benar"},
                                    {"Jawa Timur dan Jawa Tengan", "salah"},
                                    {"Jawa Barat dan DKI Jakarta", "salah"}
                            }
                    },
            }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal);
        Intent intent = getIntent();
        NomorSoal = (TextView) findViewById(R.id.nomor_soal);
        Soalnya = (TextView) findViewById((R.id.soal_text));

        pilih1 = (RadioButton) findViewById((R.id.jawaban1));
        pilih2 = (RadioButton) findViewById((R.id.jawaban2));
        pilih3 = (RadioButton) findViewById((R.id.jawaban3));
        pilih4 = (RadioButton) findViewById((R.id.jawaban4));

        hasilBtn = (Button) findViewById(R.id.hasilButton);
        nextBtn = (Button) findViewById(R.id.nextBtn);

        seleksi = (RadioGroup) findViewById((R.id.radioGroup));

        switch (MainActivity.Mapel_Soal){
            case "Matematika":
                curr_soal = 0;
                nilai_akhir = 0;
                break;
            case "Teknologi Informasi":
                curr_soal = 1;
                nilai_akhir = 0;
                break;
            case "Geografi":
                curr_soal = 2;
                nilai_akhir = 0;
                break;
            default:
                Toast.makeText(this, "Unknown", Toast.LENGTH_SHORT).show();
        }

        hasilBtn.setEnabled(false);
        setTextQuestion(curr_soal, sub_soal, 1);
    }

    public void nextQuestion(View view) {
        nomor_soal++;
        if (nomor_soal == 5){
            hasilBtn.setEnabled(true);
            nextBtn.setEnabled(false);
        }

        if(pilih1.isChecked()){
            if (soal[curr_soal][sub_soal][1][0][1] == "benar"){
                tambahNilai();
            }
        } else if(pilih2.isChecked()){
            if (soal[curr_soal][sub_soal][1][1][1] == "benar"){
                tambahNilai();
            }
        } else if(pilih3.isChecked()){
            if (soal[curr_soal][sub_soal][1][2][1] == "benar"){
                tambahNilai();
            }
        } else if(pilih4.isChecked()){
            if (soal[curr_soal][sub_soal][1][3][1] == "benar"){
                tambahNilai();
            }
        } else {
            Toast.makeText(this, "TIDAK PILIH!", Toast.LENGTH_LONG).show();
        }

        seleksi.clearCheck();
        sub_soal++;
        setTextQuestion(curr_soal, sub_soal, nomor_soal);

    }

    void setTextQuestion(int soal_sekarang, int sub_soal, int nomor_soal){
        NomorSoal.setText("" + nomor_soal);

        Soalnya.setText(soal[soal_sekarang][sub_soal][0][0][0]);
        pilih1.setText(soal[soal_sekarang][sub_soal][1][0][0]);
        pilih2.setText(soal[soal_sekarang][sub_soal][1][1][0]);
        pilih3.setText(soal[soal_sekarang][sub_soal][1][2][0]);
        pilih4.setText(soal[soal_sekarang][sub_soal][1][3][0]);
    }

    public void getHasil(View view) {

        if(pilih1.isChecked()){
            if (soal[curr_soal][sub_soal][1][0][1] == "benar"){
                tambahNilai();
            }
        } else if(pilih2.isChecked()){
            if (soal[curr_soal][sub_soal][1][1][1] == "benar"){
                tambahNilai();

            }
        } else if(pilih3.isChecked()){
            if (soal[curr_soal][sub_soal][1][2][1] == "benar"){
                tambahNilai();
            }
        } else if(pilih4.isChecked()){
            if (soal[curr_soal][sub_soal][1][3][1] == "benar"){
                tambahNilai();
            }
        } else {
            Toast.makeText(this, "TIDAK PILIH!", Toast.LENGTH_LONG).show();
        }

        Intent hasil = new Intent(this, hasil_quis.class);
        startActivity(hasil);
        finish();
    }

    void tambahNilai(){
        nilai_akhir += 20;
    }

}
