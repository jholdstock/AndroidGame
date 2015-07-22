package com.jh.multiplayergame.ui;

import org.andengine.util.color.Color;

import com.jh.multiplayergame.C;
import com.jh.multiplayergame.TimeCounter;

public abstract class Countdown
{
	private final float X = 900; 
	private final float Y =  C.SCREEN_HEIGHT / 2.0f;
	private final float SCALE = 1.5f;
	private final Color COLOR = Color.RED;
	private final int COUNTDOWN_LENGTH = 3;
	
	private TextPair tp;
	
	public Countdown()
	{
		tp = new TextPair("" + COUNTDOWN_LENGTH, X, Y);
		tp.setScale(SCALE);
		tp.setColor(COLOR);
		
		countdown(COUNTDOWN_LENGTH);
	}
	
	public void countdown(int remaining)
	{
		if (remaining > 0)
		{
			final int i = remaining - 1;
			new TimeCounter(0.8f)
			{
				public void onFinish()
				{
					tp.setText("" + i);
					countdown(i);
				}
			};
		}
		else
		{
			tp.setText("GO!");
			new TimeCounter(0.5f)
			{
				public void onFinish()
				{
					tp.setText("");
					tp.detachFromScene(C.SCENE);
					countdownFinish();
				}
			};
		}
	}

	public abstract void countdownFinish();
}