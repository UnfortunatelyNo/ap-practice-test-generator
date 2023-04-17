package com.unfortunatelyno;

public class Test {
    // Instance Variables
    public String courseName;
    public int numQuestions;
    public int time;
    public TopicArea[] topics;
    // Constructors
    public Test(String crsName, int numQ, int t, TopicArea[] tpcs){
        courseName = crsName;
        numQuestions = numQ;
        topics = tpcs;
        time = t;
    }
    public Test(String crsName, int numQ){
        courseName = crsName;
        numQuestions = numQ;
    }
    public Test(){
    }
    // Methods
    public void setTopicArea(TopicArea[] tpcs){
        topics = tpcs;
    }
    public void setCourseName(String s){
        courseName = s;
    }
    public void setTime(int t){
        time = t;
    }
    public void setNumQuestions(int n){
        numQuestions = n;
    }
    public TopicArea[] getTopics() {
        return topics;
    }
    public String getCourseName() {
        return courseName;
    }
    public int getNumQuestions() {
        return numQuestions;
    }
    public int getTime() {
        return time;
    }
    public String toString(){
        String out = "[" + courseName + " " + numQuestions + " " + time +" ";
        if (topics != null) {
            for (TopicArea topic : topics) {
                out += topic.toString() + ", ";
            }
        }
        out += "]";
        return out;
    }
}
