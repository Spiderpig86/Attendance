package com.clubattendance.attendance.activities;

/* ------------------------- IMPORTS ------------------------- */

// Android Imports
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

// Java Imports
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

// Project Imports
import com.clubattendance.attendance.R;

/* ------------------------- CLASS DEFINITION ------------------------- */

public class HomeActivity extends AppCompatActivity {


    /* ------------------------- DATA & VARS ------------------------- */

    // Constants
    private static final String TAG = HomeActivity.class.getSimpleName();

    // Display Vars
    private Button mainButton;


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

        // bind the display vars
        mainButton = (Button) findViewById(R.id.main_button);

        // determine what the button should display
        determineExistingSession();

    }



    /* ------------------------- HELPER METHODS ------------------------- */

    private void determineExistingSession(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdyFormat = new SimpleDateFormat("MM-dd-yyyy");
        String strDate = mdyFormat.format(calendar.getTime());
        String fileName = strDate + ".json";
        File file = new File(this.getFilesDir(), fileName);
        if (file.exists()){
            try {
                // change the main button accordingly; do we open the file and pass it along?
            } catch(Exception e){
                // do nothing
            }
        }
        else {
            // create a new file
        }
    }
}
