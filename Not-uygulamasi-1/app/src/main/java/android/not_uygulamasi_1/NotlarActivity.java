package android.not_uygulamasi_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NotlarActivity extends AppCompatActivity implements View.OnClickListener ,AdapterView.OnItemClickListener{
    private Button btnYeniNot;
    private ListView lvNotlar;

    ArrayList<Not> notListesi;

    FirebaseDatabase database;
    DatabaseReference myRef ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notlar);
        btnYeniNot=(Button) findViewById(R.id.btn_yeni_not);
        btnYeniNot.setOnClickListener(this);
        lvNotlar=(ListView) findViewById(R.id.lv_notlar);
        lvNotlar.setOnItemClickListener(this);

        notlariGetir();



    }

    private void notlariGetir() {
        database=FirebaseDatabase.getInstance();
        myRef=database.getReference("Notlar");

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               notListesi=new ArrayList<Not>();
                Not not;
                for(DataSnapshot ds:dataSnapshot.getChildren()){
                     not=new Not();
                    not.setKey(ds.getKey().toString());
                    not.setBaslik(ds.child("baslık").getValue().toString());
                    not.setDetay(ds.child("detay").getValue().toString());
                    notListesi.add(not);
                }
                NotAdapter adpter = new NotAdapter(getApplicationContext(),notListesi);

                lvNotlar.setAdapter(adpter);

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(NotlarActivity.this,YeniNotActivity.class);
        startActivity(intent);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Not not=notListesi.get(position);
        String  key =not.getKey();
        Intent intent= new Intent(NotlarActivity.this,NotDetayActivity.class);
        intent.putExtra("key",key);
        startActivity(intent);

    }
}
