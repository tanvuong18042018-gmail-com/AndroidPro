package com.nhphuc.doen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.icu.text.MeasureFormat;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity {

    Button btnBuyCredit, btnAudience, btnFivetyAndFivety, btnNguoiThan, btnThreeHelper;
    TextView txtResult, txtResultA, txtResultB, txtResultC, txtResultD, txtHeartFive, txtHeartFour, txtHeartThree, txtHeartTwo, txtHeartOne, txtScoreNumber, txtNumberQuestion, txtTimer;
    ImageView imgAudience, imgNguoiThan, imgThreeHelp;

    String urlGetData;
    BarChart chart;
    ListView listView;
    ArrayList<Question> questionArrayList;
    QuestionAdapter questionAdapter;
    Question question;

    FieldActivity fieldActivity;

    ArrayList<BarEntry> BARENTRY ;
    ArrayList<String> BarEntryLabels ;
    BarDataSet Bardataset ;
    BarData BARDATA ;
    int postionQuestion = 0;
    int Scroce = 0;
    int numberQuestion = 1;
    CountDownTimer countDownTimer;

    CountDownTimer countDownTimer1, countDownTimer2;
    MediaPlayer mediaPlayer, mediaPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent intent = getIntent();
        String ten = intent.getStringExtra("m");
        urlGetData = "https://laravelandandroid.000webhostapp.com/api/question?field=" + ten;

        AnhXa();

        ShowActivity();
        mediaPlayer = MediaPlayer.create(QuestionActivity.this, R.raw.backgroundmediasoundlogin);
        mediaPlayer.start();

        mediaPlayer2 = MediaPlayer.create(QuestionActivity.this, R.raw.backgroundmediasoundmain);

        countDownTimer1 = new CountDownTimer(980000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                mediaPlayer.stop();
                mediaPlayer2 = MediaPlayer.create(QuestionActivity.this, R.raw.backgroundmediasoundmain);
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
                mediaPlayer = MediaPlayer.create(QuestionActivity.this, R.raw.backgroundmediasoundlogin);
                mediaPlayer.start();
                countDownTimer1.start();
            }
        };
        countDownTimer1.start();

        GetData(urlGetData);

        countDownTimer = new CountDownTimer(30000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                txtTimer.setText("" + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                if (txtHeartFive.getText().toString().equals("")){
                    if (txtHeartFour.getText().toString().equals("")) {
                        if (txtHeartThree.getText().toString().equals("")){
                            if (txtHeartTwo.getText().toString().equals("")){
                                Intent intent = new Intent(QuestionActivity.this, MenuActivity.class);
                                startActivity(intent);
                            } else {
                                txtHeartTwo.setText("");
                                GetData(urlGetData);
                            }
                        } else {
                            txtHeartThree.setText("");
                            GetData(urlGetData);
                        }
                    } else{
                        txtHeartFour.setText("");
                        GetData(urlGetData);
                    }
                } else {
                    txtHeartFive.setText("");
                    GetData(urlGetData);
                }
                numberQuestion = numberQuestion + 1;
                txtNumberQuestion.setText("" + numberQuestion);
                questionArrayList.remove(postionQuestion);
                countDownTimer.start();
            }
        };
        countDownTimer.start();
    }

    public void AnhXa(){
        btnBuyCredit        = (Button) findViewById(R.id.buttonBuyCredit);
        btnAudience         = (Button) findViewById(R.id.buttonAudience);
        btnFivetyAndFivety  = (Button) findViewById(R.id.buttonFivetyandFivety);
        btnNguoiThan        = (Button) findViewById(R.id.buttonNguoiThan);
        btnThreeHelper      = (Button) findViewById(R.id.buttonThreeHelper);

        imgAudience         = (ImageView) findViewById(R.id.imageViewAudience);
        imgNguoiThan        = (ImageView) findViewById(R.id.imageViewNguoiThan);
        imgThreeHelp        = (ImageView) findViewById(R.id.imageViewThreeHelp);

        txtResultA          = (TextView) findViewById(R.id.textViewResultA);
        txtResultB          = (TextView) findViewById(R.id.textViewResultB);
        txtResultC          = (TextView) findViewById(R.id.textViewResultC);
        txtResultD          = (TextView) findViewById(R.id.textViewResultD);
        txtResult           = (TextView) findViewById(R.id.textViewResultQuetion);
        txtHeartFive        = (TextView) findViewById(R.id.textViewHeartFive);
        txtHeartFour        = (TextView) findViewById(R.id.textViewHeartFour);
        txtHeartThree       = (TextView) findViewById(R.id.textViewHeartThree);
        txtHeartTwo         = (TextView) findViewById(R.id.textViewHeartTwo);
        txtHeartOne         = (TextView) findViewById(R.id.textViewHeartOne);
        txtScoreNumber      = (TextView) findViewById(R.id.textViewScoreNumber);
        txtNumberQuestion   = (TextView) findViewById(R.id.textViewNumberQuestion);
        txtTimer            = (TextView) findViewById(R.id.textViewTimer);

        listView            = (ListView) findViewById(R.id.listViewQuestion);
        questionArrayList   = new ArrayList<>();

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
                btnAudience.setVisibility(View.INVISIBLE);
                imgAudience.setVisibility(View.INVISIBLE);
            }
        });

        imgNguoiThan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = questionArrayList.get(postionQuestion).getResult();
                Intent intent = new Intent(QuestionActivity.this, dinalogNguoiThan.class);
                intent.putExtra("result", result);
                startActivity(intent);
                btnNguoiThan.setVisibility(View.INVISIBLE);
                imgNguoiThan.setVisibility(View.INVISIBLE);
            }
        });

        imgThreeHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultThree = questionArrayList.get(0).getResult();
                Intent intent = new Intent(QuestionActivity.this, threeHelper.class);
                intent.putExtra("resultThree", resultThree);
                startActivity(intent);
                imgThreeHelp.setVisibility(View.INVISIBLE);
                btnThreeHelper.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void ActivityBuyCredit(){
        Intent intent = new Intent(QuestionActivity.this, activity_credit.class);
        startActivity(intent);
    }

    public void PopupAudience(){
        final Dialog dialogPopupConsultAudience = new Dialog(this);
        dialogPopupConsultAudience.setContentView(R.layout.dialog_khan_gia_tro_giup);

        veBieuDo(dialogPopupConsultAudience);

        dialogPopupConsultAudience.show();
    }

    public void veBieuDo(Dialog dialog) {
        chart = (BarChart) dialog.findViewById(R.id.chart);

        BARENTRY = new ArrayList<>();

        BarEntryLabels = new ArrayList<String>();

        AddValuesToBARENTRY();

        AddValuesToBarEntryLabels();

        Bardataset = new BarDataSet(BARENTRY, null);

        BARDATA = new BarData(BarEntryLabels, Bardataset);

        Bardataset.setValueTextSize(20);

        Bardataset.setColors(ColorTemplate.JOYFUL_COLORS);

        Bardataset.setValueTextColor(Color.WHITE);

        chart.setData(BARDATA);

        chart.animateY(5000);

        chart.setDescription(null);

        chart.getLegend().setEnabled(false);

        chart.setDescriptionTextSize(25);

        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);

        chart.getXAxis().setTextColor(Color.WHITE);

        chart.getAxisRight().setEnabled(false);
        chart.getAxisLeft().setEnabled(false);

        chart.getAxisLeft().setTextSize(15);

        chart.getXAxis().setTextSize(10);

        chart.getAxisLeft().setDrawGridLines(false);
        chart.getAxisRight().setDrawGridLines(false);
        chart.getXAxis().setDrawGridLines(false);

        chart.setTouchEnabled(false);

        chart.setDoubleTapToZoomEnabled(false);
    }

    public void AddValuesToBARENTRY(){
        if (questionArrayList.get(postionQuestion).getResult_a().equals(questionArrayList.get(postionQuestion).getResult())){
            BARENTRY.add(new BarEntry(30, 0));
            BARENTRY.add(new BarEntry(27, 1));
            BARENTRY.add(new BarEntry(21, 2));
            BARENTRY.add(new BarEntry(22, 3));
        } else {
            if (questionArrayList.get(postionQuestion).getResult_b().equals(questionArrayList.get(postionQuestion).getResult())){
                BARENTRY.add(new BarEntry(22, 0));
                BARENTRY.add(new BarEntry(30, 1));
                BARENTRY.add(new BarEntry(27, 2));
                BARENTRY.add(new BarEntry(21, 3));
            } else {
                if (questionArrayList.get(postionQuestion).getResult_c().equals(questionArrayList.get(postionQuestion).getResult())){
                    BARENTRY.add(new BarEntry(21, 0));
                    BARENTRY.add(new BarEntry(22, 1));
                    BARENTRY.add(new BarEntry(30, 2));
                    BARENTRY.add(new BarEntry(27, 3));
                } else {
                    BARENTRY.add(new BarEntry(27, 0));
                    BARENTRY.add(new BarEntry(21, 1));
                    BARENTRY.add(new BarEntry(22, 2));
                    BARENTRY.add(new BarEntry(30, 3));
                }
            }
        }
    }

    public void AddValuesToBarEntryLabels(){

        BarEntryLabels.add("A");
        BarEntryLabels.add("B");
        BarEntryLabels.add("C");
        BarEntryLabels.add("D");

    }

    public void FiveAndFive(){
        if (questionArrayList.get(postionQuestion).getResult_a().equals(questionArrayList.get(postionQuestion).getResult())){
            questionArrayList.add(new Question(questionArrayList.get(postionQuestion).getId(), "" + questionArrayList.get(postionQuestion).getCont_question(), "" + questionArrayList.get(postionQuestion).getResult_a(), "", "" + questionArrayList.get(postionQuestion).getResult_c(), "", "" + questionArrayList.get(postionQuestion).getResult(), "" + questionArrayList.get(postionQuestion).getField()));
            questionAdapter = new QuestionAdapter(this, R.layout.row_quesiton, questionArrayList);
            listView.setAdapter(questionAdapter);
            questionArrayList.remove(0);
        } else {
            if (questionArrayList.get(postionQuestion).getResult_b().equals(questionArrayList.get(postionQuestion).getResult())){
                questionArrayList.add(new Question(questionArrayList.get(postionQuestion).getId(), "" + questionArrayList.get(postionQuestion).getCont_question(), "", "" + questionArrayList.get(postionQuestion).getResult_b(), "", "" + questionArrayList.get(postionQuestion).getResult_d(), "" + questionArrayList.get(postionQuestion).getResult(), "" + questionArrayList.get(postionQuestion).getField()));
                questionAdapter = new QuestionAdapter(this, R.layout.row_quesiton, questionArrayList);
                listView.setAdapter(questionAdapter);
                questionArrayList.remove(0);
            } else{
                if (questionArrayList.get(postionQuestion).getResult_c().equals(questionArrayList.get(postionQuestion).getResult())){
                    questionArrayList.add(new Question(questionArrayList.get(postionQuestion).getId(), "" + questionArrayList.get(postionQuestion).getCont_question(), "" + questionArrayList.get(postionQuestion).getResult_a(), "", "" + questionArrayList.get(postionQuestion).getResult_c(), "", "" + questionArrayList.get(postionQuestion).getResult(), "" + questionArrayList.get(postionQuestion).getField()));
                    questionAdapter = new QuestionAdapter(this, R.layout.row_quesiton, questionArrayList);
                    listView.setAdapter(questionAdapter);
                    questionArrayList.remove(0);
                } else{
                    questionArrayList.add(new Question(questionArrayList.get(postionQuestion).getId(), "" + questionArrayList.get(postionQuestion).getCont_question(), "", "" + questionArrayList.get(postionQuestion).getResult_b(), "", "" + questionArrayList.get(postionQuestion).getResult_d(), "" + questionArrayList.get(postionQuestion).getResult(), "" + questionArrayList.get(postionQuestion).getField()));
                    questionAdapter = new QuestionAdapter(this, R.layout.row_quesiton, questionArrayList);
                    listView.setAdapter(questionAdapter);
                    questionArrayList.remove(0);
                }
            }
        }
    }

    public void resultA(View view) {
        if (questionArrayList.get(postionQuestion).getResult_a() != ""){
            if (questionArrayList.get(postionQuestion).getResult_a().equals(questionArrayList.get(postionQuestion).getResult())){
                if (Scroce < 30){
                    Scroce = Scroce + 5;
                    txtScoreNumber.setText("" + Scroce);
                } else{
                    if (Scroce > 150){
                        Scroce = Scroce + 15;
                        txtScoreNumber.setText("" + Scroce);
                    } else {
                        Scroce = Scroce + 10;
                        txtScoreNumber.setText("" + Scroce);
                    }
                }
                GetData(urlGetData);
            } else {
                if (txtHeartFive.getText().toString().equals("")){
                    if (txtHeartFour.getText().toString().equals("")) {
                        if (txtHeartThree.getText().toString().equals("")){
                            if (txtHeartTwo.getText().toString().equals("")){
                                Intent intent = new Intent(QuestionActivity.this, MenuActivity.class);
                                startActivity(intent);
                            } else {
                                txtHeartTwo.setText("");
                                GetData(urlGetData);
                            }
                        } else {
                            txtHeartThree.setText("");
                            GetData(urlGetData);
                        }
                    } else{
                        txtHeartFour.setText("");
                        GetData(urlGetData);
                    }
                } else {
                    txtHeartFive.setText("");
                    GetData(urlGetData);
                }
            }
            numberQuestion = numberQuestion + 1;
            txtNumberQuestion.setText("" + numberQuestion);
            questionArrayList.remove(postionQuestion);
        }
        countDownTimer.start();
    }

    public void resultB(View view) {
        if (questionArrayList.get(postionQuestion).getResult_b() != ""){
            if (questionArrayList.get(postionQuestion).getResult_b().equals(questionArrayList.get(postionQuestion).getResult())){
                if (Scroce < 30){
                    Scroce = Scroce + 5;
                    txtScoreNumber.setText("" + Scroce);
                } else{
                    if (Scroce > 150){
                        Scroce = Scroce + 15;
                        txtScoreNumber.setText("" + Scroce);
                    } else {
                        Scroce = Scroce + 10;
                        txtScoreNumber.setText("" + Scroce);
                    }
                }
                GetData(urlGetData);
            } else {
                if (txtHeartFive.getText().toString().equals("")){
                    if (txtHeartFour.getText().toString().equals("")) {
                        if (txtHeartThree.getText().toString().equals("")){
                            if (txtHeartTwo.getText().toString().equals("")){
                                Intent intent = new Intent(QuestionActivity.this, MenuActivity.class);
                                startActivity(intent);
                            } else {
                                txtHeartTwo.setText("");
                                GetData(urlGetData);
                            }
                        } else {
                            txtHeartThree.setText("");
                            GetData(urlGetData);
                        }
                    } else{
                        txtHeartFour.setText("");
                        GetData(urlGetData);
                    }
                } else {
                    txtHeartFive.setText("");
                    GetData(urlGetData);
                }
            }
            numberQuestion = numberQuestion + 1;
            txtNumberQuestion.setText("" + numberQuestion);
            questionArrayList.remove(postionQuestion);
        }
        countDownTimer.start();
    }

    public void resultC(View view) {
        if (questionArrayList.get(postionQuestion).getResult_c() != ""){
            if (questionArrayList.get(postionQuestion).getResult_c().equals(questionArrayList.get(postionQuestion).getResult())){
                if (Scroce < 30){
                    Scroce = Scroce + 5;
                    txtScoreNumber.setText("" + Scroce);
                } else{
                    if (Scroce > 150){
                        Scroce = Scroce + 15;
                        txtScoreNumber.setText("" + Scroce);
                    } else {
                        Scroce = Scroce + 10;
                        txtScoreNumber.setText("" + Scroce);
                    }
                }
                GetData(urlGetData);
            } else {
                if (txtHeartFive.getText().toString().equals("")){
                    if (txtHeartFour.getText().toString().equals("")) {
                        if (txtHeartThree.getText().toString().equals("")){
                            if (txtHeartTwo.getText().toString().equals("")){
                                Intent intent = new Intent(QuestionActivity.this, MenuActivity.class);
                                startActivity(intent);
                            } else {
                                txtHeartTwo.setText("");
                                GetData(urlGetData);
                            }
                        } else {
                            txtHeartThree.setText("");
                            GetData(urlGetData);
                        }
                    } else{
                        txtHeartFour.setText("");
                        GetData(urlGetData);
                    }
                } else {
                    txtHeartFive.setText("");
                    GetData(urlGetData);
                }
            }
            numberQuestion = numberQuestion + 1;
            txtNumberQuestion.setText("" + numberQuestion);
            questionArrayList.remove(postionQuestion);
        }
        countDownTimer.start();
    }

    public void resultD(View view) {
        if (questionArrayList.get(postionQuestion).getResult_d() != ""){
            if (questionArrayList.get(postionQuestion).getResult_d().equals(questionArrayList.get(postionQuestion).getResult())){
                if (Scroce < 30){
                    Scroce = Scroce + 5;
                    txtScoreNumber.setText("" + Scroce);
                } else{
                    if (Scroce > 150){
                        Scroce = Scroce + 15;
                        txtScoreNumber.setText("" + Scroce);
                    } else {
                        Scroce = Scroce + 10;
                        txtScoreNumber.setText("" + Scroce);
                    }
                }
                GetData(urlGetData);
            } else {
                if (txtHeartFive.getText().toString().equals("")){
                    if (txtHeartFour.getText().toString().equals("")) {
                        if (txtHeartThree.getText().toString().equals("")){
                            if (txtHeartTwo.getText().toString().equals("")){
                                Intent intent = new Intent(QuestionActivity.this, MenuActivity.class);
                                startActivity(intent);
                            } else {
                                txtHeartTwo.setText("");
                                GetData(urlGetData);
                            }
                        } else {
                            txtHeartThree.setText("");
                            GetData(urlGetData);
                        }
                    } else{
                        txtHeartFour.setText("");
                        GetData(urlGetData);
                    }
                } else {
                    txtHeartFive.setText("");
                    GetData(urlGetData);
                }
            }
            numberQuestion = numberQuestion + 1;
            txtNumberQuestion.setText("" + numberQuestion);
            questionArrayList.remove(postionQuestion);
        }
        countDownTimer.start();
    }

    public void FiveandFive(View view) {
        FiveAndFive();
        btnFivetyAndFivety.setVisibility(View.INVISIBLE);
    }

}
