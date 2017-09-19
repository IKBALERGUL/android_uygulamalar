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
import android.widget.Button;
import android.widget.TextView;

public class Kisi_Detay_Activity extends AppCompatActivity implements View.OnClickListener{
    private TextView kisiAdTextView;
    private TextView kisiSoyadTextView;

    private Button kisiDuzenleButton;
    private Button kisiSilButton;

    private long kisiId;

    //Oluşturduğumuz Veritabanı yardımıcı classından obje türetiyoruz
    private KisiDbHelper dbHelper;

    //Veritabanına erişmek ve işlem yapmak için kullanılacak SQLiteDatabase
    //objesi
    private SQLiteDatabase mDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisi__detay_);
        getSupportActionBar().setTitle("Kişi Detay");


        Intent gelenIntent=getIntent();

        kisiId=gelenIntent.getIntExtra(KisiContract.KisiEnty.ID_KEY,0);



        nesneleriOlustur();

        kisiGetir(kisiId);




    }

    private void kisiGetir(long kisiId) {

        Kisi kisi = new Kisi();
        String selectQuery = "SELECT * FROM " + KisiContract.KisiEnty.TABLE_NAME+ " WHERE _ID="+kisiId;


        // KisiDbHelper oluşturma bu yapıcı metod ilk defa çalışıyorda veritabanını oluşturur.
        dbHelper= new KisiDbHelper(this);

        //Veritabanı objesine veri ekleme özelliği veriliyor
        mDb = dbHelper.getWritableDatabase();

        Cursor cursor = mDb.rawQuery(selectQuery, null);

        cursor.moveToFirst();
        if(cursor.getCount() > 0){

            kisi.setAd(cursor.getString(cursor.getColumnIndex(KisiContract.KisiEnty.COLUM_AD)));
            kisi.setSoyad(cursor.getString(cursor.getColumnIndex(KisiContract.KisiEnty.COLUM_SOYAD)));
        }
        cursor.close();
        mDb.close();


        kisiAdTextView.setText(kisi.getAd());
        kisiSoyadTextView.setText(kisi.getSoyad());

    }

    private void nesneleriOlustur() {
        kisiAdTextView=(TextView)findViewById(R.id.tv_ad_detay);
        kisiSoyadTextView=(TextView) findViewById(R.id.tv_soyad_detay);

        kisiDuzenleButton=(Button) findViewById(R.id.btn_kisi_duzenle_detay);
        kisiDuzenleButton.setOnClickListener(this);

        kisiSilButton=(Button) findViewById(R.id.btn_kisi_sil_detay);
        kisiSilButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_kisi_duzenle_detay:

                Intent intent=new Intent(Kisi_Detay_Activity.this,Kisi_Duzenle_Activity.class);
                intent.putExtra(KisiContract.KisiEnty.ID_KEY,kisiId);
                startActivity(intent);

                break;
            case R.id.btn_kisi_sil_detay:

                kisiSil(kisiId);



                break;
        }


    }

    private void kisiSil(long kisiId) {

        // KisiDbHelper oluşturma bu yapıcı metod ilk defa çalışıyorda veritabanını oluşturur.
        dbHelper= new KisiDbHelper(this);

        //Veritabanı objesine veri ekleme özelliği veriliyor
        mDb = dbHelper.getWritableDatabase();

        mDb.delete(KisiContract.KisiEnty.TABLE_NAME, KisiContract.KisiEnty._ID + " = ?", new String[] {String.valueOf(kisiId)  });

        mDb.close();

        Intent intent2=new Intent(Kisi_Detay_Activity.this,Kisi_Duzenle_Activity.class);
        startActivity(intent2);

    }
}