package pt.ulisboa.tecnico.cmov.hoponcmu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import static pt.ulisboa.tecnico.cmov.hoponcmu.R.id.country_id;

public class SignUpActivity extends AppCompatActivity {
    HopOnCMUApplication _hopOnApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        _hopOnApp = (HopOnCMUApplication) getApplicationContext();

    }

    public void SignUpBtnClicked(View view) throws JSONException {
        //Get sign up values
        EditText usernameEditText = (EditText) findViewById(R.id.new_username_txt),
                passwordEditText = (EditText) findViewById(R.id.new_code_txt);
        String usernameValue = usernameEditText.getText().toString(),
                passwordValue = passwordEditText.getText().toString();
        Spinner mySpinner = (Spinner) findViewById(R.id.country_id);
            String usercountry = mySpinner.getSelectedItem().toString();

        //Check if values exist
        if (usernameValue.equals("")){
            Toast.makeText(this," Nao colocou username",Toast.LENGTH_SHORT).show();
            return;
        }
        if (passwordValue.equals("")){
            Toast.makeText(this," Nao colocou password",Toast.LENGTH_SHORT).show();
            return;
        }


        // Request Message
        UserRequest userRequest = UserRequest.SIGN_UP;
        JSONObject message = new JSONObject();
        message.put(NetworkKey.REQUEST_TYPE.toString(), userRequest.ordinal());
        message.put(NetworkKey.USERNAME.toString(), usernameValue);
        message.put(NetworkKey.PASSWORD.toString(), passwordValue);
        message.put(NetworkKey.COUNTRY.toString(), usercountry);

        ClientProxy clientProxy = new ClientProxy(userRequest, NetworkMsg.SIGN_UP , message);
        new Thread(clientProxy).start();




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
