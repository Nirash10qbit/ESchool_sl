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
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class analyse extends AppCompatActivity {

    String stn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyse);

        stn = getIntent().getExtras().getString("uname");
    }

    public void backanalyse(View view){
        Intent intent = new Intent(this,menus.class);
        intent.putExtra("uname", stn);
        startActivity(intent);
        finish();
    }

    public void si(View view){
        Intent intent = new Intent(this,analysegrades.class);
        intent.putExtra("uname", stn);
        startActivity(intent);
        finish();
    }
    public void ta(View view){
        Intent intent = new Intent(this,analysegradet.class);
        intent.putExtra("uname", stn);
        startActivity(intent);
        finish();
    }
    public void en(View view){
        Intent intent = new Intent(this,analysegradee.class);
        intent.putExtra("uname", stn);
        startActivity(intent);
        finish();
    }
    public void all(View view){
        Intent intent = new Intent(this,analysegrade.class);
        intent.putExtra("uname", stn);
        startActivity(intent);
        finish();
    }


}