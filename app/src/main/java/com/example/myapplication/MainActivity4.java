package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity4 extends AppCompatActivity {
    String bulan_ad;
    String bulan_soyad;
    String bulan_no;
    String url="http://192.168.1.36/kaza/bulundu.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Bundle b = getIntent().getExtras();
        final String id = b.getString("id");
        final EditText et_ad = (EditText) findViewById(R.id.bulan_ad);
        final EditText et_soyad = (EditText) findViewById(R.id.bulan_soyad);
        final EditText et_no = (EditText) findViewById(R.id.bulan_no);
        Toast.makeText(MainActivity4.this, "Kayıt oluşturuldu -"+id, Toast.LENGTH_SHORT).show();
        Button blnbtn=findViewById(R.id.bulundu_gnd);
        blnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bulan_ad= et_ad.getText().toString();
                bulan_soyad=et_soyad.getText().toString();
                bulan_no =et_no.getText().toString();

                StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity4.this, "Kayıt oluşturuldu", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity4.this, "Hata oluştu!", Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> deger = new HashMap<>();
                        deger.put("id", id);
                        deger.put("ad", bulan_ad);
                        deger.put("soyad", bulan_soyad);
                        deger.put("no", bulan_no);

                        return deger;
                    }
                };
                MySingleton.getInstance(getApplicationContext()).addToRequest(stringRequest);
            }
        });



    }
}