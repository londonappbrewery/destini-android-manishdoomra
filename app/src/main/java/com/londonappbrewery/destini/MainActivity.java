package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mButtonTop;
    private Button mButtonBottom;
    private int mIndex = 1;
    private Map<Integer, Integer[]> path = new HashMap<>();
    private StoryAndAnswer[] storiesAndAnswers = {
                                                    new StoryAndAnswer(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
                                                    new StoryAndAnswer(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
                                                    new StoryAndAnswer(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
                                                    new StoryAndAnswer(R.string.T4_End),
                                                    new StoryAndAnswer(R.string.T5_End),
                                                    new StoryAndAnswer(R.string.T6_End)
                                                };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        path.put(new Integer(1), new Integer[]{3,2});
        path.put(new Integer(2), new Integer[]{3,4});
        path.put(new Integer(3), new Integer[]{6,5});

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button)findViewById(R.id.buttonTop);
        mButtonBottom = (Button)findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Destini","Top");
                updateTextViewAndButtons(true);
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Destini","Bottom");
                updateTextViewAndButtons(false);
            }
        });

    }

    private void updateTextViewAndButtons(boolean isTop){
        Log.d("Destini",mIndex+"");
        Integer[] arr = path.get(mIndex);
        if(arr!=null) {
            if (isTop) {
                mIndex = arr[0];
            } else {
                mIndex = arr[1];
            }
            Log.d("Destini",mIndex+"-"+arr[0]+"-"+arr[1]);
            mStoryTextView.setText(storiesAndAnswers[mIndex-1].getStoryId());
            if(storiesAndAnswers[mIndex-1].getAnswer1Id()!=null) {
                mButtonTop.setText(storiesAndAnswers[mIndex-1].getAnswer1Id());
            }else{
                mButtonTop.setVisibility(View.INVISIBLE);
            }
            if(storiesAndAnswers[mIndex-1].getAnswer2Id()!=null) {
                mButtonBottom.setText(storiesAndAnswers[mIndex-1].getAnswer2Id());
            }else{
                mButtonBottom.setVisibility(View.INVISIBLE);
            }
        }else{
            mStoryTextView.setText(storiesAndAnswers[mIndex-1].getStoryId());
            mButtonTop.setVisibility(View.INVISIBLE);
            mButtonBottom.setVisibility(View.INVISIBLE);
        }

    }
}
