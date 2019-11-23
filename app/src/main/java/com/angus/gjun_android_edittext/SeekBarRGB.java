package com.angus.gjun_android_edittext;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SeekBarRGB extends AppCompatActivity {
    ConstraintLayout layout;
    EditText et5, et6, et7;
    android.widget.SeekBar sb3;
    android.widget.SeekBar sb4;
    SeekBar sb5;
    TextView tv11;
    RatingBar rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar_rgb);
        layout = (ConstraintLayout) findViewById(R.id.ConstraintLayout2);
        et5 = (EditText) findViewById(R.id.editText5);
        et6 = (EditText) findViewById(R.id.editText6);
        et7 = (EditText) findViewById(R.id.editText7);
        sb3 = (android.widget.SeekBar)findViewById(R.id.seekBar3);
        sb4 = (android.widget.SeekBar)findViewById(R.id.seekBar4);
        sb5 = (android.widget.SeekBar)findViewById(R.id.seekBar5);
        tv11 = (TextView)findViewById(R.id.textView11);
        rb = (RatingBar) findViewById(R.id.ratingBar);

        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(SeekBarRGB.this, "評價" + rb.getRating() + "顆星", Toast.LENGTH_SHORT).show();
            }
        });

        View.OnKeyListener OKL = new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && keyCode == event.KEYCODE_ENTER){
                    int id= ((EditText)v).getId();
                    switch (id){
                        case R.id.editText5:
                            int red =Integer.parseInt(et5.getText().toString());
                            sb3.setProgress(red);
                            break;

                        case R.id.editText6:
                            int green =Integer.parseInt(et6.getText().toString());
                            sb4.setProgress(green);
                            break;

                        case R.id.editText7:
                            int blue =Integer.parseInt(et7.getText().toString());
                            sb5.setProgress(blue);
                            break;
                    }

                }


                return false;
            }
        };
        et5.setOnKeyListener(OKL);
        et6.setOnKeyListener(OKL);
        et7.setOnKeyListener(OKL);
        SeekBar.OnSeekBarChangeListener OSBCL = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int red = sb3.getProgress();
                int green = sb4.getProgress();
                int blue = sb5.getProgress();
                et5.setText(Integer.toString(red));
                et6.setText(Integer.toString(green));
                et7.setText(Integer.toString(blue));
                tv11.setText("2. 調整滑桿，紅色: " + red +"綠色:" + green + "藍色: " + blue +"\n"
                + String.format("色碼代碼: %x%x%x",red, green, blue));
                layout.setBackgroundColor(Color.rgb(red, green, blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };
        sb3.setOnSeekBarChangeListener(OSBCL);
        sb4.setOnSeekBarChangeListener(OSBCL);
        sb5.setOnSeekBarChangeListener(OSBCL);
    }
}
