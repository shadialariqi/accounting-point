package com.example.end;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class numper_barcode extends AppCompatActivity {
    Button btn_ok,btn_close;
    EditText txt_barcoding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numper_barcode);

        btn_ok=findViewById(R.id.btn_ok);
        btn_close=findViewById(R.id.btn_close);

        txt_barcoding=findViewById(R.id.txt_barcoding);



        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent barcoding=new Intent(numper_barcode.this,product_add.class);
                Bundle b =new Bundle();
                b.putString("barcoding",txt_barcoding.getText().toString());
                barcoding.putExtras(b);
                startActivity(barcoding);
                finish();*/
                product_add.btn_barcode_add.setText(txt_barcoding.getText().toString());
                onBackPressed();
            }
        });
    }
}
