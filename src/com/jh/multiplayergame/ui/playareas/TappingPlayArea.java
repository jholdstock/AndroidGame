package com.jh.multiplayergame.ui.playareas;

import org.andengine.input.touch.TouchEvent;

import com.jh.multiplayergame.Textures;
import com.jh.multiplayergame.games.BaseMultiplayerGame;

public abstract class TappingPlayArea extends BasePlayArea
{
	public TappingPlayArea(int playerIndex, BaseMultiplayerGame game)
	{
		super(playerIndex, game, Textures.playAreaTexture);
	}

	@Override
	public void moving(TouchEvent touchEvent) {}
}
