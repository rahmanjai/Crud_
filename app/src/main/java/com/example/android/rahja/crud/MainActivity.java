package com.example.android.rahja.crud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper mydb;
    EditText edId, edNama, edAlamat, edNotelp;
    Button btnTambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new DatabaseHelper(this);

        edId = (EditText) findViewById(R.id.edId);
        edNama = (EditText) findViewById(R.id.edNama);
        edAlamat = (EditText) findViewById(R.id.edAlamat);
        edNotelp = (EditText) findViewById(R.id.edHp);
        btnTambah = (Button) findViewById(R.id.tambah);

        TambahData();

    }

    public void TambahData() {
        btnTambah.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick (View V) {
                        boolean isInsertred = mydb.insertData(
                                edId.getText().toString(),
                                edNama.getText().toString(),
                                edAlamat.getText().toString(),
                                edNotelp.getText().toString());
                        if (isInsertred == true)
                            Toast.makeText(MainActivity.this, "Data Tesimpan", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data Tidak Tersimpan", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
