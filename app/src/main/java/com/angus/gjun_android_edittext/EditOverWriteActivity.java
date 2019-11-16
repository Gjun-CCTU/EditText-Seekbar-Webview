package com.angus.gjun_android_edittext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditOverWriteActivity extends AppCompatActivity {
    Button btn1, btn2;
    EditText et1, et2, et3;
    TextView tv1,tv2, tv3, tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_over_write);
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
        tv1 = (TextView) findViewById(R.id.textView4);
        tv2 = (TextView) findViewById(R.id.textView3);
        tv3 = (TextView) findViewById(R.id.textView4);
        tv4 = (TextView) findViewById(R.id.textView5);

        View.OnKeyListener OKL = new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                int id = ((EditText)v).getId();
                switch (id){
                    case R.id.editText :
                        if(event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER)
                            Toast.makeText(EditOverWriteActivity.this,tv2.getText() + et1.getText().toString(),Toast.LENGTH_LONG).show();
                        break;

                    case R.id.editText2 :
                        if(event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER)
                            Toast.makeText(EditOverWriteActivity.this,tv3.getText() + et2.getText().toString(),Toast.LENGTH_LONG).show();
                        break;

                    case R.id.editText3 :
                        if(event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER)
                            Toast.makeText(EditOverWriteActivity.this, tv4.getText() + et3.getText().toString(),Toast.LENGTH_LONG).show();
                        break;
                }
                return false;
            }
        };
        et1.setOnKeyListener(OKL);
        et2.setOnKeyListener(OKL);
        et3.setOnKeyListener(OKL);


        View.OnClickListener OCL = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                switch (id){
                    case R.id.button :
                        int n1 = Integer.parseInt(et1.getText().toString());
                        int n2 = Integer.parseInt(et2.getText().toString());
                        int n3 = Integer.parseInt(et3.getText().toString());
                        double sum = n1+n2+n3;
                        double avg = sum/3;
                        tv1.append("國文 : " + n1 + "英文 : " + n2 + "數學 : " + n3 + "\n");
                        tv1.append(String.format("總分 : %.1f\n平均 : %.2f\n",sum,avg));
                        tv1.append((avg > 60) ? "恭喜及格" : "抱歉不及格");

                        switch ((int)avg/10){
                            case 10:
                            case 9:
                                tv1.append("A級學生");
                                break;
                            case 8:
                                tv1.append("B級學生");
                                break;
                            case 7:
                                tv1.append("C級學生");
                                break;
                            case 6:
                                tv1.append("D級學生");
                                break;
                            default:
                                tv1.append("E級學生");

                        }


                    break;

                    case R.id.button2 :
                        et1.setText("");
                        et2.setText("");
                        et3.setText("");
                        tv1.setText("");
                        break;
                }
            }
        };
        btn1.setOnClickListener(OCL);
        btn2.setOnClickListener(OCL);
    }
}
