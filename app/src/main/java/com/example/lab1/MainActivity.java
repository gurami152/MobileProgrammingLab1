package com.example.lab1;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPrevButton;
    private TextView mTextQuiz;
    private Question[] mQuestionBank;

    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextQuiz = findViewById(R.id.TextQuiz);
        mQuestionBank = new Question[]{
                new Question(R.string.question_1, this.getResources().getString(R.string.answer_1)),
                new Question(R.string.question_2, this.getResources().getString(R.string.answer_2)),
                new Question(R.string.question_3, this.getResources().getString(R.string.answer_3)),
                new Question(R.string.question_4, this.getResources().getString(R.string.answer_4))
        };
        updateQuestion();
        addListenerOnClickButtonTrueFalse();
    }

    public void addListenerOnClickButtonTrueFalse() {
        mTrueButton = findViewById(R.id.buttonTrue);
        mFalseButton = findViewById(R.id.buttonFalse);
        mNextButton = findViewById(R.id.buttonNext);
        mPrevButton = findViewById(R.id.buttonPrev);
        mTextQuiz = findViewById(R.id.TextQuiz);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer("ПРАВДА");
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer("НЕПРАВДА");
            }
        });
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                if (mCurrentIndex < 0) mCurrentIndex = mQuestionBank.length - 1;
                updateQuestion();
            }
        });
    }

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getmTextResId();
        mTextQuiz.setText(question);
        mTextQuiz.setTextColor(getResources().getColor(R.color.text));
    }

    private void checkAnswer(String userPressedTrue) {
        String  answerIsTrue = mQuestionBank[mCurrentIndex].ismAnswerTrue();
        int messageResId = 0;
        mTextQuiz.setText(mQuestionBank[mCurrentIndex].ismAnswerTrue());
        if (userPressedTrue.equals(answerIsTrue)) {
            mTextQuiz.setTextColor(getResources().getColor(R.color.right));
            messageResId = R.string.toast_true;
        } else {
            messageResId = R.string.toast_false;
            mTextQuiz.setTextColor(getResources().getColor(R.color.unright));
        }
        Toast toast = Toast.makeText(this, messageResId, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }
}