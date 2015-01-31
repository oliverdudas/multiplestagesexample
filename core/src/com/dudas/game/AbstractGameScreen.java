package com.dudas.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

/**
 * Created by OLO on 19. 1. 2015
 */
public abstract class AbstractGameScreen implements Screen {

    protected Game game;

    public AbstractGameScreen(Game game) {
        this.game = game;
    }

    public abstract void render(float deltaTime);

    public abstract void resize(int width, int height);

    public abstract void show();

    public abstract void hide();

    public abstract void pause();

    public void resume() {
    }

    public void dispose() {
    }
}
