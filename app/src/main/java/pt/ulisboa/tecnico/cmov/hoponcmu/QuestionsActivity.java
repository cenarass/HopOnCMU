package pt.ulisboa.tecnico.cmov.hoponcmu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        HashMap<String, ArrayList<String>> Questions = (HashMap<String,ArrayList<String>>) intent.getSerializableExtra(GlobalKey.QUESTION_LIST.toString());

        ArrayList<String> s = Questions.get(QuizKey);

        question1.setText(s.get(0));
        question2.setText(s.get(1));
        question3.setText(s.get(2));
    }

    public void SubmitBtnClicked(View view) {
        Intent thisintent = getIntent();
        ArrayList<String> SubmitList = thisintent.getStringArrayListExtra(GlobalKey.SUBMIT_LIST.toString());
        String QuizKey = thisintent.getStringExtra("Selected Value");

//        if (SubmitList.contains(QuizKey)){
//            Toast.makeText(this,"Quiz já submetido, vá a scores para ver como correu " + QuizKey ,Toast.LENGTH_SHORT).show();
//            return ;
//        }else{

        Toast.makeText(this, "A Submeter Quiz de " + QuizKey, Toast.LENGTH_SHORT).show();
        SubmitList.add(QuizKey);
        mHopOnCMUApplication.setSubmitList(SubmitList);

        Intent intent = new Intent(QuestionsActivity.this, MainActivity.class);
        intent.putExtra(GlobalKey.SUBMIT_LIST.toString(), mHopOnCMUApplication.getSubmitList());
        intent.putExtra(GlobalKey.QUIZ_LIST.toString(), mHopOnCMUApplication.getQuizList());
        startActivity(intent);
    //  }
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
