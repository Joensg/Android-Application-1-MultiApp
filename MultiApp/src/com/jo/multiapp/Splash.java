package com.jo.multiapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity {
	
	/** Duration of wait **/
    private int secondsDelayed = 1; //in seconds
    
    private static boolean splashLoaded = false;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        if (!splashLoaded) {
        	/* New Handler to start the Menu-Activity 
        	 * and close this Splash-Screen after some seconds.*/
        	new Handler().postDelayed(new Runnable() {
        		@Override
        		public void run() {
        			/* Create an Intent that will start the Menu-Activity. */
        			startActivity(new Intent(Splash.this, MainActivity.class));
        			finish();
        		}
        	}, secondsDelayed * 1000);
        	splashLoaded = true;
        }
        else {
            Intent goToMainActivity = new Intent(Splash.this, MainActivity.class);
            goToMainActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(goToMainActivity);
            finish();
        }
    }
}