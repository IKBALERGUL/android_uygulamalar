package android.not_uygulamasi_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class YeniNotActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etBaslik;
    private EditText etDetay;
    private Button btnYeniNotKaydet;
    FirebaseDatabase dataBase;
    DatabaseReference mDataBaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeni_not);
        nesneleriOlustur();
    }

    private void nesneleriOlustur() {
        etBaslik=(EditText) findViewById(R.id.et_yeninot_baslik);
        etDetay=(EditText)findViewById(R.id.et_yeninot_detay);
        btnYeniNotKaydet=(Button)findViewById(R.id.btn_yeninot_kaydet);
        btnYeniNotKaydet.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==btnYeniNotKaydet)
        {   String  baslik=etBaslik.getText().toString();
            String detay=etDetay.getText().toString();

                dataBase=FirebaseDatabase.getInstance();
            mDataBaseReference=dataBase.getReference().child("Notlar");

           String id= mDataBaseReference.push().getKey();

            mDataBaseReference.child(id).child("baslık").setValue(baslik);
            mDataBaseReference.child(id).child("detay").setValue(detay);
            Toast.makeText(this,"Kaydedilsi.",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,NotlarActivity.class);
            startActivity(intent);
        }
    }
}
