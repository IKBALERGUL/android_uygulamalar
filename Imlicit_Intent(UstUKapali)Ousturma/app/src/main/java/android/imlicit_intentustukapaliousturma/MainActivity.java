package android.imlicit_intentustukapaliousturma;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button webSitesiAcBtton;
    private Button haitaAcBtton;
    private Button veriPaylasAcBtton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nesnler();
    }

    private void nesnler() {
        webSitesiAcBtton =(Button) findViewById(R.id.btn_web_sitei_ac);
        webSitesiAcBtton.setOnClickListener(this);
        haitaAcBtton =(Button) findViewById(R.id.btn_harita_ac);
        haitaAcBtton.setOnClickListener(this);
        veriPaylasAcBtton=(Button) findViewById(R.id.btn_Veri_paylas);
        veriPaylasAcBtton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_web_sitei_ac:
                webSitesiAc();
            case R.id.btn_harita_ac:
               haritaAc();
            case R.id.btn_Veri_paylas:
                veriPaylas();
                break;
        }

    }

    private void veriPaylas() {
        String paylasilacakText="Merhaba";
        String mimeType ="text/plain";
        String title=MainActivity.class.getSimpleName();
        ShareCompat.IntentBuilder.from(this).setType(mimeType).setChooserTitle(title).setText(paylasilacakText).startChooser();

    }

    private void haritaAc() {
        String adres ="Okul Sk. No:4, Selimbey Mahallesi, 65140 Van Merkez/Van";
        Uri.Builder builderAdres= new Uri.Builder();
        builderAdres.scheme("geo")
                .path("0.0")
                .query(adres);
        Uri adresUri=builderAdres.build();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(adresUri);
        if(intent.resolveActivity(getPackageManager())!= null)// telefonda çalışabilirliyini sorguluyor.
        {
            startActivity(intent);
        }
    }

    private void webSitesiAc() {
        String Url="https://twitter.com/";
        Uri uriWEbSitesi=Uri.parse(Url);
        Intent intent= new Intent(Intent.ACTION_VIEW,uriWEbSitesi);
        startActivity(intent);
    }
}
