package com.example.end;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class trhib extends AppCompatActivity {
    ProgressBar progressBar;
    TextView tex1 , tex2 ;
    Animation anima;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trhib);

        /*كود تعريف الصوره وحركتها في الشاشة الترحيبيه */

        imageView=(ImageView) findViewById(R.id.imageView7);
        anima = AnimationUtils.loadAnimation(this,R.anim.anmitrb);
        imageView.setAnimation(anima);

        /*كود تعريف النص وحركته في الشاشة الترحيبيه */

        tex1=(TextView)findViewById(R.id.tex1);
        anima = AnimationUtils.loadAnimation(this,R.anim.anmitr);
        tex1.setAnimation(anima);

        /*كود تعريف النص وحركته في الشاشة الترحيبيه */

        tex2=(TextView)findViewById(R.id.tex2);
        anima = AnimationUtils.loadAnimation(this,R.anim.anmitra);
        tex2.setAnimation(anima);


                        /*كود الانتظار 7 ثانيه والانتقال الى الواجهه الرئيسية */


        Thread thread = new Thread() {

            @Override
            public void run() {

                try {

                    sleep(5000);

                    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                    startActivity(intent);

                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }



        };

        thread.start();





    }

}
