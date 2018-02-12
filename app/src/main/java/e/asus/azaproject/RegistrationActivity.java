package e.asus.azaproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener{

    Button regBtn;

    EditText editLogin,editPassword,editConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        editLogin = (EditText)findViewById(R.id.editTextForRegUser);
        editPassword = (EditText)findViewById(R.id.editTextForRegPassword);
        editConfirmPassword = (EditText)findViewById(R.id.editTextForRegPassword);

        regBtn = (Button)findViewById(R.id.buttonForRegConfirm);
        regBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.buttonForRegConfirm:
                intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.backToLogin:
                intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
