package trofiv.io.a0x4000.drawing.common;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.GestureDetector.SimpleOnGestureListener;

import java.util.List;

/**
 * Represents a button on the game layout
 */
public class Button extends AbstractDrawable {
    private final Paint backgroundStyle;
    private Label label;
    private Icon icon;
    private float rx;
    private float ry;

    /**
     * List of listeners which are called if gesture coordinates overlaps with button.
     */
    private List<SimpleOnGestureListener> gestureListeners;

    public Button() {
        this.backgroundStyle = new Paint();
        this.label = new Label();
        this.icon = new Icon();
    }

    public Paint getBackgroundStyle() {
        synchronized (this) {
            return backgroundStyle;
        }
    }

    public Label getLabel() {
        synchronized (this) {
            return label;
        }
    }

    public void setLabel(final Label label) {
        synchronized (this) {
            this.label = label;
        }
    }

    public Icon getIcon() {
        synchronized (this) {
            return icon;
        }
    }

    public void setIcon(final Icon icon) {
        synchronized (this) {
            this.icon = icon;
        }
    }

    public float getRx() {
        synchronized (this) {
            return rx;
        }
    }

    public void setRx(final float rx) {
        synchronized (this) {
            this.rx = rx;
        }
    }

    public float getRy() {
        synchronized (this) {
            return ry;
        }
    }

    public void setRy(final float ry) {
        synchronized (this) {
            this.ry = ry;
        }
    }

    @Override
    public void draw(final Canvas canvas) {
        synchronized (this) {
            canvas.drawRoundRect(left(), top(), right(), bottom(), rx, ry, backgroundStyle);
            if (icon != null) {
                icon.draw(canvas);
            }
            if (label != null) {
                label.draw(canvas);
            }
        }
    }
}
