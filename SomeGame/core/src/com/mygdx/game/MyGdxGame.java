package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends ApplicationAdapter {

    SpriteBatch batch;
    Texture texture;
    TextureRegion background;
    Sprite sprite;
    Camera camera;
    float spriteX = 0, spriteY = 0;

    @Override
    public void create() {
        camera = new OrthographicCamera(1440, 900);
        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("player.png"));
        sprite = new Sprite(texture);
        background = new TextureRegion(new Texture("background.png"),0,0,1440,900);
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        camera.position.x = spriteX;
        camera.position.y = spriteY;
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background,0,0);
        sprite.setPosition(spriteX, spriteY);
        sprite.draw(batch);
        batch.end();

        controls();

    }

    private void controls() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            spriteY +=10;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            spriteY -=10;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            spriteX -=10;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            spriteX +=10;
        }

    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();

    }

}
