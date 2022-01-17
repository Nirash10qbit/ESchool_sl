package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class analysegradet extends AppCompatActivity {

    String stn,st1,st2,st3;
    TextView tv1,tv2,tv3;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysegradet);

        lv = findViewById(R.id.gradelist);

        tv1 = findViewById(R.id.ltext2);
        stn = getIntent().getExtras().getString("uname");
        tv1.setText(stn);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                tv1 = view.findViewById(R.id.tvaid);
                st1 = tv1.getText().toString();

                tv2 = view.findViewById(R.id.tvaidname);
                st2 = tv2.getText().toString();

                tv3 = view.findViewById(R.id.tvstnc);
                st3 = tv3.getText().toString();



                Intent intent = new Intent(analysegradet.this,analysesubt.class);
                intent.putExtra("uname", stn);
                intent.putExtra("gid",st1);
                intent.putExtra("aname",st2);
                intent.putExtra("stnc",st3);
                startActivity(intent);
            }
        });
    }
    public void backanalyse(View view){
        Intent intent = new Intent(this,analyse.class);
        intent.putExtra("uname", stn);
        startActivity(intent);
        finish();
    }
    protected void onResume(){
        super.onResume();
        loadSession();
    }


    public void loadSession(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/grades.php?stnc=3";

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
                        Toast.makeText(analysegradet.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                        Log.d("VOLLEY", error.getMessage());


                    }
                });

        queue.add(request);
    }
    public void setSessions(JSONArray response){
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try{
            for(int i=0;i <response.length()  ;i++){
                JSONObject obj = response.getJSONObject(i);
                HashMap<String, String> map = new HashMap<>();

                map.put("gid",obj.getString("gid"));
                map.put("aname",obj.getString("aname"));
                map.put("stnc",obj.getString("stnc"));

                list.add(map);
            }
            //1.layout file
            int layout= R.layout.zgrade;
            //2.views
            int[] views = {R.id.tvaid,R.id.tvaidname,R.id.tvstnc};
            //3.Columms
            String[]  columns = {"gid","aname","stnc"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lv.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}