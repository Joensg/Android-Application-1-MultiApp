package ticTacToe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class CanvasView extends View {

	public int w;
	public int h;
	public int txtsize;
	private Bitmap mBitmap;
	@SuppressWarnings("unused")
	private Canvas mCanvas;
	private Path mPath;
	Context context;
	private Paint mPaint;
	private Paint mPaint1;
	private float mX, mY;
	
	private String turn = "X";
	private String info = "";
	private boolean won = false;
	private String[ ][ ] grid = 
		{
			{ " ", " ", " " }, 
			{ " ", " ", " " }, 
			{ " ", " ", " " }
		};

	public CanvasView(Context c, AttributeSet attrs) {
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
		
		mPaint1 = new Paint();
		mPaint1.setAntiAlias(true);
		mPaint1.setColor(Color.BLACK);
		mPaint1.setStyle(Style.FILL_AND_STROKE);
		mPaint1.setStrokeWidth(10f);
		
		mPaint1.setTextSize(txtsize);
		mPaint1.setTextAlign(Align.CENTER);
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
		//canvas.drawPath(mPath, mPaint);

		//Draws the grid lines
	    canvas.drawLine(0, h / 3, w, h/ 3, mPaint1);
	    canvas.drawLine(0, h / 3 * 2, w, h / 3 * 2, mPaint1);
	    canvas.drawLine(w / 3, 0, w / 3, h, mPaint1);
	    canvas.drawLine(w / 3 * 2, 0, w / 3 * 2, h, mPaint1);
	    
	    mPaint1.setTextSize(this.txtsize);
	     
	    //Draws the player choices using loops
	    for(int i=0; i<3; i++){
	    	for(int j=0; j<3; j++){
	            canvas.drawText(grid[i][j], (j * w / 3 + ((w / 3)/2)), (i * h / 3 + ((h / 3)/2)+(((h / 3)/2)/2)), mPaint1);
	        }
	    }
	    invalidate();
	}

	//when ACTION_DOWN start touch according to the x,y values
	private void startTouch(float x, float y) {
		mPath.moveTo(x, y);
		mX = x;
		mY = y;
		
		if (!won){
	        //Checks to see if the click was on a grid line
	        if ((mX % (w / 3) != 0) && (mY % (h / 3) != 0)){
	            int r = (int)(mY / (h / 3));
	            int c = (int)(mX / (w / 3));
	            //Checks to see if a square is already taken
	            if (grid[r][c] == " "){
	                grid[r][c] = turn;
	                if (check_win()){
	                    won = true;
	                    info = "Player " + turn + " wins!";
	                    //Toast.makeText(getContext(), info, Toast.LENGTH_SHORT).show();
	                    //to guide the user
	            	    Toast toast= Toast.makeText(getContext(), 
	            	    		info, Toast.LENGTH_SHORT);  
	            	    		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
	            	    		toast.show();
	                }
	                else{switch_turn();}
	            }
	        }
	     }
	}

	// when ACTION_UP stop touch
	private void upTouch() {
		mPath.lineTo(mX, mY);
	}

	//override the onTouchEvent
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
		case MotionEvent.ACTION_UP:
			upTouch();
			invalidate();
			break;
		}
		return true;
	}
	
	// Helper Functions for Tic-Tac-Toe
	public void switch_turn(){
	    if (turn == "X"){
	        turn = "O";}
	    else{
	        turn = "X";}
	    info = "Player turn: " + turn;
	    //Toast.makeText(getContext(), info, Toast.LENGTH_SHORT).show();
	    //to guide the user
	    Toast toast= Toast.makeText(getContext(), 
	    		info, Toast.LENGTH_SHORT);  
	    		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
	    		toast.show();
	}
	        
	//Returns 'True' if a player has won, false otherwise
	public boolean check_win(){
		for(int a=0; a<3; a++){
	        if ((grid[a][0] != " ") && (grid[a][0] == grid[a][1]) && (grid[a][0]== grid[a][2]) ){
	            return true;
	        }
		}
		for(int b=0; b<3; b++){
	        if ((grid[0][b] != " ") && (grid[0][b] == grid[1][b]) && (grid[0][b] == grid[2][b])){
	            return true;
	        }
		}
	    if ((grid[0][0] == grid[1][1]) && (grid[0][0] == grid[2][2]) && (grid[0][0] != " ")){
	        return true;
	    }
	    else if ((grid[0][2] == grid[1][1]) && (grid[0][2] == grid[2][0]) && (grid[0][2] != " ")){
	        return true;
	    }
	    else{
	        return false;
	    }
	}
}
