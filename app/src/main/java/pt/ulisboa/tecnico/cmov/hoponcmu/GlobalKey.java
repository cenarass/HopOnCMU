package pt.ulisboa.tecnico.cmov.hoponcmu;

public enum GlobalKey {
    USERNAME,
    CODE,
    COUNTRY,
    MONUMENTS_LIST,
    QUIZ_LIST,
    QUESTION_LIST,
    SUBMIT_LIST;

    public String toString() {
        return Integer.toString(this.ordinal());
    }
}
