package com.clubattendance.attendance.activities;

/* ------------------------- IMPORTS ------------------------- */

// Android Imports
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

// Java Imports
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

// Project Imports
import com.clubattendance.attendance.R;
import com.clubattendance.attendance.fragments.*;

import org.json.JSONException;
import org.json.JSONObject;

/* ------------------------- CLASS DEFINITION ------------------------- */

public class HomeActivity extends AppCompatActivity {


    /* ------------------------- DATA & VARS ------------------------- */

    // Constants
    private static final String TAG = HomeActivity.class.getSimpleName();
    public static final String EXISTING_SESSION = "Continue?";

    // Logic & Data Vars
    private static JSONObject meetingData;

    // Fragment Vars
    private FragmentManager fragmentManager;
    private MenuFragment menuFragment;


    /* ------------------------- APP LIFECYCLE METHODS ------------------------- */
    /**
     * Required activity lifecycle method. Performs things that should only happen once, in the
     * beginning of the activity.
     * @param savedInstanceState the instance state containing prev details about this activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // sets the layout and calls the super's onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // setup the fragment vars
        fragmentManager = getSupportFragmentManager();
        menuFragment = new MenuFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, menuFragment);
        Bundle args = new Bundle();
        args.putBoolean(EXISTING_SESSION, determineExistingSession());
        menuFragment.setArguments(args);
        fragmentTransaction.commit();

    }



    /* ------------------------- HELPER METHODS ------------------------- */

    private boolean determineExistingSession(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdyFormat = new SimpleDateFormat("MM-dd-yyyy");
        String strDate = mdyFormat.format(calendar.getTime());
        String fileName = strDate + ".json";
        AssetManager assetManager = getAssets();
        InputStream inputStream = null;
        try {
            inputStream = assetManager.open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String json = new String(buffer, "UTF-8");
            meetingData = new JSONObject(json);
            return true;
        } catch (Exception ioe){
            meetingData = new JSONObject();
            return false;
        }
    }
}
