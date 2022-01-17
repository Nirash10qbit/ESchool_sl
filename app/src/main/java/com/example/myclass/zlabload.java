package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.agrawalsuneet.dotsloader.loaders.TashieLoader;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class zlabload extends AppCompatActivity {

    String st,st0,st1,st2,st3,st4,st5,st6,st30,stn,stana,stbna,stcna,stdna,stena,ttanu,stmarks,st22,
            stl,stg,sta,stb,stz,stqa,stqb,stqc,stqd,stqe,staa,stab,stac,stad,stae,stm,stfna,stans,stbns,stcns,stdns,stens,stfns,stanz,stbnz,stcnz,stdnz,stenz,stfnz   ;
    TextView tvaz,tvz,tv1,tv2,tvsa,tvsb,tvsc,tvsd,tvse,tvsf,tvza,tvzb,tvzc,tvzd,tvze,tva,tvb,tvc,tvd,tve,tvf;

    TashieLoader tashieLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zlabload);

        tashieLoader = findViewById(R.id.progress);

        TashieLoader tashie = new TashieLoader(
                this, 5,
                20, 5,
                ContextCompat.getColor(this, R.color.blue));

        tashie.setAnimDuration(100);
        tashie.setAnimDelay(50);
        tashie.setInterpolator(new LinearInterpolator());

        tashieLoader.addView(tashie);


        stn = getIntent().getExtras().getString("uname");
        stl = getIntent().getExtras().getString("language");
        stg = getIntent().getExtras().getString("grade");

        stm = getIntent().getExtras().getString("numm");


        st = getIntent().getExtras().getString("value");
        st1= getIntent().getExtras().getString("gid");
        st2 = getIntent().getExtras().getString("SIDNAME");
        st3 = getIntent().getExtras().getString("SID");
        st4 = getIntent().getExtras().getString("CIDNAME");
        st5 = getIntent().getExtras().getString("CID");
        st6 = getIntent().getExtras().getString("CPDF");
        st0 = getIntent().getExtras().getString("SIDPDF");

        stz = getIntent().getExtras().getString("zid");

        stqa = getIntent().getExtras().getString("zqa");
        stqb = getIntent().getExtras().getString("zqb");
        stqc = getIntent().getExtras().getString("zqc");
        stqd = getIntent().getExtras().getString("zqd");
        stqe = getIntent().getExtras().getString("zqe");


        staa = getIntent().getExtras().getString("zaa");
        stab = getIntent().getExtras().getString("zab");
        stac = getIntent().getExtras().getString("zac");
        stad = getIntent().getExtras().getString("zad");
        stae = getIntent().getExtras().getString("zae");

        tvaz = findViewById(R.id.tvaid);
        sta = getIntent().getExtras().getString("aid");
        tvaz.setText(sta);
        tvz = findViewById(R.id.tvbid);
        stb = getIntent().getExtras().getString("bid");
        tvz.setText(stb);

        tva =findViewById(R.id.tva);
        tvb =findViewById(R.id.tvb);
        tvc =findViewById(R.id.tvc);
        tvd =findViewById(R.id.tvd);
        tve =findViewById(R.id.tve);
        tvf =findViewById(R.id.tvf);

        tvsa =findViewById(R.id.tvsa);
        tvsb =findViewById(R.id.tvsb);
        tvsc =findViewById(R.id.tvsc);
        tvsd =findViewById(R.id.tvsd);
        tvse =findViewById(R.id.tvse);
        tvsf =findViewById(R.id.tvsf);

        tvza =findViewById(R.id.tvza);
        tvzb =findViewById(R.id.tvzb);
        tvzc =findViewById(R.id.tvzc);
        tvzd =findViewById(R.id.tvzd);
        tvze =findViewById(R.id.tvze);


        Handler handler = new Handler ();
        handler.postDelayed (new Runnable ( ) {
            @Override
            public void run() {

                sta = getIntent().getExtras().getString("aid");
                stb = getIntent().getExtras().getString("bid");

                st1 = getIntent().getExtras().getString("gid");
                st3 = getIntent().getExtras().getString("SID");
                st5 = getIntent().getExtras().getString("CID");

                stana = tva.getText().toString();
                stbna = tvb.getText().toString();
                stcna = tvc.getText().toString();
                stdna = tvd.getText().toString();
                stena = tve.getText().toString();
                stfna = tvf.getText().toString();

                stans = tvsa.getText().toString();
                stbns = tvsb.getText().toString();
                stcns = tvsc.getText().toString();
                stdns = tvsd.getText().toString();
                stens = tvse.getText().toString();
                stfns = tvsf.getText().toString();

                stanz = tvza.getText().toString();
                stbnz = tvzb.getText().toString();
                stcnz = tvzc.getText().toString();
                stdnz = tvzd.getText().toString();
                stenz = tvze.getText().toString();

                addclasses(sta,stb,stana,stbna,stcna,stdna,stena,stfna);
               // addclasses1(st1,st3,st5,stans,stbns,stcns,stdns,stens,stfns,stanz,stbnz,stcnz,stdnz,stenz);
                addclasses1(st1,st3,st5,stb,stans,stbns,stcns,stdns,stens,stfns,stanz,stbnz,stcnz,stdnz,stenz);

            }
        },10000);

    }


    protected void onResume(){
        super.onResume();
        loadSession1();
        loadSession2();
        loadSession3();
    }
    public void loadSession1(){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zasub.php?aid="+sta+"&&bid="+stb+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva.setText(response.getString("na"));

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
        VolleySingleton.getInstance(zlabload.this).addToRequestQueue(jsonObjectRequest);

        JsonObjectRequest jsonObjectRequest1 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zbsub.php?aid="+sta+"&&bid="+stb+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            tvb.setText(response.getString("nb"));
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
        VolleySingleton.getInstance(zlabload.this).addToRequestQueue(jsonObjectRequest1);


        JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zcsub.php?aid="+sta+"&&bid="+stb+"", null,
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
        VolleySingleton.getInstance(zlabload.this).addToRequestQueue(jsonObjectRequest2);

        JsonObjectRequest jsonObjectRequest3 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zdsub.php?aid="+sta+"&&bid="+stb+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvd.setText(response.getString("nd"));
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
        VolleySingleton.getInstance(zlabload.this).addToRequestQueue(jsonObjectRequest3);

        JsonObjectRequest jsonObjectRequest4 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zesub.php?aid="+sta+"&&bid="+stb+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tve.setText(response.getString("ne"));
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
        VolleySingleton.getInstance(zlabload.this).addToRequestQueue(jsonObjectRequest4);

        JsonObjectRequest jsonObjectRequest5 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zfsub.php?aid="+sta+"&&bid="+stb+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvf.setText(response.getString("nf"));
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
        VolleySingleton.getInstance(zlabload.this).addToRequestQueue(jsonObjectRequest5);

    }

    public void loadSession2(){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zzasub.php?aid="+sta+"&&bid="+stb+"&&gid="+st1+"&&sid="+st3+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvsa.setText(response.getString("sna"));

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
        VolleySingleton.getInstance(zlabload.this).addToRequestQueue(jsonObjectRequest);

        JsonObjectRequest jsonObjectRequest1 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zzbsub.php?aid="+sta+"&&bid="+stb+"&&gid="+st1+"&&sid="+st3+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            tvsb.setText(response.getString("snb"));
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
        VolleySingleton.getInstance(zlabload.this).addToRequestQueue(jsonObjectRequest1);


        JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zzcsub.php?aid="+sta+"&&bid="+stb+"&&gid="+st1+"&&sid="+st3+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            tvsc.setText(response.getString("snc"));

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
        VolleySingleton.getInstance(zlabload.this).addToRequestQueue(jsonObjectRequest2);

        JsonObjectRequest jsonObjectRequest3 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zzdsub.php?aid="+sta+"&&bid="+stb+"&&gid="+st1+"&&sid="+st3+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvsd.setText(response.getString("snd"));
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
        VolleySingleton.getInstance(zlabload.this).addToRequestQueue(jsonObjectRequest3);

        JsonObjectRequest jsonObjectRequest4 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zzesub.php?aid="+sta+"&&bid="+stb+"&&gid="+st1+"&&sid="+st3+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvse.setText(response.getString("sne"));
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
        VolleySingleton.getInstance(zlabload.this).addToRequestQueue(jsonObjectRequest4);

        JsonObjectRequest jsonObjectRequest5 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zzfsub.php?aid="+sta+"&&bid="+stb+"&&gid="+st1+"&&sid="+st3+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvsf.setText(response.getString("snf"));
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
        VolleySingleton.getInstance(zlabload.this).addToRequestQueue(jsonObjectRequest5);

    }

    public void loadSession3(){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zzza.php?gid="+st1+"&&sid="+st3+"&&cid="+st5+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvza.setText(response.getString("zna"));

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
        VolleySingleton.getInstance(zlabload.this).addToRequestQueue(jsonObjectRequest);

        JsonObjectRequest jsonObjectRequest1 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zzzb.php?gid="+st1+"&&sid="+st3+"&&cid="+st5+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            tvzb.setText(response.getString("znb"));
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
        VolleySingleton.getInstance(zlabload.this).addToRequestQueue(jsonObjectRequest1);


        JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zzzc.php?gid="+st1+"&&sid="+st3+"&&cid="+st5+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            tvzc.setText(response.getString("znc"));

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
        VolleySingleton.getInstance(zlabload.this).addToRequestQueue(jsonObjectRequest2);

        JsonObjectRequest jsonObjectRequest3 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zzzd.php?gid="+st1+"&&sid="+st3+"&&cid="+st5+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvzd.setText(response.getString("znd"));
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
        VolleySingleton.getInstance(zlabload.this).addToRequestQueue(jsonObjectRequest3);

        JsonObjectRequest jsonObjectRequest4 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zzze.php?gid="+st1+"&&sid="+st3+"&&cid="+st5+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvze.setText(response.getString("zne"));
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
        VolleySingleton.getInstance(zlabload.this).addToRequestQueue(jsonObjectRequest4);

    }


    private void addclasses(final String sta, final String stb, final String stana, final String stbna, final String stcna, final String stdna, final String stena, final String stfna) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.updatetotal_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {
                    Intent intent = new Intent(zlabload.this, gameza.class);
                    intent.putExtra("uname", stn);
                    intent.putExtra("language", stl);
                    intent.putExtra("grade", stg);
                    intent.putExtra("value", st);
                    intent.putExtra("gid", st1);
                    intent.putExtra("SIDNAME", st2);
                    intent.putExtra("SID", st3);
                    intent.putExtra("SIDPDF", st0);
                    intent.putExtra("CID",st5);
                    intent.putExtra("CIDNAME",st4);
                    intent.putExtra("CPDF", st6);
                    intent.putExtra("aid", sta);
                    intent.putExtra("bid", stb);
                    intent.putExtra("zid", stz);
                    intent.putExtra("zqa", stqa);
                    intent.putExtra("zqb", stqb);
                    intent.putExtra("zqc", stqc);
                    intent.putExtra("zqd", stqd);
                    intent.putExtra("zqe", stqe);
                    intent.putExtra("zaa", staa);
                    intent.putExtra("zab", stab);
                    intent.putExtra("zac", stac);
                    intent.putExtra("zad", stad);
                    intent.putExtra("zae", stae);
                    startActivity(intent);

                } else {
                    Intent intent = new Intent(zlabload.this, gameza.class);
                    intent.putExtra("uname", stn);
                    intent.putExtra("language", stl);
                    intent.putExtra("grade", stg);
                    intent.putExtra("value", st);
                    intent.putExtra("gid", st1);
                    intent.putExtra("SIDNAME", st2);
                    intent.putExtra("SID", st3);
                    intent.putExtra("SIDPDF", st0);
                    intent.putExtra("CID",st5);
                    intent.putExtra("CIDNAME",st4);
                    intent.putExtra("CPDF", st6);
                    intent.putExtra("aid", sta);
                    intent.putExtra("bid", stb);
                    intent.putExtra("zid", stz);
                    intent.putExtra("zqa", stqa);
                    intent.putExtra("zqb", stqb);
                    intent.putExtra("zqc", stqc);
                    intent.putExtra("zqd", stqd);
                    intent.putExtra("zqe", stqe);
                    intent.putExtra("zaa", staa);
                    intent.putExtra("zab", stab);
                    intent.putExtra("zac", stac);
                    intent.putExtra("zad", stad);
                    intent.putExtra("zae", stae);
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(zlabload.this, "Please check your Internet Connection", Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());
                Intent intent = new Intent(zlabload.this, zlabload.class);
                intent.putExtra("uname", stn);
                intent.putExtra("language", stl);
                intent.putExtra("grade", stg);
                intent.putExtra("value", st);
                intent.putExtra("gid", st1);
                intent.putExtra("SIDNAME", st2);
                intent.putExtra("SID", st3);
                intent.putExtra("SIDPDF", st0);
                intent.putExtra("CID",st5);
                intent.putExtra("CIDNAME",st4);
                intent.putExtra("CPDF", st6);
                intent.putExtra("aid", sta);
                intent.putExtra("bid", stb);
                intent.putExtra("zid", stz);
                intent.putExtra("zqa", stqa);
                intent.putExtra("zqb", stqb);
                intent.putExtra("zqc", stqc);
                intent.putExtra("zqd", stqd);
                intent.putExtra("zqe", stqe);
                intent.putExtra("zaa", staa);
                intent.putExtra("zab", stab);
                intent.putExtra("zac", stac);
                intent.putExtra("zad", stad);
                intent.putExtra("zae", stae);
                startActivity(intent);

            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("sta", sta);
                params.put("stb", stb);

                params.put("aa", stana);
                params.put("ab", stbna);
                params.put("ac", stcna);
                params.put("ad", stdna);
                params.put("ae", stena);
                params.put("af", stfna);

                return params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

//    private void addclasses1(final String st1, final String st3, final String st5, final String stans, final String stbns, final String stcns, final String stdns, final String stens, final String stfns, final String stanz, final String stbnz, final String stcnz, final String stdnz, final String stenz) {
//
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.updateuact_url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                if (response.equals("success")) {
//                    Toast.makeText(zlabload.this, "Please sucess", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(zlabload.this, "Please sucess1", Toast.LENGTH_SHORT).show();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        }) {
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<>();
//
//                params.put("gid", st1);
//                params.put("sid", st3);
//                params.put("cid", st5);
//
//                params.put("sa", stans);
//                params.put("sb", stbns);
//                params.put("sc", stcns);
//                params.put("sd", stdns);
//                params.put("se", stens);
//                params.put("sf", stfns);
//
//                params.put("za", stanz);
//                params.put("zb", stbnz);
//                params.put("zc", stcnz);
//                params.put("zd", stdnz);
//                params.put("ze", stenz);
//
//                return params;
//            }
//        };
//        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
//    }
//

    private void addclasses1(final String st1,final String st3,final String st5,final String stb,final String stans, final String stbns, final String stcns, final String stdns, final String stens,final String stfns,final String stanz, final String stbnz, final String stcnz, final String stdnz, final String stenz) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.updateuact_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {
                    Toast.makeText(zlabload.this, "Sucess", Toast.LENGTH_SHORT).show();
                } else {

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("gid", st1);
                params.put("sid", st3);
                params.put("cid", st5);
                params.put("bid", stb);

                params.put("za", stans);
                params.put("zb", stbns);
                params.put("zc", stcns);
                params.put("zd", stdns);
                params.put("ze", stens);
                params.put("zf", stfns);

                params.put("zza", stanz);
                params.put("zzb", stbnz);
                params.put("zzc", stcnz);
                params.put("zzd", stdnz);
                params.put("zze", stenz);

                return params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }


}