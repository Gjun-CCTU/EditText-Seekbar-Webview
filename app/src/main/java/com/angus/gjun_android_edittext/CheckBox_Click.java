package com.angus.gjun_android_edittext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class CheckBox_Click extends AppCompatActivity {
    CheckBox cb1, cb2, cb3;
    EditText et6, et7, et8;
    RadioButton rb1, rb2, rb3;
    Button btn4, btn6;
    TextView tv6;
    android.widget.SeekBar sb1, sb2, sb3;
    int q1, q2 ,q3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box__click);
        cb1 = (CheckBox)findViewById(R.id.checkBox1);
        cb2 = (CheckBox)findViewById(R.id.checkBox2);
        cb3 = (CheckBox)findViewById(R.id.checkBox3);
        et6 = findViewById(R.id.editText6);
        et7 = findViewById(R.id.editText7);
        et8 = findViewById(R.id.editText8);
        rb1 = (RadioButton) findViewById(R.id.radioButton1);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        btn4 = (Button) findViewById(R.id.button4);
        tv6 = (TextView)findViewById(R.id.textView6);
        btn6 = (Button)findViewById(R.id.button6);
        sb1 = (android.widget.SeekBar) findViewById(R.id.seekBar1);
        sb2 = (android.widget.SeekBar) findViewById(R.id.seekBar2);
        sb3 = (android.widget.SeekBar) findViewById(R.id.seekBar3);


        android.widget.SeekBar.OnSeekBarChangeListener OSBCL = new android.widget.SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(android.widget.SeekBar seekBar, int progress, boolean fromUser) {

        }

            @Override
            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
                Toast.makeText(CheckBox_Click.this, "數量" + seekBar.getProgress() + "杯", Toast.LENGTH_SHORT).show();
                q1 = sb1.getProgress();
                q2 = sb2.getProgress();
                q3 = sb3.getProgress();
                tv6.setText(cb1.getText() +":"  +q1 + "杯\n" +
                        cb2.getText() +":" + q2 + "杯\n" +
                        cb3.getText() +":" +q3 + "杯\n");
            }
        };
        sb1.setOnSeekBarChangeListener(OSBCL);
        sb2.setOnSeekBarChangeListener(OSBCL);
        sb3.setOnSeekBarChangeListener(OSBCL);

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckBox_Click.this, SeekBar.class);
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum = 0;
                double disSum = 0;
                String msg = "";
                if (cb1.isChecked()){
                    sum = sum + Integer.parseInt(et6.getText().toString()) * q1;
                    msg = msg + cb1.getText() + et6.getText() + "\n";
                }
                if (cb2.isChecked()){
                    sum = sum + Integer.parseInt(et7.getText().toString()) * q2;
                    msg = msg + cb2.getText() + et7.getText() + "\n";
                }
                if (cb3.isChecked()){
                    sum = sum + Integer.parseInt(et8.getText().toString()) * q3;
                    msg = msg + cb3.getText() + et8.getText() + "\n";
                }

                if(rb1.isChecked()){
                    msg = msg + "折扣: " +rb1.getText() + "\n";
                    disSum = sum * 0.7;
                }else if (rb2.isChecked()){
                    msg = msg + "折扣: " +rb2.getText() + "\n";
                    disSum = sum * 0.8;
                }else if (rb3.isChecked()){
                    msg = msg + "折扣: " +rb3.getText() + "\n";
                    disSum = sum * 0.9;
                }
                tv6.setText(msg + "原始金額" + sum + "\n" + "折扣後金額 :" + disSum);
            }
        });


        View.OnClickListener rbOCL = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb = (RadioButton)v;
                if(rb.isChecked()){
                    Toast.makeText(CheckBox_Click.this, "折扣" + rb.getText() , Toast.LENGTH_SHORT).show();
                }
            }
        };
        rb1.setOnClickListener(rbOCL);
        rb2.setOnClickListener(rbOCL);
        rb3.setOnClickListener(rbOCL);

        CompoundButton.OnCheckedChangeListener CBOCCL = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int id = ((CheckBox)buttonView).getId();
                switch (id){
                    case R.id.checkBox1:
                        if(isChecked)
                            et6.setText("45");
                        else
                            et6.setText("0");
                        break;

                    case R.id.checkBox2:
                        if(isChecked)
                            et7.setText("35");
                        else
                            et7.setText("0");
                        break;

                    case R.id.checkBox3:
                        if(isChecked)
                            et8.setText(R.string.s1);
                        else
                            et8.setText(R.string.s2);
                        break;
                }
            }
        };
        cb1.setOnCheckedChangeListener(CBOCCL);
        cb2.setOnCheckedChangeListener(CBOCCL);
        cb3.setOnCheckedChangeListener(CBOCCL);


        View.OnClickListener CBOCL = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                CheckBox cb = (CheckBox)v;
////                if(cb.isChecked())
////                    Toast.makeText(CheckBox_Click.this, "選擇" + cb.getText().toString(), Toast.LENGTH_SHORT).show();
////                else
////                    Toast.makeText(CheckBox_Click.this, "取消" + cb.getText().toString(), Toast.LENGTH_SHORT).show();
////
                int id = ((CheckBox)v).getId();
                switch (id){
                    case R.id.checkBox1:
                        if(cb1.isChecked())
                            Toast.makeText(CheckBox_Click.this, "選擇" + cb1.getText().toString(), Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(CheckBox_Click.this, "取消" + cb1.getText().toString(), Toast.LENGTH_SHORT).show();

                        break;

                    case R.id.checkBox2:
                        if(cb2.isChecked())
                            Toast.makeText(CheckBox_Click.this, "選擇" + cb2.getText().toString(), Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(CheckBox_Click.this, "取消" + cb2.getText().toString(), Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.checkBox3:
                        if(cb3.isChecked())
                            Toast.makeText(CheckBox_Click.this, "選擇" + cb3.getText().toString(), Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(CheckBox_Click.this, "取消" + cb3.getText().toString(), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
        cb1.setOnClickListener(CBOCL);
        cb2.setOnClickListener(CBOCL);
        cb3.setOnClickListener(CBOCL);
    }
}
