package com.example.end;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class product_add extends AppCompatActivity {
    //انشاء كائن من الكلاس الخاص بقاعده البينات
    //************************************************

    Database DataBase = new Database(this);


    //************************************************

   public static Button btn_barcode_add;
    Button btn_save_product;
    public static EditText name_product,quantity,price_purchase,price_sale,description,rating;
    Bundle n;
    String BACK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_add);



        //اكواد تغيير خطوط
        //*******************************************************************************
        TextView txt_name_product=(TextView)findViewById(R.id.txt_name_product);
        TextView txt_name_barcode=(TextView)findViewById(R.id.txt_name_barcode);
        TextView txt_name_barcode2=(TextView)findViewById(R.id.txt_name_barcode2);
        TextView txt_name_quantity=(TextView)findViewById(R.id.txt_name_quantity);
        TextView txt_name_price_purchase=(TextView)findViewById(R.id.txt_name_price_purchase);
        TextView txt_name_price_sale=(TextView)findViewById(R.id.txt_name_price_sale);
        TextView txt_name_description=(TextView)findViewById(R.id.txt_name_description);
        TextView txt_name_rating=(TextView)findViewById(R.id.txt_name_rating);


        btn_barcode_add= (Button) findViewById(R.id.btn_barcode_add);
        btn_save_product= (Button) findViewById(R.id.btn_save_product);





        //************************************************************************************


        //الانتقال الى واجهه ادخال الباركود اليديويه
        //*****************************************************************

        txt_name_barcode2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BARCODE2 = new Intent(product_add.this,numper_barcode.class);
                startActivity(BARCODE2);
            }
        });

       /* Bundle b=getIntent().getExtras();
        if (b==null)
        {
            txt_name_barcode2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent BARCODE2 = new Intent(product_add.this,numper_barcode.class);
                    startActivity(BARCODE2);

                }
            });

        }


        else {
            txt_name_barcode2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent BARCODE2 = new Intent(product_add.this,numper_barcode.class);
                    startActivity(BARCODE2);
                    btn_barcode_add.setText("اضف باركود المنتج");
                }
            });
            String barcoding = b.getString("barcoding");
            btn_barcode_add.setText(barcoding);
            b.clear();

        }*/

        //*****************************************************************




        //كود لاضهار ماسح الباركود
        //*******************************************************************





        btn_barcode_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(product_add.this,QR_SCNER.class));


            }
        });
        //********************************************************************



        // كود الاضافه الى قاعد البينات اضافه المنتجات الى المخازن
        //***************************************************************************************
        name_product=(EditText)findViewById(R.id.edit_product);
        quantity=(EditText)findViewById(R.id.edit_quantity);
        price_purchase=(EditText)findViewById(R.id.edit_price_purchase);
        price_sale=(EditText)findViewById(R.id.edit__price_sale);
        description=(EditText)findViewById(R.id.edit_description);
        rating=(EditText)findViewById(R.id.edit_rating);



//********************************************************************************

        n=getIntent().getExtras();
        if(n !=null){
            String [] v = n.getStringArray("up");

            name_product.setText(v[0]);
            BACK=name_product.getText().toString();
           btn_barcode_add.setText(v[1]);
           quantity.setText(v[2]);
            price_purchase.setText(v[3]);
          price_sale.setText(v[4]);
            description.setText(v[5]);
            rating.setText(v[6]);


//***************************************************************************
        }
        btn_save_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (name_product.getText().toString().trim().isEmpty()) {
                    Toast.makeText(product_add.this, "ادخل اسم المنتج ", Toast.LENGTH_SHORT).show();
                }else if(quantity.getText().toString().trim().isEmpty()){
                    Toast.makeText(product_add.this, "ادخل الكميه ", Toast.LENGTH_SHORT).show();
                }else if(price_purchase.getText().toString().trim().isEmpty()){
                    Toast.makeText(product_add.this, "ادخل سعر الشراء ", Toast.LENGTH_SHORT).show();
                }else if(price_sale.getText().toString().trim().isEmpty()){
                    Toast.makeText(product_add.this, "ادخل سعر البيع ", Toast.LENGTH_SHORT).show();
                } else if(n!=null) {

                    String NAME_PRPDUCT = name_product.getText().toString();
                    String BARCODE = (btn_barcode_add.getText().toString());
                    int QUANTITY = Integer.parseInt(quantity.getText().toString());
                    int PRICE_PURCHASE = Integer.parseInt(price_purchase.getText().toString());
                    int PRICE_SALE = Integer.parseInt(price_sale.getText().toString());
                    String DESCRIPTION = description.getText().toString();
                    String RATING = rating.getText().toString();

                    boolean Result = DataBase.Update_up(BACK, NAME_PRPDUCT, BARCODE, QUANTITY, PRICE_PURCHASE, PRICE_SALE, DESCRIPTION, RATING);
                    if (Result == true) {
                        Toast.makeText(product_add.this, "تم تعديل المنتج بنجاح", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(product_add.this, "لم يتم تعديل المنتج بنجاح", Toast.LENGTH_SHORT).show();

                    }
                } else{

                    String NAME_PRPDUCT = name_product.getText().toString();
                    String BARCODE = (btn_barcode_add.getText().toString());
                    int QUANTITY = Integer.parseInt(quantity.getText().toString());
                    int PRICE_PURCHASE = Integer.parseInt(price_purchase.getText().toString());
                    int PRICE_SALE = Integer.parseInt(price_sale.getText().toString());
                    String DESCRIPTION = description.getText().toString();
                    String RATING = rating.getText().toString();

                    boolean Result = DataBase.save_product(NAME_PRPDUCT, BARCODE, QUANTITY, PRICE_PURCHASE, PRICE_SALE, DESCRIPTION, RATING);

                    if (Result == true) {
                        Toast.makeText(product_add.this, "تم اضافه المنتج بنجاح", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(product_add.this, "لم يتم اضافه المنتج بنجاح", Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });


        //***************************************************************************************
    }



}
