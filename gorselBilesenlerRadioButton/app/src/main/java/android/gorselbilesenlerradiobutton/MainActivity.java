package android.gorselbilesenlerradiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioGroup cinsiyetRadioGroup;
    private RadioButton secilenRadioButton;
    private Button secielenGosrButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nesneleriOlustur();

    }

    private void nesneleriOlustur() {
        cinsiyetRadioGroup=(RadioGroup)findViewById(R.id.rg_cinsiyet);
        secielenGosrButton=(Button)findViewById(R.id.btn_goster);
        secielenGosrButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_goster)
        {
            int secilenId=cinsiyetRadioGroup.getCheckedRadioButtonId();
            secilenRadioButton=(RadioButton) findViewById(secilenId);
            Toast.makeText(getApplicationContext(),secilenRadioButton.getText(),Toast.LENGTH_SHORT).show();
        }
    }
}
