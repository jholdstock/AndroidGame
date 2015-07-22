package com.jh.multiplayergame.games.pong;

import org.andengine.extension.physics.box2d.FixedStepPhysicsWorld;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.util.math.MathUtils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;

class PongModel
{
	private Body ballBody;
	private Body[] paddleBodies;
	private PhysicsWorld physics;
		
	public PongModel(PongGame game)
	{
		physics = new FixedStepPhysicsWorld(60, 1, new Vector2(0, 0), false, 1, 1);
	
		FixtureDef fixture = PhysicsFactory.createFixtureDef(1, 1, 0);
		
		createPaddleBodies(fixture);
		createWallBodies(fixture);
		createBallBody(fixture);
		
		physics.setContactListener(new PongContactListener(game));
	}

	private void createBallBody(FixtureDef fixture)
	{
		ballBody = PhysicsFactory.createCircleBody(physics, 0, 0, PongC.BALL_SIZE/2, BodyType.DynamicBody, fixture);
		ballBody.setBullet(true);
		ballBody.setTransform(PongC.GAME_WIDTH/2/32, PongC.GAME_HEIGHT/2/32, 0);
	}
	
	private void createPaddleBodies(FixtureDef fixture)
	{
		paddleBodies = new Body[2];
		
		float screenMiddle = PongC.GAME_HEIGHT/2 - (PongC.PADDLE_HEIGHT/2);
		float spaceFromBottom = PongC.BOTTOM_SPACE;
		paddleBodies[0] = PhysicsFactory.createBoxBody(physics, spaceFromBottom + (PongC.PADDLE_WIDTH/2), screenMiddle + (PongC.PADDLE_HEIGHT/2), PongC.PADDLE_WIDTH, PongC.PADDLE_HEIGHT, BodyType.KinematicBody, fixture);
		paddleBodies[1] = PhysicsFactory.createBoxBody(physics, PongC.GAME_WIDTH - spaceFromBottom - (PongC.PADDLE_WIDTH/2), screenMiddle + (PongC.PADDLE_HEIGHT/2), PongC.PADDLE_WIDTH, PongC.PADDLE_HEIGHT, BodyType.KinematicBody, fixture);
	}

	private void createWallBodies(FixtureDef fixture)
	{
		fixture.isSensor = true;
		PhysicsFactory.createLineBody(physics, 1, 1, 1, PongC.GAME_HEIGHT, fixture)
			.setUserData(1); // Left
		PhysicsFactory.createLineBody(physics, PongC.GAME_WIDTH - 1, 0, PongC.GAME_WIDTH - 1, PongC.GAME_HEIGHT, fixture)
			.setUserData(0); // Right

		fixture.isSensor = false;
		PhysicsFactory.createLineBody(physics, 1, 1, PongC.GAME_WIDTH, 1, fixture); // Top
		PhysicsFactory.createLineBody(physics, 1, PongC.GAME_HEIGHT, PongC.GAME_WIDTH, PongC.GAME_HEIGHT, fixture); // Bottom
	}
	
	public Vector2 getBallPosition()
	{
		return ballBody.getPosition();
	}
	
	public Vector2[] getPaddlePositions()
	{
		return new Vector2[]{ paddleBodies[0].getPosition(), paddleBodies[1].getPosition() };
	}
	
	public void update(float secondsElapsed)
	{
		physics.onUpdate(secondsElapsed);
	}
	
	public void start()
	{
		float xVelocity = MathUtils.randomSign() * PongC.BALL_SPEED;
		float yVelocity = MathUtils.randomSign() * PongC.BALL_SPEED;
		ballBody.setLinearVelocity(xVelocity, yVelocity);
	}
	
	public void movePaddle(int index, float fractionOFHeightTouched)
	{
		float paddleY = fractionOFHeightTouched * PongC.GAME_HEIGHT;
		
		float paddleTopLimit = 1 + PongC.PADDLE_HEIGHT/2;
		float paddleBottomLimit = PongC.GAME_HEIGHT - PongC.PADDLE_HEIGHT/2;
		
		paddleY = MathUtils.bringToBounds(paddleTopLimit, paddleBottomLimit, paddleY);
		
		setPaddleBodyHeight(index, paddleY);
	}
	
	private void setPaddleBodyHeight(int index, float y)
	{
		Vector2 paddlePosition = paddleBodies[index].getTransform().getPosition();
		paddlePosition.set(paddlePosition.x, y / 32);
		paddleBodies[index].setTransform(paddlePosition, 0);
	}
}
