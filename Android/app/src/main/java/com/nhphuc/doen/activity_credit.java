package com.nhphuc.doen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
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

public class activity_credit extends AppCompatActivity {

    String urlGetData = "https://laravelandandroid.000webhostapp.com/api/credit";

    GridView gridView;
    ArrayList<Credit> creditArrayList;
    CreditAdapter creditAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        AnhXa();

        Show();

        GetData(urlGetData);
    }

    private void Show() {
    }

    private void AnhXa() {

        gridView = (GridView) findViewById(R.id.gridViewCredit);
        creditArrayList = new ArrayList<>();

        creditAdapter = new CreditAdapter(this, R.layout.layout_credit, creditArrayList);
        gridView.setAdapter(creditAdapter);
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
                                creditArrayList.add(new Credit(
                                        jsonObject.getInt("credit_id"),
                                        jsonObject.getString("name_credit"),
                                        jsonObject.getInt("price_credit")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        creditAdapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(activity_credit.this, "Error!", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }

    public void BuyedCredit1(){
        Toast.makeText(this, "Da mua thanh cong con cat", Toast.LENGTH_SHORT).show();
    }
}
