package other;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.graphics.Color;

public class AppBgcolor {
	private static int a = 1;
	private static int red = 0;
	private static int green = 0;
	private static int blue = 0; 

	//getter
	public static int getColor(String field)
	{
	    if(field == "a"){
	    	return a;
	    }
	    else if(field == "red"){
	    	return red;
	    }
	    else if(field == "green"){
	    	return green;
	    }
	    else if(field == "blue"){
	    	return blue;
	    }
	    else{
	    	return 0;
	    }
	}
	
	//setter
	public static void setColor(String field, int value)
	{
		if(field == "a"){
			AppBgcolor.a = value;
	    }
		else if(field == "red"){
			AppBgcolor.red = value;
	    }
	    else if(field == "green"){
	    	AppBgcolor.green = value;
	    }
	    else if(field == "blue"){
	    	AppBgcolor.blue = value;
	    }
	}
	
	public static void setActBgcolor(RelativeLayout root, TextView root1, TextView root2){
		root.setBackgroundColor(Color.argb(a, red, green, blue));
		root1.setTextColor(Color.argb(255, 0, 0, 0));
		root2.setTextColor(Color.argb(255, 0, 0, 0));
		 
		if ((a == 255) && (red == 0) && (green == 0) && (blue == 0) ){ 
			root1.setTextColor(Color.argb(255, 255, 255, 255));
			root2.setTextColor(Color.argb(255, 255, 255, 255));
		}
	}
	
	public static void setActBgcolor(RelativeLayout root, TextView root1){
		root.setBackgroundColor(Color.argb(a, red, green, blue));
		root1.setTextColor(Color.argb(255, 0, 0, 0));
		 
		if ((a == 255) && (red == 0) && (green == 0) && (blue == 0) ){ 
			root1.setTextColor(Color.argb(255, 255, 255, 255));
		}
	}
	
	public static void setActBgcolor(RelativeLayout root){
		root.setBackgroundColor(Color.argb(a, red, green, blue));
	}
	
	public static void setActBgcolor(LinearLayout root){
		root.setBackgroundColor(Color.argb(a, red, green, blue));
	}
	
	public static void setActBgcolor(CustomDrawableView root){
		root.setBackgroundColor(Color.argb(a, red, green, blue));
	}
	
	public static void setActBgcolor(FrameLayout root){
		root.setBackgroundColor(Color.argb(a, red, green, blue));
	}
	
	public static void setActBgcolor( 
			TableLayout root,
			TextView root1, TextView root2, TextView root3, TextView root4,
			TextView root5, TextView root6, TextView root7, TextView root8
			){
		root.setBackgroundColor(Color.argb(a, red, green, blue));
		root1.setTextColor(Color.argb(255, 0, 0, 0));
		root2.setTextColor(Color.argb(255, 0, 0, 0));
		root3.setTextColor(Color.argb(255, 0, 0, 0));
		root4.setTextColor(Color.argb(255, 0, 0, 0));
		root5.setTextColor(Color.argb(255, 0, 0, 0));
		root6.setTextColor(Color.argb(255, 0, 0, 0));
		root7.setTextColor(Color.argb(255, 0, 0, 0));
		root8.setTextColor(Color.argb(255, 0, 0, 0));
		 
		if ((a == 255) && (red == 0) && (green == 0) && (blue == 0) ){ 
			root1.setTextColor(Color.argb(255, 255, 255, 255));
			root2.setTextColor(Color.argb(255, 255, 255, 255));
			root3.setTextColor(Color.argb(255, 255, 255, 255));
			root4.setTextColor(Color.argb(255, 255, 255, 255));
			root5.setTextColor(Color.argb(255, 255, 255, 255));
			root6.setTextColor(Color.argb(255, 255, 255, 255));
			root7.setTextColor(Color.argb(255, 255, 255, 255));
			root8.setTextColor(Color.argb(255, 255, 255, 255));
		}
	}
}
