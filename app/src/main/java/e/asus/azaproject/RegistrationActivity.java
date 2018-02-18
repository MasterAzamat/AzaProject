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
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener{

    Button regBtn;

    EditText editLogin,editPassword,editConfirmPassword;
    DBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        editLogin = (EditText)findViewById(R.id.editTextForRegUser);
        editPassword = (EditText)findViewById(R.id.editTextForRegPassword);
        editConfirmPassword = (EditText)findViewById(R.id.editTextForRegPassword);

        regBtn = (Button)findViewById(R.id.buttonForRegConfirm);
        regBtn.setOnClickListener(this);

        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.buttonForRegConfirm:
                if(editConfirmPassword.getText().toString().equals(editPassword.getText().toString())){
                    Cursor cursor = db.query(DBHelper.USERS_TABLE,null,"NAME = ?",new String[]{editLogin.getText().toString()},null,null,null);
                    if(!cursor.moveToFirst()){
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("NAME",editLogin.getText().toString());
                        contentValues.put("PASSWORD",editPassword.getText().toString());
                        db.insert(DBHelper.USERS_TABLE,null,contentValues);
                        intent = new Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }else Toast.makeText(this, "Пользователь уже есть", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(this, "Пороли не совпадают!", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.backToLogin:
                intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
