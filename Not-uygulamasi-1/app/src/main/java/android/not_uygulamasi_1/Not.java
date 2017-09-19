package android.not_uygulamasi_1;

/**
 * Created by lenovo on 8.07.2017.
 */

public class Not {
    private  String key;
    private  String baslik;
    private String detay;

    public Not(){

    }

    public Not(String key, String baslik, String detay) {
        this.key = key;
        this.baslik = baslik;
        this.detay = detay;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getDetay() {
        return detay;
    }

    public void setDetay(String detay) {
        this.detay = detay;
    }
}
