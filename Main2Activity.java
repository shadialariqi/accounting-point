package com.example.end;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.activity_main2_drawer,menu);
        return true;
    }


    ImageButton btn_b , btn_sh , btn_m , btn_mo , btn_a , btn_ms , btn_ah;
    Animation inmebotn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        btn_b =(ImageButton) findViewById(R.id.btn_b);
        btn_sh =(ImageButton) findViewById(R.id.btn_sh);
        btn_m =(ImageButton) findViewById(R.id.btn_m);
        btn_mo =(ImageButton) findViewById(R.id.btn_mo);
        btn_a =(ImageButton) findViewById(R.id.btn_a);
        btn_ms =(ImageButton) findViewById(R.id.btn_ms);
        btn_ah =(ImageButton) findViewById(R.id.btn_ah);

        inmebotn= AnimationUtils.loadAnimation(this,R.anim.inmebotn);
    }

    /*كود زر البيع */

    public void btn_b(View view) {
        Thread thread = new Thread() {

            @Override
            public void run() {
                btn_b.startAnimation(inmebotn);
                try {

                    /*كود الانتظار نص ثانيه والانتقال الى الصفحه المطلوبة*/
                    sleep(500);

                    Intent intent = new Intent(getApplicationContext(), fatorh_sal.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }



        };

        thread.start();
    }

    /*كود زر الشراء */

    public void btn_sh(View view) {
        Thread thread = new Thread() {

            @Override
            public void run() {
                btn_sh.startAnimation(inmebotn);
                try {

                    /*كود الانتظار نص ثانيه والانتقال الى الصفحه المطلوبة*/
                    sleep(500);

                    Intent intent = new Intent(getApplicationContext(), fatorh_sal.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }



        };

        thread.start();


    }


    /*كود زر مخزون المنتجات  */

    public void btn_m(View view) {
        Thread thread = new Thread() {

            @Override
            public void run() {
                btn_m.startAnimation(inmebotn);
                try {

                    /*كود الانتظار نص ثانيه والانتقال الى الصفحه المطلوبة*/
                    sleep(500);

                    Intent intent = new Intent(getApplicationContext(), storees.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }



        };

        thread.start();


    }

    /*كود زر الموردين */

    public void btn_mo(View view) {
        Thread thread = new Thread() {

            @Override
            public void run() {
                btn_mo.startAnimation(inmebotn);
                try {

                    /*كود الانتظار نص ثانيه والانتقال الى الصفحه المطلوبة*/
                    sleep(500);

                    Intent intent = new Intent(getApplicationContext(), ALMORADON.class);
                    intent.putExtra("m_or_a",true);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }



        };

        thread.start();




    }

    /*كود زر العملاء */

    public void btn_a(View view) {
        Thread thread = new Thread() {

            @Override
            public void run() {
                btn_a.startAnimation(inmebotn);
                try {

                    /*كود الانتظار نص ثانيه والانتقال الى الصفحه المطلوبة*/
                    sleep(500);

                    Intent intent = new Intent(getApplicationContext(), ALMORADON.class);
                    intent.putExtra("m_or_a",false);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }



        };

        thread.start();


    }

    /*كود زر المصروفات  */

    public void btn_ms(View view) {
        Thread thread = new Thread() {

            @Override
            public void run() {
                btn_ms.startAnimation(inmebotn);
                try {
                    /*كود الانتظار نص ثانيه والانتقال الى الصفحه المطلوبة*/

                    sleep(500);

                    Intent intent = new Intent(getApplicationContext(), expeness.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }



        };

        thread.start();


    }

    /*كود زر ادارة الحسابات */

    public void btn_ah(View view) {
        Thread thread = new Thread() {

            @Override
            public void run() {
                btn_ah.startAnimation(inmebotn);
                try {

                    /*كود الانتظار نص ثانيه والانتقال الى الصفحه المطلوبة*/
                    sleep(500);

                    Intent intent = new Intent(getApplicationContext(), alhsabat_a.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }



        };

        thread.start();

    }


}

