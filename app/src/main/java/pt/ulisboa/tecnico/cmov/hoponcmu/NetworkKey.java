package pt.ulisboa.tecnico.cmov.hoponcmu;

public enum NetworkKey {
    //Type keys
    REQUEST_TYPE,
    REPLY_TYPE,

    //Request Keys
    USERNAME,
    PASSWORD,
    COUNTRY,

    //Reply Keys
    USER_INFO,
    MONUMENT_LIST,
    QUIZ_LIST,
    QUESTION_LIST;

    public String toString() {
        return Integer.toString(this.ordinal());
    }

}
