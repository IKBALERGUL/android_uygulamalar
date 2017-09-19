package android.personelotomasyon.Data;

import android.provider.BaseColumns;

/**
 * Created by lenovo on 21.06.2017.
 */


/**
 * Kontrat sınıfı:
 * Tablolar, sütunlar ve URI'ler için isim tanımlamaları yapan
 * sabitleri bulunduran taşıyıcı olarak düşünebiliriz.
 */

public class KisiContract  {

    /**
     * Tablo içeriklerini tanımlayan dahili sınıf
     */
    public static final class KisiEnty implements BaseColumns{

        // Sabit değişkenkerin tanımlanması
        public static final String TABLE_NAME="kisi";
        public static final String COLUM_AD="ad";
        public static final String COLUM_SOYAD="soyad";
        public static final String ID_KEY="idKey";
    }

}