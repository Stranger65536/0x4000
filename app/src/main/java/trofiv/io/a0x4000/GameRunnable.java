package trofiv.io.a0x4000;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import trofiv.io.a0x4000.Logger.LoggerDepth;

public class GameRunnable implements Runnable {
    private static final Logger LOGGER = Logger.getLogger();
    private final SurfaceHolder surfaceHolder;
    private final GameView gameView;

    GameRunnable(final SurfaceHolder surfaceHolder, final GameView gameView) {
        this.surfaceHolder = surfaceHolder;
        this.gameView = gameView;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Canvas canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                if (canvas == null) {
                    return;
                }
                synchronized (surfaceHolder) {
                    this.gameView.draw(canvas);
                }
            } catch (Exception e) {
                Logger.e("Can't obtain canvas!", e, LoggerDepth.ACTUAL_METHOD);
            } finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {
                        Logger.e("Can't release canvas!", e, LoggerDepth.ACTUAL_METHOD);
                    }
                }
            }
        }
    }
}
