package dailySelfie;

import java.text.DateFormat;
import java.util.Date;

import com.jo.multiapp.R;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class ActivitySeven_AlarmSelfie  extends BroadcastReceiver {
	// Notification ID to allow for future updates
	private static final int MY_NOTIFICATION_ID = 11;
	private static final String TAG = "AlarmSelfie";

	// Notification Text Elements
	private final CharSequence tickerText = "It's time for a Selfie";
	private final CharSequence contentTitle = "Daily Selfie";
	private final CharSequence contentText = "Let's take your Daily Selfie";

	// Notification Action Elements
	private Intent mNotificationIntent;
	private PendingIntent mContentIntent;

	// Notification Sound and Vibration on Arrival
	private final Uri soundURI = Uri
			.parse("android.resource://course.examples.Alarms.AlarmCreate/"
					+ R.raw.alarm_rooster);
	private final long[] mVibratePattern = { 0, 200, 200, 300 };

	@Override
	public void onReceive(Context context, Intent intent) {

		// The Intent to be used when the user clicks on the Notification View
		mNotificationIntent = new Intent(context, ActivitySeven.class);

		// The PendingIntent that wraps the underlying Intent
		mContentIntent = PendingIntent.getActivity(context, 0,
				mNotificationIntent, 0);

		// Build the Notification
		Notification.Builder notificationBuilder = new Notification.Builder(
				context)
                .setSmallIcon(android.R.drawable.ic_menu_camera)
				.setAutoCancel(true)
                .setContentTitle(contentTitle)
				.setContentText(contentText)
                .setContentIntent(mContentIntent)
				.setSound(soundURI)
                .setVibrate(mVibratePattern)
                .setTicker(tickerText);

		// Get the NotificationManager
		NotificationManager mNotificationManager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);

		// Pass the Notification to the NotificationManager:
		mNotificationManager.notify(MY_NOTIFICATION_ID,
				notificationBuilder.build());

		// Log occurence of notify() call
		Log.i(TAG, "Sending notification at:"
				+ DateFormat.getDateTimeInstance().format(new Date()));

	}
}