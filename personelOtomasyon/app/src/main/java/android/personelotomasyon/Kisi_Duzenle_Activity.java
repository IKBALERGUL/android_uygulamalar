package android.personelotomasyon;

import android.content.ContentValues;
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
import android.widget.EditText;
import android.widget.Toast;

public class Kisi_Duzenle_Activity extends AppCompatActivity implements View.OnClickListener{

    private EditText kisiAdEditText;
    private EditText kisiSoyadEditText;
    private Button kisiGuncelleButton;
    private Button yeniKisiEkle;

    private long kisiId;


    //Oluşturduğumuz Veritabanı yardımıcı classından obje türetiyoruz
    private KisiDbHelper dbHelper;

    //Veritabanına erişmek ve işlem yapmak için kullanılacak SQLiteDatabase
    //objesi
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisi__duzenle_);
        getSupportActionBar().setTitle("Kişi Düzenle");

        Intent intent=getIntent();

        kisiId=intent.getLongExtra(KisiContract.KisiEnty.ID_KEY,0);

        nesneleriOlustur();
        kisiGetir(kisiId);
    }




    private void nesneleriOlustur() {

        kisiAdEditText=(EditText) findViewById(R.id.et_kisi_ad_duzelt);
        kisiSoyadEditText=(EditText) findViewById(R.id.et_kisi_soyad_duzelt);

        kisiGuncelleButton=(Button) findViewById(R.id.btn_guncelle_duzenle);
        kisiGuncelleButton.setOnClickListener(this);
        yeniKisiEkle=(Button) findViewById(R.id.btn_yeni_kisi_ekle_duzenle);
        yeniKisiEkle.setOnClickListener(this);
    }

    private void kisiGetir(long kisiId) {


        Kisi kisi = new Kisi();
        String selectQuery = "SELECT * FROM " + KisiContract.KisiEnty.TABLE_NAME+ " WHERE _ID="+kisiId;

        // KisiDbHelper oluşturma bu yapıcı metod ilk defa çalışıyorda veritabanını oluşturur.
        dbHelper= new KisiDbHelper(this);

        //Veritabanı objesine veri ekleme özelliği veriliyor
        mDb = dbHelper.getWritableDatabase();
        Cursor cursor = mDb.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if(cursor.getCount() > 0){

            kisi.setAd(cursor.getString(cursor.getColumnIndex(KisiContract.KisiEnty.COLUM_AD)));
            kisi.setSoyad(cursor.getString(cursor.getColumnIndex(KisiContract.KisiEnty.COLUM_SOYAD)));
        }
        cursor.close();
        mDb.close();

        kisiAdEditText.setText(kisi.getAd());
        kisiSoyadEditText.setText(kisi.getSoyad());


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_guncelle_duzenle:

                String kisiAd=kisiAdEditText.getText().toString();
                String kisiSoyad=kisiSoyadEditText.getText().toString();

                String hataMesaj="";

                if(kisiAd.trim().equals("")||kisiAd.isEmpty()){
                    hataMesaj+="Bir ad girmelisiniz\n";
                }
                if(kisiSoyad.trim().equals("")||kisiSoyad.isEmpty()){
                    hataMesaj+="Bir soyad girmelisiniz";
                }
                if(hataMesaj!=""){
                    Toast.makeText(getApplicationContext(),hataMesaj,Toast.LENGTH_SHORT).show();
                }
                else {
                    kisiGuncelle(kisiAd,kisiSoyad);
                    Toast.makeText(getApplicationContext(),"Kişi başarılı bir şekilde güncellendi",Toast.LENGTH_SHORT).show();
                }


                break;
            case R.id.btn_yeni_kisi_ekle_duzenle:
                Intent intent=new Intent(Kisi_Duzenle_Activity.this,Kisi_Ekle_Activity.class);
                startActivity(intent);
                break;
        }

    }

    private void kisiGuncelle(String kisiAd, String kisiSoyad) {

        mDb = dbHelper.getWritableDatabase();
        //Bu methodda ise var olan veriyi güncelliyoruz(update)
        ContentValues values = new ContentValues();
        values.put(KisiContract.KisiEnty.COLUM_AD, kisiAd);
        values.put(KisiContract.KisiEnty.COLUM_SOYAD, kisiSoyad);

        // updating row
        mDb.update(KisiContract.KisiEnty.TABLE_NAME, values, KisiContract.KisiEnty._ID + " = ?",
                new String[] { String.valueOf(kisiId) });
        mDb.close();


    }
}