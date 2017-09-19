package and.android;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by lenovo on 16.06.2017.
 */

public class fragment_a extends Fragment {
    Button banaTikla;
    int counter =0;
    veritasiyici_java veriTasiyici;
    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container, Bundle saveInstanceState)
    {
        if (saveInstanceState!=null)
        {
            counter=saveInstanceState.getInt("counter",0);

        }
        else {
            counter=0;
        }
        View view=inflater.inflate(R.layout.fragment_a,container,false);
        return  view;
    }
    public void  onActivityCreated(@Nullable Bundle saveInstanceState)
    {
        super.onActivityCreated(saveInstanceState);
        banaTikla=(Button)getActivity().findViewById(R.id.btn_tikla);
        veriTasiyici=(veritasiyici_java) getActivity();
        banaTikla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                counter++;
                veriTasiyici.gonder("Butona"+counter+"kere tıklandı.");
            }
        });
    }



}
