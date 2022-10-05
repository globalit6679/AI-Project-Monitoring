package com.example.monitoring;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MembershipActivity  extends AppCompatActivity {
    CheckBox idCheck, passwordCheck, codeCheck;
    ImageButton finishButton;
    TextView idCheckWrong, passwordCheckWrong, codeCheckWrong;
    EditText idEdit, passwordEdit, passwordEdit2, codeEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.membership);

        finishButton = (ImageButton) findViewById(R.id.finishButton);
        idCheck = (CheckBox) findViewById(R.id.checkBox);
        passwordCheck = (CheckBox) findViewById(R.id.checkBox2);
        codeCheck = (CheckBox) findViewById(R.id.checkBox3);
        idCheckWrong = (TextView) findViewById(R.id.idCheckWrong);
        passwordCheckWrong = (TextView) findViewById(R.id.passwordCheckWrong);
        codeCheckWrong = (TextView) findViewById(R.id.codeCheckWrong);
        idEdit = (EditText) findViewById(R.id.idEdit);
        passwordEdit = (EditText) findViewById(R.id.passwordEdit);
        passwordEdit2 = (EditText) findViewById(R.id.passwordEdit2);
        codeEdit = (EditText) findViewById(R.id.codeEdit);


        idCheckWrong.setVisibility(View.INVISIBLE);
        passwordCheckWrong.setVisibility(View.INVISIBLE);
        codeCheckWrong.setVisibility(View.INVISIBLE);

//        if(passwordCheck.isChecked()){
//            if(passwordEdit.getText().toString().equals(passwordEdit2.getText().toString())){
//                Toast.makeText(getApplicationContext(), "비밀번호가 일치합니다", Toast.LENGTH_SHORT).show();
//            } else {
//                passwordCheck.setChecked(false);
//                passwordCheckWrong.setVisibility(View.VISIBLE);
//            }
//        }
        passwordCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(passwordCheck.isChecked()){
                    if(passwordEdit.getText().toString().equals(passwordEdit2.getText().toString())){
                        Toast.makeText(getApplicationContext(), "비밀번호가 일치합니다", Toast.LENGTH_SHORT).show();
                        passwordCheckWrong.setVisibility(View.INVISIBLE);
                    } else {
                        passwordCheck.setChecked(false);
                        passwordCheckWrong.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

//        if(idCheck.isChecked() && passwordCheck.isChecked() && codeCheck.isChecked()) {
//            finishButton.setVisibility(View.VISIBLE);
//        } else{
//            finishButton.setVisibility(View.INVISIBLE);
//        }

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(idCheck.isChecked() && passwordCheck.isChecked() && codeCheck.isChecked()){
                    Toast.makeText(getApplicationContext(), "회원가입되었습니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(getApplicationContext(), "모든 요소를 체크해주세요", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

    }
}

