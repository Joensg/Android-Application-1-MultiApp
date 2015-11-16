package glowingSketchPad;

import java.util.Random;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CanvasView1 extends View {

	public int w;
	public int h;
	public int txtsize;
	private Bitmap mBitmap;
	@SuppressWarnings("unused")
	private Canvas mCanvas;
	private Path mPath;
	Context context;
	private Paint mPaint;
	private float mX, mY;
	private static final float TOLERANCE = 5;

	private final int interval = 400; // 10 miliSecond
    private Handler handler = new Handler();
    
    private int a = 255;
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    
    Random randomGenerator = new Random();
    
    
    Runnable runnable = new Runnable(){
    	public void run() {
        	//Toast.makeText(ActivityThree.this, "C'Mom no hands!", Toast.LENGTH_SHORT).show();

        	//change Brush Color
          
    	    red = randomGenerator.nextInt(256);
        	green = randomGenerator.nextInt(256);
        	blue = randomGenerator.nextInt(256);
        	    
        	mPaint.setARGB(a, red, green, blue);      
            
            handler.postDelayed(runnable, interval);
        }    
    };

	public CanvasView1(Context c, AttributeSet attrs) {
		super(c, attrs);
		context = c;

		// we set a new Path
		mPath = new Path();

		// and we set a new Paint with the desired attributes
		mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setColor(Color.BLACK);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setStrokeJoin(Paint.Join.ROUND);
		mPaint.setStrokeWidth(4f);

		//Update Brush Color at specified interval
		handler.postDelayed(runnable, interval);
	}

	// override onSizeChanged
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		this.w = w;
        this.h = h;
        this.txtsize = h/10+w/5;
		super.onSizeChanged(w, h, oldw, oldh);

		// your Canvas will draw onto the defined Bitmap
		mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
		mCanvas = new Canvas(mBitmap);
	}

	// override onDraw
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		//Draws user touch
		canvas.drawPath(mPath, mPaint);
	    invalidate();  
	}

	//when ACTION_DOWN start touch according to the x,y values
	private void startTouch(float x, float y) {
		mPath.moveTo(x, y);
		mX = x;
		mY = y;
	}

	//when ACTION_MOVE move touch according to the x,y values
	private void moveTouch(float x, float y) {
		float dx = Math.abs(x - mX);
		float dy = Math.abs(y - mY);
		if (dx >= TOLERANCE || dy >= TOLERANCE){
			mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
			mX = x;
			mY = y;
		}
	}

	public void clearCanvas() {
		mPath.reset();
		invalidate();
	}

	// when ACTION_UP stop touch
	private void upTouch() {
		mPath.lineTo(mX, mY);
	}

	//override the onTouchEvent
	@Override
	public boolean performClick (){
		super.performClick();
		return true;
	}
	
	
	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			startTouch(x, y);
			invalidate();
			break;
		case MotionEvent.ACTION_MOVE:
			moveTouch(x, y);
			invalidate();
			break;
		case MotionEvent.ACTION_UP:
			upTouch();
			invalidate();
			break;
		}
		return true;
	}
}
