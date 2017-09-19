package android.personelotomasyon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button kisiEkleButton;
    private Button kisileriListeleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nesneleriOlustur();
    }

    private void nesneleriOlustur() {
        kisiEkleButton=(Button) findViewById(R.id.btn_kisi_ekle);
        kisiEkleButton.setOnClickListener(this);

        kisileriListeleButton=(Button) findViewById(R.id.btn_kisi_listele);
        kisileriListeleButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_kisi_ekle:
                Intent intentKisiEkle=new Intent(MainActivity.this,Kisi_Ekle_Activity.class);
                startActivity(intentKisiEkle);
                break;
            case R.id.btn_kisi_listele:
                Intent intentKisileriListele=new Intent(MainActivity.this,Kisileri_Litele_Activity.class);
                startActivity(intentKisileriListele);

                break;

        }

    }
}