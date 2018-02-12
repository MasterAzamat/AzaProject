package e.asus.azaproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editLogin,editPassword;

    Button regBtn,loginBtn;

    TextView forgotPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
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
