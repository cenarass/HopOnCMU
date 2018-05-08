package pt.ulisboa.tecnico.cmov.hoponcmu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    HopOnCMUApplication _hopOnApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        _hopOnApp = (HopOnCMUApplication) getApplicationContext();



        Intent intent = getIntent();
        if(intent.hasExtra(LoginIntentKey.USERNAME.toString()) && intent.hasExtra(LoginIntentKey.CODE.toString())) {
            ((EditText) findViewById(R.id.username_txt)).setText(intent.getStringExtra(LoginIntentKey.USERNAME.toString()));
            ((EditText) findViewById(R.id.code_txt)).setText(intent.getStringExtra(LoginIntentKey.CODE.toString()));
        } else {
            SharedPreferences sharedPreferences = getSharedPreferences(SharedPreferenceKey.USERNAME.toString(), Context.MODE_PRIVATE);
            String username = sharedPreferences.getString(SharedPreferenceKey.USERNAME.toString(), Constant.INVALID_VALUE),
                    password = sharedPreferences.getString(SharedPreferenceKey.CODE.toString(), Constant.INVALID_VALUE);

            if(username != null && password != null &&
                    !username.equals(Constant.INVALID_VALUE) &&
                    !password.equals(Constant.INVALID_VALUE)) {
                ((EditText) findViewById(R.id.username_txt)).setText(username);
                ((EditText) findViewById(R.id.code_txt)).setText(password);
            }
        }

    }


    public void loginBtnClicked(View view) throws JSONException {

       //Get login values
        EditText usernameEditText = (EditText) findViewById(R.id.username_txt),
                passwordEditText = (EditText) findViewById(R.id.code_txt);
        String usernameValue = usernameEditText.getText().toString(),
                passwordValue = passwordEditText.getText().toString();

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
        UserRequest userRequest = UserRequest.LOGIN;
        JSONObject message = new JSONObject();
        message.put(NetworkKey.REQUEST_TYPE.toString(), userRequest.ordinal());
        message.put(NetworkKey.USERNAME.toString(), usernameValue);
        message.put(NetworkKey.PASSWORD.toString(), passwordValue);

        ClientProxy clientProxy = new ClientProxy(userRequest, NetworkMsg.LOGIN , message);
        new Thread(clientProxy).start();



        //Save login fields
        SharedPreferences sharedPreferences = getSharedPreferences(SharedPreferenceKey.USERNAME.toString(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(SharedPreferenceKey.USERNAME.toString(), usernameValue);
        editor.putString(SharedPreferenceKey.CODE.toString(), passwordValue);

        editor.apply();


        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra(LoginIntentKey.USERNAME.toString(), usernameValue);
        intent.putExtra(LoginIntentKey.CODE.toString(), passwordValue);

        startActivityForResult(intent, ApplicationOperationsCode.LOGIN.ordinal());

    }

    public void SignUpBtnClicked(View view) {
        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);
    }



}
