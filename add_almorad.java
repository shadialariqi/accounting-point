package com.example.end;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class add_almorad extends AppCompatActivity {
    TextView namper_m,int_nam,nam_amal;
    EditText name_m,address_m,phone_m,malhdh_m;
    Button ok_m,msh_m;
    Database db=new Database(this);



    int sh;


    boolean m;
    int r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_almorad);




        nam_amal=findViewById(R.id.nam_amal);
        int_nam=findViewById(R.id.int_amal);
        namper_m=findViewById(R.id.namper_m);
        name_m=findViewById(R.id.name_m);
        address_m=findViewById(R.id.addrss_m);
        phone_m=findViewById(R.id.phone_m);
        malhdh_m=findViewById(R.id.malhdh_m);
        msh_m=findViewById(R.id.msh_m);
        ok_m=findViewById(R.id.hav_m);



         m=getIntent().getExtras().getBoolean("mo_om");
         r=getIntent().getExtras().getInt("up_or_da");
        if(m==true){
            if(r>0){
                ok_m.setText("تعديل ");
                msh_m.setText("حذف التاجر");
                String []MM=db.getAllmord(r);
                namper_m.setText(MM[0]);
                name_m.setText(MM[1]);
                address_m.setText(MM[2]);
                phone_m.setText(MM[3]);
                malhdh_m.setText(MM[4]);


            }else {

                SharedPreferences sh_m = getSharedPreferences("save_m_id", Context.MODE_PRIVATE);
                sh = sh_m.getInt("mordamel", 1);
                namper_m.setText(String.valueOf(sh));

                Toast.makeText(add_almorad.this, "  yas mord ", Toast.LENGTH_SHORT).show();
            }





        }
        else {
            int_nam.setText("رقم العميل ");
            nam_amal.setText("اسم العميل");
            name_m.setHint("ادخل اسم العميل");
            phone_m.setHint("ادخل رقم العميل");
            address_m.setHint("ادخل عنوان العميل");
            if(r>0) {
            ok_m.setText("تعديل ");
            msh_m.setText("حذف العميل");
            String[] MM = db.getAllamal(r);
            namper_m.setText(MM[0]);
            name_m.setText(MM[1]);
            address_m.setText(MM[2]);
            phone_m.setText(MM[3]);
            malhdh_m.setText(MM[4]);
        }
        else {
            SharedPreferences sh_m = getSharedPreferences("save_m_id", Context.MODE_PRIVATE);
            sh = sh_m.getInt("amalamal", 1);
            namper_m.setText(String.valueOf(sh));
        }








            Toast.makeText(add_almorad.this,"yas amil " ,Toast.LENGTH_SHORT).show();
        }

        msh_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(m==true) {
                    if (r != 0) {
                        Integer s=db.delete_m(Integer.parseInt(namper_m.getText().toString()));
                        if (s>0)
                        {
                            Toast.makeText(add_almorad.this, "تم الحذف ", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else
                        { Toast.makeText(add_almorad.this, "لم يتم الحذف", Toast.LENGTH_SHORT).show();
                            finish();}


                    }
                    else {
                        name_m.setText("");
                        address_m.setText("");
                        phone_m.setText("");
                        malhdh_m.setText("");
                    }

                }
                else if(m==false) {
                    if (r != 0) {
                    Integer s=db.delete_a(Integer.parseInt(namper_m.getText().toString()));
                    if (s>0)
                    {
                        Toast.makeText(add_almorad.this, "تم الحذف ", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else
                    { Toast.makeText(add_almorad.this, "لم يتم الحذف", Toast.LENGTH_SHORT).show();
                        finish();}


                }
                else {
                    name_m.setText("");
                    address_m.setText("");
                    phone_m.setText("");
                    malhdh_m.setText("");
                }

                }
            }
        });
        ok_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (m == true) {
                        if(r!=0){
                            if (name_m.getText().toString().trim().isEmpty()) {
                                Toast.makeText(add_almorad.this, "ادخل اسم المورد ", Toast.LENGTH_SHORT).show();
                            }else {
                                boolean s = db.Update_m(Integer.parseInt(namper_m.getText().toString()), name_m.getText().toString(), address_m.getText().toString(), Integer.parseInt(phone_m.getText().toString()), malhdh_m.getText().toString());
                                if(s==true){

                                Toast.makeText(add_almorad.this, " تم التعديل ", Toast.LENGTH_SHORT).show();
                                finish();
                                }else {
                                    Toast.makeText(add_almorad.this, " لم يتم التعديل ", Toast.LENGTH_SHORT).show();
                                    finish();

                                }

                            }


                        }
                        else {
                            if (name_m.getText().toString().trim().isEmpty()) {
                                Toast.makeText(add_almorad.this, "ادخل اسم المورد ", Toast.LENGTH_SHORT).show();
                            } else {
                                boolean s = db.save_m(Integer.parseInt(namper_m.getText().toString()), name_m.getText().toString(), address_m.getText().toString(), Integer.parseInt(phone_m.getText().toString()), malhdh_m.getText().toString());
                                if (s == true) {
                                    SharedPreferences sh_mm = getSharedPreferences("save_m_id", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sh_mm.edit();
                                    editor.putInt("mordamel", sh + 1);
                                    editor.apply();


                                    Toast.makeText(add_almorad.this, "تم الحفظ بنجاج ", Toast.LENGTH_SHORT).show();
                                    finish();
                                } else {
                                    Toast.makeText(add_almorad.this, " لم يتم الحفظ ", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                }else {
                    if(r!=0) {
                        if (name_m.getText().toString().trim().isEmpty()) {
                            Toast.makeText(add_almorad.this, "ادخل اسم العميل ", Toast.LENGTH_SHORT).show();
                        } else {
                            boolean s = db.Update_a(Integer.parseInt(namper_m.getText().toString()), name_m.getText().toString(), address_m.getText().toString(), Integer.parseInt(phone_m.getText().toString()), malhdh_m.getText().toString());
                            if (s == true) {

                                Toast.makeText(add_almorad.this, " تم التعديل ", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                Toast.makeText(add_almorad.this, " لم يتم التعديل ", Toast.LENGTH_SHORT).show();
                                finish();

                            }
                        }
                    }
                    else {
                    if (name_m.getText().toString().trim().isEmpty()) {
                        Toast.makeText(add_almorad.this, "ادخل اسم العميل ", Toast.LENGTH_SHORT).show();
                    }else {
                        boolean s = db.save_a(Integer.parseInt(namper_m.getText().toString()), name_m.getText().toString(), address_m.getText().toString(), Integer.parseInt(phone_m.getText().toString()), malhdh_m.getText().toString());
                        if (s == true) {
                            SharedPreferences sh_mm = getSharedPreferences("save_m_id", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sh_mm.edit();
                            editor.putInt("amalamal", sh + 1);
                            editor.apply();


                            Toast.makeText(add_almorad.this, "تم حفظ العميل بنجاج ", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(add_almorad.this, " لم يتم حفظ العميل  ", Toast.LENGTH_SHORT).show();
                        }


                }
                }
                        }

            }
        });



    }
}
