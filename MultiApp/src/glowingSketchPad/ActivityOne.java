package glowingSketchPad;

import other.AppBgcolor;

import com.jo.multiapp.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;

public class ActivityOne extends Activity {
	// String for LogCat documentation
    private final static String TAG = "ActivityOne";

	private CanvasView1 customCanvas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "Entered the onCreate() method, ActivityOne");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);

		customCanvas = (CanvasView1) findViewById(R.id.signature_canvas1);
		FrameLayout root = (FrameLayout)findViewById(R.id.actone);
		AppBgcolor.setActBgcolor(root);
		
		Button closeButton = (Button) findViewById(R.id.bClose12); 
	    closeButton.setOnClickListener(new OnClickListener() {
	    	@Override
	    	public void onClick(View v) {
	    		// Finish the Activity
	    		finish();
	    	}
	    });
	}

	public void clearCanvas(View v) {
		customCanvas.clearCanvas();
	}

}

