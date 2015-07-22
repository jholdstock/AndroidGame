package com.jh.multiplayergame.games.pong;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.jh.multiplayergame.games.GameResult;

class PongContactListener implements ContactListener
{
	private PongGame game;
	
	public PongContactListener(PongGame game)
	{
		this.game = game;
	}
	
	@Override
	public void beginContact(Contact contact)
	{
		endGameIfEndAreaContacted(contact.getFixtureA());
		endGameIfEndAreaContacted(contact.getFixtureB());
	}
	
	private void endGameIfEndAreaContacted(Fixture f)
	{
		Object userDataA = f.getBody().getUserData();
		boolean endAreaContacted = userDataA != null; 
		if (endAreaContacted)
		{
			int winnerIndex = (Integer) userDataA;
			game.endAndDisplayResult(GameResult.winner(winnerIndex, "You win!", "You lose!"));;
		}
	}

	@Override
	public void endContact(Contact contact) {}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {}
}
