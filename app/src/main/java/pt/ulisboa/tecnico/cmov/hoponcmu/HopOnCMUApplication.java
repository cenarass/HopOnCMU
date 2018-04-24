package pt.ulisboa.tecnico.cmov.hoponcmu;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by peolie on 13-04-2018.
 */

public class HopOnCMUApplication extends Application {


    private String  mUsername = "";
    private String mCode = "";

    private ArrayList<String> mMonumentsList = new ArrayList<String>();
    private ArrayList<String> mQuizList = new ArrayList<String>();


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


}
