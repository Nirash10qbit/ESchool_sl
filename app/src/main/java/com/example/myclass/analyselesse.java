package com.example.myclass;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;

public class analyselesse extends AppCompatActivity {

    String stz,st2,stn, sta,staname, stb,stbname,total,sl1,sl2,sl3,sl4,sl5,stnc,stzname,snf,bid,stlen;
    TextView tvsu,tvto,tvl1,tvl2,tvl3,tvl4,tvl5,tvl6,tv20,tvasu,tvbsu,tvsu2,tvl62,tvlen,tvse1,tvse2,tvse3,tvse4,tvse5,tvse6,tvse7,tvse8;

    BarChart barChart;
    ArrayList<BarEntry> barEntryArrayList;
    ArrayList<String> labelsNames;
    ArrayList<chartMarks> chartMarksArrayList = new ArrayList<>();
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyselesse);

        tvl1 = findViewById(R.id.l1);
        tvl2 = findViewById(R.id.l2);
        tvl3 = findViewById(R.id.l3);
        tvl4 = findViewById(R.id.l4);
        tvl5 = findViewById(R.id.l5);
        tvl6 = findViewById(R.id.l6);
        tvl62 = findViewById(R.id.l62);
        tvlen = findViewById(R.id.tvlen);

        tvse1 = findViewById(R.id.se1);
        tvse2 = findViewById(R.id.se2);
        tvse3 = findViewById(R.id.se3);
        tvse4 = findViewById(R.id.se4);
        tvse5 = findViewById(R.id.se5);
        tvse6 = findViewById(R.id.se6);
        tvse7 = findViewById(R.id.se7);
        tvse8 = findViewById(R.id.se8);

        barChart = findViewById(R.id.barChart);

        barEntryArrayList = new ArrayList<>();
        labelsNames =  new ArrayList<>();


        Handler handler = new Handler ();
        handler.postDelayed (new Runnable ( ) {
            @Override
            public void run() {
                fillmarks();

                for(int i=0; i< chartMarksArrayList.size(); i++){
                    String subject = chartMarksArrayList.get(i).getSubject();
                    int marks = chartMarksArrayList.get(i).getMarks();
                    barEntryArrayList.add(new BarEntry(i,marks));
                    labelsNames.add(subject);


                }
                BarDataSet barDataSet = new BarDataSet(barEntryArrayList, "");
                // barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                Description description = new Description();
                description.setText("Marks");
                barChart.setDescription(description);
                BarData barData = new BarData(barDataSet);
                barChart.setData(barData);

                XAxis xAxis = barChart.getXAxis();
                barChart.getAxisRight().setDrawLabels(false);
                xAxis.setValueFormatter(new IndexAxisValueFormatter(labelsNames));
                barDataSet.setValueTextColors(Collections.singletonList(Color.WHITE));

                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                xAxis.setDrawGridLines(false);
                xAxis.setDrawAxisLine(false);
                xAxis.setGranularity(1f);
                xAxis.setLabelCount(labelsNames.size());
                xAxis.setLabelRotationAngle(270);
                barChart.animateY(100);
                barChart.invalidate();

                barChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                    @Override
                    public void onValueSelected(Entry e, Highlight h) {

                        int x = barChart.getBarData().getDataSetForEntry(e).getEntryIndex((BarEntry)e);

                        String subject = chartMarksArrayList.get(x).getSubject();
                        String mark = NumberFormat.getNumberInstance().format(chartMarksArrayList.get(x).getMarks()) ;
                        AlertDialog.Builder builder = new AlertDialog.Builder(analyselesse.this);
                        builder.setCancelable(true);
                        View nview = LayoutInflater.from(analyselesse.this).inflate(R.layout.chart_stn,null);
                        TextView marks = nview.findViewById(R.id.stm);
                        TextView nostn = nview.findViewById(R.id.stn);

                        marks.setText(subject);
                        nostn.setText(mark);
                        builder.setView(nview);
                        alertDialog = builder.create();
                        alertDialog.show();
                    }

                    @Override
                    public void onNothingSelected() {

                    }
                });

            }
        },3000);

        stn = getIntent().getExtras().getString("uname");
        stnc = getIntent().getExtras().getString("stnc");
        sta = getIntent().getExtras().getString("gid");
        staname = getIntent().getExtras().getString("aname");
        stb = getIntent().getExtras().getString("sid");
        stz= getIntent().getExtras().getString("cid");
        snf= getIntent().getExtras().getString("snf");
        bid= getIntent().getExtras().getString("bid");
        stbname = getIntent().getExtras().getString("bname");

        tvsu = findViewById(R.id.tvsu);
        tvsu2 = findViewById(R.id.tvsu2);
        tvasu = findViewById(R.id.tvasu);
        tvbsu = findViewById(R.id.tvbsu);
        stzname = getIntent().getExtras().getString("zname");
        tvsu.setText(stzname);
        tvsu2.setText(stzname);
        tvasu.setText(stzname);
        tvbsu.setText(stzname);


        tvto = findViewById(R.id.subm);
        total = getIntent().getExtras().getString("ztotal");
        tvto.setText( total);
    }

    private void fillmarks () {
        chartMarksArrayList.clear();

        sl1 = tvl1.getText().toString();
        sl2 = tvl2.getText().toString();
        sl3 = tvl3.getText().toString();
        sl4 = tvl4.getText().toString();
        sl5 = tvl5.getText().toString();

        int l1 = Integer.valueOf(sl1);
        int l2 = Integer.valueOf(sl2);
        int l3 = Integer.valueOf(sl3);
        int l4 = Integer.valueOf(sl4);
        int l5 = Integer.valueOf(sl5);


        chartMarksArrayList.add(new chartMarks ("1-20",l1));
        chartMarksArrayList.add(new chartMarks ("21-40",l2));
        chartMarksArrayList.add(new chartMarks ("41-60",l3));
        chartMarksArrayList.add(new chartMarks ("61-80",l4));
        chartMarksArrayList.add(new chartMarks ("81-100",l5));
    }

    public void backanalyseact(View view) {
        Intent intent = new Intent(this, analyseacte.class);
        intent.putExtra("uname", stn);
        intent.putExtra("gid",sta);
        intent.putExtra("aname",staname);
        intent.putExtra("sid",stb);
        intent.putExtra("bname",stbname);
        intent.putExtra("stnc",stnc);
        intent.putExtra("snf",snf);
        intent.putExtra("bid",bid);
        startActivity(intent);
        finish();
    }
    protected void onResume() {
        super.onResume();
        loadSession();

        Handler handler = new Handler ();
        handler.postDelayed (new Runnable ( ) {
            @Override
            public void run() {
                stlen = tvlen.getText().toString();

                int gra = Integer.valueOf(stlen);

                if(gra >= 7) {
                    tvse5.setVisibility(View.VISIBLE);
                    tvse6.setVisibility(View.VISIBLE);
                    tvse7.setVisibility(View.VISIBLE);
                    tvse8.setVisibility(View.VISIBLE);
                    tvl62.setVisibility(View.VISIBLE);
                    tvsu2.setVisibility(View.VISIBLE);
                }
                else{
                    tvasu.setVisibility(View.VISIBLE);
                    tvse1.setVisibility(View.VISIBLE);
                    tvse2.setVisibility(View.VISIBLE);
                    tvse3.setVisibility(View.VISIBLE);
                    tvse8.setVisibility(View.VISIBLE);
                    tvse4.setVisibility(View.VISIBLE);
                    tvl6.setVisibility(View.VISIBLE);

                }

            }
        },2000);
    }

    public void loadSession() {

        sta = getIntent().getExtras().getString("gid");
        stb = getIntent().getExtras().getString("sid");
        stz= getIntent().getExtras().getString("cid");

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zgetlabacts.php?gid="+sta+"&&sid="+stb+"&&cid="+stz+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvl1.setText(response.getString("aae"));
                            tvl2.setText(response.getString("abe"));
                            tvl3.setText(response.getString("ace"));
                            tvl4.setText(response.getString("ade"));
                            tvl5.setText(response.getString("aee"));
                            tvl6.setText(response.getString("zstne"));
                            tvl62.setText(response.getString("zstne"));

                        } catch (JSONException e){
                            e.printStackTrace();;
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        VolleySingleton.getInstance(analyselesse.this).addToRequestQueue(jsonObjectRequest)   ;

        JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/length.php?gid="+sta+"&&sid="+stb+"&&cid="+stz+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvlen.setText(response.getString("len"));

                        } catch (JSONException e){
                            e.printStackTrace();;
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        VolleySingleton.getInstance(analyselesse.this).addToRequestQueue(jsonObjectRequest2)   ;
    }
}
