package android.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button kaydetButton;
    private EditText veriEditText;
    SharedPreferences sharedPreferences;
    public  static  final  String PREF_NAME="myprefName";
    public  static  final  String VERI_KEY="veriKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nesneler();
        sharedPreferences=getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(VERI_KEY))
        {
            veriEditText.setText(sharedPreferences.getString(VERI_KEY,""));
        }
    }

    private void nesneler() {
        kaydetButton =(Button) findViewById(R.id.btn_kaydet);
        kaydetButton.setOnClickListener(this);
        veriEditText=(EditText) findViewById(R.id.et_veri);
    }

    @Override
    public void onClick(View v) {
        String veri= veriEditText.getText().toString();
        if(veri.isEmpty()|| veri.trim().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Bir şeyler yaz",Toast.LENGTH_SHORT).show();

        }

        else {
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putString(VERI_KEY,veri);
            editor.commit();
            Toast.makeText(getApplicationContext(),"Vei kydedildi",Toast.LENGTH_SHORT).show();

        }
    }
}
