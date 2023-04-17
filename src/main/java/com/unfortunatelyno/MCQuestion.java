package com.unfortunatelyno;

public class MCQuestion {
    // Instance Variables:
    private String question;
    private MCAnswer[] answers = new MCAnswer[5];
    char correctAnswer;
    // Constructors:
    public MCQuestion(String q, String a, String b, String c, String d, String e, char cAns){
        question = q;
        answers[0] = new MCAnswer('A', a);
        answers[1] = new MCAnswer('B', b);
        answers[2] = new MCAnswer('C', c);
        answers[3] = new MCAnswer('D', d);
        answers[4] = new MCAnswer('E', e);
        correctAnswer = cAns;
    }
    // Methods
    public boolean verifyAns(char in){
        return in == correctAnswer;
    }
    public String toString(){
        return question + " " + answers[0] + " " + answers[1] + " " + answers[2] + " " + answers[3] + " " + answers[4];
    }
}
