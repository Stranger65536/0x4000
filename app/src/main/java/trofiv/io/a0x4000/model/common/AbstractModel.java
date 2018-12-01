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
        //noinspection BooleanVariableAlwaysNegated
        boolean initialized = false;
        while (!initialized) {
            Canvas canvas = null;
            try {
                canvas = holder.lockCanvas();
                if (canvas == null) {
                    return;
                }
                //noinspection SynchronizationOnLocalVariableOrMethodParameter
                synchronized (holder) {
                    //noinspection NestedSynchronizedStatement
                    synchronized (this) {
                        this.width = canvas.getWidth();
                        this.height = canvas.getHeight();
                    }
                    initialized = true;
                }
            } catch (Exception e) {
                Logger.e("Can't obtain canvas!", e, LoggerDepth.ACTUAL_METHOD);
            } finally {
                if (canvas != null) {
                    try {
                        holder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {
                        Logger.e("Can't release canvas!", e, LoggerDepth.ACTUAL_METHOD);
                    }
                }
            }
        }
    }

    public int getWidth() {
        synchronized (this) {
            return width;
        }
    }

    public int getHeight() {
        synchronized (this) {
            return height;
        }
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
        synchronized (this) {
            this.width = width;
            this.height = height;
        }
    }

    @Override
    public void surfaceDestroyed(final SurfaceHolder holder) {
        synchronized (this) {
            this.width = -1;
            this.height = -1;
        }
    }
}
