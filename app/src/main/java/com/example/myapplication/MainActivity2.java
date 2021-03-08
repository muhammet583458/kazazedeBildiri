package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class MainActivity2 extends AppCompatActivity {
    private String[] iller={"Adana", "Adıyaman", "Afyonkarahisar", "Ağrı","Aksaray", "Amasya", "Ankara", "Antalya","Ardahan", "Artvin",
            "Aydın", "Balıkesir","Bartın","Batman","Bayburt", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale",
            "Çankırı", "Çorum", "Denizli", "Diyarbakır","Düzce", "Edirne", "Elazığ", "Erzincan", "Erzurum", "Eskişehir",
            "Gaziantep", "Giresun", "Gümüşhane", "Hakkari", "Hatay","Iğdır", "Isparta",  "İstanbul", "İzmir",
            "Kahramanmaraş","Karabük",   "Karaman","Kars", "Kastamonu", "Kayseri", "Kırıkkale","Kırklareli", "Kırşehir","Kilis", "Kocaeli", "Konya", "Kütahya", "Malatya",
            "Manisa",  "Mardin","Mersin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu","Osmaniye", "Rize", "Sakarya",
            "Samsun", "Siirt", "Sinop", "Sivas","Şanlıurfa", "Şırnak","Tekirdağ", "Tokat", "Trabzon", "Tunceli",  "Uşak",
            "Van", "Yalova","Yozgat", "Zonguldak"};
    private String[] ilceler0={"Aladağ","Ceyhan","Çukurova","Feke","İmamoğlu","Karaisalı","Karataş","Kozan","Pozantı","Saimbeyli","Sarıçam","Seyhan","Tufanbeyli","Yumurtalık","Yüreğir"};
    private String[] ilceler1={"Besni","Çelikhan","Gerger","Gölbaşı","Kâhta","Merkez","Samsat","Sincik","Tut"};
    private String[] ilceler2={"Başmakçı","Bayat","Bolvadin","Çay","Çobanlar","Dazkırı","Dinar","Emirdağ","Evciler","Hocalar","İhsaniye","İscehisar","Kızılören","Merkez","Sandıklı","Sinanpaşa","Sultandağı","Şuhut"};
    private String[] ilceler3={"Diyadin","Doğubayazıt","Eleşkirt","Hamur","Merkez","Patnos","Taşlıçay","Tutak"};
    private String[] ilceler4={"Ağaçören","Eskil","Gülağaç","Güzelyurt","Merkez","Ortaköy","Sarıyahşi","Sultanhanı"};
    private String[] ilceler5={"Göynücek","Gümüşhacıköy","Hamamözü","Merkez","Merzifon","Suluova","Taşova"};
    private String[] ilceler6={"Akyurt","Altındağ","Ayaş","Balâ","Beypazarı","Çamlıdere","Çankaya","Çubuk","Elmadağ","Etimesgut","Evren","Gölbaşı","Güdül","Haymana","Kalecik","Kahramankazan","Keçiören","Kızılcahamam","Mamak","Nallıhan","Polatlı","Pursaklar","Sincan","Şereflikoçhisar","Yenimahalle"};
    private String[] ilceler7={"Akseki","Aksu","Alanya","Döşemealtı","Elmalı","Finike","Gazipaşa","Gündoğmuş","İbradı","Demre","Kaş","Kemer","Kepez","Konyaaltı","Korkuteli","Kumluca","Manavgat","Muratpaşa","Serik"};
    private String[] ilceler8={"Çıldır","Damal","Göle","Hanak","Merkez","Posof"};
    private String[] ilceler9={"Ardanuç","Arhavi","Borçka","Hopa","Kemalpaşa","Merkez","Murgul","Şavşat","Yusufeli"};
    private String[] ilceler10={"Bozdoğan","Buharkent","Çine","Didim","Efeler","Germencik","İncirliova","Karacasu","Karpuzlu","Koçarlı","Köşk","Kuşadası","Kuyucak","Merkez","Nazilli","Söke","Sultanhisar","Yenipazar"};
    private String[] ilceler11={"Altıeylül","Ayvalık","Balya","Bandırma","Bigadiç","Burhaniye","Dursunbey","Edremit","Erdek","Gömeç","Gönen","Havran","İvrindi","Karesi","Kepsut","Manyas","Marmara","Savaştepe","Sındırgı","Susurluk"};
    private String[] ilceler12={"Amasra","Kurucaşile","Merkez","Ulus"};
    private String[] ilceler13={"Beşiri","Gercüş","Hasankeyf","Kozluk","Merkez","Sason"};
    private String[] ilceler14={"Aydıntepe","Demirözü","Merkez"};
    private String[] ilceler15={"Bozüyük","Gölpazarı","İnhisar","Merkez","Osmaneli","Pazaryeri","Söğüt","Yenipazar"};
    private String[] ilceler16={"Adaklı","Genç","Karlıova","Kiğı","Merkez","Solhan","Yayladere","Yedisu"};
    private String[] ilceler17={"Adilcevaz","Ahlat","Güroymak","Hizan","Merkez","Mutki","Tatvan"};
    private String[] ilceler18={"Dörtdivan","Gerede","Göynük","Kıbrıscık","Mengen","Merkez","Mudurnu","Seben","Yeniçağa"};
    private String[] ilceler19={"Ağlasun","Altınyayla","Bucak","Çavdır","Çeltikçi","Gölhisar","Karamanlı","Kemer","Merkez","Tefenni","Yeşilova"};
    private String[] ilceler20={"Büyükorhan","Gemlik","Gürsu","Harmancık","İnegöl","İznik","Karacabey","Keles","Kestel","Mudanya","Mustafakemalpaşa","Nilüfer","Orhaneli","Orhangazi","Osmangazi","Yenişehir","Yıldırım"};
    private String[] ilceler21={"Ayvacık","Bayramiç","Biga","Bozcaada","Çan","Eceabat","Ezine","Gelibolu","Gökçeada","Lapseki","Merkez","Yenice"};
    private String[] ilceler22={"Atkaracalar","Bayramören","Çerkeş","Eldivan","Ilgaz","Kızılırmak","Korgun","Kurşunlu","Merkez","Orta","Şabanözü","Yapraklı"};
    private String[] ilceler23={"Alaca","Bayat","Boğazkale","Dodurga","İskilip","Kargı","Laçin","Mecitözü","Merkez","Oğuzlar","Ortaköy","Osmancık","Sungurlu","Uğurludağ"};
    private String[] ilceler24={"Acıpayam","Babadağ","Baklan","Bekilli","Beyağaç","Bozkurt","Buldan","Çal","Çameli","Çardak","Çivril","Güney","Honaz","Kale","Merkezefendi","Pamukkale","Sarayköy","Serinhisar","Tavas"};
    private String[] ilceler25={"Bağlar","Bismil","Çermik","Çınar","Çüngüş","Dicle","Eğil","Ergani","Hani","Hazro","Kayapınar","Kocaköy","Kulp","Lice","Silvan","Sur","Yenişehir"};
    private String[] ilceler26={"Akçakoca","Cumayeri","Çilimli","Gölyaka","Gümüşova","Kaynaşlı","Merkez","Yığılca"};
    private String[] ilceler27={"Enez","Havsa","İpsala","Keşan","Lalapaşa","Meriç","Merkez","Süloğlu","Uzunköprü"};
    private String[] ilceler28={"Ağın","Alacakaya","Arıcak","Baskil","Karakoçan","Keban","Kovancılar","Maden","Merkez","Palu","Sivrice"};
    private String[] ilceler29={"Çayırlı","İliç","Kemah","Kemaliye","Merkez","Otlukbeli","Refahiye","Tercan","Üzümlü"};
    private String[] ilceler30={"Aşkale","Aziziye","Çat","Hınıs","Horasan","İspir","Karaçoban","Karayazı","Köprüköy","Narman","Oltu","Olur","Palandöken","Pasinler","Pazaryolu","Şenkaya","Tekman","Tortum","Uzundere","Yakutiye"};
    private String[] ilceler31={"Alpu","Beylikova","Çifteler","Günyüzü","Han","İnönü","Mahmudiye","Mihalgazi","Mihalıççık","Odunpazarı","Sarıcakaya","Seyitgazi","Sivrihisar","Tepebaşı"};
    private String[] ilceler32={"Araban","İslahiye","Karkamış","Nizip","Nurdağı","Oğuzeli","Şahinbey","Şehitkamil","Yavuzeli"};
    private String[] ilceler33={"Alucra","Bulancak","Çamoluk","Çanakçı","Dereli","Doğankent","Espiye","Eynesil","Görele","Güce","Keşap","Merkez","Piraziz","Şebinkarahisar","Tirebolu","Yağlıdere"};
    private String[] ilceler34={"Kelkit","Köse","Kürtün","Merkez","Şiran","Torul"};
    private String[] ilceler35={"Çukurca","Merkez","Şemdinli","Yüksekova","Derecik"};
    private String[] ilceler36={"Altınözü","Antakya","Arsuz","Belen","Defne","Dörtyol","Erzin","Hassa","İskenderun","Kırıkhan","Kumlu","Payas","Reyhanlı","Samandağ","Yayladağı"};
    private String[] ilceler37={"Aralık","Karakoyunlu","Merkez","Tuzluca"};
    private String[] ilceler38={"Aksu","Atabey","Eğirdir","Gelendost","Gönen","Keçiborlu","Merkez","Senirkent","Sütçüler","Şarkikaraağaç","Uluborlu","Yalvaç","Yenişarbademli"};
    private String[] ilceler39={"Adalar","Arnavutköy","Ataşehir","Avcılar","Bağcılar","Bahçelievler","Bakırköy","Başakşehir","Bayrampaşa","Beşiktaş","Beykoz","Beylikdüzü","Beyoğlu","Büyükçekmece","Çatalca","Çekmeköy","Esenler","Esenyurt","Eyüpsultan","Fatih","Gaziosmanpaşa","Güngören","Kadıköy","Kâğıthane","Kartal","Küçükçekmece","Maltepe","Pendik","Sancaktepe","Sarıyer","Silivri","Sultanbeyli","Sultangazi","Şile","Şişli","Tuzla","Ümraniye","Üsküdar","Zeytinburnu"};
    private String[] ilceler40={"Aliağa","Balçova","Bayındır","Bayraklı","Bergama","Beydağ","Bornova","Buca","Çeşme","Çiğli","Dikili","Foça","Gaziemir","Güzelbahçe","Karabağlar","Karaburun","Karşıyaka","Kemalpaşa","Kınık","Kiraz","Konak","Menderes","Menemen","Narlıdere","Ödemiş","Seferihisar","Selçuk","Tire","Torbalı","Urla"};
    private String[] ilceler41={"Afşin","Andırın","Çağlayancerit","Dulkadiroğlu","Ekinözü","Elbistan","Göksun","Nurhak","Onikişubat","Pazarcık","Türkoğlu"};
    private String[] ilceler42={"Eflani","Eskipazar","Merkez","Ovacık","Safranbolu","Yenice"};
    private String[] ilceler43={"Ayrancı","Başyayla","Ermenek","Kazımkarabekir","Merkez","Sarıveliler"};
    private String[] ilceler44={"Akyaka","Arpaçay","Digor","Kağızman","Merkez","Sarıkamış","Selim","Susuz"};
    private String[] ilceler45={"Abana","Ağlı","Araç","Azdavay","Bozkurt","Cide","Çatalzeytin","Daday","Devrekani","Doğanyurt","Hanönü","İhsangazi","İnebolu","Küre","Merkez","Pınarbaşı","Seydiler","Şenpazar","Taşköprü","Tosya"};
    private String[] ilceler46={"Akkışla","Bünyan","Develi","Felahiye","Hacılar","İncesu","Kocasinan","Melikgazi","Özvatan","Pınarbaşı","Sarıoğlan","Sarız","Talas","Tomarza","Yahyalı","Yeşilhisar"};
    private String[] ilceler47={"Bahşili","Balışeyh","Çelebi","Delice","Karakeçili","Keskin","Merkez","Sulakyurt","Yahşihan"};
    private String[] ilceler48={"Babaeski","Demirköy","Kofçaz","Lüleburgaz","Merkez","Pehlivanköy","Pınarhisar","Vize"};
    private String[] ilceler49={"Akçakent","Akpınar","Boztepe","Çiçekdağı","Kaman","Merkez","Mucur"};
    private String[] ilceler50={"Elbeyli","Merkez","Musabeyli","Polateli"};
    private String[] ilceler51={"Başiskele","Çayırova","Darıca","Derince","Dilovası","Gebze","Gölcük","İzmit","Kandıra","Karamürsel","Kartepe","Körfez"};
    private String[] ilceler52={"Ahırlı","Akören","Akşehir","Altınekin","Beyşehir","Bozkır","Cihanbeyli","Çeltik","Çumra","Derbent","Derebucak","Doğanhisar","Emirgazi","Ereğli","Güneysınır","Hadim","Halkapınar","Hüyük","Ilgın","Kadınhanı","Karapınar","Karatay","Kulu","Meram","Sarayönü","Selçuklu","Seydişehir","Taşkent","Tuzlukçu","Yalıhüyük","Yunak"};
    private String[] ilceler53={"Altıntaş","Aslanapa","Çavdarhisar","Domaniç","Dumlupınar","Emet","Gediz","Hisarcık","Merkez","Pazarlar","Şaphane","Simav","Tavşanlı"};
    private String[] ilceler54={"Akçadağ","Arapgir","Arguvan","Battalgazi","Darende","Doğanşehir","Doğanyol","Hekimhan","Kale","Kuluncak","Pütürge","Yazıhan","Yeşilyurt"};
    private String[] ilceler55={"Ahmetli","Akhisar","Alaşehir","Demirci","Gölmarmara","Gördes","Kırkağaç","Köprübaşı","Kula","Salihli","Sarıgöl","Saruhanlı","Selendi","Soma","Şehzadeler","Turgutlu","Yunusemre"};
    private String[] ilceler56={"Artuklu","Dargeçit","Derik","Kızıltepe","Mazıdağı","Midyat","Nusaybin","Ömerli","Savur","Yeşilli"};
    private String[] ilceler57={"Akdeniz","Anamur","Aydıncık","Bozyazı","Çamlıyayla","Erdemli","Gülnar","Mezitli","Mut","Silifke","Tarsus","Toroslar","Yenişehir"};
    private String[] ilceler58={"Bodrum","Dalaman","Datça","Fethiye","Kavaklıdere","Köyceğiz","Marmaris","Menteşe","Milas","Ortaca","Seydikemer","Ula","Yatağan"};
    private String[] ilceler59={"Bulanık","Hasköy","Korkut","Malazgirt","Merkez","Varto"};
    private String[] ilceler60={"Acıgöl","Avanos","Derinkuyu","Gülşehir","Hacıbektaş","Kozaklı","Merkez","Ürgüp"};
    private String[] ilceler61={"Altunhisar","Bor","Çamardı","Çiftlik","Merkez","Ulukışla"};
    private String[] ilceler62={"Akkuş","Altınordu","Aybastı","Çamaş","Çatalpınar","Çaybaşı","Fatsa","Gölköy","Gülyalı","Gürgentepe","İkizce","Kabadüz","Kabataş","Korgan","Kumru","Mesudiye","Perşembe","Ulubey","Ünye"};
    private String[] ilceler63={"Bahçe","Düziçi","Hasanbeyli","Kadirli","Merkez","Sumbas","Toprakkale"};
    private String[] ilceler64={"Ardeşen","Çamlıhemşin","Çayeli","Derepazarı","Fındıklı","Güneysu","Hemşin","İkizdere","İyidere","Kalkandere","Merkez","Pazar"};
    private String[] ilceler65={"Adapazarı","Akyazı","Arifiye","Erenler","Ferizli","Geyve","Hendek","Karapürçek","Karasu","Kaynarca","Kocaali","Pamukova","Sapanca","Serdivan","Söğütlü","Taraklı"};
    private String[] ilceler66={"Alaçam","Asarcık","Atakum","Ayvacık","Bafra","Canik","Çarşamba","Havza","İlkadım","Kavak","Ladik","Ondokuzmayıs","Salıpazarı","Tekkeköy","Terme","Vezirköprü","Yakakent"};
    private String[] ilceler67={"Tillo","Baykan","Eruh","Kurtalan","Merkez","Pervari","Şirvan"};
    private String[] ilceler68={"Ayancık","Boyabat","Dikmen","Durağan","Erfelek","Gerze","Merkez","Saraydüzü","Türkeli"};
    private String[] ilceler69={"Akıncılar","Altınyayla","Divriği","Doğanşar","Gemerek","Gölova","Hafik","İmranlı","Kangal","Koyulhisar","Merkez","Suşehri","Şarkışla","Ulaş","Yıldızeli","Zara","Gürün"};
    private String[] ilceler70={"Akçakale","Birecik","Bozova","Ceylanpınar","Eyyübiye","Halfeti","Haliliye","Harran","Hilvan","Karaköprü","Siverek","Suruç","Viranşehir"};
    private String[] ilceler71={"Beytüşşebap","Cizre","Güçlükonak","İdil","Merkez","Silopi","Uludere"};
    private String[] ilceler72={"Çerkezköy","Çorlu","Ergene","Hayrabolu","Kapaklı","Malkara","Marmaraereğlisi","Muratlı","Saray","Süleymanpaşa","Şarköy"};
    private String[] ilceler73={"Almus","Artova","Başçiftlik","Erbaa","Merkez","Niksar","Pazar","Reşadiye","Sulusaray","Turhal","Yeşilyurt","Zile"};
    private String[] ilceler74={"Akçaabat","Araklı","Arsin","Beşikdüzü","Çarşıbaşı","Çaykara","Dernekpazarı","Düzköy","Hayrat","Köprübaşı","Maçka","Of","Ortahisar","Sürmene","Şalpazarı","Tonya","Vakfıkebir","Yomra"};
    private String[] ilceler75={"Çemişgezek","Hozat","Mazgirt","Merkez","Nazımiye","Ovacık","Pertek","Pülümür"};
    private String[] ilceler76={"Banaz","Eşme","Karahallı","Merkez","Sivaslı","Ulubey"};
    private String[] ilceler77={"Bahçesaray","Başkale","Çaldıran","Çatak","Edremit","Erciş","Gevaş","Gürpınar","İpekyolu","Muradiye","Özalp","Saray","Tuşba"};
    private String[] ilceler78={"Altınova","Armutlu","Çınarcık","Çiftlikköy","Merkez","Termal"};
    private String[] ilceler79={"Akdağmadeni","Aydıncık","Boğazlıyan","Çandır","Çayıralan","Çekerek","Kadışehri","Merkez","Saraykent","Sarıkaya","Sorgun","Şefaatli","Yenifakılı","Yerköy"};
    private String[] ilceler80={"Alaplı","Çaycuma","Devrek","Ereğli","Gökçebey","Kilimli","Kozlu","Karadeniz","Merkez"};

    private Spinner spinnerIller;
    private Spinner spinnerIlceler;
    private ArrayAdapter<String> dataAdapterForIller;
    private ArrayAdapter<String> dataAdapterForIlceler;
    Button gndbtn;
    String ad;
    String soyad;
    String no;
    String kayipad;
    String kayipsoyad;
    String adres;
    String il,ilce;
    String url="http://192.168.1.36/kaza/demo.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final EditText et_ad = (EditText) findViewById(R.id.ad);
        final EditText et_soyad = (EditText) findViewById(R.id.soyad);
        final EditText et_no = (EditText) findViewById(R.id.no);
        final EditText et_kad = (EditText) findViewById(R.id.kayipad);
        final EditText et_ksoyad = (EditText) findViewById(R.id.kayipsoyad);
        final EditText et_adres = (EditText) findViewById(R.id.adres);

        gndbtn=findViewById(R.id.gndrBtn);
        gndbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = et_ad.getText().toString();
                soyad=et_soyad.getText().toString();
                no=et_no.getText().toString();
                kayipad=et_kad.getText().toString();
                kayipsoyad=et_ksoyad.getText().toString();
                adres=et_adres.getText().toString();
               /* FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("iller");

                myRef.setValue("Adana");*/
              //  Toast.makeText(getBaseContext(),""+ad+" "+soyad+" "+no+" "+kayipad+" "+kayipsoyad+" "+adres+" "+il+" "+ilce,Toast.LENGTH_LONG).show();
                il=spinnerIller.getSelectedItem().toString();
                ilce=spinnerIlceler.getSelectedItem().toString();
                StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity2.this, "Kayıt oluşturuldu", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity2.this, "Hata oluştu!", Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> deger = new HashMap<>();
                        deger.put("ad",ad);
                        deger.put("soyad",soyad);
                        deger.put("no",no);
                        deger.put("kayipad",kayipad);
                        deger.put("kayipsoyad",kayipsoyad);
                        deger.put("adres",adres);
                        deger.put("il",il);
                        deger.put("ilce",ilce);
                        deger.put("durum","Kayıp");
                        return deger;
                    }
                };
                MySingleton.getInstance(getApplicationContext()).addToRequest(stringRequest);
            }
        });
        spinnerIller = (Spinner) findViewById(R.id.spinner1);
        spinnerIlceler = (Spinner) findViewById(R.id.spinner2);

        dataAdapterForIller = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, iller);
        dataAdapterForIlceler = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,ilceler0);

        dataAdapterForIller.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterForIlceler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerIller.setAdapter(dataAdapterForIller);
        spinnerIlceler.setAdapter(dataAdapterForIlceler);

        spinnerIller.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //Hangi il seçilmişse onun ilçeleri adapter'e ekleniyor.
                if(parent.getSelectedItem().toString().equals(iller[0]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler0);
                else if(parent.getSelectedItem().toString().equals(iller[1]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler1);
                else if(parent.getSelectedItem().toString().equals(iller[2]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler2);
                else if(parent.getSelectedItem().toString().equals(iller[3]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler3);
                else if(parent.getSelectedItem().toString().equals(iller[4]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler4);
                else if(parent.getSelectedItem().toString().equals(iller[5]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler5);
                else if(parent.getSelectedItem().toString().equals(iller[6]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler6);
                else if(parent.getSelectedItem().toString().equals(iller[7]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler7);
                else if(parent.getSelectedItem().toString().equals(iller[8]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler8);
                else if(parent.getSelectedItem().toString().equals(iller[9]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler9);
                else if(parent.getSelectedItem().toString().equals(iller[10]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler10);
                else if(parent.getSelectedItem().toString().equals(iller[11]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler11);
                else if(parent.getSelectedItem().toString().equals(iller[12]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler12);
                else if(parent.getSelectedItem().toString().equals(iller[13]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler13);
                else if(parent.getSelectedItem().toString().equals(iller[14]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler14);
                else if(parent.getSelectedItem().toString().equals(iller[15]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler15);
                else if(parent.getSelectedItem().toString().equals(iller[16]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler16);
                else if(parent.getSelectedItem().toString().equals(iller[17]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler17);
                else if(parent.getSelectedItem().toString().equals(iller[18]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler18);
                else if(parent.getSelectedItem().toString().equals(iller[19]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler19);
                else if(parent.getSelectedItem().toString().equals(iller[20]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler20);
                else if(parent.getSelectedItem().toString().equals(iller[21]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler21);
                else if(parent.getSelectedItem().toString().equals(iller[22]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler22);
                else if(parent.getSelectedItem().toString().equals(iller[23]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler23);
                else if(parent.getSelectedItem().toString().equals(iller[24]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler24);
                else if(parent.getSelectedItem().toString().equals(iller[25]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler25);
                else if(parent.getSelectedItem().toString().equals(iller[26]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler26);
                else if(parent.getSelectedItem().toString().equals(iller[27]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler27);
                else if(parent.getSelectedItem().toString().equals(iller[28]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler28);
                else if(parent.getSelectedItem().toString().equals(iller[29]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler29);
                else if(parent.getSelectedItem().toString().equals(iller[30]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler30);
                else if(parent.getSelectedItem().toString().equals(iller[31]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler31);
                else if(parent.getSelectedItem().toString().equals(iller[32]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler32);
                else if(parent.getSelectedItem().toString().equals(iller[33]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler33);
                else if(parent.getSelectedItem().toString().equals(iller[34]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler34);
                else if(parent.getSelectedItem().toString().equals(iller[35]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler35);
                else if(parent.getSelectedItem().toString().equals(iller[36]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler36);
                else if(parent.getSelectedItem().toString().equals(iller[37]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler37);
                else if(parent.getSelectedItem().toString().equals(iller[38]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler38);
                else if(parent.getSelectedItem().toString().equals(iller[39]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler39);
                else if(parent.getSelectedItem().toString().equals(iller[40]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler40);
                else if(parent.getSelectedItem().toString().equals(iller[41]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler41);
                else if(parent.getSelectedItem().toString().equals(iller[42]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler42);
                else if(parent.getSelectedItem().toString().equals(iller[43]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler43);
                else if(parent.getSelectedItem().toString().equals(iller[44]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler44);
                else if(parent.getSelectedItem().toString().equals(iller[45]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler45);
                else if(parent.getSelectedItem().toString().equals(iller[46]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler46);
                else if(parent.getSelectedItem().toString().equals(iller[47]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler47);
                else if(parent.getSelectedItem().toString().equals(iller[48]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler48);
                else if(parent.getSelectedItem().toString().equals(iller[49]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler49);
                else if(parent.getSelectedItem().toString().equals(iller[50]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler50);
                else if(parent.getSelectedItem().toString().equals(iller[51]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler51);
                else if(parent.getSelectedItem().toString().equals(iller[52]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler52);
                else if(parent.getSelectedItem().toString().equals(iller[53]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler53);
                else if(parent.getSelectedItem().toString().equals(iller[54]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler54);
                else if(parent.getSelectedItem().toString().equals(iller[55]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler55);
                else if(parent.getSelectedItem().toString().equals(iller[56]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler56);
                else if(parent.getSelectedItem().toString().equals(iller[57]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler57);
                else if(parent.getSelectedItem().toString().equals(iller[58]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler58);
                else if(parent.getSelectedItem().toString().equals(iller[59]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler59);
                else if(parent.getSelectedItem().toString().equals(iller[60]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler60);
                else if(parent.getSelectedItem().toString().equals(iller[61]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler61);
                else if(parent.getSelectedItem().toString().equals(iller[62]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler62);
                else if(parent.getSelectedItem().toString().equals(iller[63]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler63);
                else if(parent.getSelectedItem().toString().equals(iller[64]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler64);
                else if(parent.getSelectedItem().toString().equals(iller[65]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler65);
                else if(parent.getSelectedItem().toString().equals(iller[66]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler66);
                else if(parent.getSelectedItem().toString().equals(iller[67]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler67);
                else if(parent.getSelectedItem().toString().equals(iller[68]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler68);
                else if(parent.getSelectedItem().toString().equals(iller[69]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler69);
                else if(parent.getSelectedItem().toString().equals(iller[70]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler70);
                else if(parent.getSelectedItem().toString().equals(iller[71]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler71);
                else if(parent.getSelectedItem().toString().equals(iller[72]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler72);
                else if(parent.getSelectedItem().toString().equals(iller[73]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler73);
                else if(parent.getSelectedItem().toString().equals(iller[74]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler74);
                else if(parent.getSelectedItem().toString().equals(iller[75]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler75);
                else if(parent.getSelectedItem().toString().equals(iller[76]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler76);
                else if(parent.getSelectedItem().toString().equals(iller[77]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler77);
                else if(parent.getSelectedItem().toString().equals(iller[78]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler78);
                else if(parent.getSelectedItem().toString().equals(iller[79]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler79);
                else if(parent.getSelectedItem().toString().equals(iller[80]))
                    dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_spinner_item,ilceler80);



                dataAdapterForIlceler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerIlceler.setAdapter(dataAdapterForIlceler);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerIlceler.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                il=spinnerIller.getSelectedItem().toString();
                ilce=spinnerIlceler.getSelectedItem().toString();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}