package com.nhphuc.doen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button btnNewGame, btnUpdateProfile, btnHistory, btnRank, btnQuit;
    Layout layoutMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        AnhXa();

        showActivity();
    }

    private void AnhXa() {
        btnNewGame = (Button) findViewById(R.id.buttonNewGame);
        btnUpdateProfile = (Button) findViewById(R.id.buttonUpdatePersonal);
        btnHistory = (Button) findViewById(R.id.buttonHistory);
        btnRank = (Button) findViewById(R.id.buttonRank);
        btnQuit = (Button) findViewById(R.id.buttonQuit);
    }

    private void showActivity() {
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityChoosenField();
            }
        });

        btnUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUpdateProfile();
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityHistory();
            }
        });

        btnRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityRank();
            }
        });

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogoutActivity();
            }
        });
    }

    public void ActivityChoosenField()
    {
        Intent intent = new Intent(MenuActivity.this, FieldActivity.class);
        startActivity(intent);
    }

    public void ActivityUpdateProfile()
    {
        Intent intent = new Intent(MenuActivity.this, profile_activity.class);
        startActivity(intent);
    }

    public void ActivityHistory(){
        Intent intent = new Intent(MenuActivity.this, activity_history.class);
        startActivity(intent);
    }

    public void LogoutActivity(){
        Intent intent = new Intent(MenuActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void ActivityRank(){
        Intent intent = new Intent(MenuActivity.this, activity_rank.class);
        startActivity(intent);
    }
}
