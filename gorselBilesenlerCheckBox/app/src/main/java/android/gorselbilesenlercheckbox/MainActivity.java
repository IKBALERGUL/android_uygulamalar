package android.gorselbilesenlercheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CheckBox javaCheckBox;
    private CheckBox androidCheckBox;
    private CheckBox chasrpCheckBox;
    private Button secilenleri_goster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nesneler();

    }

    private void nesneler() {
        javaCheckBox=(CheckBox) findViewById(R.id.cb_Java);
        androidCheckBox=(CheckBox)findViewById(R.id.cb_android);
        chasrpCheckBox=(CheckBox)findViewById(R.id.cb_csharp);
        secilenleri_goster=(Button) findViewById(R.id.btn_secilenleri_goster);
        secilenleri_goster.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_secilenleri_goster){
            String secilenler="Seçilenler";
            if(javaCheckBox.isChecked())
            {
                secilenler+="\n"+javaCheckBox.getText();
            }
            if(androidCheckBox.isChecked())
            {
                secilenler+="\n"+androidCheckBox.getText();
            }
            if(chasrpCheckBox.isChecked())
            {
                secilenler+="\n"+chasrpCheckBox.getText();
            }
            Toast.makeText(getApplicationContext(),secilenler,Toast.LENGTH_SHORT).show();

    }
    }
}
