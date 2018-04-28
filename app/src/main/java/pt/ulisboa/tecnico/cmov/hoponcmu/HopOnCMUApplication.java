package pt.ulisboa.tecnico.cmov.hoponcmu;

import android.app.Application;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by peolie on 13-04-2018.
 */

public class HopOnCMUApplication extends Application {


    private String  mUsername = "";
    private String mCode = "";

    private ArrayList<String> mMonumentsList = new ArrayList<>();

    //Lista De Quizes e Mapa para as perguntas de cada Quiz
    private ArrayList<String> mQuizList = new ArrayList<>();
    private HashMap<String, ArrayList<String>> mQuestions = new HashMap<>();

    private ArrayList<String> mSubmitList = new ArrayList<>();


    public String getUsername() {
        return mUsername;
    }
    public void setUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getCode() {
        return mCode;
    }
    public void setCode(String mCode) {
        this.mCode = mCode;
    }

    public ArrayList<String> getMonumentsList() { return mMonumentsList; }
    public void setMonumentList(ArrayList<String> mMonumentsList) {
        this.mMonumentsList = mMonumentsList;    }


    public ArrayList<String> getQuizList() { return mQuizList; }
    public void setQuizList(ArrayList<String> mQuizList) {
        this.mQuizList = mQuizList;    }


    public HashMap<String, ArrayList<String>> getQuestions() { return mQuestions; }
    public void setQuestions(HashMap<String, ArrayList<String>> mQuestions) {
        this.mQuestions = mQuestions;
    }

    public ArrayList<String> getSubmitList() { return mSubmitList; }
    public void setSubmitList(ArrayList<String> mSubmitList) { this.mSubmitList = mSubmitList;
    }
}
