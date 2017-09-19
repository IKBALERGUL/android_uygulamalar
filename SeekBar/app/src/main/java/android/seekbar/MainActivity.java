package android.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar volumeSeekBar;
    private TextView valueSeekBarTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nesneler();
        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valueSeekBarTextView.setText("Durum:"+volumeSeekBar.getProgress()+"/"+volumeSeekBar.getMax());

            }
        });

    }

    private void nesneler() {
        volumeSeekBar=(SeekBar)findViewById(R.id.seekbaar_volme);
        valueSeekBarTextView=(TextView) findViewById(R.id.tv_show_seekbar_value);
        valueSeekBarTextView.setText("Durum:"+volumeSeekBar.getProgress()+"/"+volumeSeekBar.getMax());


    }
}
