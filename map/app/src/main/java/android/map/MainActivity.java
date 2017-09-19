package android.map;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//intentler arası veri transeferi
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText veriEditText;
    private Button veriGonderButton;
    public  static  final String VERI_KEY="veriKey";//sabit değişken tanımlama
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nesnler();
    }

    private void nesnler() {
        veriEditText =(EditText) findViewById(R.id.et_veri);
        veriGonderButton=(Button) findViewById(R.id.btn_veri_gonder);
        veriGonderButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String veri = veriEditText.getText().toString();
        if(veri.isEmpty()|| veri.trim().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Birşeyler yaz!",Toast.LENGTH_SHORT).show();

        }
        else
        {
            Intent intenet= new Intent(MainActivity.this,DetayActivity.class);
            intenet.putExtra(VERI_KEY,veri);
            startActivity(intenet);
        }
    }
}
