package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
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
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class analysesubs extends AppCompatActivity {

    String st1,st2,st3,st4,stn, sta,staname,sl1,sl2,sl3,sl4,sl5,stnc,stann,st5;
    TextView tv1,tv2,tv3,tv4,tvgr,tvl1,tvl2,tvl3,tvl4,tvl5,tvl6,tv3a,tvf,tvl7,sel,tv5,tvc;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysesubs);

        tv3a = findViewById(R.id.tv3a);
        stnc = getIntent().getExtras().getString("stnc");
        tv3a.setText(stnc);

        tvl1 = findViewById(R.id.l1);
        tvl2 = findViewById(R.id.l2);
        tvl3 = findViewById(R.id.l3);
        tvl4 = findViewById(R.id.l4);
        tvl5 = findViewById(R.id.l5);
        tvl6 = findViewById(R.id.subm);

        sel = findViewById(R.id.sel);


        tvf = findViewById(R.id.tvf);

        tvc = findViewById(R.id.tvc);


        stn = getIntent().getExtras().getString("uname");

        tvgr = findViewById(R.id.tvgr);
        staname = getIntent().getExtras().getString("aname");
        tvgr.setText(staname);

        tvl7 = findViewById(R.id.gnum);
        sta = getIntent().getExtras().getString("gid");
        tvl7.setText(sta);

        lv = findViewById(R.id.sublist);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                stnc = getIntent().getExtras().getString("stnc");

                tv1 = view.findViewById(R.id.tvsid);
                st1 = tv1.getText().toString();

                tv2 = view.findViewById(R.id.tvbname);
                st2 = tv2.getText().toString();

                tv3 = view.findViewById(R.id.tvbtotal);
                st3 = tv3.getText().toString();

                tv4 = view.findViewById(R.id.tvbstn);
                st4 = tv4.getText().toString();

                tv5 = view.findViewById(R.id.tvbid);
                st5 = tv5.getText().toString();



                Intent intent = new Intent(analysesubs.this,analyseacts.class);
                intent.putExtra("uname", stn);
                intent.putExtra("gid",sta);
                intent.putExtra("aname",staname);
                intent.putExtra("sid",st1);
                intent.putExtra("bid",st5);
                intent.putExtra("bname",st2);
                intent.putExtra("btotal",st3);
                intent.putExtra("snf",st4);
                intent.putExtra("stnc",stnc);
                startActivity(intent);
            }
        });
    }

    public void backanalysesub(View view) {
        Intent intent = new Intent(this, analysegrades.class);
        intent.putExtra("uname", stn);
        startActivity(intent);
        finish();
    }

    protected void onResume() {
        super.onResume();

        loadSession1();

        Handler handler = new Handler ();
        handler.postDelayed (new Runnable ( ) {
            @Override
            public void run() {
                stann = tvc.getText().toString();

                int gra = Integer.valueOf(stann);

                if(gra >= 1) {
                    sel.setVisibility(View.VISIBLE);
                    loadSession();
                }
                else{

                }

            }
        },2000);

    }

    public void loadSession() {

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/sube.php?gid=" + sta + "&&lan=sin";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,

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
                        Toast.makeText(analysesubs.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                        Log.d("VOLLEY", error.getMessage());


                    }
                });

        queue.add(request);

        JsonObjectRequest jsonObjectRequest6 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zgsub.php?aid="+sta+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvf.setText(response.getString("ng"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();
            }
        });
        VolleySingleton.getInstance(analysesubs.this).addToRequestQueue(jsonObjectRequest6);




    }

    public void loadSession1() {
        JsonObjectRequest jsonObjectRequest7= new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/subt.php?gid="+sta+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvc.setText(response.getString("nc"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();
            }
        });
        VolleySingleton.getInstance(analysesubs.this).addToRequestQueue(jsonObjectRequest7);
    }


    public void setSessions(JSONArray response) {
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject obj = response.getJSONObject(i);
                HashMap<String, String> map = new HashMap<>();

                map.put("sid", obj.getString("sid"));
                map.put("sfe", obj.getString("sfe"));
                map.put("bid", obj.getString("bid"));
                map.put("bname", obj.getString("bname"));
                map.put("btotale", obj.getString("btotale"));

                list.add(map);
            }
            //1.layout file
            int layout = R.layout.zzzsub;
            //2.views
            int[] views = {R.id.tvsid, R.id.tvbstn,R.id.tvbid,R.id.tvbname , R.id.tvbtotal};
            //3.Columms
            String[] columns = {"sid", "sfe","bid","bname", "btotale"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lv.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
