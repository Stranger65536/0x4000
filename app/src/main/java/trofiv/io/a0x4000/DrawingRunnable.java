package trofiv.io.a0x4000;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import trofiv.io.a0x4000.drawing.GameView;
import trofiv.io.a0x4000.utils.Logger;
import trofiv.io.a0x4000.utils.Logger.LoggerDepth;

public class DrawingRunnable implements Runnable {
    private final SurfaceHolder surfaceHolder;
    private final GameView gameView;

    public DrawingRunnable(final SurfaceHolder surfaceHolder, final GameView gameView) {
        this.surfaceHolder = surfaceHolder;
        this.gameView = gameView;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            final Canvas canvas;
            try {
                canvas = this.surfaceHolder.lockCanvas();
            } catch (Exception e) {
                Logger.e("Can't obtain canvas!", e, LoggerDepth.ACTUAL_METHOD);
                continue;
            }
            if (canvas == null) {
                continue;
            }
            try {
                this.gameView.draw(canvas);
            } catch (Exception e) {
                Logger.e("Can't draw surface!", e, LoggerDepth.ACTUAL_METHOD);
            } finally {
                try {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                } catch (Exception e) {
                    Logger.e("Can't release canvas!", e, LoggerDepth.ACTUAL_METHOD);
                }
            }
        }
    }
}
