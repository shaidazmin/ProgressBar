package com.example.nz.progressbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {


    ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // delete title bar from screen

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getWindowManager();

        setContentView(R.layout.activity_main);
        this.setTitle("Learn ProgressBar");

        progressBar = (ProgressBar) findViewById(R.id.progressBar);



        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {


                doWark();

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);

            }
        });
        thread.start();
    }



  public  void  doWark(){

      for(int state =20; state<=100; state+=20)

      try {
             Thread.sleep(1000);
            progressBar.setProgress(state);


      }catch (Exception e){
          e.printStackTrace();
      }
  }



}
