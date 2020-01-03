package com.nhphuc.doen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    Button btnRegister, btnLogin;
    TextView txtForgotPass;
    EditText edtNameLogin, edtPassLogin;

    String urlGetData;
    ArrayList<Login> memberArrayList;

    Login login;

    LoginAdapter loginAdapter;

    CountDownTimer countDownTimer, countDownTimer2;
    MediaPlayer mediaPlayer, mediaPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        AnhXa();

        ShowActivity();

        urlGetData = "https://laravelandandroid.000webhostapp.com/api/member?name_login=admin";

        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.backgroundmediasoundlogin);
        mediaPlayer.start();

        mediaPlayer2 = MediaPlayer.create(MainActivity.this, R.raw.backgroundmediasoundmain);

        countDownTimer = new CountDownTimer(980000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                mediaPlayer.stop();
                mediaPlayer2 = MediaPlayer.create(MainActivity.this, R.raw.backgroundmediasoundmain);
                mediaPlayer2.start();
                countDownTimer2.start();
            }
        };
        countDownTimer2 = new CountDownTimer(134000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                mediaPlayer2.stop();
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.backgroundmediasoundlogin);
                mediaPlayer.start();
                countDownTimer.start();
            }
        };
        countDownTimer.start();
        GetData(urlGetData);

    }

    private void AnhXa()
    {
        txtForgotPass = (TextView) findViewById(R.id.textViewForgotPass);

        btnRegister = (Button) findViewById(R.id.buttonRegister);
        btnLogin = (Button) findViewById(R.id.buttonLogin);

        memberArrayList = new ArrayList<>();

        edtNameLogin    = (EditText) findViewById(R.id.editTextNameLogin);
        edtPassLogin    = (EditText) findViewById(R.id.editTextPassLogin);

    }

    private void GetData(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++){
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                memberArrayList.add(new Login(
                                        jsonObject.getInt("id"),
                                        jsonObject.getString("name_login"),
                                        jsonObject.getString("email"),
                                        jsonObject.getString("password"),
                                        jsonObject.getString("avatar"),
                                        jsonObject.getInt("max_score"),
                                        jsonObject.getInt("credit"),
                                        jsonObject.getInt("diamon")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Đăng nhập không thành công!", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }

    public void ShowActivity()
    {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupRegister();
            }
        });
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ActivityMenu();
//            }
//        });
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

//    public void ActivityMenu()
//    {
//        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
//        startActivity(intent);
//    }

    public void login(View view) {
        if(edtNameLogin.getText().toString().equals("")){
            Toast.makeText(this, "Tài khoản không được bỏ trống!", Toast.LENGTH_SHORT).show();
        } else if (edtPassLogin.getText().toString().equals("")){
            Toast.makeText(this, "Mật khẩu không được bỏ trống!", Toast.LENGTH_SHORT).show();
        } else {
            if(edtNameLogin.getText().toString().equals(memberArrayList.get(0).getName_login())){
                String username, emailuser, maxScore, diamon;
                username = memberArrayList.get(0).getName_login();
                emailuser = memberArrayList.get(0).getEmail();
                maxScore = String.valueOf(memberArrayList.get(0).getMax_score());
                diamon = String.valueOf(memberArrayList.get(0).getDiamon());
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("emailuser", emailuser);
                intent.putExtra("maxScore", maxScore);
                intent.putExtra("diamon", diamon);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Sai tài khoản hoặc mật khẩu!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
