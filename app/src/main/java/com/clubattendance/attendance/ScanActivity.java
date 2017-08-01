package com.clubattendance.attendance;

/* ------------------------- IMPORTS ------------------------- */

// Android Imports
import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import java.io.IOException;
import java.util.Scanner;

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
    private CameraSource cameraSource; // Access the camera from the
    // recognition library

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
        TextRecognizer textRecognizer = new TextRecognizer.Builder
                (getApplicationContext()).build(); // Pass in current context as
        // param

        // Log if recognizer cannot run
        if (!textRecognizer.isOperational())
            Log.w(TAG + " - ScanActivity", "Text recognition dependency not " +
                    "available.");
        else {
            // Set up the camera source to process frames
            cameraSource = new CameraSource.Builder(getApplicationContext(),
                    textRecognizer)
                    .setFacing(CameraSource.CAMERA_FACING_BACK)
                    .setRequestedPreviewSize(1280, 1024) // Will set best
                    // matching if not able to set 1280x1024
                    .setRequestedFps(2.0f)
                    .setAutoFocusEnabled(true)
                    .build();

            // Add callback handler for the surfaceView
            surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
                @Override
                public void surfaceCreated(SurfaceHolder surfaceHolder) {
                    try {
                        // Add permission checker (not sure if needed to
                        // check for API level 22 and below
                        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest
                                .permission.CAMERA) != PackageManager
                                .PERMISSION_GRANTED) {

                            // Request permission first if not granted
                            ActivityCompat.requestPermissions(ScanActivity
                                    .this, new String[]{Manifest.permission
                                    .CAMERA}, REQUEST_IMG_CAPTURE);
                            return;
                        }

                        cameraSource.start(surfaceView.getHolder());

                    } catch (IOException e) {

                    }
                }

                /**
                 * Called when any changes have been made to the surface view
                 * including format or size.
                 *
                 * @param surfaceHolder
                 *      The surface holder whose surface has changed
                 * @param format
                 *      The PixelFormat of the surface.
                 * @param width
                 *      The width of the surface.
                 * @param height
                 *      The heght of the surface
                 */
                @Override
                public void surfaceChanged(SurfaceHolder surfaceHolder, int
                        format, int width, int height) {

                }

                @Override
                public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                    cameraSource.stop(); // Stop further processing
                }
            });

            // Set up the recognition part of the app
            textRecognizer.setProcessor(new Detector.Processor<TextBlock>() {
                @Override
                public void release() {

                }

                @Override
                public void receiveDetections(Detector.Detections<TextBlock> detections) {
                    // Get all the chunks of text detected
                    final SparseArray<TextBlock> items = detections
                            .getDetectedItems();

                    // Check if any text was detected
                    if (items.size() != 0) {
                        textView.post(new Runnable() {
                            @Override
                            public void run() {
                                StringBuilder stringBuilder = new
                                        StringBuilder();
                                for (int i = 0; i < items.size();  ++i) {
                                    TextBlock item = items.valueAt(i); // Get
                                    // textblock at index (this represents
                                    // like a paragraph)
                                    // https://developers.google
                                    // .com/vision/text-overview
                                    stringBuilder.append(item.getValue());
                                    stringBuilder.append("\n");
                                }

                                textView.setText(stringBuilder.toString());
                            }
                        });
                    }
                }
            });
        }
    }

    /* ------------------------- HELPER METHODS ------------------------- */
    // Handle permission access
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[]
            permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_IMG_CAPTURE:
                if ((grantResults.length > 0) && (grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED)) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest
                            .permission.CAMERA) != PackageManager
                            .PERMISSION_GRANTED) {
                        return;
                    }

                    try {
                        cameraSource.start(surfaceView.getHolder());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }
    }
}
