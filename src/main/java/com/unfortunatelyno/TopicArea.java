package com.unfortunatelyno;

public class TopicArea {
    // Instance Variables
    int unit;
    String title;
    float weight;
    // Constructors
    public TopicArea(int u, String t, float w){
        unit = u;
        title = t;
        weight = w;
    }
    public TopicArea(int u, String t){
        unit = u;
        title = t;
    }
    // Methods
    public void setWeight(float w){
        weight = w;
    }
    public void setUnit(int u){
        unit = u;
    }
    public void setTitle(String t){
        title = t;
    }
    public String toString(){
        return unit + ": " + title +": " + weight;
    }
}
