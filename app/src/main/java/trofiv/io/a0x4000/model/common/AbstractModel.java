package trofiv.io.a0x4000.model.common;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

import trofiv.io.a0x4000.utils.Logger;
import trofiv.io.a0x4000.utils.Logger.LoggerDepth;

public class AbstractModel implements Callback {
    private int width;
    private int height;

    private void waitCanvasInitialization(final SurfaceHolder holder) {
        while (true) {
            Canvas canvas = null;
            try {
                canvas = holder.lockCanvas();
            } catch (Exception e) {
                Logger.e("Can't obtain canvas!", e, LoggerDepth.ACTUAL_METHOD);
            }
            if (canvas == null) {
                continue;
            }
            try {
                this.width = canvas.getWidth();
                this.height = canvas.getHeight();
                break;
            } catch (Exception e) {
                Logger.e("Can't draw canvas!", e, LoggerDepth.ACTUAL_METHOD);
            } finally {
                try {
                    holder.unlockCanvasAndPost(canvas);
                } catch (Exception e) {
                    Logger.e("Can't release canvas!", e, LoggerDepth.ACTUAL_METHOD);
                }
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void surfaceCreated(final SurfaceHolder holder) {
        waitCanvasInitialization(holder);
    }

    @Override
    public void surfaceChanged(
            final SurfaceHolder holder,
            final int format,
            final int width,
            final int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void surfaceDestroyed(final SurfaceHolder holder) {
        this.width = -1;
        this.height = -1;
    }
}
