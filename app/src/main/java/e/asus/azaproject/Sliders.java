package e.asus.azaproject;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

/**
 * Created by Yerkebulan on 11.02.2018.
 */

public class Sliders extends Activity implements View.OnClickListener  {
  public Button btn;
   public RadioButton rbtn_1,rbtn_2,rbtn_3;
    int count = 0;
    ImageView imageView,imageView2;
    SQLiteDatabase db;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        DBHelper dbHelper = new DBHelper(getApplicationContext());
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(DBHelper.DB_1TABLE,null,"_id = ? AND NAME = ?",new String[] {"1","on"},null,null,null,null);
        if(cursor.moveToFirst()){
            Intent intent = new Intent(Sliders.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
        setContentView(R.layout.slider);

        btn = (Button) findViewById(R.id.btnslider);
        btn.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.imageViewdale);

        rbtn_1 = (RadioButton) findViewById(R.id.rbtn_1);
        rbtn_2 = (RadioButton) findViewById(R.id.rbtn_2);
        rbtn_3 = (RadioButton) findViewById(R.id.rbtn_3);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnslider:
                count++;
                setImage(count);
                break;

        }
    }
    public void setImage(int count){
        if(count==1){
            rbtn_1.setChecked(false);
            rbtn_2.setChecked(true);
            rbtn_3.setChecked(false);
            imageView.setImageResource(R.drawable.slider2);
        }else if(count==2){
            rbtn_1.setChecked(false);
            rbtn_2.setChecked(false);
            rbtn_3.setChecked(true);
            imageView.setImageResource(R.drawable.slider3);
        }
        else if(count==3){
            ContentValues contentValues = new ContentValues();
            contentValues.put("NAME","on");
            db.update(DBHelper.DB_1TABLE,contentValues,"_id = ?",new String[]{"1"});
            Intent intent = new Intent(Sliders.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
