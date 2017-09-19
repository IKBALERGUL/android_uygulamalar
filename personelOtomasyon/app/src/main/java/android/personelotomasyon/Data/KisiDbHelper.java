package android.personelotomasyon.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lenovo on 21.06.2017.
 */

public class KisiDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="kisiler.db";
    public static final int DATABASE_VERSION=1;

    public KisiDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_KISI_TABLE ="CREATE TABLE" + KisiContract.KisiEnty.TABLE_NAME+ "("+KisiContract.KisiEnty._ID+
                "INTEGER PRİMARY KEY  AUTOINCREMENT,"+
                KisiContract.KisiEnty.COLUM_AD+"TEXT NOT NULL,"+
                KisiContract.KisiEnty.COLUM_SOYAD+"TEXT NOT NULL);";
        db.execSQL(SQL_CREATE_KISI_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ KisiContract.KisiEnty.TABLE_NAME);
        onCreate(db);

    }
}
