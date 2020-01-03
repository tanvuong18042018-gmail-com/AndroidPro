package com.nhphuc.doen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ListView;
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

import java.util.ArrayList;

public class activity_rank extends AppCompatActivity {

    String urlGetData = "https://laravelandandroid.000webhostapp.com/api/rank";

    ListView listView;
    ArrayList<Rank> rankArrayList;
    RankAdapter rankAdapter;

    CountDownTimer countDownTimer, countDownTimer2;
    MediaPlayer mediaPlayer, mediaPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        AnhXa();

        mediaPlayer = MediaPlayer.create(activity_rank.this, R.raw.backgroundmediasoundlogin);
        mediaPlayer.start();

        mediaPlayer2 = MediaPlayer.create(activity_rank.this, R.raw.backgroundmediasoundmain);

        countDownTimer = new CountDownTimer(980000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                mediaPlayer.stop();
                mediaPlayer2 = MediaPlayer.create(activity_rank.this, R.raw.backgroundmediasoundmain);
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
                mediaPlayer = MediaPlayer.create(activity_rank.this, R.raw.backgroundmediasoundlogin);
                mediaPlayer.start();
                countDownTimer.start();
            }
        };
        countDownTimer.start();

        GetData(urlGetData);
    }

    private void AnhXa() {
        listView = (ListView) findViewById(R.id.listViewRank);
        rankArrayList = new ArrayList<>();

        rankAdapter = new RankAdapter(this, R.layout.row_rank, rankArrayList);
        listView.setAdapter(rankAdapter);
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
                                rankArrayList.add(new Rank(
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
                        rankAdapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(activity_rank.this, "Error!", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }
}
