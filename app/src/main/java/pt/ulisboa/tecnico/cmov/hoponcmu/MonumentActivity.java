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
import java.util.HashMap;
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

        Intent intent1 = getIntent();

        ArrayList<String> currentQuizList = mHopOnCMUApplication.getQuizList();
        HashMap<String, ArrayList<String>> QuestionList= mHopOnCMUApplication.getQuestions();
        ArrayList<String> monuments = intent1.getStringArrayListExtra(GlobalKey.MONUMENTS_LIST.toString());

        String QUIZKey = monuments.get(position);

        // ve-se quizes ja foi downloaded, se sim só manda toast, se nao adicioana e volta para main
        if (currentQuizList.contains(QUIZKey)) {
            Toast.makeText(this,"Quiz " + id + " already downloaded" ,Toast.LENGTH_SHORT).show();
        }else {
            // "" Downloading Seleced Quiz ""
            ArrayList<String> questions = new ArrayList<String>();
            questions.add("Pergunta 1 do " + QUIZKey + "  ");
            questions.add("Pergunta 2 do "  + QUIZKey + "  ");
            questions.add("Pergunta 3 do" + QUIZKey + "  ");

            QuestionList.put( QUIZKey , questions);
            mHopOnCMUApplication.setQuestions( QuestionList );

            currentQuizList.add(QUIZKey);
            mHopOnCMUApplication.setQuizList(currentQuizList);

            Intent intent = new Intent(MonumentActivity.this, MainActivity.class);
            intent.putExtra(GlobalKey.USERNAME.toString(), mHopOnCMUApplication.getUsername());
            intent.putExtra(GlobalKey.CODE.toString(), mHopOnCMUApplication.getCode());
            intent.putExtra(GlobalKey.MONUMENTS_LIST.toString(), mHopOnCMUApplication.getMonumentsList());
            intent.putExtra(GlobalKey.QUIZ_LIST.toString(), mHopOnCMUApplication.getQuizList());
            intent.putExtra(GlobalKey.QUESTION_LIST.toString(), mHopOnCMUApplication.getQuestions());
            startActivity(intent);
        }
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
