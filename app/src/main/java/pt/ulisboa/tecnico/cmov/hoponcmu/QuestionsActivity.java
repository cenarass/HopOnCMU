package pt.ulisboa.tecnico.cmov.hoponcmu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class QuestionsActivity extends AppCompatActivity {
    HopOnCMUApplication mHopOnCMUApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        mHopOnCMUApplication = (HopOnCMUApplication) getApplicationContext();

    }

    @Override
    protected void onStart() {
        super.onStart();
        TextView question1 = (TextView) findViewById(R.id.question1_id);
        TextView question2 = (TextView) findViewById(R.id.question2_id);
        TextView question3 = (TextView) findViewById(R.id.question3_id);

        Intent intent = getIntent();
        String QuizKey = intent.getStringExtra("Selected Value");
        ArrayList<String> quizes = intent.getStringArrayListExtra(GlobalKey.QUIZ_LIST.toString());
        HashMap<String, ArrayList<String>> Questions = (HashMap<String,ArrayList<String>>) intent.getSerializableExtra(GlobalKey.QUESTION_LIST.toString());

        ArrayList<String> s = Questions.get(QuizKey);

        question1.setText(s.get(0));
        question2.setText(s.get(1));
        question3.setText(s.get(2));
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
