package dailySelfie;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.jo.multiapp.R;

public class ActivitySeven_PhotosListAdapter extends BaseAdapter {

	private static final String TAG = "PhotoListAdapter";

	private static class ViewHolder {
		ImageView image;
		TextView fileName;
	}

	ViewHolder holder = new ViewHolder();
	private final List<ActivitySeven_PhotoRecord> mItems = new ArrayList<ActivitySeven_PhotoRecord>();
	private final Context mContext;

	public ActivitySeven_PhotosListAdapter(Context context) {
		mContext = context;
	}

	// Returns the number of mItem
	@Override
	public int getCount() {
		return mItems.size();
	}

	// Retrieve the number of ToDoItems
	@Override
	public Object getItem(int position) {
		return mItems.get(position);
	}

	// Get the ID for the mItem
	// In this case it's just the position
	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ActivitySeven_PhotoRecord currentRecord = mItems.get(position);

		LayoutInflater inflater = (LayoutInflater) mContext
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

		RelativeLayout itemLayout = (RelativeLayout) convertView;
		if (convertView == null) {
			itemLayout = (RelativeLayout) inflater.inflate(R.layout.activity_seven_selfie,
					parent, false);

			holder.image = (ImageView) itemLayout.findViewById(R.id.imageView);
			holder.fileName = (TextView) itemLayout.findViewById(R.id.textView);
			itemLayout.setTag(holder);
		}
		holder = (ViewHolder) itemLayout.getTag();
		holder.image.setImageBitmap(currentRecord.getmPhotoBitmap());
		holder.fileName.setText(currentRecord.getTimeStamp());
		return itemLayout;
	}

	private Bitmap setPic(String path) {
		BitmapFactory.Options bmOptions = new BitmapFactory.Options();
		int scaleFactor = 5;

		// Decode the image file into a Bitmap sized to fill the View
		bmOptions.inJustDecodeBounds = false;
		bmOptions.inSampleSize = scaleFactor;
		// bmOptions.inPurgeable = true;

		Bitmap bitmap = BitmapFactory.decodeFile(path, bmOptions);
		return bitmap;
	}

	public void addAllViews() {
		// File folder = new File("/storage/sdcard/DailySelfiePictures/");
		File folder = new File(Environment.getExternalStorageDirectory()
				.toString() + "/DailySelfiePictures");
		File[] fileList = folder.listFiles();

		if (fileList == null) {

		} else {
			for (int i = 0; i < fileList.length; i++) {
				String filePath = fileList[i].getAbsolutePath();
				String filename = fileList[i].getName();

				String fileTimestamp = filename.substring(5, 20);
				ActivitySeven_PhotoRecord listItem = new ActivitySeven_PhotoRecord();

				listItem.setmPhotoPath(filePath);
				Bitmap mbitmap = setPic(filePath);

				listItem.setmPhotoBitmap(mbitmap);
				listItem.setTimeStamp(fileTimestamp);
				add(listItem);
			}
		}
	}

	// Add a ToDoItem to the adapter
	// Notify observers that the data set has changed
	public void add(ActivitySeven_PhotoRecord item) {
		mItems.add(item);
		notifyDataSetChanged();
		Log.i(TAG, "List view updated");
	}

	public void deleteAllPics() {
		File file[] = getFileList();
		if (file.length > 0) {
			for (File f : file) {
				f.delete();
			}
		}
	}

	public void removeAllViews() {
		mItems.clear();
		this.notifyDataSetChanged();
	}

	private File[] getFileList() {
		String path = Environment.getExternalStorageDirectory().toString()
				+ "/DailySelfiePictures";
		File f = new File(path);
		if (f.exists()) {
			return f.listFiles();
		} else {
			f.mkdir();
			return new File[0];
		}
	}
}