package com.clubattendance.attendance.fragments;

/* ----------------------------- IMPORTS ----------------------------- */

// Android Imports
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

// Java Imports
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


// Project Imports
import com.clubattendance.attendance.R;
import com.clubattendance.attendance.activities.HomeActivity;


/* ----------------------------- CLASS DEF ----------------------------- */

public class MenuFragment extends Fragment {

    /* ----------------------- VARIABLES ----------------------- */

    // Constants
    private static final String TAG = MenuFragment.class.getSimpleName();

    // Logic & Data Vars
    private static boolean LOADED = false;
    private static JSONObject meetingData;

    // Display Vars
    private Button mainButton;

    // Fragment Vars

    /* ----------------------- FRAGMENT LIFECYCLE METHODS ----------------------- */
    /**
     * Required lifecycle method to create the view.
     * @param inflater              the layout inflater
     * @param container             the ViewGroup container
     * @param savedInstanceState    the instance state of the app
     * @return                      the inflated view
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View inflatedView = inflater.inflate(R.layout.fragment_menu, container, false);

        // grab display vars
        mainButton = (Button) inflatedView.findViewById(R.id.mainButton);

        // change the main button accordingly
        Bundle args = getArguments();
        changeMainButton(args.getBoolean(HomeActivity.EXISTING_SESSION));

        return inflatedView;
    }


    /* ----------------------- DISPLAYING INPUT METHODS ----------------------- */

    private void changeMainButton(boolean existingSession){
        if (existingSession){
        }
        else {

        }
    }



    /* ----------------------- GRABBING INPUT METHODS ----------------------- */



}
