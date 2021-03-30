package com.example.end;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.Result;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class fatorh_sal extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    RelativeLayout relativeLayout;

    TextView  txt_name_barcode2, txt_no_barcode;
    Database db=new Database(this);
    ZXingScannerView mScannerView;
    public static ListView listView;
    int i=1;
    String[]Z;
    public static student sad;
    public static ArrayList<student> arr;
    public  static sale_list sall;
    Button msh,hav;
    public static TextView magma;
    Button button_add_sal;
    AutoCompleteTextView editText_sal;

    ZXingScannerView scannerView;
    String name;







    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatorh_sal);

        relativeLayout = findViewById(R.id.barcode_show);
        txt_name_barcode2 = findViewById(R.id.txt_name_barcode2);
        txt_no_barcode = findViewById(R.id.txt_no_barcode);
        listView = findViewById(R.id.list_sal);
        button_add_sal = findViewById(R.id.btn_fatorh);
        editText_sal = findViewById(R.id.edt_fatorh);
        hav = findViewById(R.id.hav);
        msh = findViewById(R.id.msh);
        magma = findViewById(R.id.magmoa);
        mScannerView = new ZXingScannerView(this);
        relativeLayout.addView(mScannerView);

        //**************قائمة الاختيار عند كتابة اسم المنتج

            ArrayList<String> SER = db.getAlData();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(fatorh_sal.this, android.R.layout.simple_list_item_1, SER);
            editText_sal.setAdapter(adapter);








        //*****************************************

        txt_name_barcode2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                relativeLayout.setVisibility(View.VISIBLE);
                txt_name_barcode2.setVisibility(View.GONE);
                txt_no_barcode.setVisibility(View.VISIBLE);


            }
        });
        txt_no_barcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                relativeLayout.setVisibility(View.GONE);
                txt_name_barcode2.setVisibility(View.VISIBLE);
                txt_no_barcode.setVisibility(View.GONE);

            }
        });


        arr = new ArrayList<>();


        //عند الضغط على اضف
        button_add_sal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle up = getIntent().getExtras();
                if (editText_sal.getText().toString().trim().isEmpty()) {
                    Toast.makeText(fatorh_sal.this, "ادخل اسم المنتج او الباركود", Toast.LENGTH_SHORT).show();
                }
                else if (up != null) {
                    name = up.getString("name");

                    String names = editText_sal.getText().toString();


                    Intent intent = new Intent(fatorh_sal.this, add_albea.class);
                    intent.putExtra("name", names);

                    startActivity(intent);

                } else {
                        Z = db.getAllercordtextname(editText_sal.getText().toString().trim());
                        sad = new student(Z[0], i, Integer.parseInt(Z[1]));
                        arr.add(sad);
                        sall = new sale_list(fatorh_sal.this, R.layout.mycastmlastview, arr);
                        listView.setAdapter(sall);
                        editText_sal.setText(" ");
                        int ma = Integer.parseInt(magma.getText().toString()) + Integer.parseInt(Z[1]);
                        magma.setText(String.valueOf(ma));


                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                int asm = (arr.get(position).getQuantity()) + 1;
                                int ma = Integer.parseInt(magma.getText().toString()) + arr.get(position).getPrice_sale();
                                magma.setText(String.valueOf(ma));

                                arr.get(position).setQuantity(asm);
                                listView.setAdapter(sall);

                            }
                        });
                    }
                }



        });

        //عند الضغط على حفظ
        hav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String[] G=new String[3];
                Date date=new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                String s=sdf.format(date);
                G[0]=magma.getText().toString();
                G[1]=s;


                Intent intent=new Intent(fatorh_sal.this,fatorh_sal_sal.class);
                Bundle n=new Bundle();
                n.putStringArray("sall",G);
                intent.putExtras(n);
                startActivity(intent);

              //db.ALL(arr);




            }
        });
        //عند الضغط على مسح
        msh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

              /*  listView.setAdapter(null);

                magma.setText(String.valueOf(0));*/
            }
        });




    }

    @Override
    public void handleResult(Result result) {
        Bundle up=getIntent().getExtras();
        if(up !=null){
            name = up.getString("name");

            String names=result.getText();
            boolean c=db.serch_alb(names);

            if(c==true){
                String[]S=db.getAllercordtextname(names);



            Intent intent=new Intent(fatorh_sal.this,add_albea.class);
            intent.putExtra("name",S[0]);
            startActivity(intent);
            }
            else {Toast.makeText(fatorh_sal.this,"هذا الباركود غير موجود " ,Toast.LENGTH_SHORT).show();}

        }
        else {

            Z = db.getAllercordtext(result.getText().trim());

            try {

                sad = new student(Z[0], i, Integer.parseInt(Z[1]));
                arr.add(sad);
                sall = new sale_list(fatorh_sal.this, R.layout.mycastmlastview, arr);

                listView.setAdapter(sall);
                int ma = Integer.parseInt(magma.getText().toString()) + Integer.parseInt(Z[1]);

                magma.setText(String.valueOf(ma));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        int asm = (arr.get(position).getQuantity()) + 1;
                        int ma = Integer.parseInt(magma.getText().toString()) + arr.get(position).getPrice_sale();
                        magma.setText(String.valueOf(ma));
                        arr.get(position).setQuantity(asm);
                        listView.setAdapter(sall);

                    }
                });


            } catch (Exception e) {

                Toast.makeText(fatorh_sal.this, "NO", Toast.LENGTH_SHORT).show();
            }
        }


            mScannerView.resumeCameraPreview(this);


    }
    @Override
    protected void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);


        mScannerView.startCamera();


    }
    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();

    }

    //عند الرجوع
    @Override
    public void onBackPressed() {
        super.onBackPressed();
       /* Intent i=new Intent(fatorh_sal.this,Main2Activity.class);
        startActivity(i);
       finish();*/

    }
}
