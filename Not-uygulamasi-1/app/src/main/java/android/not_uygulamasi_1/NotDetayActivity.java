package android.not_uygulamasi_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NotDetayActivity extends AppCompatActivity implements View.OnClickListener{
        private EditText etBaslik;
    private  EditText etDetay;
    private Button btnSil;
    private Button btnGuncelle;
    FirebaseDatabase dataBase;
    DatabaseReference mDatabaseRefrence;
    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_detay);
        getSupportActionBar().setTitle("Not");

        Bundle extras = getIntent().getExtras();
        key= extras.getString("key");

        neneleriOlustur();

        notGetir(key);

    }

    private void notGetir(String key) {
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

    private void neneleriOlustur() {
        etBaslik =(EditText)findViewById(R.id.et_notdetay_baslik);
        etDetay=(EditText)findViewById(R.id.et_notdetay_detay);
        btnSil=(Button)findViewById(R.id.btn_notDetay_sil);
        btnGuncelle=(Button)findViewById(R.id.btn_notdetay_guncelle);
        btnGuncelle.setOnClickListener(this);
        btnSil.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btnGuncelle)
        {
            guncelle();
        }
        if (v==btnSil)
        {
            sil();
        }

    }


    private void guncelle() {
        Intent intent= new Intent(NotDetayActivity.this,NotGuncelleActivity.class);
        intent.putExtra("key",key);
        startActivity(intent);

    }

    private void sil() {
        dataBase=FirebaseDatabase.getInstance();
        mDatabaseRefrence=dataBase.getReference("Notlar").child(key);
        mDatabaseRefrence.removeValue();
        Intent intent= new Intent(NotDetayActivity.this,NotlarActivity.class);
        startActivity(intent);

    }

}
