package com.example.end;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class QR_SCNER extends AppCompatActivity implements ZXingScannerView.ResultHandler{
    ZXingScannerView scannerView;
    LinearLayout con;
    ImageView switch_of,switch_on;

    Bundle e;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr__scner);
        con=findViewById(R.id.con);



        con.addView(scannerView=new ZXingScannerView(getBaseContext()));



        switch_of=findViewById(R.id.switch_of);
        switch_on=findViewById(R.id.switch_on);

        //زر تشغيل الفلاش

        switch_of.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {



                switch_of.setVisibility(View.GONE);
                switch_on.setVisibility(View.VISIBLE);
                scannerView.setFlash(true);
                scannerView.setAutoFocus(true);



            }
        });
        switch_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               switch_of.setVisibility(View.VISIBLE);
                switch_on.setVisibility(View.GONE);
                scannerView.setFlash(false);
                scannerView.setAutoFocus(false);


            }
        });


    }


    @Override
    public void handleResult(Result result) {
        e=getIntent().getExtras();
        if(e!=null){
           // String w=e.getString("alb");
            add_albea.barcode_alb.setText(result.getText());
            onBackPressed();
        }else {
            product_add.btn_barcode_add.setText(result.getText());
            onBackPressed();
        }

    }
    @Override
    protected void onResume() {
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();


    }

    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();

    }
}
