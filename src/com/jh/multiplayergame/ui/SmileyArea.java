package com.jh.multiplayergame.ui;

import java.util.Random;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.util.color.Color;

import com.jh.multiplayergame.C;
import com.jh.multiplayergame.Textures;

public class SmileyArea
{	
	private int numberFaces = 6;
	public Sprite[][] faces = new Sprite[numberFaces][numberFaces];
	public static final float scale = 0.85f;
	
	public SmileyArea()
	{
		float y = C.SCREEN_HEIGHT/2 - (Textures.faceTexture.getHeight() * numberFaces * scale)/2; 
				
		for (int i = 0; i < numberFaces; i++)
		{
			float x = C.SCREEN_WIDTH/2 - (Textures.faceTexture.getWidth() * numberFaces * scale)/2;
			for (int j = 0; j < numberFaces; j++)
			{
				Sprite s = createFaceAtLocation(Textures.faceTexture, x, y, null);
				faces[i][j] = s;
				x = x + Textures.faceTexture.getWidth() * scale;
			}
			y = y + Textures.faceTexture.getHeight() * scale;
		}
	}

	public void update()
	{
		for (int i = 0; i < 4 ; i++)
		{
			int x = new Random().nextInt(numberFaces);
			int y = new Random().nextInt(numberFaces);
			float rotation = new Random().nextInt(4) * 90f;
			faces[x][y].setRotation(rotation);
		}
	}
	
	public void addSadFace()
	{
		int x = new Random().nextInt(numberFaces);
		int y = new Random().nextInt(numberFaces);
		Sprite old = faces[x][y];
		Sprite New = createFaceAtLocation(Textures.sadFaceTexture, old.getX(), old.getY(), old.getColor());
		
		C.SCENE.detachChild(old);
		faces[x][y] = New;
	}
	
	private Sprite createFaceAtLocation(ITextureRegion face, float x, float y, Color color)
	{
		Sprite newFace = new Sprite(x, y, face, C.VMANAGER);
		
		float rotation = new Random().nextInt(4) * 90f;
		newFace.setRotation(rotation);
		if (color == null)
		{
			color = C.COLORS[new Random().nextInt(C.COLORS.length)];
		}
		newFace.setColor(color);
		newFace.setScale(scale);
		
		C.SCENE.attachChild(newFace);
		return newFace;
	}
}
