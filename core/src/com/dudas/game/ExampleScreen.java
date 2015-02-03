package com.dudas.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dudas.game.util.ExtendViewportWithRightCamera;

/**
 * Created by OLO on 31. 1. 2015
 */
public class ExampleScreen extends AbstractGameScreen {

    private static final String TAG = ExampleScreen.class.getName();
    public static final int GAME_STAGE_WIDTH = 9;
    public static final int GAME_STAGE_HEIGHT = 9;

    private SpriteBatch batch;

    private Stage mainStage;
    private Stage gameStage;

    public ExampleScreen(Game game) {
        super(game);
    }

    @Override
    public void render(float deltaTime) {
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//        mainStage.act();
        mainStage.draw();

//        gameStage.act();
        gameStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        resizeMainStage(width, height);
        resizeGameStage(width, height);
    }

    private void resizeGameStage(int width, int height) {
        gameStage.getViewport().update(width, height);
    }

    private void resizeMainStage(int width, int height) {
        mainStage.getViewport().update(width, height);
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        setupMainStage();
        setupGameStage();
    }

    private void setupMainStage() {
        FitViewport viewport = new FitViewport(100, 100);
        mainStage = new Stage(viewport, batch);

        initMainStageActors();
    }

    private void initMainStageActors() {
        MainActor actor = new MainActor();
        actor.setTouchable(Touchable.enabled);
        mainStage.addActor(actor);
        Gdx.input.setInputProcessor(mainStage);
    }

    private void setupGameStage() {
        ExtendViewportWithRightCamera gameViewport = new ExtendViewportWithRightCamera(GAME_STAGE_WIDTH, GAME_STAGE_HEIGHT);

        gameStage = new Stage(gameViewport, batch);
        initGameStageActors();
    }

    private void initGameStageActors() {
        gameStage.addActor(new PixmapGemActor(0, 0));
        gameStage.addActor(new PixmapGemActor(0, 1));
        gameStage.addActor(new PixmapGemActor(0, 2));
        gameStage.addActor(new PixmapGemActor(0, 3));
        gameStage.addActor(new PixmapGemActor(0, 4));
        gameStage.addActor(new PixmapGemActor(0, 5));
        gameStage.addActor(new PixmapGemActor(0, 6));
        gameStage.addActor(new PixmapGemActor(0, 7));
        gameStage.addActor(new PixmapGemActor(0, 8));

        gameStage.addActor(new PixmapGemActor(0, 8));
        gameStage.addActor(new PixmapGemActor(1, 8));
        gameStage.addActor(new PixmapGemActor(2, 8));
        gameStage.addActor(new PixmapGemActor(3, 8));
        gameStage.addActor(new PixmapGemActor(4, 8));
        gameStage.addActor(new PixmapGemActor(5, 8));
        gameStage.addActor(new PixmapGemActor(6, 8));
        gameStage.addActor(new PixmapGemActor(7, 8));

        gameStage.addActor(new PixmapGemActor(8, 8));
        gameStage.addActor(new PixmapGemActor(8, 7));
        gameStage.addActor(new PixmapGemActor(8, 6));
        gameStage.addActor(new PixmapGemActor(8, 5));
        gameStage.addActor(new PixmapGemActor(8, 4));
        gameStage.addActor(new PixmapGemActor(8, 3));
        gameStage.addActor(new PixmapGemActor(8, 2));
        gameStage.addActor(new PixmapGemActor(8, 1));

        gameStage.addActor(new PixmapGemActor(8, 0));
        gameStage.addActor(new PixmapGemActor(7, 0));
        gameStage.addActor(new PixmapGemActor(6, 0));
        gameStage.addActor(new PixmapGemActor(5, 0));
        gameStage.addActor(new PixmapGemActor(4, 0));
        gameStage.addActor(new PixmapGemActor(3, 0));
        gameStage.addActor(new PixmapGemActor(2, 0));
        gameStage.addActor(new PixmapGemActor(1, 0));

        gameStage.addActor(new PixmapGemActor(5, 3));
        gameStage.addActor(new PixmapGemActor(4, 3));
        gameStage.addActor(new PixmapGemActor(3, 3));
        gameStage.addActor(new PixmapGemActor(2, 6));
        gameStage.addActor(new PixmapGemActor(6, 6));
    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void dispose() {
        mainStage.dispose();
        gameStage.dispose();
    }

}
