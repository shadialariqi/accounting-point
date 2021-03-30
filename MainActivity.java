package com.example.end;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Database database = new Database(this);
    EditText n1,n2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          n1=findViewById(R.id.usname);
          n2=findViewById(R.id.pass);
        b1=findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                  /*String n=n1.getText().toString();
                  String p=n2.getText().toString();
                   boolean b=database.logen(n,p);

                 if(n.equals("admin") && p.equals("admin")) {
                     Toast.makeText(MainActivity.this, "تم تسجيل الدخول ", Toast.LENGTH_SHORT).show();
                     Intent button = new Intent(MainActivity.this, Main2Activity.class);
                     startActivity(button);
                 }


                  else if (b == true ){
                   Toast.makeText(MainActivity.this, "تم تسجيل الدخول ", Toast.LENGTH_SHORT).show();
                     Intent button=new Intent(MainActivity.this,Main2Activity.class);
                     startActivity(button);}

                  else
                    Toast.makeText(MainActivity.this, "لم يتم الدخول ", Toast.LENGTH_SHORT).show();

                    }*/
                  int u=database.getSUM();
                Toast.makeText(MainActivity.this,"d"+u,Toast.LENGTH_SHORT).show();

                Intent button=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(button);}




        });

    }
}



