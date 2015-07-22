package com.jh.multiplayergame.ui;

import org.andengine.util.color.Color;

import com.jh.multiplayergame.C;

public class GameText
{
	private final float X = C.SCREEN_WIDTH / 3;
	private final float Y = C.SCREEN_HEIGHT / 2;
	
	private TextPair tp;

	public GameText()
	{
		tp = new TextPair(X, Y);
	}
	
	public void setText(String text)
	{
		tp.setText(text);
	}
	
	public void setOneText(int index, String text)
	{
		tp.setOneText(index, text);
	}
	
	public void setColor(Color color)
	{
		tp.setColor(color);
	}

	public void setScale(float scale)
	{
		tp.setScale(scale);
	}
}
