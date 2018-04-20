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

    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monument);



        //Cria o List view
        mListView = (ListView) findViewById(R.id.monument_list_id);
// 1// 2


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
        Log.i("HelloListView", "You clicked Item: " + id + " at position:" + position);
        // Then you start a new Activity via Intent
        Toast.makeText(this," Sucessoooo",Toast.LENGTH_SHORT).show();
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
