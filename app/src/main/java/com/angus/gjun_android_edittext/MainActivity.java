package com.angus.gjun_android_edittext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn5, btn10;
    EditText et1, et2;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn5 = (Button) findViewById(R.id.button5);
        btn10 = (Button) findViewById(R.id.button10);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        tv1 = (TextView) findViewById(R.id.tv1);

        View.OnClickListener OCL = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = ((Button)v).getId();
                switch (id){
                    case R.id.btn1:
                        double h  = Double.parseDouble(et1.getText().toString());
                        double w  = Double.parseDouble(et2.getText().toString());
                        double bmi = w/(h/100 * h/100);
                        tv1.setText("身高 : " + h + "cm \n 體重 : " + w + "kg \n bmi :" + bmi);
                        break;

                    case R.id.btn2:
                        et1.setText("");
                        et2.setText("");
                        tv1.setText("");
                        break;

                    case R.id.btn3 :
                        Intent intent = new Intent(MainActivity.this, EditOverWriteActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.button5:
                        Intent intent2 = new Intent(MainActivity.this, SeekBarRGB.class);
                        startActivity(intent2);

                    case  R.id.button10:
                        Intent intent3 = new Intent(MainActivity.this, MyWebView.class);
                        startActivity(intent3);
                }
            }
        };

        btn1.setOnClickListener(OCL);
        btn2.setOnClickListener(OCL);
        btn3.setOnClickListener(OCL);
        btn5.setOnClickListener(OCL);
        btn10.setOnClickListener(OCL);

    }
}
