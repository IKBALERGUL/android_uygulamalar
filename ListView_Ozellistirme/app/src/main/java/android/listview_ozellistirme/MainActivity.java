package android.listview_ozellistirme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener{
    private ListView lvNotlar;
    ArrayList<Not> notlar= new ArrayList<Not>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvNotlar =(ListView) findViewById(R.id.lv_notlar);
        lvNotlar.setOnItemClickListener(this);

        FakeDataOlustur();
        NotAdapter adaptor=new NotAdapter(getApplicationContext(),notlar);
        lvNotlar.setAdapter(adaptor);

    }

    private void FakeDataOlustur() {
        notlar.add(new Not("1","baslik1","detay1"));
        notlar.add(new Not("2","baslik2","detay2"));
        notlar.add(new Not("3","baslik3","detay3"));
        notlar.add(new Not("4","baslik4","detay4"));
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Not not = notlar.get(position);
        Toast.makeText(getApplicationContext(),not.getBaslik()+"Başlık Tıklandı",Toast.LENGTH_SHORT).show();

    }
}
