package discoLights;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
//import android.widget.Toast;
import android.graphics.Color;

import java.util.Random;

import com.jo.multiapp.R;

public class ActivityThree extends Activity {
	// String for LogCat documentation
    private final static String TAG = "ActivityThree";
    //private final int interval = 1000; // 1 Second
    private final int interval = 400; // 10 miliSecond
    private Handler handler = new Handler();
    
    private int a = 1;
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    
    Runnable runnable = new Runnable(){
        public void run() {
            //Toast.makeText(ActivityThree.this, "C'Mom no hands!", Toast.LENGTH_SHORT).show();
            Random randomGenerator = new Random();
    		
    	    a = randomGenerator.nextInt(256)+125;
    	    red = randomGenerator.nextInt(256);
    	    green = randomGenerator.nextInt(256);
    	    blue = randomGenerator.nextInt(256);
    	    
    	    FrameLayout root = (FrameLayout)findViewById(R.id.Frame1);
    		root.setBackgroundColor(Color.argb(a, red, green, blue));
    	    
            handler.postDelayed(runnable, interval);
        }    
    };
      
    @Override
	protected void onCreate(Bundle savedInstanceState) {
    	Log.i(TAG, "Entered the onCreate() method, ActivityTwo");
    	super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_three);
		
		// Emit LogCat message
		Log.i(TAG, "Entered the onCreate() method, ActivityTwo");
		
		Random randomGenerator = new Random();
		
	    a = randomGenerator.nextInt(256);
	    red = randomGenerator.nextInt(256);
	    green = randomGenerator.nextInt(256);
	    blue = randomGenerator.nextInt(256);
	    
	    //handler.postAtTime(runnable, System.currentTimeMillis()+interval);
        handler.postDelayed(runnable, interval); 
		
		FrameLayout root = (FrameLayout)findViewById(R.id.Frame1);
		root.setBackgroundColor(Color.argb(a, red, green, blue));
			
        Button closeButton = (Button) findViewById(R.id.bClose3); 
	    closeButton.setOnClickListener(new OnClickListener() {
	    	@Override
	    	public void onClick(View v) {
	    		// Finish the Activity
	    		handler.removeCallbacks(runnable);
	    		finish();
	    	}
	    });
     }
    
    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }   
}
