package com.example.ckap.criminalintent;

import java.util.UUID;

/**
 * Created by ckap on 3/21/15.
 */
public class Crime {
    private UUID mId;
    private String mTitle;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public UUID getId() {
        return mId;
    }

    public Crime() {
        // Generate unique identifier.
        mId = UUID.randomUUID();
    }
}
