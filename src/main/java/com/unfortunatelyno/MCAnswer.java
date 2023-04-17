package com.unfortunatelyno;

import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class MCAnswer {
    // Instance Variables
    private String content;
    private char letter;
    private PDImageXObject img; // Unimplemented
    // Constructors
    public MCAnswer (char l, String c){
        content = c;
        letter = l;
    }
    public MCAnswer (char l, PDImageXObject i){
        letter = l;
        img = i;
    }
    // Methods
    public String getContent(){
        return content;
    }
    public char getLetter(){
        return letter;
    }
    public PDImageXObject getImage(){
        return img;
    }
    public String toString(){
        return letter + ": " + content;
    }
}
