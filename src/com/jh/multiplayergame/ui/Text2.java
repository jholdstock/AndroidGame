package com.jh.multiplayergame.ui;

import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.util.HorizontalAlign;

import com.jh.multiplayergame.C;
import com.jh.multiplayergame.Fonts;

class Text2 extends Text
{
	public Text2(String string)
	{
		// Long string used to initialise to avoid bug = http://www.andengine.org/forums/bugs-gles2/text-settext-isn-working-t7450-10.html 
		super(0, 0, Fonts.font, SILLY_STRING, new TextOptions(HorizontalAlign.CENTER), C.VMANAGER);
		this.setText(string);
		C.SCENE.attachChild(this);	
	}
		
	private static final String SILLY_STRING = "                                                               " +
			"                                                                                                  " +
			"                                                                                                  "; 
} 
