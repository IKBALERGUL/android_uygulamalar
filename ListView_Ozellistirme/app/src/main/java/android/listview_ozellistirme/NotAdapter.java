package android.listview_ozellistirme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lenovo on 8.07.2017.
 */

public class NotAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    ArrayList<Not> notListesi;

    public NotAdapter(Context context, ArrayList<Not> notListesi){
        layoutInflater=(LayoutInflater) context.getSystemService(
                context.LAYOUT_INFLATER_SERVICE
        );
        this.notListesi=notListesi;
    }
    @Override
    public int getCount() {
        return notListesi.size();
    }

    @Override
    public Object getItem(int position) {
        return notListesi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View satirView;

        satirView=layoutInflater.inflate(R.layout.listeiew_satir_tasarim,null);
        TextView tvBaslik=(TextView) satirView.findViewById(R.id.tv_baslik);
        TextView tvDEtay=(TextView) satirView.findViewById(R.id.tv_detay);
        Not not= notListesi.get(position);
        tvBaslik.setText(not.getBaslik());
        tvDEtay.setText(not.getDetay());
        return satirView;
    }
}
