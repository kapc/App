package com.example.ckap.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by ckap on 3/22/15.
 */
public class CrimeLab {
    // List of Crimes.
    private ArrayList<Crime> mCrimes;

    // Static Instance of the Singleton class.
    private static CrimeLab sCrimeLab;
    private Context mAppContext;

    // Context
    private CrimeLab(Context appContext) {
        mAppContext = appContext;
    }

    // Return the instance, if does not exist then create and
    // return it.
    public static CrimeLab get(Context c) {
        if(sCrimeLab == null) {
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }
        return sCrimeLab;
    }

    // Return the crime list.
    public ArrayList<Crime> getCrimes() {
        return mCrimes;
    }

    // Return the crime with this UUID.
    public Crime getCrime(UUID id) {
        for(Crime c: mCrimes) {
            if(c.getId().equals(id))
                return c;
        }
        return null;
    }
}
