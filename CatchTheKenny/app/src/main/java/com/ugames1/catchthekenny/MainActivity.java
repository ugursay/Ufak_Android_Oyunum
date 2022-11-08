package com.ugames1.catchthekenny;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.SharedPreferences;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView scoresayma;
    TextView time;
    TextView maxx;
    Button clear;

    Button yanRenk1;
    Button yanRenk2;
    Button yanRenk3;
    Button yanRenk4;
    Button start;
    Button bastanbasla;

    TextView seviye;
    TextView tepkiler;



    int score;
    int hiz=800;

    ImageView imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9;
    ImageView[] imageArray;

    Handler handler;
    Runnable runnable;
    MediaPlayer ply;
    int zm=45000;

    public SharedPreferences sharedPreferences;
    int storedAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize

        time=findViewById(R.id.timeText);
        scoresayma=findViewById(R.id.scoreText);
        maxx=findViewById(R.id.Max);
        clear=findViewById(R.id.Clear);
        seviye=findViewById(R.id.Level);
        tepkiler=findViewById(R.id.Tepkiler);

        yanRenk1=findViewById(R.id.yanRenk1);
        yanRenk2=findViewById(R.id.yanRenk2);
        yanRenk3=findViewById(R.id.yanRenk3);
        yanRenk4=findViewById(R.id.yanRenk4);

        start=findViewById(R.id.Start);
        bastanbasla=findViewById(R.id.bastanBasla);


        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);

        imageArray = new ImageView[]{imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9};
        hideImages();

        sharedPreferences = this.getSharedPreferences("com.ugames1.catchthekenny", Context.MODE_PRIVATE);
        storedAge = sharedPreferences.getInt("storedAge",0);
        maxx.setText("Rekor: "+storedAge);

        score=0;
        seviye.setText("Seviye 1");
        tepkiler.setText("");

        clear.setVisibility(View.INVISIBLE);
        bastanbasla.setVisibility(View.INVISIBLE);


    }

    public void increaseScore(View view){

        score ++;
        //score= score + 1 ;
        scoresayma.setText("Score: "+ score);


        switch(score){

            case 0:
                ply=MediaPlayer.create(MainActivity.this,R.raw.buton);
                ply.start();
                hiz=800;
                seviye.setText("Seviye 1");
                tepkiler.setText("BAŞLAYALIMMM");
                tepkiler.setTextSize(22);
                break;

            case 10:
                ply=MediaPlayer.create(MainActivity.this,R.raw.buton);
                ply.start();
                hiz=750;
                seviye.setText("Seviye 2");
                tepkiler.setText("HIMMMM");
                tepkiler.setTextSize(22);
               yanRenk1.setBackgroundColor(Color.WHITE);
               yanRenk2.setBackgroundColor(Color.WHITE);
               yanRenk3.setBackgroundColor(Color.WHITE);
               yanRenk4.setBackgroundColor(Color.WHITE);
                break;
            case 20:
                ply=MediaPlayer.create(MainActivity.this,R.raw.buton2);
                ply.start();
                hiz=700;
                seviye.setText("Seviye 3");
                tepkiler.setText("WOWOWO");
                tepkiler.setTextSize(22);
                yanRenk1.setBackgroundColor(Color.GREEN);
                yanRenk2.setBackgroundColor(Color.GREEN);
                yanRenk3.setBackgroundColor(Color.GREEN);
                yanRenk4.setBackgroundColor(Color.GREEN);
                break;
            case 30:
                ply=MediaPlayer.create(MainActivity.this,R.raw.buton3);
                ply.start();
                hiz=650;
                seviye.setText("Seviye 4");
                tepkiler.setText("MÜQQQ");
                tepkiler.setTextSize(22);
                yanRenk1.setBackgroundColor(Color.RED);
                yanRenk2.setBackgroundColor(Color.RED);
                yanRenk3.setBackgroundColor(Color.RED);
                yanRenk4.setBackgroundColor(Color.RED);
                break;
            case 40:
                ply=MediaPlayer.create(MainActivity.this,R.raw.buton4);
                ply.start();
                hiz=600;
                seviye.setText("Seviye 5");
                tepkiler.setText("YUHHHHH!!!");
                tepkiler.setTextSize(18);
                yanRenk1.setBackgroundColor(Color.BLUE);
                yanRenk2.setBackgroundColor(Color.BLUE);
                yanRenk3.setBackgroundColor(Color.BLUE);
                yanRenk4.setBackgroundColor(Color.BLUE);
                break;
            case 50:
                ply=MediaPlayer.create(MainActivity.this,R.raw.buton5);
                ply.start();
                hiz=550;
                seviye.setText("Seviye 6");
                tepkiler.setText("SEN NESİN BÖYLE!!!");
                tepkiler.setTextSize(16);
                yanRenk1.setBackgroundColor(Color.BLACK);
                yanRenk2.setBackgroundColor(Color.BLACK);
                yanRenk3.setBackgroundColor(Color.BLACK);
                yanRenk4.setBackgroundColor(Color.BLACK);
               // grid.setBackgroundColor(Color.BLACK);

                break;
            case 60:
                ply=MediaPlayer.create(MainActivity.this,R.raw.buton6);
                ply.start();
                hiz=500;
                seviye.setText("Seviye 7");
                tepkiler.setText("BU OYUNU SEN Mİ YAPTIN?!?!?");
                tepkiler.setTextSize(16);
                yanRenk1.setBackgroundColor(Color.MAGENTA);
                yanRenk2.setBackgroundColor(Color.MAGENTA);
                yanRenk3.setBackgroundColor(Color.MAGENTA);
                yanRenk4.setBackgroundColor(Color.MAGENTA);
                break;
            case 70:
                ply=MediaPlayer.create(MainActivity.this,R.raw.buton7);
                ply.start();
                hiz=450;
                seviye.setText("Seviye 8");
                tepkiler.setText("HİLE MİSİN?!?!?");
                tepkiler.setTextSize(16);
                yanRenk1.setBackgroundColor(Color.YELLOW);
                yanRenk2.setBackgroundColor(Color.YELLOW);
                yanRenk3.setBackgroundColor(Color.YELLOW);
                yanRenk4.setBackgroundColor(Color.YELLOW);
                break;
            case 80:
                ply=MediaPlayer.create(MainActivity.this,R.raw.buton8);
                ply.start();
                hiz=400;
                seviye.setText("Seviye 9");
                tepkiler.setText("BEN ŞOOOOOK?!?!?");
                tepkiler.setTextSize(16);
                yanRenk1.setBackgroundColor(Color.GRAY);
                yanRenk2.setBackgroundColor(Color.GRAY);
                yanRenk3.setBackgroundColor(Color.GRAY);
                yanRenk4.setBackgroundColor(Color.GRAY);
                break;
            case 90:
                ply=MediaPlayer.create(MainActivity.this,R.raw.buton9);
                ply.start();
                hiz=350;
                seviye.setText("Seviye 10");
                tepkiler.setText("MÜKEMMEL ÖTESİ!!!");
                tepkiler.setTextSize(16);
                yanRenk1.setBackgroundColor(Color.CYAN);
                yanRenk2.setBackgroundColor(Color.CYAN);
                yanRenk3.setBackgroundColor(Color.CYAN);
                yanRenk4.setBackgroundColor(Color.CYAN);
                break;
                case 100:
                ply=MediaPlayer.create(MainActivity.this,R.raw.butonx);
                ply.start();
                hiz=300;
                seviye.setText("Seviye x");
                tepkiler.setText("DEHŞET-Ü VAHŞET!!!");
                tepkiler.setTextSize(16);
                yanRenk1.setBackgroundColor(Color.LTGRAY);
                yanRenk2.setBackgroundColor(Color.LTGRAY);
                yanRenk3.setBackgroundColor(Color.LTGRAY);
                yanRenk4.setBackgroundColor(Color.LTGRAY);
                break;

        }


    }

    public void hideImages(){
        handler= new Handler();
        runnable= new Runnable() {
            @Override
            public void run() {
                for(ImageView image: imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random= new Random();
                int i= random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this, hiz);
            }
        };
        handler.post(runnable);

    }

    public void clearr(View view){
        sharedPreferences.edit().remove("storedAge").apply();
        storedAge=0;
        maxx.setText("Rekor: "+0);
    }

    public void basla(View view){
        start.setVisibility(View.INVISIBLE);
        clear.setVisibility(View.VISIBLE);
        bastanbasla.setVisibility(View.VISIBLE);

        new CountDownTimer(zm, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time.setText("SÜRE: "+millisUntilFinished/1000);

            }

            @Override
            public void onFinish() {
                time.setText("SÜRE BİTTİ :)");
                handler.removeCallbacks(runnable);
                for(ImageView image: imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert= new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("TEKRAK OYNAYAK?");
                alert.setMessage("1 EL DAHA VAR MISIN?");
                alert.setPositiveButton("TABİ LANN", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "DEWAMMM :)", Toast.LENGTH_SHORT).show();
                        //restart

                        if(score>storedAge || storedAge==0)
                        {
                            sharedPreferences.edit().putInt("storedAge",score).apply();
                            storedAge = sharedPreferences.getInt("storedAge",0);
                            maxx.setText("Rekor: "+storedAge);
                        }
                        storedAge = sharedPreferences.getInt("storedAge",0);
                        maxx.setText("Rekor: "+storedAge);

                        Intent intent= getIntent();
                        finish();
                        startActivity(intent);

                        ply.reset();

                    }
                });
                alert.setNegativeButton("ÇOK KÖTÜYÜM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "GİT :(", Toast.LENGTH_SHORT).show();

                        if(score>storedAge|| storedAge==0)
                        {
                            sharedPreferences.edit().putInt("storedAge",score).apply();
                            storedAge = sharedPreferences.getInt("storedAge",0);
                            maxx.setText("Rekor: "+storedAge);
                        }
                        storedAge = sharedPreferences.getInt("storedAge",0);
                        maxx.setText("Rekor: "+storedAge);
                    }
                });

                alert.show();
            }
        }.start();
    }



    public void tekrarbasla(View view){

        Intent mStartActivity = new Intent(MainActivity.this, MainActivity.class);
        int mPendingIntentId = 123456;
        PendingIntent mPendingIntent = PendingIntent.getActivity(MainActivity.this, mPendingIntentId, mStartActivity, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager mgr = (AlarmManager)MainActivity.this.getSystemService(Context.ALARM_SERVICE);
        mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
        System.exit(0);
    }


}