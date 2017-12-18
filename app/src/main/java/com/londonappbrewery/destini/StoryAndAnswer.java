package com.londonappbrewery.destini;

/**
 * Created by mdoomra on 18-12-2017.
 */

public class StoryAndAnswer {
    private int mStoryId;
    private Integer mAnswer1Id;
    private Integer mAnswer2Id;

    public StoryAndAnswer(int storyEnd){
        this.mStoryId = storyEnd;
        this.mAnswer1Id = null;
        this.mAnswer2Id = null;
    }

    public StoryAndAnswer(int storyId, Integer answer1Id, Integer answer2Id){
        this.mStoryId = storyId;
        this.mAnswer1Id = answer1Id;
        this.mAnswer2Id = answer2Id;
    }

    public int getStoryId() {
        return mStoryId;
    }

    public void setStoryId(int storyId) {
        mStoryId = storyId;
    }

    public Integer getAnswer1Id() {
        return mAnswer1Id;
    }

    public void setAnswer1Id(Integer answer1Id) {
        mAnswer1Id = answer1Id;
    }

    public Integer getAnswer2Id() {
        return mAnswer2Id;
    }

    public void setAnswer2Id(Integer answer2Id) {
        mAnswer2Id = answer2Id;
    }
}
