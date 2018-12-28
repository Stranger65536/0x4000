package trofiv.io.a0x4000.drawing.common;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Represents a button on the game layout
 */
public class Button extends AbstractDrawable {
    private static final double EPSILON = 1.0E-6;
    private final Paint currentBackgroundStyle;
    private final Paint backgroundStyle;
    private final Paint backgroundHoverStyle;
    private ValueAnimator animator;
    private long transitionDuration;
    private Label label;
    private Icon icon;
    private float rx;
    private float ry;


    public Button() {
        this.currentBackgroundStyle = new Paint();
        this.backgroundStyle = new Paint();
        this.backgroundHoverStyle = new Paint();
        this.label = new Label();
        this.icon = new Icon();
    }

    public Paint getBackgroundStyle() {
        synchronized (this) {
            return backgroundStyle;
        }
    }

    public Paint getCurrentBackgroundStyle() {
        synchronized (this) {
            return currentBackgroundStyle;
        }
    }

    public Paint getBackgroundHoverStyle() {
        synchronized (this) {
            return backgroundHoverStyle;
        }
    }

    public void setAnimator(final ValueAnimator animator) {
        synchronized (this) {
            this.animator = animator;
        }
    }

    public long getTransitionDuration() {
        synchronized (this) {
            return transitionDuration;
        }
    }

    public void setTransitionDuration(final long transitionDuration) {
        synchronized (this) {
            this.transitionDuration = transitionDuration;
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

    public void onButtonPressAnimation() {
        synchronized (this) {
            if (animator.isRunning()) {
                animator.reverse();
            } else {
                animator.start();
            }
        }
    }

    public void onButtonBlurAnimation() {
        synchronized (this) {
            if (animator.isRunning() || Math.abs(animator
                    .getAnimatedFraction() - 1.0f) < EPSILON) {
                animator.reverse();
            }
        }
    }

    @Override
    public void draw(final Canvas canvas) {
        synchronized (this) {
            canvas.drawRoundRect(left(), top(), right(), bottom(), rx, ry, currentBackgroundStyle);
            if (icon != null) {
                icon.draw(canvas);
            }
            if (label != null) {
                label.draw(canvas);
            }
        }
    }
}
