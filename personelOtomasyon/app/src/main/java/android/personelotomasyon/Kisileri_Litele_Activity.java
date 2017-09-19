package android.personelotomasyon;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.personelotomasyon.Data.Kisi;
import android.personelotomasyon.Data.KisiContract;
import android.personelotomasyon.Data.KisiDbHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Kisileri_Litele_Activity extends AppCompatActivity {


    private ListView kisilerListView;
    //ListView'e verileri bağlayacak olan adaptör
    private KisiAdapter kisiAdapter;

    //Veritabanından çekilen kişilerin tutulacağı liste
    private List<Kisi> kisiList;

    //
    private KisiDbHelper dbHelper;

    //Veritabanına erişmek ve işlem yapmak için kullanılacak SQLiteDatabase
    //objesi
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisileri__litele_);
        getSupportActionBar().setTitle("Kişi Listesi");


        //ListView nesnesini oluşturma
        kisilerListView=(ListView) findViewById(R.id.lv_kisi_listesi);


        // KisiDbHelper oluşturma bu yapıcı metod ilk defa çalışıyorda veritabanını oluşturur.
        dbHelper= new KisiDbHelper(this);


        //Veritabanı objesine veri ekleme özelliği veriliyor
        mDb = dbHelper.getWritableDatabase();

        //Kişiler listesi oluşturuluyor
        kisiList=  kisiListesigetir();

        //listview için adaptör oluşturuluyor
        kisiAdapter = new KisiAdapter(this, kisiList);

        //Adaptör listview nesnesine atama yapılıyor
        kisilerListView.setAdapter(kisiAdapter);

        kisilerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Kisi kisi=kisiList.get(position);


                Intent intent=new Intent(Kisileri_Litele_Activity.this,
                        Kisi_Detay_Activity.class);
                intent.putExtra(KisiContract.KisiEnty.ID_KEY,kisi.getId());
                startActivity(intent);

            }
        });



    }

    /**
     * Veritananındaki kişileri listeye atıp döndüren metod
     * @return kişi listesi döndürülr
     */
    private List<Kisi> kisiListesigetir() {

        List<Kisi> liste=new ArrayList<Kisi>();

        //Veritabanı objesine okuma özelliği veriliyor
        mDb=dbHelper.getReadableDatabase();

        //Veritabanı sorgusu
        String selectQuery="SELECT * FROM "+ KisiContract.KisiEnty.TABLE_NAME;

        //veritabanı sorgusu çalıştırılıyor ve sonuç cursor objesine atanıyor.
        Cursor cursor=mDb.rawQuery(selectQuery,null);

        //Eğer cursor boş değilse if bloğuna girilir
        if(cursor!=null){

            if(cursor.moveToFirst()){
                do{
                    int kisiId=cursor.getInt(cursor.getColumnIndex(KisiContract.KisiEnty._ID));
                    String kisiAd=cursor.getString(cursor.getColumnIndex(KisiContract.KisiEnty.COLUM_AD));
                    String kisiSoyad=cursor.getString(cursor.getColumnIndex(KisiContract.KisiEnty.COLUM_SOYAD));

                    Kisi kisi = new Kisi();
                    liste.add(kisi);

                }while (cursor.moveToNext());
            }
        }

        return liste;

    }

}