package e.asus.azaproject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editLogin,editPassword;
    Button regBtn,loginBtn;
    TextView forgotPassword;

    DBHelper dbHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Database connecting
        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(DBHelper.DB_1TABLE,null,"_id = ? AND NAME = ?",new String[]{"2","on"},null,null,null,null);
        if(cursor.moveToFirst()){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }
        setContentView(R.layout.activity_login);

        editLogin = (EditText)findViewById(R.id.editTextForLoginUser);
        editPassword = (EditText)findViewById(R.id.editTextForLoginPassword);

        loginBtn = (Button)findViewById(R.id.buttonForLogin);
        regBtn = (Button)findViewById(R.id.goToRegistration);
        forgotPassword = (TextView)findViewById(R.id.forgotPassword);


        forgotPassword.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
        regBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.buttonForLogin:
                Cursor cursor = db.query(DBHelper.USERS_TABLE,null," NAME = ? AND PASSWORD = ?",
                        new String[]{editLogin.getText().toString(),editPassword.getText().toString()},null,null,null);
                if(cursor.moveToFirst()){
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("NAME","on");
                    db.update(DBHelper.DB_1TABLE,contentValues,"_id=?",new String[]{"2"});
                    intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                }else Toast.makeText(this, "Нет пользователь с такими данными", Toast.LENGTH_SHORT).show();

                break;
            case R.id.goToRegistration:
                intent = new Intent(getApplicationContext(),RegistrationActivity.class);
                startActivity(intent);
                break;
            case R.id.forgotPassword:

                break;
        }

    }
}
