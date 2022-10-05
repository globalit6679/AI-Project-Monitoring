package com.example.monitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    ImageButton memButton, loginButton;
    EditText idEditText, pwdEditText;
    String idText, pwdText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        memButton = (ImageButton) findViewById(R.id.membership);
        loginButton = (ImageButton) findViewById(R.id.loginButton);
        idEditText = (EditText) findViewById(R.id.idEditText);
        pwdEditText = (EditText) findViewById(R.id.pwdEditText);


        memButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MembershipActivity.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                pwdText = pwdEditText.getText().toString();
                idText = idEditText.getText().toString();
                if(idText.length()!=0 && pwdText.length()!=0){
                    Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent2);
                } else {
                    Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}