package com.example.myclass;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class analyseacte extends AppCompatActivity {

    String stz,st2,st3,st4,stn, sta,staname, stb,stbname,sl1,sl2,sl3,sl4,sl5,stnc,stf,snf,bid;
    TextView tvsu,tvl1,tvl2,tvl3,tvl4,tvl5,tvl6,tv1,tv2,tv3,tv4,tvf,tv3a,num,tvasu,tvbsu,n1,n2,n3;
    ListView lv2;

    BarChart barChart;
    ArrayList<BarEntry> barEntryArrayList;
    ArrayList<String> labelsNames;
    ArrayList<chartMarks> chartMarksArrayList = new ArrayList<>();
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyseacte);

        tvl1 = findViewById(R.id.l1);
        tvl2 = findViewById(R.id.l2);
        tvl3 = findViewById(R.id.l3);
        tvl4 = findViewById(R.id.l4);
        tvl5 = findViewById(R.id.l5);
        tvl6 = findViewById(R.id.subm);

        barChart = findViewById(R.id.barChart);
        num = findViewById(R.id.num);
        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        n3 = findViewById(R.id.n3);

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
                barChart.getAxisRight().setDrawLabels(false);
                XAxis xAxis = barChart.getXAxis();
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
                        AlertDialog.Builder builder = new AlertDialog.Builder(analyseacte.this);
                        builder.setCancelable(true);
                        View nview = LayoutInflater.from(analyseacte.this).inflate(R.layout.chart_stn,null);
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
        staname = getIntent().getExtras().getString("aname");
        sta = getIntent().getExtras().getString("gid");
        stb = getIntent().getExtras().getString("sid");
        bid = getIntent().getExtras().getString("bid");
        tvsu = findViewById(R.id.tvsu);
        tvasu = findViewById(R.id.tvasu);
        tvbsu = findViewById(R.id.tvbsu);
        stbname = getIntent().getExtras().getString("bname");
        tvsu.setText(stbname);
        tvasu.setText(stbname);
        tvbsu.setText(stbname);

        tv3a = findViewById(R.id.tv3b);
        stnc = getIntent().getExtras().getString("stnc");
        tv3a.setText(stnc);

        tvf = findViewById(R.id.tvf);
        snf = getIntent().getExtras().getString("snf");
        tvf.setText(snf);

        lv2 = findViewById(R.id.actlist);

        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                tv1 = view.findViewById(R.id.tvbid);
                stz = tv1.getText().toString();

                tv2 = view.findViewById(R.id.tvbname);
                st2 = tv2.getText().toString();

                tv3 = view.findViewById(R.id.tvbtotal);
                st3 = tv3.getText().toString();

                tv4 = view.findViewById(R.id.tvbstn);
                st4 = tv4.getText().toString();



                Intent intent = new Intent(analyseacte.this,analyselesse.class);
                intent.putExtra("uname", stn);
                intent.putExtra("gid",sta);
                intent.putExtra("aname",staname);
                intent.putExtra("sid",stb);
                intent.putExtra("bid",bid);
                intent.putExtra("bname",stbname);
                intent.putExtra("zname",st2);
                intent.putExtra("ztotal",st3);
                intent.putExtra("cid",stz);
                intent.putExtra("snf",snf);
                intent.putExtra("stnc",stnc);
                startActivity(intent);
            }
        });
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
        Intent intent = new Intent(this, analysesube.class);
        intent.putExtra("uname", stn);
        intent.putExtra("gid",sta);
        intent.putExtra("aname",staname);
        intent.putExtra("stnc",stnc);
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
                tvl6 = findViewById(R.id.subm);
                stf = tvl6.getText().toString();

                int leone = 0;
                int letwo = Integer.valueOf(stf);

                if(leone == letwo) {

                }
                else{
                    barChart.setVisibility(View.VISIBLE);
                    num.setVisibility(View.VISIBLE);
                    n1.setVisibility(View.VISIBLE);
                    n2.setVisibility(View.VISIBLE);
                    n3.setVisibility(View.VISIBLE);
                    lv2.setVisibility(View.VISIBLE);
                }

            }
        },3000);


    }

    public void loadSession() {


        sta = getIntent().getExtras().getString("gid");
        stb = getIntent().getExtras().getString("sid");
        bid = getIntent().getExtras().getString("bid");

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, "https://eschoolslgit1.000webhostapp.com/acte.php?gid="+sta+"&&sid="+stb+"&&bid="+bid+"", null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        setSessions(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(analyseacte.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                        Log.d("VOLLEY", error.getMessage());


                    }
                });

        queue.add(request);

        JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zgetlabsubs.php?gid="+sta+"&&sid="+ stb +"&&bid="+ bid +"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvl1.setText(response.getString("sae"));
                            tvl2.setText(response.getString("sbe"));
                            tvl3.setText(response.getString("sce"));
                            tvl4.setText(response.getString("sde"));
                            tvl5.setText(response.getString("see"));
                            tvl6.setText(response.getString("btotale"));
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

        VolleySingleton.getInstance(analyseacte.this).addToRequestQueue(jsonObjectRequest2)   ;

    }

    public void setSessions(JSONArray response) {
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject obj = response.getJSONObject(i);
                HashMap<String, String> map = new HashMap<>();

                map.put("cid", obj.getString("cid"));
                map.put("zstne", obj.getString("zstne"));
                map.put("zname", obj.getString("zname"));
                map.put("ztotale", obj.getString("ztotale"));

                list.add(map);
            }
            //1.layout file
            int layout = R.layout.zanalysesub;
            //2.views
            int[] views = {R.id.tvbid, R.id.tvbstn, R.id.tvbname , R.id.tvbtotal};
            //3.Columms
            String[] columns = {"cid","zstne", "zname", "ztotale"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lv2.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
