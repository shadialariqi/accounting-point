package com.example.end;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class add_albea extends AppCompatActivity {
    EditText km,shre,bea;
    public static TextView barcode_alb;
    TextView ok_alb,exit_alb,prodect_name_alb;
    Database database=new Database(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_albea);
        km=findViewById(R.id.quantit_alb);
        shre=findViewById(R.id.sheree_alb);
        bea=findViewById(R.id.bae_alb);

        prodect_name_alb=findViewById(R.id.prodect_name_alb);
        barcode_alb=findViewById(R.id.barcode_bea);
        ok_alb=findViewById(R.id.ok_albe);
        exit_alb=findViewById(R.id.exit_alb);

        final Intent inten= getIntent();
        String names= inten.getStringExtra("name");
        final boolean b=database.serch_alba(names);

        if(b==true ) {

            String[] fall = database.getAll(names);
            prodect_name_alb.setText(fall[0]);
            shre.setText(fall[3]);
            bea.setText(fall[4]);
            barcode_alb.setText(fall[1]);


        }else {
            prodect_name_alb.setText(names);


        }


        //****عند الضغط على حفظ**********************
        ok_alb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b==true ){
                    boolean x=database.Update_alb(prodect_name_alb.getText().toString(),Integer.parseInt(km.getText().toString()),Integer.parseInt(shre.getText().toString()),Integer.parseInt(bea.getText().toString()));
                    if(x==true){
                        Toast.makeText(add_albea.this,"yas up",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(add_albea.this,"no up",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    boolean y = database.save_product(prodect_name_alb.getText().toString(), barcode_alb.getText().toString(), Integer.parseInt(km.getText().toString()), Integer.parseInt(shre.getText().toString()), Integer.parseInt(bea.getText().toString()), null, null);

                    if(y==true){
                        Toast.makeText(add_albea.this,"yas add",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(add_albea.this,"no add",Toast.LENGTH_SHORT).show();
                    }
                }
               fatorh_sal.sad = new student(prodect_name_alb.getText().toString(),Integer.parseInt(km.getText().toString()), Integer.parseInt(shre.getText().toString()) );
                fatorh_sal.arr.add(fatorh_sal.sad);
                fatorh_sal.sall = new sale_list(add_albea.this, R.layout.mycastmlastview, fatorh_sal.arr);
                fatorh_sal.listView.setAdapter(fatorh_sal.sall);
                int w=Integer.parseInt(km.getText().toString())*Integer.parseInt(shre.getText().toString());
                int alb_mg=Integer.parseInt(fatorh_sal.magma.getText().toString())+w;
                fatorh_sal.magma.setText(String.valueOf(alb_mg));
                finish();
            }
        });
        //****************************************************************************************************************************************************

        //************************غلق***************************************
        exit_alb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        barcode_alb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(barcode_alb.getText().toString().trim().isEmpty()){
                    Intent inte=new Intent(add_albea.this,QR_SCNER.class);
                    inte.putExtra("alb","alb");

                    startActivity(inte);
                }
            }
        });
    }
}
