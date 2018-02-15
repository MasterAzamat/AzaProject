package e.asus.azaproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Azaat on 14.02.2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static int DB_VERSION = 1;
    public static final String DB_NAME = "MyDatabase";
    public static final String FIRST_ENTER_TABLE = "firsttable";

    public static final String KEY_ID = "_id";
    public static final String FIRST_ENTER = "first_enter";



    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String a = "CREATE TABLE " + FIRST_ENTER_TABLE + " ("
                +KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +FIRST_ENTER+" INTEGER );";
        sqLiteDatabase.execSQL(a);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
