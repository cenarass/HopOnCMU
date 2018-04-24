package pt.ulisboa.tecnico.cmov.hoponcmu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener {
    HopOnCMUApplication mHopOnCMUApplication;

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mHopOnCMUApplication = (HopOnCMUApplication) getApplicationContext();

        //Cria o List view e o adaptador

        mListView = (ListView) findViewById(R.id.quiz_list_id);
        ListView listview = (ListView) findViewById(R.id.quiz_list_id);
        Intent intent=getIntent();
        if (intent.hasExtra(GlobalKey.QUIZ_LIST.toString())) {
            ArrayList<String> quizes = intent.getStringArrayListExtra(GlobalKey.QUIZ_LIST.toString());
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, quizes);
            listview.setOnItemClickListener(this);
            listview.setAdapter(adapter);
        }//
    }

    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        Toast.makeText(this," Abrir Quiz" + id + " at position:" + position ,Toast.LENGTH_SHORT).show();
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
