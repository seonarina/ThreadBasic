package kr.co.threadbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

   // private ProgressBar mProgress;
   // private int mProgressStatus = 0;
    Thread w;
    boolean running = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
    }

    @Override
    protected void onStart() {
        super.onStart();
        w = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                for (i = 0; i < 20 && running; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.v("THREAD", "time=" + i);
                }
            }
        });
        running = true;
        w.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        running = false;
    }
}