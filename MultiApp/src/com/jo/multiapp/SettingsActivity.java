package com.jo.multiapp;

import other.AppBgcolor;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class SettingsActivity extends Activity {
	// String for LogCat documentation
    private final static String TAG = "ActivitySettings";
    SeekBar seekBar1, seekBar2, seekBar3, seekBar4;
    TextView tv1, tv2, tv3, tv4;
    private int dispprog1, dispprog2, dispprog3, dispprog4, a, red, green, blue;    
    
    @Override
	protected void onCreate(Bundle savedInstanceState) {
    	Log.i(TAG, "Entered the onCreate() method, ActivitySettings");
    	super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		
		seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
		seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
		seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
		seekBar4 = (SeekBar) findViewById(R.id.seekBar4);
		
		tv1 = (TextView)findViewById(R.id.percent1);
		tv2 = (TextView)findViewById(R.id.percent2);
		tv3 = (TextView)findViewById(R.id.percent3);
		tv4 = (TextView)findViewById(R.id.percent4);
		
		TableLayout root = (TableLayout)findViewById(R.id.table1);
	    TextView root1 = (TextView)findViewById(R.id.rowtext1);
	    TextView root2 = (TextView)findViewById(R.id.rowtext2);
	    TextView root3 = (TextView)findViewById(R.id.rowtext3);
	    TextView root4 = (TextView)findViewById(R.id.rowtext4);
	    
	    AppBgcolor.setActBgcolor(root, root1, root2, root3, root4, tv1, tv2, tv3, tv4);
		
		a = AppBgcolor.getColor("a");
		red = AppBgcolor.getColor("red");
		green = AppBgcolor.getColor("green");
		blue = AppBgcolor.getColor("blue");
		
	    seekBar1.setProgress(a);
	    seekBar2.setProgress(red);
	    seekBar3.setProgress(green);
	    seekBar4.setProgress(blue);
	    
	    dispprog1 = (int)((a/255.0)*100);
	    tv1.setText(Integer.toString(dispprog1)+"%");
	    dispprog2 = (int)((red/255.0)*100);
	    tv2.setText(Integer.toString(dispprog2)+"%");
	    dispprog3 = (int)((green/255.0)*100);
	    tv3.setText(Integer.toString(dispprog3)+"%");
	    dispprog4 = (int)((blue/255.0)*100);
	    tv4.setText(Integer.toString(dispprog4)+"%");
	    				
		seekBar1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				a = progress;
				TableLayout root = (TableLayout)findViewById(R.id.table1);
				root.setBackgroundColor(Color.argb(a, red, green, blue));
				dispprog1 = (int)((progress/255.0)*100);
				tv1.setText(Integer.toString(dispprog1)+"%");
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}
		});
		
		seekBar2.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				red = progress;
				TableLayout root = (TableLayout)findViewById(R.id.table1);
				root.setBackgroundColor(Color.argb(a, red, green, blue));
				dispprog2 = (int)((progress/255.0)*100);
				tv2.setText(Integer.toString(dispprog2)+"%");
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}
		});
		
		seekBar3.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				green = progress;
				TableLayout root = (TableLayout)findViewById(R.id.table1);
				root.setBackgroundColor(Color.argb(a, red, green, blue));
				dispprog3 = (int)((progress/255.0)*100);
				tv3.setText(Integer.toString(dispprog3)+"%");
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}
		});
		
		seekBar4.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				blue = progress;
				TableLayout root = (TableLayout)findViewById(R.id.table1);
				root.setBackgroundColor(Color.argb(a, red, green, blue));
				dispprog4 = (int)((progress/255.0)*100);
				tv4.setText(Integer.toString(dispprog4)+"%");
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}
		});
		
        Button closeButton = (Button) findViewById(R.id.bSetsettings); 
	    closeButton.setOnClickListener(new OnClickListener() {
	    	@Override
	    	public void onClick(View v) {
	    		// Create a new intent
	    		Intent backtomain = new Intent();
	    		
	    		AppBgcolor.setColor("a", a);
	    		AppBgcolor.setColor("red", red);
	    		AppBgcolor.setColor("green", green);
	    		AppBgcolor.setColor("blue", blue);
	    		
	    		// Set Activity's result with result code RESULT_OK
	    		SettingsActivity.this.setResult(RESULT_OK, backtomain);
	
	    		// Finish the Activity
	    		finish();
	    	}
	    });
     }
}
