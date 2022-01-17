
package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

public class zlabgameg extends AppCompatActivity {

    String st,st0,st1,st2,st3,st4,st5,st6,st8,st9,st10,ca,cb,cc,cd,ce,stn,stl,stg,sta,stb,stz,stqa,stqb,stqc,stqd,stqe,staa,stab,stac,stad,stae,totale,totalf,ra,rb,rc,rd,re,sttstn,sttmarks,stnt,totalt,markst,sttotal,
            nstntt,nmarkstt,ntotaltt,anu,bnu,cnu,dnu,enu,one,two,stbstn,stbmarks,stbtotal,stzstn,stzmarks,stztotal,stnb,totalb,marksb,stnz,marksz,totalz,marks,ststn,stmarks,stttotal,stntt,markstt,totaltt,
            sa,sb,sc,sd,se,sf,ssa,ssb,ssc,ssd,sse,ssf,mz1,mz2,mz3,mz4,mz5,sz1,sz2,sz3,sz4,sz5,al1,al2,al3,al4,al5,as1,as2,as3,as4,as5,az1,az2,az3,az4,az5;
    TextView tvaz,tvz,tvname,tvv,tv3,tv4,tv5,tva1,tva2,tva3,tva4,tva5,tva6,tva7,tva8,tva9,tva10,tvmarks,tvboy,tva11,tva12,tva13,tva14,tva15,tva16,tva17,tva18,tva19,tvs2,tvs3,tvs4,tvs5,tvz1,tvz2,tvz3,tvz4,tvz5;
    ListView lv1;
    Button etadd,ethome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zlabgameg);

        etadd = findViewById(R.id.etadd);
        ethome = findViewById(R.id.ethome);



        stn = getIntent().getExtras().getString("uname");
        stl = getIntent().getExtras().getString("language");
        stg = getIntent().getExtras().getString("grade");

        st = getIntent().getExtras().getString("value");
        st1= getIntent().getExtras().getString("gid");


        st3 = getIntent().getExtras().getString("SID");
        st4 = getIntent().getExtras().getString("CIDNAME");


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

        tvname = findViewById(R.id.sname);
        st2 = getIntent().getExtras().getString("SIDNAME");
        tvname.setText(st2);

        tvaz = findViewById(R.id.said);
        sta = getIntent().getExtras().getString("aid");
        tvaz.setText(sta);
        tvz = findViewById(R.id.sbid);
        stb = getIntent().getExtras().getString("bid");
        tvz.setText(stb);

        tvv = findViewById(R.id.scid);
        st5 = getIntent().getExtras().getString("CID");
        tvv.setText(st5);



        tva1 =findViewById(R.id.aastn);
        tva2 =findViewById(R.id.aamarks);
        tva3 =findViewById(R.id.aatotal);
        tva4 =findViewById(R.id.abstn);
        tva5 =findViewById(R.id.abmarks);
        tva6 =findViewById(R.id.abtotal);
        tva7 =findViewById(R.id.azstn);
        tva8 =findViewById(R.id.azmarks);
        tva9 =findViewById(R.id.aztotal);

        tva10 =findViewById(R.id.marks);

        tva11 =findViewById(R.id.tv11);
        tva12 =findViewById(R.id.tv12);
        tva13 =findViewById(R.id.tv13);

        tva14 =findViewById(R.id.sastn);
        tva15 =findViewById(R.id.samarks);
        tva16 =findViewById(R.id.satotal);

        tva17 =findViewById(R.id.sustn);
        tva18 =findViewById(R.id.sumarks);
        tva19 =findViewById(R.id.sutotal);


        tvz1 =findViewById(R.id.z1);
        tvz2 =findViewById(R.id.z2);
        tvz3 =findViewById(R.id.z3);
        tvz4 =findViewById(R.id.z4);
        tvz5 =findViewById(R.id.z5);



        tvmarks = findViewById(R.id.gidnew6);


        etadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stbstn = tva4.getText().toString();
                stbmarks = tva5.getText().toString();
                stbtotal = tva6.getText().toString();

                stzstn = tva7.getText().toString();
                stzmarks = tva8.getText().toString();
                stztotal = tva9.getText().toString();

                marks = tva10.getText().toString();

                ststn = tva11.getText().toString();
                stmarks = tva12.getText().toString();
                stttotal = tva13.getText().toString();

                sa = tva14.getText().toString();
                sb = tva15.getText().toString();
                sc = tva16.getText().toString();
                sd = tva17.getText().toString();
                se = tva18.getText().toString();
                sf = tva19.getText().toString();



                sz1 = tvz1.getText().toString();
                sz2 = tvz2.getText().toString();
                sz3 = tvz3.getText().toString();
                sz4 = tvz4.getText().toString();
                sz5 = tvz5.getText().toString();


                totale = tvmarks.getText().toString();

                one = "1";
                two = tvz.getText().toString();


                int tot = Integer.valueOf(totale);
                int ma = Integer.valueOf(marks);

                int saa = Integer.valueOf(sa);
                int saaa = saa + 1;
                ssa = String.valueOf(saaa);

                int sbb = Integer.valueOf(sb);
                int sbbb = sbb + tot;
                ssb = String.valueOf(sbbb);

                int scc = sbbb/saaa;
                ssc = String.valueOf(scc);


                int sdd = Integer.valueOf(sd);
                int sddd = sdd + 1;
                ssd = String.valueOf(sddd);

                int see = Integer.valueOf(se);
                int seee = see + tot;
                sse = String.valueOf(seee);

                int sff = seee/sddd;
                ssf = String.valueOf(sff);


                int tmstn = Integer.valueOf(stbstn);
                int mstn = tmstn + 1;
                stnb = String.valueOf(mstn);

                int tmmarks = Integer.valueOf(stbmarks);
                int mmarks = tmmarks + tot;
                marksb = String.valueOf(mmarks);

                int mstotal = mmarks/mstn;
                totalb = String.valueOf(mstotal);


                int tpstn = Integer.valueOf(stzstn);
                int pstn = tpstn + 1;
                stnz = String.valueOf(pstn);

                int tpmarks = Integer.valueOf(stzmarks);
                int pmarks = tpmarks + tot;
                marksz = String.valueOf(pmarks);

                int pstotal = pmarks/pstn;
                totalz = String.valueOf(pstotal);

                int tnstnt = Integer.valueOf(ststn);
                int nstnt = tnstnt + 1;
                stntt = String.valueOf(nstnt);

                nstntt = String.valueOf(tnstnt);

                int tnmarkst = Integer.valueOf(stmarks);
                int nmarkst = tnmarkst + tot;
                markstt = String.valueOf(nmarkst);

                int nnmarkst = nmarkst - ma ;

                nmarkstt = String.valueOf(nnmarkst);

                int nstotalt = nmarkst/nstnt;
                totaltt = String.valueOf(nstotalt);

                int nnstotalt = nnmarkst/tnstnt;
                ntotaltt = String.valueOf(nnstotalt);

                int z1 = Integer.valueOf(sz1);
                int lz1 = z1 + 1;
                az1 = String.valueOf(lz1);

                int z2 = Integer.valueOf(sz2);
                int lz2 = z2 + 1;
                az2 = String.valueOf(lz2);

                int z3 = Integer.valueOf(sz3);
                int lz3 = z3 + 1;
                az3 = String.valueOf(lz3);

                int z4 = Integer.valueOf(sz4);
                int lz4 = z4 + 1;
                az4 = String.valueOf(lz4);

                int z5 = Integer.valueOf(sz5);
                int lz5 = z5 + 1;
                az5 = String.valueOf(lz5);



                addclasses(st4,stnb,marksb,totalb,stnz,marksz,totalz,stn,stg,st1,st3,st5,sta,stb,stz,marks,totale,az1,az2,az3,az4,az5);

                addclasses3(stmarks,st1,st2,one,two,ststn,totale,marks,stn,st3,sta,stg,stntt,markstt,totaltt,nstntt,nmarkstt,ntotaltt);

                addclasses4(stg,marks,st1,st3,st5,sta,two,ssa,ssb,ssc,ssd,sse,ssf);

            }
        });

        ethome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                mz1 = tvz1.getText().toString();
                mz2 = tvz2.getText().toString();
                mz3 = tvz3.getText().toString();
                mz4 = tvz4.getText().toString();
                mz5 = tvz5.getText().toString();




                stbstn = tva4.getText().toString();
                stbmarks = tva5.getText().toString();
                stbtotal = tva6.getText().toString();

                stzstn = tva7.getText().toString();
                stzmarks = tva8.getText().toString();
                stztotal = tva9.getText().toString();

                marks = tva10.getText().toString();

                ststn = tva11.getText().toString();
                stmarks = tva12.getText().toString();
                stttotal = tva13.getText().toString();


                totale = tvmarks.getText().toString();

                one = "1";
                two = tvz.getText().toString();


                int tot = Integer.valueOf(totale);
                int ma = Integer.valueOf(marks);



                int tmstn = Integer.valueOf(stbstn);
                int mstn = tmstn + 1;
                stnb = String.valueOf(mstn);

                int tmmarks = Integer.valueOf(stbmarks);
                int mmarks = tmmarks + tot;
                marksb = String.valueOf(mmarks);

                int mstotal = mmarks/mstn;
                totalb = String.valueOf(mstotal);


                int tpstn = Integer.valueOf(stzstn);
                int pstn = tpstn + 1;
                stnz = String.valueOf(pstn);

                int tpmarks = Integer.valueOf(stzmarks);
                int pmarks = tpmarks + tot;
                marksz = String.valueOf(pmarks);

                int pstotal = pmarks/pstn;
                totalz = String.valueOf(pstotal);

                int tnstnt = Integer.valueOf(ststn);
                int nstnt = tnstnt + 1;
                stntt = String.valueOf(nstnt);

                nstntt = String.valueOf(tnstnt);

                int tnmarkst = Integer.valueOf(stmarks);
                int nmarkst = tnmarkst + tot;
                markstt = String.valueOf(nmarkst);

                int nnmarkst = nmarkst - ma ;

                nmarkstt = String.valueOf(nnmarkst);

                int nstotalt = nmarkst/nstnt;
                totaltt = String.valueOf(nstotalt);

                int nnstotalt = nnmarkst/tnstnt;
                ntotaltt = String.valueOf(nnstotalt);


                addclasses2(st4,stnb,marksb,totalb,stnz,marksz,totalz,stn,stg,st1,st3,st5,sta,stb,stz,marks,totale,az1,az2,az3,az4,az5);

                addclasses3(stmarks,st1,st2,one,two,ststn,totale,marks,stn,st3,sta,stg,stntt,markstt,totaltt,nstntt,nmarkstt,ntotaltt);

            }
        });
    }


    protected void onResume(){
        super.onResume();
        loadSession1();
    }
    public void loadSession1(){


        JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zgetlabsub.php?aid="+sta+"&&bid="+stb+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva4.setText(response.getString("bstn"));
                            tva5.setText(response.getString("bmarks"));
                            tva6.setText(response.getString("btotal"));

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


        VolleySingleton.getInstance(zlabgameg.this).addToRequestQueue(jsonObjectRequest2)   ;

        JsonObjectRequest jsonObjectRequest1 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zgetlabsube.php?aid="+sta+"&&bid="+stb+"&&gid="+st1+"&&sid="+st3+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva14.setText(response.getString("bstne"));
                            tva15.setText(response.getString("bmarkse"));
                            tva16.setText(response.getString("btotale"));

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


        VolleySingleton.getInstance(zlabgameg.this).addToRequestQueue(jsonObjectRequest1)   ;


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zgetlabacte.php?aid="+sta+"&&bid="+stb+"&&gid="+st1+"&&sid="+st3+"&&cid="+st5+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva17.setText(response.getString("zstne"));
                            tva18.setText(response.getString("zmarkse"));
                            tva19.setText(response.getString("ztotale"));

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


        VolleySingleton.getInstance(zlabgameg.this).addToRequestQueue(jsonObjectRequest)   ;

        JsonObjectRequest jsonObjectRequest3 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zgetlabact.php?aid="+sta+"&&bid="+stb+"&&zid="+stz+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva7.setText(response.getString("zstn"));
                            tva8.setText(response.getString("zmarks"));
                            tva9.setText(response.getString("ztotal"));

                            tvz1.setText(response.getString("aa"));
                            tvz2.setText(response.getString("ab"));
                            tvz3.setText(response.getString("ac"));
                            tvz4.setText(response.getString("ad"));
                            tvz5.setText(response.getString("ae"));
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


        VolleySingleton.getInstance(zlabgameg.this).addToRequestQueue(jsonObjectRequest3);

        JsonObjectRequest jsonObjectRequest4 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/getuser.php?uname="+stn+"&&gid="+st1+"&&sid="+st3+"&&cid="+st5+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva10.setText(response.getString("marks"));
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


        VolleySingleton.getInstance(zlabgameg.this).addToRequestQueue(jsonObjectRequest4)   ;

        JsonObjectRequest jsonObjectRequest5 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/simmarks.php?uname="+stn+"&&cid="+st5+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvmarks.setText(response.getString("marks"));
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
        VolleySingleton.getInstance(zlabgameg.this).addToRequestQueue(jsonObjectRequest5);

        JsonObjectRequest jsonObjectRequest6 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/getusub.php?sid="+st3+"&&uname="+stn+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva11.setText(response.getString("ststn"));
                            tva12.setText(response.getString("stmarks"));
                            tva13.setText(response.getString("sttotal"));
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


        VolleySingleton.getInstance(zlabgameg.this).addToRequestQueue(jsonObjectRequest6);






    }



    private void showMessage(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }



    private void addclasses( final String st4,final String stnb, final String marksb, final  String totalb,final String stnz, final String marksz, final  String totalz,final String stn, final String stg, final  String st1 ,final  String st3 ,final  String st5 ,final  String sta, final String stb,
                             final String stz, final String marks, final String totale,
                             final String az1, final String az2, final String az3, final String az4, final String az5) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.updatedata_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {
                    Intent intent = new Intent(zlabgameg.this, zlabload.class);
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
                    Intent intent = new Intent(zlabgameg.this, zlabload.class);
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

                Toast.makeText(zlabgameg.this, "Please check your Internet Connection", Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());
                Intent intent = new Intent(zlabgameg.this, zlabload.class);
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

                params.put("bstn", stnb);
                params.put("bmarks", marksb);
                params.put("btotal", totalb);
                params.put("zstn", stnz);
                params.put("zmarks", marksz);
                params.put("ztotal", totalz);
                params.put("stn", stn);
                params.put("stg", stg);
                params.put("sta", sta);
                params.put("stb", stb);
                params.put("stz", stz);
                params.put("marks", marks);
                params.put("totale", totale);
                params.put("gid", st1);
                params.put("sid", st3);
                params.put("cid", st5);
                params.put("cname", st4);


                params.put("az1", az1);
                params.put("az2", az2);
                params.put("az3", az3);
                params.put("az4", az4);
                params.put("az5", az5);





                return params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    private void addclasses2( final String st4,final String stnb, final String marksb, final  String totalb,final String stnz, final String marksz, final  String totalz,final String stn, final String stg, final  String st1 ,final  String st3 ,final  String st5 ,final  String sta, final String stb,
                              final String stz, final String marks, final String totale,
                              final String az1, final String az2, final String az3, final String az4, final String az5) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.updatedata_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {
                    Intent intent = new Intent(zlabgameg.this,zsubject.class);
                    intent.putExtra("uname", stn);
                    intent.putExtra("language", stl);
                    intent.putExtra("grade", stg);
                    intent.putExtra("value",st);
                    intent.putExtra("gid",st1);
                    intent.putExtra("SIDNAME",st2);
                    intent.putExtra("SID",st3);
                    intent.putExtra("SIDPDF",st0);
                    startActivity(intent);
                    finish();

                } else {
                    Intent intent = new Intent(zlabgameg.this,zsubject.class);
                    intent.putExtra("uname", stn);
                    intent.putExtra("language", stl);
                    intent.putExtra("grade", stg);
                    intent.putExtra("value",st);
                    intent.putExtra("gid",st1);
                    intent.putExtra("SIDNAME",st2);
                    intent.putExtra("SID",st3);
                    intent.putExtra("SIDPDF",st0);
                    startActivity(intent);
                    finish();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(zlabgameg.this, "Please check your Internet Connection", Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());
                Intent intent = new Intent(zlabgameg.this,zsubject.class);
                intent.putExtra("uname", stn);
                intent.putExtra("language", stl);
                intent.putExtra("grade", stg);
                intent.putExtra("value",st);
                intent.putExtra("gid",st1);
                intent.putExtra("SIDNAME",st2);
                intent.putExtra("SID",st3);
                intent.putExtra("SIDPDF",st0);
                startActivity(intent);
                finish();

            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
//                params.put("tstn", stnt);
//                params.put("tmarks", markst);
//                params.put("ttotal", totalt);
                params.put("bstn", stnb);
                params.put("bmarks", marksb);
                params.put("btotal", totalb);
                params.put("zstn", stnz);
                params.put("zmarks", marksz);
                params.put("ztotal", totalz);
                params.put("stn", stn);
                params.put("stg", stg);
                params.put("sta", sta);
                params.put("stb", stb);
                params.put("stz", stz);
                params.put("marks", marks);
                params.put("totale", totale);
                params.put("gid", st1);
                params.put("sid", st3);
                params.put("cid", st5);
                params.put("cname", st4);


                params.put("az1", az1);
                params.put("az2", az2);
                params.put("az3", az3);
                params.put("az4", az4);
                params.put("az5", az5);


                return params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }


    private void addclasses3(final String stmarks, final String st1,final String st2, final String one, final String two,final String ststn,final String totale,final String marks,final String stn,final String st3,final String stg, final  String sta, final String stntt, final  String markstt,final String totaltt, final String nstntt, final  String nmarkstt,final String ntotaltt) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.updateusub_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {

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
                params.put("marks", marks);
                params.put("ststn", stntt);
                params.put("stmarks", markstt);
                params.put("sttotal", totaltt);

                params.put("nststn", nstntt);
                params.put("nstmarks", nmarkstt);
                params.put("nsttotal", ntotaltt);

                params.put("stg", stg);
                params.put("sta", sta);

                params.put("sname", st2);

                params.put("uname", stn);
                params.put("gid", st1);
                params.put("sid", st3);

                params.put("one", one);
                params.put("two", two);
                params.put("zero", ststn);
                params.put("total", totale);

                params.put("change", stmarks);



                return params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }



//    private void addclasses4(final String marks, final String st1,final String st3, final String st5, final String sta,final String two,final String ssa,final String ssb,final String ssc,final String ssd,final  String sse, final String ssf) {
//
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.updatesube_url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                if (response.equals("success")) {
//
//                    Toast.makeText(zlabgameg.this, "Please sucess", Toast.LENGTH_SHORT).show();
//
//                }else {
//                    Toast.makeText(zlabgameg.this, "Please error1", Toast.LENGTH_SHORT).show();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//                Toast.makeText(zlabgameg.this, "Please check error2", Toast.LENGTH_SHORT).show();
//            }
//        }) {
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<>();
//                params.put("marks", marks);
//                params.put("ssa", ssa);
//                params.put("ssb", ssb);
//                params.put("ssc", ssc);
//
//                params.put("ssd", ssd);
//                params.put("sse", sse);
//                params.put("ssf", ssf);
//
//                params.put("two", two);
//                params.put("sta", sta);
//
//                params.put("gid", st1);
//                params.put("sid", st3);
//                params.put("cid", st5);
//
//
//
//                return params;
//            }
//        };
//        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
//    }


    private void addclasses4(final String stg,final String marks, final String st1,final String st3, final String st5,final String sta, final String two,final String ssa,final String ssb,final String ssc,final String ssd,final  String sse, final String ssf) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.updatesube_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {
                }
               else {

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("stg", stg);
                params.put("marks", marks);
                params.put("gid", st1);
                params.put("sid", st3);
                params.put("cid", st5);

                params.put("two", two);
                params.put("sta", sta);

                params.put("ssa", ssa);
                params.put("ssb", ssb);
                params.put("ssc", ssc);

                params.put("ssd", ssd);
                params.put("sse", sse);
                params.put("ssf", ssf);

                return params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }


}
