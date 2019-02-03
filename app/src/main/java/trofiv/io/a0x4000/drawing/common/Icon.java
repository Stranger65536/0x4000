package trofiv.io.a0x4000.drawing.common;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Icon extends AbstractDrawable {
    private final Paint style;
    private android.graphics.drawable.Drawable drawable;

    public Icon() {
        this.style = new Paint();
    }

    public Paint getStyle() {
        return style;
    }

    public android.graphics.drawable.Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(final android.graphics.drawable.Drawable drawable) {
        this.drawable = drawable;
    }

    @Override
    public void draw(final Canvas canvas) {
        if (drawable != null) {
            drawable.setBounds(getLeft(), getTop(), getLeft() + getWidth(), getTop() + getHeight());
            drawable.draw(canvas);
        }
    }
}
