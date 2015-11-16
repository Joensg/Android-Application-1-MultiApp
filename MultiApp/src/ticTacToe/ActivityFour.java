package ticTacToe;

import other.AppBgcolor;

import com.jo.multiapp.R;
import com.jo.multiapp.R.id;
import com.jo.multiapp.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;

@SuppressWarnings("unused")
public class ActivityFour extends Activity {
	// String for LogCat documentation
    private final static String TAG = "ActivityFour";

	private CanvasView customCanvas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "Entered the onCreate() method, ActivityFour");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_four);

		customCanvas = (CanvasView) findViewById(R.id.signature_canvas);
		FrameLayout root = (FrameLayout)findViewById(R.id.actfour);
		AppBgcolor.setActBgcolor(root);
		
		Button closeButton = (Button) findViewById(R.id.bClose44); 
	    closeButton.setOnClickListener(new OnClickListener() {
	    	@Override
	    	public void onClick(View v) {
	    		// Finish the Activity
	    		finish();
	    	}
	    });
	}
}