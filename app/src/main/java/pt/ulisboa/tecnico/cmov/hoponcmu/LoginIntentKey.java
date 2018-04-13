package pt.ulisboa.tecnico.cmov.hoponcmu;

/**
 * Created by peolie on 13-04-2018.
 */

public enum LoginIntentKey {
    USERNAME,
    CODE;

    public String toString() {
        return Integer.toString(this.ordinal());
    }
}
