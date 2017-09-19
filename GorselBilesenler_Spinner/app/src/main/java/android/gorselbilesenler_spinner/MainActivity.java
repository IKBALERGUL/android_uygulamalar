package android.gorselbilesenler_spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Spinner kodlaSpinner;
    private  Spinner manuelSpinner;
    private Button secimiGosterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        degiskenleriOlustur();
        ArrayAdapter<String> adater= new ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item,getResources().getStringArray(R.array.country_arrays));
        kodlaSpinner.setAdapter(adater);

    }

    private void degiskenleriOlustur() {
        kodlaSpinner=(Spinner)findViewById(R.id.spinner_kodla);
        manuelSpinner=(Spinner)findViewById(R.id.spinner_manuel);
        secimiGosterButton=(Button)findViewById(R.id.btn_secileni_goster);
        secimiGosterButton.setOnClickListener(this);
    }
    public  void onClick(View v)
    {
        if(v.getId()==R.id.btn_secileni_goster)
        {
            String secilenler="Manel seçilen \n"+ manuelSpinner.getSelectedItem()+
                    "\nkodla secimi\n"+
                    kodlaSpinner.getSelectedItem();
            Toast.makeText(getApplicationContext(),secilenler,Toast.LENGTH_SHORT).show();
        }
    }
}
