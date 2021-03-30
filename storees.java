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

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class storees extends AppCompatActivity {
    EditText serch;
    Database db=new Database(this);
    ListView listView;
    ArrayList<student> arrayList;
    MyAdapter myAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storees);

        serch=findViewById(R.id.serch);
        listView=findViewById(R.id.list_product);
        lodedatalistview();

        ImageView img_product_add=(ImageView)findViewById(R.id.img_product_add);

        img_product_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_product_add=new Intent(storees.this,product_add.class);
                startActivity(i_product_add);
            }
        });






        serch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                myAdapter.getFilter().filter(s);


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




    }
    public void lodedatalistview() {
        arrayList = db.getAllData();

            myAdapter = new MyAdapter(storees.this ,arrayList);
        listView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String names=arrayList.get(position).getName_product();


                Intent intent=new Intent(storees.this,update_or_delete.class);
                intent.putExtra("name",names);
                startActivity(intent);
            }
        });




    }

    @Override
    protected void onResume() {
        super.onResume();
        lodedatalistview();
    }
}
