package com.jh.multiplayergame.ui;

import org.andengine.entity.sprite.Sprite;
import org.andengine.util.color.Color;

import com.jh.multiplayergame.C;
import com.jh.multiplayergame.Textures;

public class ColorArea
{	
	public Sprite area;
	public static final int X = 690;
	public static final int Y = 50;
	
	public ColorArea()
	{
		area = new Sprite(X, Y, Textures.questionAreaTexture, C.VMANAGER);
		C.SCENE.attachChild(area);
	}

	public void setColor(Color color)
	{
		area.setColor(color);
	}
}
