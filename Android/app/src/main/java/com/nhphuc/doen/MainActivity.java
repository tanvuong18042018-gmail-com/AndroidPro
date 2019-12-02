package com.nhphuc.doen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    Button btnRegister, btnLogin;
    TextView txtForgotPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        AnhXa();

        ShowActivity();
    }

    private void AnhXa()
    {
        txtForgotPass = (TextView) findViewById(R.id.textViewForgotPass);
        btnRegister = (Button) findViewById(R.id.buttonRegister);
        btnLogin = (Button) findViewById(R.id.buttonLogin);
    }

    public void ShowActivity()
    {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupRegister();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityMenu();
            }
        });
        txtForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupForgotPass();
            }
        });
    }

    public void PopupRegister()
    {
        final Dialog dialogPopupRegister = new Dialog(this);
        Button btnCloseRegister;
        dialogPopupRegister.setContentView(R.layout.popup_register);

        btnCloseRegister = (Button) dialogPopupRegister.findViewById(R.id.buttonBackRegister);
        dialogPopupRegister.show();
        btnCloseRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogPopupRegister.dismiss();
            }
        });
    }

    public void PopupForgotPass(){
        Dialog dialogPopupForgotPass = new Dialog(this);
        dialogPopupForgotPass.setContentView((R.layout.popup_forgot_password));

        dialogPopupForgotPass.show();
    }

    public void ActivityMenu()
    {
        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
        startActivity(intent);
    }
}
