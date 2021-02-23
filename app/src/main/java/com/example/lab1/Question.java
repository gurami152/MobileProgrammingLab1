package com.example.lab1;

public class Question {

    private int mTextResId;
    private String mAnswerTrue;
    private boolean isAnswered;

    public Question(int textResId, String answerTrue, boolean isAnswered) {
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
        isAnswered = isAnswered;
    }

    public int getmTextResId() {
        return mTextResId;
    }

    public void setmTextResId(int mTextResId) {
        this.mTextResId = mTextResId;
    }

    public String ismAnswerTrue() {
        return mAnswerTrue;
    }

    public void setmAnswerTrue(String mAnswerTrue) {
        this.mAnswerTrue = mAnswerTrue;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }
}
