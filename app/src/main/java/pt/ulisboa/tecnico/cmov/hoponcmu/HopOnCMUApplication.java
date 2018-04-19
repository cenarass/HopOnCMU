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

    //List<LoginIntentKey> loginList= Arrays.asList(LoginIntentKey.values());
    List<LoginIntentKey> loginList=new ArrayList<LoginIntentKey>();

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
}
