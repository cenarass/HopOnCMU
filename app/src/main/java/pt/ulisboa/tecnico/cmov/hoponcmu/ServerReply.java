package pt.ulisboa.tecnico.cmov.hoponcmu;

public enum ServerReply {
    SUCESS,

    //login
    WRONG_USER,
    WRONG_PASS,

    //sign up
    INVALID_USER,
    INVALID_PASS,
    ERROR, QUIZ_SUBMITED,
}
