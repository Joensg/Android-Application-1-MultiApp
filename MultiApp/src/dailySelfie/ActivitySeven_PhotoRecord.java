package dailySelfie;

import android.graphics.Bitmap;

public class ActivitySeven_PhotoRecord {
	private Bitmap mPhotoBitmap;
	private String mPhotoPath;
	private String fileName;
	private String timeStamp;

	public ActivitySeven_PhotoRecord() {
	}

	public ActivitySeven_PhotoRecord(Bitmap mFlagBitmap, String mPhotoPath, String fileName,
			String timeStamp) {
		this.mPhotoBitmap = mFlagBitmap;
		this.mPhotoPath = mPhotoPath;
		this.fileName = fileName;
		this.timeStamp = timeStamp;
	}

	public String getFileName() {
		return fileName;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Bitmap getmPhotoBitmap() {
		return mPhotoBitmap;
	}

	public void setmPhotoBitmap(Bitmap mFlagBitmap) {
		this.mPhotoBitmap = mFlagBitmap;
	}

	public String getmPhotoPath() {
		return mPhotoPath;
	}

	public void setmPhotoPath(String mPhotoPath) {
		this.mPhotoPath = mPhotoPath;
	}
}