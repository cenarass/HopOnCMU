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
import java.util.HashMap;

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
        Intent thisintent= getIntent();
        ArrayList<String> quizes = thisintent.getStringArrayListExtra(GlobalKey.QUIZ_LIST.toString());
        ArrayList<String> SubmitList = thisintent.getStringArrayListExtra(GlobalKey.SUBMIT_LIST.toString());

        if (SubmitList.contains(quizes.get(position))) {
            Toast.makeText(this,"Quiz de "+ quizes.get(position) +"já submetido, vá a scores para ver como correu "  ,Toast.LENGTH_SHORT).show();
            return ;
        }else{
            Intent intent = new Intent(QuizActivity.this, QuestionsActivity.class);
            intent.putExtra(GlobalKey.USERNAME.toString(), mHopOnCMUApplication.getUsername());
            intent.putExtra(GlobalKey.CODE.toString(), mHopOnCMUApplication.getCode());
            intent.putExtra(GlobalKey.QUESTION_LIST.toString(), mHopOnCMUApplication.getQuestions());
            intent.putExtra(GlobalKey.SUBMIT_LIST.toString(), mHopOnCMUApplication.getSubmitList());
            intent.putExtra("Selected Value", quizes.get(position));
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
