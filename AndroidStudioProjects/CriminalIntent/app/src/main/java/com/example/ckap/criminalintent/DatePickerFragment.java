package com.example.ckap.criminalintent;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by ckap on 3/28/15.
 */
public class DatePickerFragment extends DialogFragment {

    /* Key value to be store for arguments. */
    public static final String EXTRA_DATE =
            "com.bignerdranch.android.criminalintent.date";
    public static final String TAG_TMP = "";

    private Date mDate;
    /*
    Creates new DatePickerFragment to manage the date dialog.
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mDate = (Date)getArguments().getSerializable(EXTRA_DATE);

        // Create a calandar to get the year, month, and day

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mDate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_date, null);

        DatePicker datePicker = (DatePicker)v.findViewById(R.id.dialog_date_datePicker);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Translate year month day into a Date object using a calendar.
                Log.d(TAG_TMP, "We were call once!");
                mDate = new GregorianCalendar(year, monthOfYear, dayOfMonth).getTime();

                // Update arguments to preserve selected value on rotation.
                getArguments().putSerializable(EXTRA_DATE, mDate);
            }
        });


        return new AlertDialog.Builder(getActivity()).
                setView(v).
                setTitle(R.string.date_picker_title).
                setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        sendResult(Activity.RESULT_OK);
                    }
                }).create();
    }

    /*
    Basically, Every crime will have some date set. Now when user clicks on the crime, and
    DatePickerFragment opens up. But DatePickFragment should show the default date to crime's
    original or current date. For that, instead of calling default constructor DatePickerFragment,
    we will call DatePickerFragment with crime's date, stash it into the arguments for later
    retrieval.
     */
    public static DatePickerFragment newInstance(Date date) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_DATE, date);

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void sendResult(int resultCode) {
        if(getTargetFragment() == null)
            return;

        Intent i = new Intent();
        i.putExtra(EXTRA_DATE, mDate);

        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, i);
    }
}
