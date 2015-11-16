package other;

import android.graphics.Color;
import android.graphics.Paint;

public class CustomBall {
	// Ball Properties
	public int ball_radius = 0;
    public int ball_pos[] = {0 ,0};
	private int ball_vel[] = {0 ,0};
	public Paint mPaint;
	
	//Ball Constructor
	public CustomBall(int ball_radius, int ball_pos[]){
		this.ball_radius = (ball_radius);
		this.ball_pos[0]= ball_pos[0];
		this.ball_pos[1]= ball_pos[1];
		this.BallRandomVel(ball_vel);	
	}
	
	// onSizeChanged, Update Ball Position
	public void BallSizechange(int w, int h){
		ball_pos[0] = w / 2;
		ball_pos[1] = h / 2;
	}
	
	//Set Ball Random Velocity
	public void BallRandomVel(int ball_vel[]){
		int n1 = (int)(Math.random() * 240 + 120);
		int n2 = (int)(Math.random() * 280 + 60);
		ball_vel[0] = n1/60;
		ball_vel[1] = n2/60;	
	}
	
	//Set Ball Color
	public void BallSetColor(int a1, int red1, int green1, int blue1){
		int a = a1;
	    int red = red1;
		int green = green1;
		int blue = blue1;
		mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setColor(Color.argb(a, red, green, blue));
		mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
		mPaint.setStrokeJoin(Paint.Join.ROUND);
		mPaint.setStrokeWidth(4f);
	}
	
	//Update Ball Position
	public void BallUpdatePos(int w, int h){
		ball_pos[0] += ball_vel[0];
	    ball_pos[1] += ball_vel[1];
	    
	  //reflect off of top, bottom, left or right hand side of canvas
	    if ((ball_pos[0] <= ball_radius)||(ball_pos[0] >= w-ball_radius)) {
	    	ball_vel[0] = - ball_vel[0];
	    }
	    else if ((ball_pos[1] <= ball_radius)||(ball_pos[1] >= h-ball_radius)){
	        ball_vel[1] = - ball_vel[1];
	    }
	}

}
