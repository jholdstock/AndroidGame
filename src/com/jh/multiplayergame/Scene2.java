package com.jh.multiplayergame;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.sprite.Sprite;
import org.andengine.util.color.Color;

public class Scene2 extends Scene
{
	public Scene2()
	{
		Sprite sprite = new Sprite(0, 0, Textures.backgroundTexture, C.VMANAGER);
		sprite.setColor(Color.BLACK);
		SpriteBackground background = new SpriteBackground(sprite);
		setBackground(background);
		
		setOnAreaTouchTraversalFrontToBack();
		setTouchAreaBindingOnActionDownEnabled(true);
	}
	
	@Override
	public void reset()
	{
		super.reset();
		detachChildren();
		clearTouchAreas();
		clearUpdateHandlers();
	}

}
