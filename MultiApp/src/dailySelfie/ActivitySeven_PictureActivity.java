package dailySelfie;

import other.AppBgcolor;

import com.jo.multiapp.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ActivitySeven_PictureActivity  extends Activity {

	ImageView image;
	String mCurrentPhotoPath;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seven_image_activity);
		
		LinearLayout root = (LinearLayout)findViewById(R.id.linView1);
		AppBgcolor.setActBgcolor(root);
		
		if (getIntent().hasExtra("byteArray")) {
			mCurrentPhotoPath = (String) getIntent().getStringExtra("fileName");
			image = (ImageView) findViewById(R.id.imageView2);
			Bitmap b = BitmapFactory.decodeByteArray(getIntent()
					.getByteArrayExtra("byteArray"), 0, getIntent()
					.getByteArrayExtra("byteArray").length);
			image.setImageBitmap(b);
		}
	}
}	