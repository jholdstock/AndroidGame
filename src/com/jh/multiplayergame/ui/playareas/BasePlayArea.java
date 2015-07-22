package com.jh.multiplayergame.ui.playareas;

import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;

import com.jh.multiplayergame.C;
import com.jh.multiplayergame.games.BaseMultiplayerGame;
import com.jh.multiplayergame.games.Player;

public abstract class BasePlayArea
{
	protected Player player;
	protected BaseMultiplayerGame game;
	protected Sprite sprite;
	
	public BasePlayArea(int playerIndex, BaseMultiplayerGame game, ITextureRegion texture)
	{
		float x;
		if (playerIndex == 0)
		{
			x = 300 - (texture.getWidth() / 2.0f);
		}
		else
		{
			x = (C.SCREEN_WIDTH - 300) - (texture.getWidth() / 2.0f);
		}
		float y = (C.SCREEN_HEIGHT / 2.0f) - (texture.getHeight() / 2.0f);
		
		sprite = new Sprite(x, y, texture, C.VMANAGER)
		{
			public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY)
			{
				switch (pSceneTouchEvent.getAction())
				{
					case TouchEvent.ACTION_DOWN:
						pressed(pSceneTouchEvent);
						break;
					case TouchEvent.ACTION_MOVE:
						moving(pSceneTouchEvent);
						break;
				}
				return true;
			}
		};
		if (playerIndex == 1)
		{
			sprite.setRotation(180f);
		}
		this.player = BaseMultiplayerGame.players[playerIndex];
		this.game = game;
		C.SCENE.attachChild(sprite);
	}
	
	public void attachTouchAreas()
	{
		C.SCENE.registerTouchArea(sprite);
	}
	
	public void setColor(float r, float g, float b)
	{
		sprite.setColor(r, g, b);
	}

	public abstract void pressed(TouchEvent touchEvent);
	public abstract void moving(TouchEvent touchEvent);	
}
