package trofiv.io.a0x4000;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Sprite {
    private Bitmap image;
    private int x;
    private int y;

    public Sprite(final Bitmap image) {
        this.image = image;
    }

    public void draw(final Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);
    }

    public void update(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public void update(final Bitmap bitmap) {
        this.image = bitmap;
    }

    public Bitmap getBitmap() {
        return image;
    }
}