package trofiv.io.a0x4000;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Sprite {
    private Bitmap image;
    private Bitmap originalImage;
    private int x;
    private int y;
    private float scale = 1.0f;

    Sprite(final Bitmap image) {
        this.originalImage = image;
        this.image = image;
    }

    void draw(final Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);
    }

    void update(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    void scaleUp() {
        if (this.scale <= 3) {
            //noinspection MagicNumber
            this.scale += 0.1f;
        }
    }

    void scaleDown() {
        //noinspection MagicNumber
        this.scale = 1.0f;
    }

    public float getScale() {
        return scale;
    }

    public void update(final Bitmap bitmap) {
        this.image = bitmap;
    }

    public Bitmap getImage() {
        return image;
    }

    public Bitmap getOriginalImage() {
        return originalImage;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
