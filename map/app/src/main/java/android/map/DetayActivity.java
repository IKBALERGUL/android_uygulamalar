package android.map;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DetayActivity extends AppCompatActivity {
    private TextView veriGonderTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);
        Intent intent =getIntent();
        String gelenVeri = intent.getExtras().getString(MainActivity.VERI_KEY);
        veriGonderTextView =(TextView) findViewById(R.id.tv_veri_goster);
        if (gelenVeri.isEmpty()||gelenVeri.trim().equals(""))
        {
            Toast.makeText(getApplicationContext(),"gelen veri boş",Toast.LENGTH_SHORT).show();
        }
        else {
            veriGonderTextView.setText(gelenVeri);
        }
    }
}
