package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity3 extends AppCompatActivity {
    private ListView list;

    public ArrayList<String> liste = new ArrayList<>();
    public ArrayList<String> liste2 = new ArrayList<>();
    String showUrl="http://192.168.1.36/kaza/verial.php";
    RequestQueue queue;
    Context context;
    public void Yazilarim(){




        queue = Volley.newRequestQueue(MainActivity3.this);


        JsonObjectRequest getYaziRequest = new JsonObjectRequest(Request.Method.POST, showUrl, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray kazazedeler= response.getJSONArray("kazazedeler");
                            for (int i = 0; i < kazazedeler.length(); i++){
                                JSONObject kaza = kazazedeler.getJSONObject(i);
                                final String idd = kaza.getString("id");
                                String ad = kaza.getString("kayip_ad");
                                String soyad = kaza.getString("kayip_soyad");
                                String adres = kaza.getString("adres");
                                String durum = kaza.getString("durum");
                                if(!durum.equals("Bulundu")){
                                    liste.add(idd+" "+ad+" "+soyad);
                                    liste2.add(adres);
                                    String[] maintitle=new String[liste.size()];
                                    String[] subtitle =new String[liste2.size()];
                                    liste.toArray(maintitle);
                                    liste2.toArray(subtitle);
                                    MyListAdapter adapter=new MyListAdapter(MainActivity3.this, maintitle, subtitle);
                                    list=(ListView)findViewById(R.id.listview1);
                                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                                            Intent appInfo = new Intent(MainActivity3.this, MainActivity4.class);
                                            Bundle b = new Bundle();
                                            b.putString("id", String.valueOf(idd));
                                            appInfo.putExtras(b);
                                            startActivity(appInfo);



                                        }
                                    });
                                    list.setAdapter(adapter);
                                }

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
        setContentView(R.layout.activity_main3);
        context=this;



        Yazilarim();


    }




    }

