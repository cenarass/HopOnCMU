package pt.ulisboa.tecnico.cmov.hoponcmu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import static pt.ulisboa.tecnico.cmov.hoponcmu.R.id.country_id;

public class SignUpActivity extends AppCompatActivity {
    HopOnCMUApplication _hopOnApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        _hopOnApp = (HopOnCMUApplication) getApplicationContext();

    }

    public void SignUpBtnClicked(View view) {
        //Get sign up values
        EditText usernameEditText = (EditText) findViewById(R.id.new_username_txt),
                passwordEditText = (EditText) findViewById(R.id.new_code_txt);
        String usernameValue = usernameEditText.getText().toString(),
                passwordValue = passwordEditText.getText().toString();
        Spinner mySpinner = (Spinner) findViewById(R.id.country_id);
            String usercountry = mySpinner.getSelectedItem().toString();




        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
        intent.putExtra(LoginIntentKey.USERNAME.toString(), usernameValue);
        intent.putExtra(LoginIntentKey.CODE.toString(), passwordValue);

        startActivityForResult(intent, ApplicationOperationsCode.SIGN_UP.ordinal());
    }

    public void LoginBtnClicked(View view) {
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



}
