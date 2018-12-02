package trofiv.io.a0x4000.drawing.common;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Label extends AbstractDrawable {
    private final Paint style;
    private final Rect bounds;
    private String text;
    private int xPosCorrection;
    private int yPosCorrection;

    public Label() {
        this.style = new Paint();
        this.bounds = new Rect();
    }

    /**
     * Sets the text size for a Paint object so a given string of text will be a
     * given width.
     */
    public void setTextSizeForWidth(final float desiredWidth) {
        synchronized (this) {
            // Pick a reasonably large value for the test. Larger values produce
            // more accurate results, but may cause problems with hardware
            // acceleration. But there are workarounds for that, too; refer to
            // http://stackoverflow.com/questions/6253528/font-size-too-large-to-fit-in-cache
            final float testTextSize = 96.0f;
            // Get the bounds of the text, using our testTextSize.
            style.setTextSize(testTextSize);
            style.getTextBounds(text, 0, text.length(), bounds);
            // Calculate the desired size as a proportion of our testTextSize.
            final float desiredTextSize = testTextSize * desiredWidth / bounds.width();
            // Set the paint for that size.
            style.setTextSize(desiredTextSize);
            style.getTextBounds(text, 0, text.length(), bounds);
            this.setHeight(bounds.height());
            this.setWidth(bounds.width());
            xPosCorrection = bounds.left;
            yPosCorrection = bounds.bottom;
        }
    }

    /**
     * Sets the text size for a Paint object so a given string of text will be a
     * given height.
     */
    public void setTextSizeForHeight(final float desiredHeight) {
        synchronized (this) {
            // Pick a reasonably large value for the test. Larger values produce
            // more accurate results, but may cause problems with hardware
            // acceleration. But there are workarounds for that, too; refer to
            // http://stackoverflow.com/questions/6253528/font-size-too-large-to-fit-in-cache
            final float testTextSize = 96.0f;
            // Get the bounds of the text, using our testTextSize.
            style.setTextSize(testTextSize);
            style.getTextBounds(text, 0, text.length(), bounds);
            // Calculate the desired size as a proportion of our testTextSize.
            final float desiredTextSize = testTextSize * desiredHeight / bounds.height();
            // Set the paint for that size.
            style.setTextSize(desiredTextSize);
            style.getTextBounds(text, 0, text.length(), bounds);
            this.setHeight(bounds.height());
            this.setWidth(bounds.width());
            xPosCorrection = bounds.left;
            yPosCorrection = bounds.bottom;
        }
    }

    public Paint getStyle() {
        synchronized (this) {
            return style;
        }
    }

    public Rect getBounds() {
        synchronized (this) {
            return bounds;
        }
    }

    public String getText() {
        synchronized (this) {
            return text;
        }
    }

    public void setText(final String text) {
        synchronized (this) {
            this.text = text;
        }
    }

    @Override
    public void draw(final Canvas canvas) {
        synchronized (this) {
            canvas.drawText(text, getLeft() - xPosCorrection, getTop() - yPosCorrection, style);
        }
    }
}
