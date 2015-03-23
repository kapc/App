package com.example.ckap.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by ckap on 3/21/15.
 */
public class Crime {
    private UUID mId;
    private String mTitle;

    private Date mDate;
    private boolean mSolved;

    public Crime() {
        // Generate unique identifier.
        mId = UUID.randomUUID();
        mDate = new Date();
    }
    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public UUID getId() {
        return mId;
    }
}
