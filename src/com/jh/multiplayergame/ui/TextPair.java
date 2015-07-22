package com.jh.multiplayergame.ui;

import org.andengine.entity.scene.Scene;
import org.andengine.util.color.Color;

import com.jh.multiplayergame.C;

class TextPair
{
	public Text2[] pair = new Text2[2];
	private float X;
	private float Y;
	private float SCALE = 1.0f;
	private Color COLOR = Color.WHITE;
	
	public TextPair(float x, float y)
	{
		this("", "", x, y);
	}
	
	public TextPair(String left, String right, float x, float y)
	{
		pair[0] = new Text2(left);
		pair[1] = new Text2(right);
		this.X = x;
		this.Y = y;
		setRotationAndPositionAndScaleAndColor();
	}
	
	public TextPair(String text, float x, float y)
	{
		this(text,text, x, y);
	}
	
	public void setOneText(int index, String text)
	{
		detachFromScene(C.SCENE);
		pair[index] = new Text2(text);
		int opponent = index == 1 ? 0 : 1;
		
		pair[opponent] = new Text2((String) pair[opponent].getText());
		setRotationAndPositionAndScaleAndColor();
	}
	
	public void setScale(float scale)
	{
		SCALE = scale;
		detachFromScene(C.SCENE);
		for(int i = 0; i < 2; i++)
		{
			pair[i] = new Text2((String) pair[i].getText());
		}
		setRotationAndPositionAndScaleAndColor();
	}
	
	public void setText(String text)
	{
		detachFromScene(C.SCENE);
		for(int i = 0; i < 2; i++)
		{
			pair[i] = new Text2(text);
		}
		setRotationAndPositionAndScaleAndColor();
	}
	
	public void detachFromScene(Scene scene)
	{
		for(Text2 t : pair)
		{
			scene.detachChild(t);
		}
	}
	
	private void setRotationAndPositionAndScaleAndColor()
	{
		pair[0].setRotation(90.0f);
		setTextPosition(pair[0], X, Y);
		pair[0].setScale(SCALE);
		pair[0].setColor(COLOR);
		
		pair[1].setRotation(270.0f);
		setTextPosition(pair[1], C.SCREEN_WIDTH - X,  C.SCREEN_HEIGHT - Y);
		pair[1].setScale(SCALE);
		pair[1].setColor(COLOR);
	}
	
	public void setTextPosition(Text2 text, float x, float y)
	{
		float width = text.getWidth() / 2;
		float height = text.getHeight() / 2;
		text.setPosition(x - width, y - height);
	}

	public void setColor(Color color)
	{
		COLOR = color;
		detachFromScene(C.SCENE);
		for(int i = 0; i < 2; i++)
		{
			pair[i] = new Text2((String) pair[i].getText());
		}
		setRotationAndPositionAndScaleAndColor();
	}
}
