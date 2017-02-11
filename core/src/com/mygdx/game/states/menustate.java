package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

/**
 * Created by kt-uchiha on 05-02-2017.
 */

public class menustate extends state {
    public Texture background;
    public Texture playbtn;
    public menustate(GameStateManager gm) {
        super(gm);
        cam.setToOrtho(false, MyGdxGame.WIDTH/2,MyGdxGame.HEIGHT/2);
        background = new Texture("bg.png");
        playbtn = new Texture("playbtn.png");
    }

    @Override
    public void handleinput() {
        if(Gdx.input.justTouched()) {

            gm.setStates(new playstate(gm));
        }
    }

    @Override
    public void update(float dt) {
        handleinput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background,0,0);
        sb.draw(playbtn,cam.position.x-playbtn.getWidth()/2,cam.position.y);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playbtn.dispose();
        System.out.println("Menustate disposed");
    }
}
