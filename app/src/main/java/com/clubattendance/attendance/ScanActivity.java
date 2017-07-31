package com.clubattendance.attendance;

/* ------------------------- IMPORTS ------------------------- */

// Android Imports
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

// Java Imports

// Project Imports


/* ------------------------- CLASS DEFINITION ------------------------- */

public class ScanActivity extends AppCompatActivity {

    /* ------------------------- DATA & VARS ------------------------- */

    // Logic Vars
    public static final int REQUEST_IMG_CAPTURE = 1;

    // Display Vars
    private TextView capturedText;

    /* ------------------------- APP LIFECYCLE METHODS ------------------------- */

    @Override
    protected void onCreate(Bundle savedInstanceState){
        // always call the super onCreate and set view first
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_capture);

        // grab display vars
        capturedText = (TextView) findViewById(R.id.captured_text);
    }

    /* ------------------------- HELPER METHODS ------------------------- */

}
