package trofiv.io.a0x4000.drawing.common;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector.SimpleOnGestureListener;

import java.util.List;

/**
 * Represents a button on the game layout
 */
public class Button extends AbstractDrawable {
    /**
     * Visual design of an image. Scales according to the {@link #width} and {@link #height} or
     * their corresponding calculated values. If null, button background is transparent.
     */
    private Drawable image;

    /**
     * List of listeners which are called if gesture coordinates overlaps with button.
     */
    private List<SimpleOnGestureListener> gestureListeners;

    @Override
    public void draw(final Canvas canvas) {
        //TODO
    }
}
