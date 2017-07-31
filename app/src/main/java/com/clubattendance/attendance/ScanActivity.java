package com.clubattendance.attendance;

/* ------------------------- IMPORTS ------------------------- */

// Android Imports
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.widget.TextView;

import com.google.android.gms.vision.text.TextRecognizer;

// Java Imports

// Project Imports


/* ------------------------- CLASS DEFINITION ------------------------- */

public class ScanActivity extends AppCompatActivity {

    /* ------------------------- DATA & VARS ------------------------- */

    // Constants
    public static final int REQUEST_IMG_CAPTURE = 1;
    private static final String TAG = ScanActivity.class.getSimpleName(); //
    // For debugging

    // Display Vars
    private SurfaceView surfaceView;
    private TextView textView;

    /* ------------------------- APP LIFECYCLE METHODS ------------------------- */

    @Override
    protected void onCreate(Bundle savedInstanceState){
        // always call the super onCreate and set view first
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        // Bind UI elements to vars
        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        textView = (TextView) findViewById(R.id.textView);

        // Create the text recognition engine
        TextRecognizer textRecognizer = new TextRecognizer().Builder
                (getApplicationContext()); // Pass in current context as param

        // Log if recognizer cannot run
        if (!textRecognizer.isOperational())
            Log.w(TAG + " - ScanActivity", "Text recognition dependency not " +
                    "available.");
    }

    /* ------------------------- HELPER METHODS ------------------------- */

}
