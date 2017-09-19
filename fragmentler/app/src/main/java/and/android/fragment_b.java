package and.android;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lenovo on 16.06.2017.
 */

public class fragment_b extends Fragment{
    TextView sonuc;
    String veri;
   public  View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
   {
       View view=inflater.inflate(R.layout.fragment_b,container,false);
       if(savedInstanceState!=null)
       {
           veri=savedInstanceState.getString("verikey");
           TextView textView=(TextView)view.findViewById(R.id.tv_sonuc);
           textView.setText(veri);
       }
       return view;
   }
   public void  onActivityCreated(@Nullable Bundle savedInstanceState)
   {
       super.onActivityCreated(savedInstanceState);
       sonuc=(TextView)getActivity().findViewById(R.id.tv_sonuc);

   }
   public void  yzyDgst(String geleVeri)
   {
       this.veri=geleVeri;
       sonuc.setText(veri);

   }
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("verikey",veri);
    }

}
