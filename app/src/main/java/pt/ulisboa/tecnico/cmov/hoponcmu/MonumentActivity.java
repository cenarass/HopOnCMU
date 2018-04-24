package pt.ulisboa.tecnico.cmov.hoponcmu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MonumentActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    HopOnCMUApplication mHopOnCMUApplication;

    private ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monument);

        mHopOnCMUApplication = (HopOnCMUApplication) getApplicationContext();

        //Cria o List view e o adaptador

        mListView = (ListView) findViewById(R.id.monument_list_id);
        ListView listview = (ListView) findViewById(R.id.monument_list_id);
        Intent intent=getIntent();
        if (intent.hasExtra(GlobalKey.MONUMENTS_LIST.toString())) {
            ArrayList<String> monuments = intent.getStringArrayListExtra(GlobalKey.MONUMENTS_LIST.toString());
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, monuments);
            listview.setOnItemClickListener(this);
            listview.setAdapter(adapter);
        }
        //
    }

    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        Toast.makeText(this," Downloading Quiz " + id + " at position:" + position ,Toast.LENGTH_SHORT).show();

        // "" Downloading Selected Quiz ""
        Intent intent1 = getIntent();
        ArrayList<String> monuments = intent1.getStringArrayListExtra(GlobalKey.MONUMENTS_LIST.toString());
        String QUIZ = monuments.get(position);


        ArrayList<String> aux = mHopOnCMUApplication.getQuizList();
        aux.add(QUIZ);

        mHopOnCMUApplication.setQuizList(aux);

        Intent intent = new Intent(MonumentActivity.this, MainActivity.class);
        intent.putExtra(GlobalKey.USERNAME.toString(),mHopOnCMUApplication.getUsername());
        intent.putExtra(GlobalKey.CODE.toString(), mHopOnCMUApplication.getCode());
        intent.putExtra(GlobalKey.MONUMENTS_LIST.toString(), mHopOnCMUApplication.getMonumentsList());
        intent.putExtra(GlobalKey.QUIZ_LIST.toString(), mHopOnCMUApplication.getQuizList());
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
