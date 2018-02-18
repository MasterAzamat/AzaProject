package e.asus.azaproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLClientInfoException;

/**
 * Created by Azaat on 16.02.2018.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static  int  DB_VERSION = 1;
    public static  String DB_NAME = "justwork";
    public static  String  DB_1TABLE = "FIRST";
    public static  String KEY_ID= "_id";

    public static String USERS_TABLE = "users_table";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+DB_1TABLE+" ("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT);");

        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME","off");
        sqLiteDatabase.insert(DB_1TABLE,null,contentValues);
        contentValues = new ContentValues();
        contentValues.put("NAME","off");
        sqLiteDatabase.insert(DB_1TABLE,null,contentValues);

        sqLiteDatabase.execSQL("CREATE TABLE "+USERS_TABLE+" ("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT,"+
                "PASSWORD TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
