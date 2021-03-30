package com.example.end;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class fatorh_sal_sal extends AppCompatActivity {
    EditText ksm,agmala,madfo,motbge,amal;
    TextView tarh,ok_sal,exit_sal;
    Database db=new Database(this);

    Bundle M;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatorh_sal_sal);
        ksm=findViewById(R.id.ksm_sal_sal);
        agmala=findViewById(R.id.agmale_sal_sal);
        madfo=findViewById(R.id.madfo_sal);
        motbge=findViewById(R.id.motbge_sal);
        amal=findViewById(R.id.name_amel);

        tarh=findViewById(R.id.tarh_sal);
        ok_sal=findViewById(R.id.ok_sal_sal);
        exit_sal=findViewById(R.id.exit_sal_sal);
        //عرض الفاتوره معا البيانات*****************************
        M=getIntent().getExtras();
        String[] nal= M.getStringArray("sall");
        agmala.setText(nal[0]);
        madfo.setText(nal[0]);
        tarh.setText(nal[1]);


        ok_sal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.ALL(fatorh_sal.arr);
                Intent i=new Intent(fatorh_sal_sal.this,fatorh_sal.class);
                startActivity(i);
                finish();

            }
        });




//***************************************************************************




        //*************************************************الغلق
        exit_sal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
