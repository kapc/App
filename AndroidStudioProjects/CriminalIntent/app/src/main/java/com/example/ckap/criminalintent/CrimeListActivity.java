package com.example.ckap.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by ckap on 3/23/15.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected android.support.v4.app.Fragment createFragment() {
        return new CrimeListFragment();
    }
}
