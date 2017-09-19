package and.android;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity  implements veritasiyici_java {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gonder (String veri) {


        FragmentManager fragmentManager=getFragmentManager();
        fragment_b fragmentB=(fragment_b)fragmentManager.findFragmentById(R.id.fragment2);
        fragmentB.yzyDgst(veri);
    }


}
