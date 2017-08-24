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

// JSON Imports
import org.json.JSONObject;

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
    private Button mainButton, scanButton, editButton, exportButton;

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
        scanButton = (Button) inflatedView.findViewById(R.id.scanButton);
        editButton = (Button) inflatedView.findViewById(R.id.editButton);
        exportButton = (Button) inflatedView.findViewById(R.id.exportButton);

        // change the main button accordingly
        Bundle args = getArguments();
        changeMainButton(args.getBoolean(HomeActivity.EXISTING_SESSION));

        return inflatedView;
    }


    /* ----------------------- DISPLAYING INPUT METHODS ----------------------- */

    private void changeMainButton(boolean existingSession){
        if (existingSession){
            mainButton.setText(getString(R.string.menufrag_continue));
        }
        else {
            mainButton.setText(getString(R.string.menufrag_new));
        }
        mainButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mainButton.setVisibility(View.GONE);
                scanButton.setVisibility(View.VISIBLE);
                editButton.setVisibility(View.VISIBLE);
                exportButton.setVisibility(View.VISIBLE);
            }
        });
    }


    /* ----------------------- GRABBING INPUT METHODS ----------------------- */



}
