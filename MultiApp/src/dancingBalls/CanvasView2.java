package dancingBalls;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import other.CustomBall;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

@SuppressLint("ClickableViewAccessibility")
public class CanvasView2 extends View {

	public int w;
	public int h;
	public int txtsize;
	private Bitmap mBitmap;
	@SuppressWarnings("unused")
	private Canvas mCanvas;
	Context context;
	private Paint mPaint;
	
	private int ball_pos[] = {80, 80};
	
	//Array List of Balls
	private int count = 0;
	
	private int count1 = 0;
	
	private List<CustomBall> BallList = new ArrayList<CustomBall>();
	//CustomBall newBall;
	
	
	private final int interval = 400; // 10 miliSecond
    private Handler handler = new Handler();
    
    private int a = 255;
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    
    Random randomGenerator = new Random();
     
    Runnable runnable = new Runnable(){
    	public void run() {
        	while(count>=1){
        		CustomBall newBall = new CustomBall((int)(Math.random() * 60 + 20), ball_pos);
        		newBall.BallSetColor(255, 255, 0, 0);
        		//newBall.BallSizechange(w, h); 
        		BallList.add(newBall);
        		count = count -1;
        		count1 = count1 +1;
        	}
        	//change Ball Color

    	    for (CustomBall newBall : BallList){           
    	    	red = randomGenerator.nextInt(256);
        	    green = randomGenerator.nextInt(256);
        	    blue = randomGenerator.nextInt(256);
        	    
        	    newBall.BallSetColor(a, red, green, blue);      
            }
            handler.postDelayed(runnable, interval);
        }    
    };

	public CanvasView2(Context c, AttributeSet attrs) {
		super(c, attrs);
		context = c;

		// we set a new Paint with the desired attributes
		mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setColor(Color.BLACK);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setStrokeJoin(Paint.Join.ROUND);
		mPaint.setStrokeWidth(4f);

		//Create a new Ball
		/*
		CustomBall newBall = new CustomBall((int)(Math.random() * 60 + 20), ball_pos);
		newBall.BallSetColor(255, 255, 0, 0);
		BallList.add(newBall);
		*/

		//Update Ball Colors at specified interval
		handler.postDelayed(runnable, interval);
	}

	// override onSizeChanged
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		this.w = w;
        this.h = h;
        this.txtsize = h/10+w/5;
        for (CustomBall newBall : BallList)
        {           
        	newBall.BallSizechange(w, h);       
        }
		super.onSizeChanged(w, h, oldw, oldh);

		// your Canvas will draw onto the defined Bitmap
		mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
		mCanvas = new Canvas(mBitmap);
	}

	// override onDraw
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		
	    //Update ball position
	    for (CustomBall newBall : BallList)
        {   
	    	newBall.BallUpdatePos(w, h);      
        }

	    //Draw ball   
	    for (CustomBall newBall : BallList)
        {   
	    	canvas.drawCircle(newBall.ball_pos[0], newBall.ball_pos[1], newBall.ball_radius, newBall.mPaint);
        } 

	    //update the view
		invalidate();
	}
	
	public void addBall() {
		count = count +1;
		invalidate();
	}
	
	public void deleteBall() {
		if(count1>0){
    		count1 = count1 -1;
    		BallList.remove(count1);
    	}
		invalidate();
	}
	
	//override the onTouchEvent
	@Override
	public boolean performClick (){
		super.performClick();
		return true;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		
		if(event.getAction()== MotionEvent.ACTION_DOWN){
			userTouch(x, y);
			invalidate();
		}
		return true;
	}
	
	//when ACTION_DOWN start touch according to the x,y values
		private void userTouch(float x, float y) {
			if(x>80 && x<w-80 && y>80 && y<h-80){
			ball_pos[0] = (int) x;
			ball_pos[1] = (int) y;
			}
			else if(x<80){
				ball_pos[0] = 80;
				ball_pos[1] = (int) y;
			}
			else if(x>w-80){
				ball_pos[0] = w-80;
				ball_pos[1] = (int) y;
		    }
			else if(y<80){
				ball_pos[0] = (int) x;
				ball_pos[1] = 80;
		    }
			else if(y>h-80){
				ball_pos[0] = (int) x;
				ball_pos[1] = h-80;
		    }
			addBall();
		}
}
