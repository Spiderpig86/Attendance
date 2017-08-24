package com.clubattendance.attendance.fragments;

/* ----------------------------- IMPORTS ----------------------------- */

// Android Imports
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

// Java Imports
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

// JSON Imports
import org.json.JSONObject;

// Project Imports
import com.clubattendance.attendance.R;
import com.clubattendance.attendance.activities.HomeActivity;
import com.clubattendance.attendance.activities.ScanActivity;

/* ----------------------------- CLASS DEF ----------------------------- */

public class MenuFragment extends Fragment {

    /* ----------------------- VARIABLES ----------------------- */

    // Constants
    private static final String TAG = MenuFragment.class.getSimpleName();
    private static final int SCAN_REQUEST_MEMBERS = 1; // ID for scan activity

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

        bindControls(inflatedView);

        return inflatedView;
    }


    /* ----------------------- DISPLAYING INPUT METHODS ----------------------- */

    private void bindControls(View inflatedView) {
        // grab display vars
        mainButton = (Button) inflatedView.findViewById(R.id.mainButton);
        scanButton = (Button) inflatedView.findViewById(R.id.scanButton);
        editButton = (Button) inflatedView.findViewById(R.id.editButton);
        exportButton = (Button) inflatedView.findViewById(R.id.exportButton);

        // change the main button accordingly
        Bundle args = getArguments();
        changeMainButton(args.getBoolean(HomeActivity.EXISTING_SESSION));

        // Set listeners
        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ScanActivity.class); //
                // Intent to start the scan activity

                startActivityForResult(intent, SCAN_REQUEST_MEMBERS);
            }
        });
    }

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


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SCAN_REQUEST_MEMBERS) {
            Toast.makeText(getActivity(), data.getStringExtra("members"), Toast
                    .LENGTH_SHORT).show(); // Testing passing back data to this
            // activity
        }
    }
}
