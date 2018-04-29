
/*

This app mainly tests the usability of the android version of
the Lab Streaming Layer (LSL) library. It opens the LSL stream
and broadcasting random string markers.

Date: 29.04.2018
Collaborator(s): Allan C. Maheri, Sarah Blum
e-mail: acmaheri@outlook.com

 */




package lib.android.lsl;
import android.app.Activity;
import android.widget.TextView;
import android.os.Bundle;
import android.os.AsyncTask;

import java.io.IOException;

import edu.ucsd.sccn.LSL;

// IMPORTS FOR ANDROID SENSORS DATA
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;





public class lsltestApp extends Activity implements
        SensorEventListener {

    private static TextView tv;
    void showMessage(String string) {
        final String finalString = string;
        runOnUiThread(new Runnable(){
            @Override
            public void run(){
                tv.setText(finalString);
            }
        });
    }


    private TextView mXValueView, mYValueView, mZValueView;
    private long mLastUpdate;

    private String markertypes[] = { "TestEEG","TestECOG" ,"TestACC","TestMOTION", "TestVISUAL", "TestAUDIO", "TestSTIMULI", "TestPSYC", "Test-1-2-3"};







    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        tv = new TextView(this);
        showMessage( "Attempting to send LSL markers: ");
        setContentView(tv);


        AsyncTask.execute(new Runnable() {
            public void run() {
                System.out.println(LSL.local_clock());
                java.util.Random rand = new java.util.Random();
                showMessage("Creating a new StreamInfo...");
                LSL.StreamInfo info = new LSL.StreamInfo("MyMarkers","Markers",1,LSL.IRREGULAR_RATE,LSL.ChannelFormat.string,"myuid4563");

                showMessage("Creating an outlet...");
                LSL.StreamOutlet outlet = null;
                try {
                    outlet = new LSL.StreamOutlet(info);
                } catch(IOException ex) {
                    showMessage("Unable to open LSL outlet. Have you added <uses-permission android:name=\"android.permission.INTERNET\" /> to your manifest file?");
                    return;
                }




                // send random marker strings
                while (true) {
                    try{

                        final String mrk = markertypes[Math.abs(rand.nextInt()) % markertypes.length];
                        runOnUiThread(new Runnable(){
                            @Override
                            public void run(){
                                showMessage("Now sending: " + mrk);
                            }
                        });
                        String[] sample = new String[1];
                        sample[0] = mrk;
                        outlet.push_sample(sample);

                        Thread.sleep(100);

                    } catch (Exception ex) {
                        showMessage(ex.getMessage());
                        outlet.close();
                        info.destroy();
                    }

                }


            }
        });


    }


    // Register listener
    @Override
    protected void onResume() {
        super.onResume();
    }

    // Unregister listener
    @Override
    protected void onPause() {
        super.onPause();
    }



    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

