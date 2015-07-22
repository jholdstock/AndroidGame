package com.jh.multiplayergame.ui;

import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;

import com.jh.multiplayergame.C;
import com.jh.multiplayergame.Textures;

public abstract class StartButton extends Sprite
{
	public StartButton()
	{
		super((C.SCREEN_WIDTH / 2) - 256, (C.SCREEN_HEIGHT / 2) - 64, Textures.startTexture, C.VMANAGER);
		C.SCENE.attachChild(this);
		C.SCENE.registerTouchArea(this);
	}

	@Override
	public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY)
	{
		switch (pSceneTouchEvent.getAction())
		{
			case TouchEvent.ACTION_DOWN:
				pressed();
				break;
			case TouchEvent.ACTION_UP:
				break;
		}
		return true;
	}

	public abstract void pressed();
}
