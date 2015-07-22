package com.jh.multiplayergame;

import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.ui.activity.BaseGameActivity;

public class Fonts
{
	public static Font font;

	public static void LoadFonts(BaseGameActivity a)
	{
		font = FontFactory.createFromAsset(a.getFontManager(), a.getTextureManager(), 512, 512, a.getAssets(),"fnt/ARCADECLASSIC.TTF", 64, false, android.graphics.Color.WHITE);
		font.load();
	}
}
