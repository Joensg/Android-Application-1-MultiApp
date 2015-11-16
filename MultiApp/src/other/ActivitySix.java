package other;

import com.jo.multiapp.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ActivitySix extends Activity {
	// String for LogCat documentation
    private final static String TAG = "ActivitySix";
    
    
    @Override
	protected void onCreate(Bundle savedInstanceState) {
    	Log.i(TAG, "Entered the onCreate() method, ActivitySix");
    	super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_six);
		RelativeLayout root = (RelativeLayout)findViewById(R.id.actsix);
	    TextView root1 = (TextView)findViewById(R.id.textView1);
		AppBgcolor.setActBgcolor(root, root1);
		
        Button closeButton = (Button) findViewById(R.id.bClose2); 
	    closeButton.setOnClickListener(new OnClickListener() {
	    	@Override
	    	public void onClick(View v) {
	    		// Finish the Activity
	    		finish();
	    	}
	    });
     }
}