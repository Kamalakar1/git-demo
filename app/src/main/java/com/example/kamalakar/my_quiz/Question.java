package com.example.kamalakar.my_quiz;

public class Question {
    int answerid;
    boolean isTrue;

    public Question(int answerid, boolean isTrue) {
        this.answerid = answerid;
        this.isTrue = isTrue;
    }

    public int getAnswerid() {
        return answerid;
    }

    public void setAnswerid(int answerid) {
        this.answerid = answerid;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }
}
