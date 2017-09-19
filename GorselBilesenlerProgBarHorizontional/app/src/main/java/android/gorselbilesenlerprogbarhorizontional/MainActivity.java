package android.gorselbilesenlerprogbarhorizontional;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import static java.lang.Thread.*;

public class MainActivity extends AppCompatActivity {
    private ProgressBar horizontalProgessBar;
    private TextView durumTextView;
    private int progressStatus= 0;
    private Handler handler= new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nesneleriOlustur();

    }

    private void nesneleriOlustur() {
        durumTextView=(TextView) findViewById(R.id.tv_durum);
        horizontalProgessBar=(ProgressBar) findViewById(R.id.progressBarHorizontal);

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (progressStatus<100)
                {
                    progressStatus +=1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            horizontalProgessBar.setProgress(progressStatus);
                            durumTextView.setText(progressStatus+"/"+horizontalProgessBar.getMax());
                        }
                    });
                    try {

                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
        horizontalProgessBar.getProgressDrawable().setColorFilter(Color.BLUE,android.graphics.PorterDuff.Mode.SRC_IN);

    }
}
