package pt.ulisboa.tecnico.cmov.hoponcmu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    HopOnCMUApplication mHopOnCMUApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHopOnCMUApplication = (HopOnCMUApplication)getApplicationContext();


        Intent intent = getIntent();
        String usernameValue = intent.getStringExtra(LoginIntentKey.USERNAME.toString());
        Toast.makeText(this,usernameValue,Toast.LENGTH_SHORT).show();
        String passwordValue = intent.getStringExtra(LoginIntentKey.CODE.toString());
        Toast.makeText(this,passwordValue,Toast.LENGTH_SHORT).show();



        bindService(
                new Intent(MainActivity.this, HopOnService.class),
                wifiServiceConn,
                Context.BIND_AUTO_CREATE);

    }

    public void listMonumentsBtnClicked(View view){

        // HardCoded Value
        ArrayList<String> monuments = new ArrayList<String>();
        monuments.add("convento de mafra");
        monuments.add("torre de belem");
        monuments.add("estadio da luz");
        monuments.add("marques de pombal");
        Intent intent1 = getIntent();
        String usernameValue = intent1.getStringExtra(LoginIntentKey.USERNAME.toString());
        String passwordValue = intent1.getStringExtra(LoginIntentKey.CODE.toString());

        Intent intent = new Intent(MainActivity.this, MonumentActivity.class);
        intent.putExtra(GlobalKey.USERNAME.toString(), usernameValue);
        intent.putExtra(GlobalKey.CODE.toString(), passwordValue);
        intent.putExtra(GlobalKey.MONUMENTS_LIST.toString(), monuments);
        startActivity(intent);
    }

    public void scoreBtnClicked(View view){
        Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(wifiServiceConn);
    }

    private HopOnService wifiService = null;
    private HopOnService.WifiBinder wifiBinder = null;
    private ServiceConnection wifiServiceConn = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {

            wifiBinder = (HopOnService.WifiBinder) service;
            wifiService = wifiBinder.getService();

            wifiService.setMainActivity(MainActivity.this);

            wifiService.setUsername(mHopOnCMUApplication.getUsername());


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


}
