package com.jo.multiapp;

import other.ActivityFive;
import other.ActivitySix;
import other.AppBgcolor;
import ticTacToe.ActivityFour;
import dailySelfie.ActivitySeven;
import dancingBalls.ActivityTwo;
import discoLights.ActivityThree;
import glowingSketchPad.ActivityOne;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	// String for LogCat documentation
	private final static String TAG = "MainActivity";
	static private final int GET_TEXT_REQUEST_CODE = 1;

    //Called when the activity is first created.
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Emit LogCat message
		Log.i(TAG, "Entered the onCreate() method, MainActivity");
    	setContentView(R.layout.activity_main);
    	
    	//Toast.makeText(MainActivity.this, "Please Click 'Disco Lights'!", Toast.LENGTH_LONG).show();
    	//Toast.makeText(MainActivity.this, "Also don't forget to Click 'Options-Settings'!", Toast.LENGTH_LONG).show();
    	//Toast.makeText(MainActivity.this, "Thank You!", Toast.LENGTH_LONG).show();
    	   	
    	findViewById(R.id.ActivityOne).setOnClickListener(this);
    	findViewById(R.id.ActivityTwo).setOnClickListener(this);
    	findViewById(R.id.ActivityThree).setOnClickListener(this);
    	findViewById(R.id.ActivityFour).setOnClickListener(this);
    	findViewById(R.id.ActivityFive).setOnClickListener(this);
    	findViewById(R.id.ActivitySix).setOnClickListener(this);
    	findViewById(R.id.ActivitySeven).setOnClickListener(this);
     }
     
     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
 		// Inflate the menu; this adds items to the action bar if it is present.
 		 getMenuInflater().inflate(R.menu.main, menu);
 		 return true;
 	 }
     
     @Override
     public boolean onOptionsItemSelected(MenuItem item) {
 		// Handle action bar item clicks here.
 		 int id = item.getItemId();
 		 if (id == R.id.action_settings) {
    		 Intent explicitIntent = new Intent(getBaseContext(), SettingsActivity.class);
    		 startActivityForResult(explicitIntent,GET_TEXT_REQUEST_CODE);
 		 }
 		 else if (id == R.id.About) {
 			 showAbout();
 			 }
 		 return super.onOptionsItemSelected(item);
 	 }  
     
     @Override
     public void onClick(View v) {
    	 switch (v.getId())
    	 {
    	 case R.id.ActivityOne:
    		 Intent intent1 = new Intent(this, ActivityOne.class);
    		 startActivity(intent1);
    		 break;
    	 case R.id.ActivityTwo:
    		 Intent intent2 = new Intent(this, ActivityTwo.class);
    		 startActivity(intent2);
    		 break;
    	 case R.id.ActivityThree:
    		 Intent intent3 = new Intent(this, ActivityThree.class);
    		 startActivity(intent3);
    		 break;
    	 case R.id.ActivityFour:
    		 Intent intent4 = new Intent(this, ActivityFour.class);
    		 startActivity(intent4);
    		 break;
    	 case R.id.ActivityFive:
    		 Intent intent5 = new Intent(this, ActivityFive.class);
    		 startActivity(intent5);
    		 break;
    	 case R.id.ActivitySix:
    		 Intent intent6 = new Intent(this, ActivitySix.class);
    		 startActivity(intent6);
    		 break;
    	 case R.id.ActivitySeven:
    		 Intent intent7 = new Intent(this, ActivitySeven.class);
    		 startActivity(intent7);
    		 break;
    	 }
     }
     
     private void showAbout() {
    	 LinearLayout rootabt = (LinearLayout)findViewById(R.id.about_linlay);
 		 View dialogView = this.getLayoutInflater().inflate(R.layout.about, rootabt);
 		 final AlertDialog dialog = new AlertDialog.Builder(this).setView(dialogView).create();

 		 TextView visitGoogle = (TextView) dialogView.findViewById(R.id.visit_google);
 		 visitGoogle.setOnClickListener(new OnClickListener() {
 			 @Override
 			 public void onClick(View arg0) {
 				 dialog.dismiss();
 				 Intent i = new Intent(Intent.ACTION_VIEW);
 				 i.setData(Uri.parse("https://uk.linkedin.com/in/joelfsequeira"));
 				 startActivity(i);
 			 }
 		 });
 		 TextView notNow = (TextView) dialogView.findViewById(R.id.not_now);
 		 notNow.setOnClickListener(new OnClickListener() {
 			 @Override
 			 public void onClick(View arg0) {
 				 dialog.dismiss();
 			 }
 		 });
 		 dialog.show();
 	 }
     
     @Override
     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	 Log.i(TAG, "Entered onActivityResult()");
    	 // Process the result only if this method received both
 		 // a RESULT_OK result code and a recognised request code
    	 if (requestCode == GET_TEXT_REQUEST_CODE) {
    		 // Make sure the request was successful
    		 if (resultCode == RESULT_OK) {		 
    			 RelativeLayout root = (RelativeLayout)findViewById(R.id.textView0);
    			 TextView root1 = (TextView)findViewById(R.id.textView1);
    			 AppBgcolor.setActBgcolor(root, root1);
    	     }
    	 }
    }
}
