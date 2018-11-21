package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class OldGDXGame extends ApplicationAdapter {

    final int maxJumpSpeed = 40;
    Animation animation;
    SpriteBatch batch, backgroundBatch;
    Camera camera;

    TextureRegion a0, a1, a2, a3, a4, a5, a6, a7;
    Sprite backgroundSprite, platformSprite;
    boolean jump = false;
    float elapsedTime = 0;
    float speed = 5, fallSpeed = 1, jumpSpeed = 1, playerX = 0, playerY = 0, lowestPlayerCollision = 0;

    ;

    @Override
    public void create() {
        camera = new OrthographicCamera(1440, 900);
        batch = new SpriteBatch();

        a0 = new TextureRegion(new Texture("0.png"));
        a1 = new TextureRegion(new Texture("1.png"));
        a2 = new TextureRegion(new Texture("2.png"));
        a3 = new TextureRegion(new Texture("3.png"));
        a4 = new TextureRegion(new Texture("4.png"));
        a5 = new TextureRegion(new Texture("5.png"));
        a6 = new TextureRegion(new Texture("6.png"));
        a7 = new TextureRegion(new Texture("7.png"));

        animation = new Animation(2f, a0, a1, a2, a3, a4, a5, a6, a7);

        backgroundSprite = new Sprite(new Texture("Background.png"));
        backgroundSprite.setScale(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        platformSprite = new Sprite(new Texture("Platform.png"));

    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        camera.position.x = playerX;
        camera.update();

        batch.setProjectionMatrix(camera.combined);
        backgroundSprite.draw(batch);
        platformSprite.setPosition(30, 50);
        platformSprite.draw(batch);
        batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime), playerX, playerY);
        batch.end();

        controls();
        jump();
        gravity();

    }

    private void controls() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            if (playerY <= lowestPlayerCollision) {
                jump = true;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            animation.setPlayMode(Animation.PlayMode.REVERSED);
            playerX -= 10;
            elapsedTime++;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            animation.setPlayMode(Animation.PlayMode.NORMAL);
            playerX += 10;
            elapsedTime++;
        }
        if (animation.isAnimationFinished(elapsedTime)) {
            elapsedTime = 0;
        }
    }

    private void gravity() {

        Rectangle platform = platformSprite.getBoundingRectangle();
        float platformXStart = platform.getX();
        float platformYStart = platform.getY();
        float platformXEnd = platformXStart + platform.getWidth();
        float platformYEnd = platformYStart + platform.getHeight();
        
        if (playerY >= platformYStart && playerY <= platformYEnd
                && playerX >= platformXStart && playerX <= platformXEnd) {
            lowestPlayerCollision = platform.getY();
        } else {
            lowestPlayerCollision = 0;
        }

        if (!(playerY <= lowestPlayerCollision)) {
            playerY -= fallSpeed;
            fallSpeed += 0.4;
        } else {
            fallSpeed = 2;
            playerY = lowestPlayerCollision;
        }
    }

    private void jump() {
        if (jump == true) {

            if (jumpSpeed < maxJumpSpeed) {
                jumpSpeed += maxJumpSpeed / 10;
            } else {
                jump = false;
                jumpSpeed = 0;
            }
            playerY += jumpSpeed;
        }
    }

    @Override
    public void dispose() {
        batch.dispose();

    }

}
