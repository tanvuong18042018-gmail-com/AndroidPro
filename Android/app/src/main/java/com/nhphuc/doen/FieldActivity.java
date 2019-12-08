package com.nhphuc.doen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class FieldActivity extends AppCompatActivity {

    Button btnField;

    String urlGetData = "https://laravelandandroid.000webhostapp.com/api/apiField";

    ListView listView;
    ArrayList<Field> fieldArrayList;
    FieldAdapter fieldAdapter;
    //Field field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field);

        Anhxa();

        //ShowActivity();

        GetData(urlGetData);

    }

    private void Anhxa() {
        btnField = (Button) findViewById(R.id.buttonFieldOne);

        listView = (ListView) findViewById(R.id.listViewButtonField);
        fieldArrayList = new ArrayList<>();

        fieldAdapter = new FieldAdapter(this, R.layout.button_field_group, fieldArrayList);
        listView.setAdapter(fieldAdapter);
    }

//    private void ShowActivity(){
//        btnField.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ActivityFieldHistory();
//            }
//        });
//    }
//
//    private void ActivityFieldHistory(){
////        Intent intent = new Intent(FieldActivity.this, QuestionActivity.class);
////        startActivity(intent);
//        Toast.makeText(FieldActivity.this, btnField.getText(), Toast.LENGTH_SHORT).show();
//    }

    private void GetData(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++){
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                fieldArrayList.add(new Field(
                                   jsonObject.getInt("field_id"),
                                   jsonObject.getString("field_name")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        fieldAdapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(FieldActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }

    public void c(View view) {
        Intent intent = new Intent(FieldActivity.this, QuestionActivity.class);
        startActivity(intent);
    }
}
