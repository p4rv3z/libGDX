package bd.parvez.wwiii;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Timer;

public class MainActivity extends Game {
    float delay = 3;
    SplashScreen splashScreen;
    MenuScreen menuScreen;

    public MainActivity() {
        super();
    }

    @Override
    public void create() {
        splashScreen = new SplashScreen();
        menuScreen = new MenuScreen();
        setScreen(splashScreen);
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                setScreen(menuScreen);
                if (splashScreen!=null) {
                    splashScreen.dispose();
                }

            }
        }, delay);
    }

    @Override
    public void dispose() {
        // DISPOSE ALL RESOURCES
        getScreen().dispose();
        Gdx.app.exit();
    }
}
