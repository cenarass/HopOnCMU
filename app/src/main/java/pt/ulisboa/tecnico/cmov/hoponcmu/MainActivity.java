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

public class MainActivity extends AppCompatActivity {

    HopOnCMUApplication mHopOnCMUApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHopOnCMUApplication = (HopOnCMUApplication)getApplicationContext();


        Intent intent = getIntent();
        String s = intent.getStringExtra(LoginIntentKey.USERNAME.toString());

        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();

        bindService(
                new Intent(MainActivity.this, HopOnService.class),
                wifiServiceConn,
                Context.BIND_AUTO_CREATE);

    }

    public void listMonumentsBtnClicked(View view){
        Intent intent = new Intent(MainActivity.this, MonumentActivity.class);
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
