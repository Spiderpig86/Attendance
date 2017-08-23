package com.clubattendance.attendance.activities;

/* ------------------------- IMPORTS ------------------------- */

// Android Imports
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.clubattendance.attendance.R;

// External Imports

// Java Imports

// Project Imports





/* ------------------------- CLASS DEFINITION ------------------------- */

public class LoginActivity extends AppCompatActivity{

    /* ------------------------- DATA & VARS ------------------------- */

    // LOGIC & DATA VARS
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    // UI VARS
    private EditText emailInput;
    private EditText passwordInput;
    private Button loginButton;
    private TextView signupLink;
    private ProgressDialog progressDialog;  // used for the loading bar thing :)


    /* ------------------------- APP LIFECYCLE METHODS ------------------------- */

    /**
     * Required activity lifecycle method. Performs things that should only happen once, in the
     * beginning of the activity.
     * @param savedInstanceState the instance state containing prev details about this activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        // always call the super onCreate and set view first
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // bind data vars to UI elements
        emailInput = (EditText) findViewById(R.id.input_email);
        passwordInput = (EditText) findViewById(R.id.input_password);
        loginButton = (Button) findViewById(R.id.button_login);
        signupLink = (TextView) findViewById(R.id.link_signup);

        // format what the loading bar will look like
        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(getString(R.string.logging_in));

        // set listener for the login button
        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                login(view);
            }
        });

        // set listener for the sign up link textview
        signupLink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // start the signup activity
                Intent signupIntent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(signupIntent,REQUEST_SIGNUP);
            }
        });

    }


    /* ------------------------- HELPER METHODS ------------------------- */

}
