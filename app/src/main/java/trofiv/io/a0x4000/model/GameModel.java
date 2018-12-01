package trofiv.io.a0x4000.model;

import android.view.SurfaceHolder;

import trofiv.io.a0x4000.model.common.AbstractModel;

public class GameModel extends AbstractModel {
    @Override
    public void surfaceCreated(final SurfaceHolder holder) {
        super.surfaceCreated(holder);
    }

    @Override
    public void surfaceChanged(
            final SurfaceHolder holder,
            final int format,
            final int width,
            final int height) {
        super.surfaceChanged(holder, format, width, height);
    }

    @Override
    public void surfaceDestroyed(final SurfaceHolder holder) {
        super.surfaceDestroyed(holder);
    }
}
