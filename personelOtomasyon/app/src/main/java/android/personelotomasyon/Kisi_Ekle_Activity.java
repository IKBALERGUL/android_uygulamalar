package android.personelotomasyon;

import android.content.ContentValues;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.personelotomasyon.Data.KisiContract;
import android.personelotomasyon.Data.KisiDbHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Kisi_Ekle_Activity extends AppCompatActivity implements View.OnClickListener {

    //Oluşturduğumuz Veritabanı yardımıcı classından obje türetiyoruz
    private KisiDbHelper dbHelper;

    long yeniKayitId;

    //Veritabanına erişmek ve işlem yapmak için kullanılacak SQLiteDatabase
    //objesi
    private SQLiteDatabase mDb;

    private EditText kisiAdEditText;
    private EditText kisiSoyadEditText;
    private Button yeniKisiEkleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisi__ekle_);
        getSupportActionBar().setTitle("Yeni Kayıt");
        getSupportActionBar().setSubtitle("Yeni Kişi Ekleme Ekranı");

        nesneleriOlustur();

    }

    private void nesneleriOlustur() {
        kisiAdEditText=(EditText) findViewById(R.id.et_kisi_ad);
        kisiSoyadEditText=(EditText) findViewById(R.id.et_kisi_soyad);
        yeniKisiEkleButton=(Button) findViewById(R.id.btn_yeni_kisi_ekle);
        yeniKisiEkleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.btn_yeni_kisi_ekle){
            String kisiAd=kisiAdEditText.getText().toString();
            String kisiSoyad=kisiSoyadEditText.getText().toString();

            String hataMesaji="";

            if(kisiAd.trim().equals("")|| kisiAd.isEmpty()){
                hataMesaji+="Bir ad girmelisiniz\n";

            }
            if(kisiSoyad.trim().equals("")||kisiSoyad.isEmpty()){
                hataMesaji+="Bir soyad girmelisiniz";
            }

            if(hataMesaji!=""){
                Toast.makeText(getApplicationContext(),hataMesaji,Toast.LENGTH_SHORT).show();
            }
            else {

                // KisiDbHelper oluşturma bu yapıcı metod ilk defa çalışıyorda veritabanını oluşturur.
                dbHelper= new KisiDbHelper(this);

                //Veritabanı objesine veri ekleme özelliği veriliyor
                mDb = dbHelper.getWritableDatabase();

                ContentValues cv = new ContentValues();
                cv.put(KisiContract.KisiEnty.COLUM_AD, kisiAd);
                cv.put(KisiContract.KisiEnty.COLUM_SOYAD,kisiSoyad);

                try {
                    yeniKayitId=yeniKisiEkle(cv);

                    Intent intent=new Intent(Kisi_Ekle_Activity.this,
                            Kisi_Duzenle_Activity.class);
                    intent.putExtra(KisiContract.KisiEnty.ID_KEY,yeniKayitId);
                    startActivity(intent);
                }catch (Exception ex){

                }
                finally {
                    mDb.close();
                }



            }

        }

    }

    private long yeniKisiEkle(ContentValues cv) {

        //Bir transaciton ile tüm kişileri ekliyoruz
        try
        {
            //Transaction başlatılır
            mDb.beginTransaction();
            /**
             * db.insert(value1,value2,value3)
             *
             * value1 param=ekleme yapılacak tablo ismi
             * value2 param=String isteğe bağlı, boş olabilir
             * Sütünlardan birine değer girilmemişse null değerini
             * almasını sağlar
             * value3=yeni eklenecek verinin tutulduğu contentvalue objesi
             */
            yeniKayitId=mDb.insert(KisiContract.KisiEnty.TABLE_NAME, null, cv);
            //Transaction başarılı olursa aşağıdaki kod
            mDb.setTransactionSuccessful();
        }
        catch (SQLException e) {

        }
        finally
        {
            //Transaction'u sonlandırma
            mDb.endTransaction();
        }
        return yeniKayitId;
    }
}