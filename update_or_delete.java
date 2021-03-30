package com.example.end;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class update_or_delete extends AppCompatActivity {
    Database database=new Database(this);
    EditText up_sal,add_quantity;
    TextView prodect_name,update,delete,ok_up,exit_up;
    int m=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_or_delete);
        up_sal=findViewById(R.id.sal_up);
        add_quantity=findViewById(R.id.add_quantity);
        prodect_name=findViewById(R.id.prodect_name);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.delete);
        ok_up=findViewById(R.id.ok_up);
        exit_up=findViewById(R.id.exit_up);

        Intent inten= getIntent();
        String names= inten.getStringExtra("name");
        final String [] fall=database.getAll(names);
        prodect_name.setText(fall[0]);
        up_sal.setText(fall[4]);
        String makzon=fall[2];
        m=Integer.parseInt(makzon);

        ok_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namep=prodect_name.getText().toString();
                int p=Integer.parseInt(up_sal.getText().toString());
                String b=add_quantity.getText().toString();
                int w=Integer.parseInt(b);





                int c=m+w;


                boolean r=database.Update(namep,c,p);
                if (r == true) {

                    Toast.makeText(update_or_delete.this, "تم التعديل", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }
                else
                {
                    Toast.makeText(update_or_delete.this, "لم يتم التعديل", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }

            }
        });
        exit_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




        //تعديل بيانات المنتج***************************************
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* String S=prodect_name.getText().toString();
               String [] fall=database.getAll(S);



               product_add.name_product.setText(prodect_name.getText().toString());
                product_add.btn_barcode_add.setText(fall[1]);
                product_add.quantity.setText(fall[2]);
                product_add.price_purchase.setText(fall[3]);
                product_add.price_sale.setText(fall[4]);
                product_add.description.setText(fall[5]);
                product_add.rating.setText(fall[6]);



                Intent intent=new Intent(update_or_delete.this,product_add.class);
                intent.putExtra("name",S);
                startActivity(intent);*/
                Intent up=new Intent(update_or_delete.this,product_add.class);
                Bundle n=new Bundle();
                n.putStringArray("up",fall);
                up.putExtras(n);
                startActivity(up);
                finish();
            }
        });

        //حذف المنتج *****************************************
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(update_or_delete.this);
                builder.setMessage("هل تريد حذف المنتج "+fall[0]+"?")
                    .setIcon(R.drawable.ic_search)
                    .setTitle("حذف البيانات")
                    .setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            String  d= prodect_name.getText().toString();
                            Integer r=database.deletedate(d);
                            if (r>0)
                            {
                                Toast.makeText(update_or_delete.this, "تم الحذف ", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                            else
                            { Toast.makeText(update_or_delete.this, "لم يتم الحذف", Toast.LENGTH_SHORT).show();
                            finish();}


                        }
                    })
                    .setNegativeButton(" لا ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            finish();
                        }
                    }).show();

            }
        });













    }
}
