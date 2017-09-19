package android.el_feneri;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton fenerAcKapat;
    private CameraManager mCameraManager;
    private String mKameraId;
    private boolean flasAcikMi;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nesneOlustu();
        flashKontrol();
        try {
            mKameraId = mCameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private void flashKontrol() {
        Boolean flashVarMi=getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        if(!flashVarMi)
        {
            AlertDialog alert= new AlertDialog.Builder(MainActivity.this).create();
            alert.setTitle("uyarı");
            alert.setMessage("falsh yok");
            alert.setButton(DialogInterface.BUTTON_POSITIVE, "uygulmadam çık", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    System.exit(0);
                }
            });
            alert.show();
            return;
        }
    }

    private void nesneOlustu() {
        fenerAcKapat=(ImageButton) findViewById(R.id.img_fener);
        fenerAcKapat.setOnClickListener(this);
        flasAcikMi=false;
        mCameraManager=(CameraManager)getSystemService(CAMERA_SERVICE);
    }

    @Override
    public void onClick(View v) {

    }
}
