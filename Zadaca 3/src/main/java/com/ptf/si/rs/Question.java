package com.ptf.si.rs;

import java.util.List;

public class Question {
    public String timestamp;
    public String question;
    public List<Answer> answers;
    public int question_num;

    public Question() {

    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public int getQuestion_num() {
        return question_num;
    }

    public void setQuestion_num(int question_num) {
        this.question_num = question_num;
    }

    @Override
    public String toString() {
        String ispisPitanja = "";
        ispisPitanja += question + "\n";
        for(Answer a : answers) ispisPitanja += a.toString();
        return ispisPitanja;
    }
}
