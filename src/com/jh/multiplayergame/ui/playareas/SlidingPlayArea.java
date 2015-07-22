package com.jh.multiplayergame.ui.playareas;

import org.andengine.input.touch.TouchEvent;
import org.andengine.util.math.MathUtils;

import com.jh.multiplayergame.C;
import com.jh.multiplayergame.Textures;
import com.jh.multiplayergame.games.BaseMultiplayerGame;

public abstract class SlidingPlayArea extends BasePlayArea
{
	private static final float TOP =  (C.SCREEN_HEIGHT / 2.0f) - (Textures.longPlayAreaTexture.getHeight() / 2.0f);
	private static final float BOTTOM = TOP + Textures.longPlayAreaTexture.getHeight();
	
	public SlidingPlayArea(int playerIndex, BaseMultiplayerGame game)
	{
		super(playerIndex, game, Textures.longPlayAreaTexture);
	}
	
	protected float getHeightFraction(TouchEvent touchEvent)
	{
		float y = touchEvent.getY() - TOP;
		MathUtils.bringToBounds(TOP, BOTTOM, y);
		return y / Textures.longPlayAreaTexture.getHeight();
	}
	
	public void pressed(TouchEvent touchEvent)
	{
		moving(touchEvent);
	}
}
