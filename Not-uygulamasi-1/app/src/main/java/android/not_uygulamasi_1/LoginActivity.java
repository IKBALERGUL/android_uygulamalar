package android.not_uygulamasi_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
private EditText etMail;
    private EditText etSifre;
    private Button btnGiris;
    private Button btnYenikayit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        nesneleriOlustu();
    }

    private void nesneleriOlustu() {
        etMail =(EditText)findViewById(R.id.et_email);
        etSifre =(EditText)findViewById(R.id.et_sifre);
        btnGiris =(Button) findViewById(R.id.btn_giris);
        btnYenikayit =(Button) findViewById(R.id.btn_yeni_kayit);
        btnGiris.setOnClickListener(this);
        btnYenikayit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==btnGiris){
            String email=etMail.getText().toString();
            String sifre=etSifre.getText().toString();
            if(email.equals("ikbal@.com") && sifre.equals("ab")){
                Intent intent= new Intent(LoginActivity.this,NotlarActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this,"Email veya şifre hatalı", Toast.LENGTH_SHORT).show();
            }

        }
        if(v==btnYenikayit)
        {

        }
    }
}
