package android.not_uygulamasi_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NotGuncelleActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etBaslik;
    private EditText etDetay;
    private Button btnGuncelle;
    FirebaseDatabase dataBase;
    DatabaseReference mDatabaseRefrence;
    String key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_guncelle);
        getSupportActionBar().setTitle("Not güncelle");
        Bundle extras=getIntent().getExtras();
        key=extras.getString("key");
        nottGetir();
        nesneOlustur();
    }

    private void nottGetir() {
        dataBase=FirebaseDatabase.getInstance();
        mDatabaseRefrence=dataBase.getReference("Notlar").child(key);
        mDatabaseRefrence.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                etBaslik.setText(dataSnapshot.child("baslık").getValue().toString());
                etDetay.setText(dataSnapshot.child("detay").getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void nesneOlustur() {

        etBaslik =(EditText) findViewById(R.id.et_notguncelle_baslik);
        etDetay =(EditText) findViewById(R.id.et_notguncelle_detay);
        btnGuncelle=(Button) findViewById(R.id.btn_notguncelle_kaydet);
        btnGuncelle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==btnGuncelle){
            guncelle();
        }
    }

    private void guncelle() {
        String baslik=etBaslik.getText().toString();
        String detay= etDetay.getText().toString();
        mDatabaseRefrence=dataBase.getReference("Notlar").child(key);

        mDatabaseRefrence.child("baslık").setValue(baslik);
        mDatabaseRefrence.child("detay").setValue(detay);
        Intent intent= new Intent(NotGuncelleActivity.this,NotlarActivity.class);
        startActivity(intent);
    }
}
