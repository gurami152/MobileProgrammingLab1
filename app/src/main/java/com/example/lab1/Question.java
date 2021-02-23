package com.example.lab1;

public class Question {

    private int mTextResId;
    private String mAnswerTrue;

    public Question(int textResId, String answerTrue) {
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
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
}
