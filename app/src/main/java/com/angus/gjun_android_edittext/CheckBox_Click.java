package com.angus.gjun_android_edittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class CheckBox_Click extends AppCompatActivity {
    CheckBox cb1, cb2, cb3;
    EditText et6, et7, et8;
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
