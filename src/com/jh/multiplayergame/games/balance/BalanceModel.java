package com.jh.multiplayergame.games.balance;

import org.andengine.extension.physics.box2d.FixedStepPhysicsWorld;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.util.math.MathUtils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;

class BalanceModel
{
	private Body[] ballBodies;
	private DeathZones deathZones;
	
	private PhysicsWorld physics;
			
	public BalanceModel()
	{
		physics = new FixedStepPhysicsWorld(60, 1, new Vector2(0, 0), false, 1, 1);
	
		FixtureDef fixture = PhysicsFactory.createFixtureDef(1, 1, 0);
				
		createBallBodies(fixture);
		deathZones = new DeathZones(BalanceC.DEATH_HEIGHT, BalanceC.SAFE_ZONE_HEIGHT);
	}
	
	private void createBallBodies(FixtureDef fixture)
	{
		fixture.isSensor = false;
		ballBodies = new Body[2];
		
		float screenMiddle = BalanceC.GAME_HEIGHT/2 - (BalanceC.BALL_SIZE/2);
		float spaceFromBottom = BalanceC.BOTTOM_SPACE;
		ballBodies[0] = PhysicsFactory.createBoxBody(physics, spaceFromBottom + (BalanceC.BALL_SIZE/2), screenMiddle + (BalanceC.BALL_SIZE/2), BalanceC.BALL_SIZE, BalanceC.BALL_SIZE, BodyType.KinematicBody, fixture);
		ballBodies[0].setBullet(true);
		ballBodies[1] = PhysicsFactory.createBoxBody(physics, BalanceC.GAME_WIDTH - spaceFromBottom - (BalanceC.BALL_SIZE/2), screenMiddle + (BalanceC.BALL_SIZE/2), BalanceC.BALL_SIZE, BalanceC.BALL_SIZE, BodyType.KinematicBody, fixture);
		ballBodies[1].setBullet(true);
	}
		
	public Vector2[] getBallPositions()
	{
		return new Vector2[]{ ballBodies[0].getPosition(), ballBodies[1].getPosition() };
	}
	
	public void update(float secondsElapsed)
	{
		physics.onUpdate(secondsElapsed);
		deathZones.updatePositions(secondsElapsed);
	}

	public void moveBall(int index, float fractionOFHeightTouched)
	{
		float ballY = fractionOFHeightTouched * BalanceC.GAME_HEIGHT;
		
		float ballTopLimit = 1 + BalanceC.BALL_SIZE/2;
		float ballBottomLimit = BalanceC.GAME_HEIGHT - BalanceC.BALL_SIZE/2;
		
		ballY = MathUtils.bringToBounds(ballTopLimit, ballBottomLimit, ballY);
		
		setBallBodyY(index, ballY);
	}
	
	private void setBallBodyY(int index, float y)
	{
		Vector2 ballPosition = ballBodies[index].getTransform().getPosition();
		ballPosition.set(ballPosition.x, y / 32);
		ballBodies[index].setTransform(ballPosition, 0);
	}
	
	public float[] getDeathHeights()
	{
		return deathZones.getHeights();
	}

	public int getCollidingIndex()
	{
		for (int i = 0; i < 2; i++)
		{
			if(deathZones.isPlayerColliding(ballBodies[i].getPosition().y))
			{
				return i;
			}
		}
		return -1;
	}
}
