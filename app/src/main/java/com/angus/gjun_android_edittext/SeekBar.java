package com.angus.gjun_android_edittext;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SeekBar extends AppCompatActivity {
    android.widget.SeekBar sb1;
    TextView tv;
    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);
        tv = (TextView) findViewById(R.id.textView7);
        sb1 = (android.widget.SeekBar) findViewById(R.id.seekBar1);
        layout = (ConstraintLayout) findViewById(R.id.ConstranintLayout1);

        sb1.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(android.widget.SeekBar seekBar, int progress, boolean fromUser) {
                tv.setText("2.調整滑桿，數值 = " + seekBar.getProgress());
                layout.setBackgroundColor(Color.rgb(progress, progress, progress));
            }

            @Override
            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
                Toast.makeText(SeekBar.this, "1.按下滑桿，數值 = " +seekBar.getProgress(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
                Toast.makeText(SeekBar.this, "3.放開滑桿，數值" +seekBar.getProgress(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
