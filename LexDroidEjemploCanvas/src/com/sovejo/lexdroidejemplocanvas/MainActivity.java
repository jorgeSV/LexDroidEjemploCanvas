package com.sovejo.lexdroidejemplocanvas;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

public class MainActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		Vista vista = new Vista(this);
		setContentView(vista);
	}
	
	class Vista extends View
	{
		float x = 50;
		float y = 50;
		String accion = "Accion";
		Path path = new Path();
		
		public Vista(Context context) 
		{
			super(context);
			// TODO Auto-generated constructor stub
		}
		
		public void onDraw(Canvas canvas)
		{
			Paint paint = new Paint();
			paint.setStyle(Paint.Style.STROKE);
			paint.setStrokeWidth(10);
			paint.setColor(Color.RED);
			
			int ancho = canvas.getWidth();
			canvas.drawRect(20, 90, ancho - 20, 38, paint);
			
			if(accion == "Abajo")
				path.moveTo(x, y);
			
			if(accion == "Mover")
				path.lineTo(x, y);
			
			canvas.drawPath(path, paint);
		}
		
		public boolean onTouchEvent(MotionEvent e)
		{
			x = e.getX();
			y = e.getY();
			
			if(e.getAction() == MotionEvent.ACTION_DOWN)
				accion = "Abajo";
			
			if(e.getAction() == MotionEvent.ACTION_MOVE)
				accion = "Mover";
				
			invalidate();
			return true;
		}
	}

}
