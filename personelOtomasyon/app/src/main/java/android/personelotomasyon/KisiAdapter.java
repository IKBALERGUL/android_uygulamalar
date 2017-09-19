package android.personelotomasyon;

import android.app.Activity;
import android.content.Context;
import android.personelotomasyon.Data.Kisi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lenovo on 2.07.2017.
 */

public class KisiAdapter  extends BaseAdapter {
    private LayoutInflater mInflater;

    private List<Kisi> mKisiListesi;

    public KisiAdapter(Activity activity, List<Kisi> kisiler) {

        this.mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mKisiListesi = kisiler;

    }

    @Override
    public int getCount() {
        return mKisiListesi.size();
    }

    @Override
    public Object getItem(int position) {
        return mKisiListesi.get(position);
    }

    @Override
    public long getItemId(int position) {

        Kisi kisi=mKisiListesi.get(position);

        return kisi.getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View kisilerLayoutView;

        //Boş bir View oluşturuyoruz kisiler_layout.xml layoutundan
        kisilerLayoutView = mInflater.inflate(R.layout.kisi_list_item, null);

        TextView isimTextView =
                (TextView) kisilerLayoutView.findViewById(R.id.tv_ad);

        TextView soyisimTextView =
                (TextView) kisilerLayoutView.findViewById(R.id.tv_soyad);


        //position ile listedeki kişi objesini alıyoruz
        Kisi kisi = mKisiListesi.get(position);

        //Boş olan View'in içindeki textview'e kişinin ismini atıyoruz
        isimTextView.setText(kisi.getAd());
        soyisimTextView.setText(kisi.getSoyad());

        return kisilerLayoutView;
    }
}
