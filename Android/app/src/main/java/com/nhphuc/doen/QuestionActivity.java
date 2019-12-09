package com.nhphuc.doen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
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

import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity {

    Button btnBuyCredit, btnAudience;

    String urlGetData = "https://laravelandandroid.000webhostapp.com/api/question?field=L%E1%BB%8Bch%20s%E1%BB%AD";

    ListView listView;
    ArrayList<Question> questionArrayList;
    QuestionAdapter questionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        AnhXa();

        ShowActivity();

        GetData(urlGetData);
    }

    public void AnhXa(){
        btnBuyCredit = (Button) findViewById(R.id.buttonBuyCredit);
        btnAudience = (Button) findViewById(R.id.buttonAudience);

        listView = (ListView) findViewById(R.id.listViewQuestion);
        questionArrayList = new ArrayList<>();

        questionAdapter = new QuestionAdapter(this, R.layout.row_quesiton, questionArrayList);
        listView.setAdapter(questionAdapter);
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
                                questionArrayList.add(new Question(
                                        jsonObject.getInt("id"),
                                        jsonObject.getString("cont_question"),
                                        jsonObject.getString("result_a"),
                                        jsonObject.getString("result_b"),
                                        jsonObject.getString("result_c"),
                                        jsonObject.getString("result_d"),
                                        jsonObject.getString("result"),
                                        jsonObject.getString("field")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        questionAdapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(QuestionActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }

    public void ShowActivity(){
        btnBuyCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityBuyCredit();
            }
        });

        btnAudience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupAudience();
            }
        });
    }

    public void ActivityBuyCredit(){
        Intent intent = new Intent(QuestionActivity.this, activity_credit.class);
        startActivity(intent);
    }

    public void PopupAudience(){
        final Dialog dialogPopupConsultAudience = new Dialog(QuestionActivity.this);
        dialogPopupConsultAudience.setContentView(R.layout.activity_popup_consult_audience);
        dialogPopupConsultAudience.show();
    }
}
