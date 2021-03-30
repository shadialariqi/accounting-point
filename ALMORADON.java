package com.example.end;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ALMORADON extends AppCompatActivity {
    ArrayList<mord_or_amal> arrayList_m,arrayList_a;
    ListView listView_m;
    arymord ary_m;
    arymord ary_a;
    Database db=new Database(this);
    ImageView add_m_or_a;
    EditText serch_m;
    boolean b;
    TextView m_serh_m,m_t1,m_t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almoradon);
        add_m_or_a=findViewById(R.id.img_m_add);
        serch_m=findViewById(R.id.m_serch);
        m_serh_m=findViewById(R.id.m_search_m);

        m_t1=findViewById(R.id.m_titel2);
        m_t2=findViewById(R.id.m_title);
        add_m_or_a.bringToFront();

        b=getIntent().getExtras().getBoolean("m_or_a");

        listView_m=findViewById(R.id.m_list);
        if(b==true){
            show_m();
            Toast.makeText(ALMORADON.this, "انت في صفحة الموردين ", Toast.LENGTH_SHORT).show();

        }else  {
            show_a();
            m_serh_m.setText("ابحث عن العميل");

            serch_m.setHint("ادخل اسم العميل ");
            m_t1.setText("رقم العميل");
            m_t2.setText(" العميل ");



            Toast.makeText(ALMORADON.this, "انت في صفحة العملاء", Toast.LENGTH_SHORT).show();
        }


        add_m_or_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b==true) {
                    Intent i = new Intent(ALMORADON.this, add_almorad.class);
                    i.putExtra("mo_om", true);
                    startActivity(i);
                }else {
                    Intent i = new Intent(ALMORADON.this, add_almorad.class);
                    i.putExtra("mo_om", false);
                    startActivity(i);

                }

            }
        });
        serch_m.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(b==true) {
                    ary_m.getFilter().filter(s);
                }
                else {
                    ary_a.getFilter().filter(s);
                }



            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    public void show_m(){
        arrayList_m =db.getAllData_m();
        ary_m=new arymord(ALMORADON.this, arrayList_m);
        listView_m.setAdapter(ary_m);
        listView_m.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int u=arrayList_m.get(position).getId_amal();
                Intent i = new Intent(ALMORADON.this, add_almorad.class);
                i.putExtra("mo_om", true);
                i.putExtra("up_or_da",u);
                startActivity(i);
            }
        });
    }
    public void show_a(){
        arrayList_a =db.getAllData_a();
        ary_a=new arymord(ALMORADON.this, arrayList_a);
        listView_m.setAdapter(ary_a);
        listView_m.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int u=arrayList_a.get(position).getId_amal();
                Intent i = new Intent(ALMORADON.this, add_almorad.class);
                i.putExtra("mo_om", false);
                i.putExtra("up_or_da",u);
                startActivity(i);


            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (b==true){
            show_m();
        }else {
            show_a();
        }
    }
}
