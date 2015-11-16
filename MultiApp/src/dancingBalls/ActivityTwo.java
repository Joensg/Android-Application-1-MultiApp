package dancingBalls;

import other.AppBgcolor;

import com.jo.multiapp.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class ActivityTwo extends Activity {
	// String for LogCat documentation
    private final static String TAG = "ActivityTwo";

	private CanvasView2 customCanvas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "Entered the onCreate() method, ActivityTwo");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		customCanvas = (CanvasView2) findViewById(R.id.signature_canvas2);
		FrameLayout root = (FrameLayout)findViewById(R.id.acttwo);
		AppBgcolor.setActBgcolor(root);
		
		Button closeButton = (Button) findViewById(R.id.bClose23); 
	    closeButton.setOnClickListener(new OnClickListener() {
	    	@Override
	    	public void onClick(View v) {
	    		// Finish the Activity
	    		finish();
	    	}
	    });
	    
	    //to guide the user
	    Toast toast= Toast.makeText(getApplicationContext(), 
	    		"Click anywhere to add a dancing ball!", Toast.LENGTH_SHORT);  
	    		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
	    		toast.show();
	}
	
	public void addBall(View v) {
		customCanvas.addBall();
	}
	
	public void deleteBall(View v) {
		customCanvas.deleteBall();
	}

}
