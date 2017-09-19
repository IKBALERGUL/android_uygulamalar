package android.gorselbilesenlerprogressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ProgressBar cycleProgresBar;
    private Button gosterGizleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        degiskenlerOlustur();
    }

    private void degiskenlerOlustur() {
        cycleProgresBar=(ProgressBar) findViewById(R.id.progressBarCycle);
        gosterGizleButton=(Button) findViewById(R.id.btn_Progressbar_goster_gizle);
        gosterGizleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(cycleProgresBar.getVisibility()==View.VISIBLE)
        {
            cycleProgresBar.setVisibility(View.INVISIBLE);
        }
        else {
            cycleProgresBar.setVisibility(View.VISIBLE);
        }
    }
}
