package com.finotti.teste1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {

    private SpriteBatch batch;

    // UP
    private Texture up1;
    private Texture up2;
    private Texture up3;
    private Texture up4;

    // DOWN
    private Texture down1;
    private Texture down2;
    private Texture down3;
    private Texture down4;

    // LEFT
    private Texture left1;
    private Texture left2;
    private Texture left3;
    private Texture left4;

    // RIGHT
    private Texture right1;
    private Texture right2;
    private Texture right3;
    private Texture right4;

    // Sprite atual
    private Texture playerCurrent;

    private float x = 100;
    private float y = 100;

    private float speed = 200;

    // Controle da animação
    private float animationTimer = 0;

    private float animationSpeed = 0.12f;

    private int animationFrame = 1;

    @Override
    public void create() {

        batch = new SpriteBatch();

        // UP
        up1 = new Texture("up1.png");
        up2 = new Texture("up2.png");
        up3 = new Texture("up3.png");
        up4 = new Texture("up4.png");

        // DOWN
        down1 = new Texture("down1.png");
        down2 = new Texture("down2.png");
        down3 = new Texture("down3.png");
        down4 = new Texture("down4.png");

        // LEFT
        left1 = new Texture("left1.png");
        left2 = new Texture("left2.png");
        left3 = new Texture("left3.png");
        left4 = new Texture("left4.png");

        // RIGHT
        right1 = new Texture("right1.png");
        right2 = new Texture("right2.png");
        right3 = new Texture("right3.png");
        right4 = new Texture("right4.png");

        // Começa parado olhando para baixo
        playerCurrent = down1;
    }

    @Override
    public void render() {

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        float delta = Gdx.graphics.getDeltaTime();

        boolean moving = false;

        // =========================
        // MOVIMENTO
        // =========================

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {

            moving = true;

            playerCurrent = up1;

            if (y < Gdx.graphics.getHeight() - 100) {
                y += speed * delta;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)) {

            moving = true;

            playerCurrent = down1;

            if (y > 0) {
                y -= speed * delta;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {

            moving = true;

            playerCurrent = left1;

            if (x > 0) {
                x -= speed * delta;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {

            moving = true;

            playerCurrent = right1;

            if (x < Gdx.graphics.getWidth() - 100) {
                x += speed * delta;
            }
        }

        // =========================
        // ANIMAÇÃO
        // =========================

        if (moving) {

            animationTimer += delta;

            if (animationTimer >= animationSpeed) {

                animationTimer = 0;

                animationFrame++;

                if (animationFrame > 4) {
                    animationFrame = 1;
                }
            }

        } else {

            // Quando parar, volta para o primeiro frame
            animationFrame = 1;
            animationTimer = 0;
        }

        // =========================
        // ESCOLHE O FRAME
        // =========================

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {

            if (animationFrame == 1) {
                playerCurrent = up1;
            }

            if (animationFrame == 2) {
                playerCurrent = up2;
            }

            if (animationFrame == 3) {
                playerCurrent = up3;
            }

            if (animationFrame == 4) {
                playerCurrent = up4;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)) {

            if (animationFrame == 1) {
                playerCurrent = down1;
            }

            if (animationFrame == 2) {
                playerCurrent = down2;
            }

            if (animationFrame == 3) {
                playerCurrent = down3;
            }

            if (animationFrame == 4) {
                playerCurrent = down4;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {

            if (animationFrame == 1) {
                playerCurrent = left1;
            }

            if (animationFrame == 2) {
                playerCurrent = left2;
            }

            if (animationFrame == 3) {
                playerCurrent = left3;
            }

            if (animationFrame == 4) {
                playerCurrent = left4;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {

            if (animationFrame == 1) {
                playerCurrent = right1;
            }

            if (animationFrame == 2) {
                playerCurrent = right2;
            }

            if (animationFrame == 3) {
                playerCurrent = right3;
            }

            if (animationFrame == 4) {
                playerCurrent = right4;
            }
        }

        // =========================
        // DESENHA
        // =========================

        batch.begin();

        batch.draw(playerCurrent, x, y, 100, 100);

        batch.end();
    }

    @Override
    public void dispose() {

        batch.dispose();

        up1.dispose();
        up2.dispose();
        up3.dispose();
        up4.dispose();

        down1.dispose();
        down2.dispose();
        down3.dispose();
        down4.dispose();

        left1.dispose();
        left2.dispose();
        left3.dispose();
        left4.dispose();

        right1.dispose();
        right2.dispose();
        right3.dispose();
        right4.dispose();
    }
}