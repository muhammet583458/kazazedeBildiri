package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {
    private ListView list;

    public ArrayList<String> liste = new ArrayList<>();
    public ArrayList<String> liste2 = new ArrayList<>();
    String showUrl="http://192.168.1.36/kaza/bulunanlar.php";
    RequestQueue queue;
    Context context;
    public void Yazilarim(){

        queue = Volley.newRequestQueue(MainActivity5.this);


        JsonObjectRequest getYaziRequest = new JsonObjectRequest(Request.Method.POST, showUrl, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray kazazedeler= response.getJSONArray("kazazedeler");
                            for (int i = 0; i < kazazedeler.length(); i++){
                                JSONObject kaza = kazazedeler.getJSONObject(i);

                                String ad = kaza.getString("kayip_ad");
                                String soyad = kaza.getString("kayip_soyad");
                                String no = kaza.getString("bul_no");

                                    liste.add(ad+" "+soyad);
                                    liste2.add("Bulan kişinin numarası: "+no);
                                    String[] maintitle=new String[liste.size()];
                                    String[] subtitle =new String[liste2.size()];
                                    liste.toArray(maintitle);
                                    liste2.toArray(subtitle);
                                    MyListAdapter adapter=new MyListAdapter(MainActivity5.this, maintitle, subtitle);
                                    list=(ListView)findViewById(R.id.listview13);

                                    list.setAdapter(adapter);


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.getMessage());
                    }
                }
        );

        queue.add(getYaziRequest);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Yazilarim();
    }
}