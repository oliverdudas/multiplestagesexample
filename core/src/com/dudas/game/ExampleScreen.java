package com.dudas.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by OLO on 31. 1. 2015
 */
public class ExampleScreen extends AbstractGameScreen {

    private static final String TAG = ExampleScreen.class.getName();

    private SpriteBatch batch;

    private Stage mainStage;
    private Stage gameStage;
    private static final float MAIN_VIEWPORT_WIDTH = 12f;
    private static final float MAIN_VIEWPORT_HEIGHT = 12f;
    private static final float GAME_VIEWPORT_WIDTH = 8f;
    private static final float GAME_VIEWPORT_HEIGHT = 8f;

    public ExampleScreen(Game game) {
        super(game);
    }

    @Override
    public void render(float deltaTime) {
        Gdx.gl.glClearColor(0.0f, 0.0f, 1.5f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mainStage.act();
        mainStage.draw();

        gameStage.act();
        gameStage.draw();



    }

    private Pixmap createProceduralPixmap(int width, int height) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);

        // Fill square with red color at 50% opacity
        pixmap.setColor(1, 0, 0, 0.5f);
        pixmap.fill();

        // Draw a yellow-colored X shape on square
        pixmap.setColor(1, 1, 0, 1);
        pixmap.drawLine(0, 0, width, height);
        pixmap.drawLine(width, 0, 0, height);

        // Draw a cyan-colored border around square
        pixmap.setColor(0, 1, 1, 1);
        pixmap.drawRectangle(0, 0, width, height);

        return pixmap;
    }

    @Override
    public void resize(int width, int height) {
        resizeMainStage(width, height);

//        resizeGameStage(width, height);

    }

    private void resizeGameStage(int width, int height) {
        gameStage.getViewport().update(width, height);
        Camera gameCamera = gameStage.getViewport().getCamera();
        gameCamera.position.set(gameCamera.viewportWidth / 2, gameCamera.viewportHeight / 2, 0) ;
    }

    private void resizeMainStage(int width, int height) {
        Viewport mainViewport = mainStage.getViewport();
        mainViewport.update(width / 2, height / 2);
        Camera camera = mainStage.getViewport().getCamera();
        camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2, 0) ;
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

        MainActor actor = new MainActor();
        actor.setTouchable(Touchable.enabled);
        mainStage.addActor(actor);
        Gdx.input.setInputProcessor(mainStage);
    }

    private void setupGameStage() {
//        OrthographicCamera gameCamera = new OrthographicCamera();
//        gameCamera.position.set(gameCamera.viewportWidth / 2, gameCamera.viewportHeight / 2, 0);
//        gameCamera.position.set(3, 3, 0);
//        gameCamera.update();
        ExtendViewport gameViewport = new ExtendViewport(100, 100);

        gameStage = new Stage(gameViewport, batch);
        MainActor2 gameActor = new MainActor2();
        gameActor.setTouchable(Touchable.enabled);
        gameStage.addActor(gameActor);
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
