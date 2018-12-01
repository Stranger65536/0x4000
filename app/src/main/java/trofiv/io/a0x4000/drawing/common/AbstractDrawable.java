package trofiv.io.a0x4000.drawing.common;

import android.graphics.Canvas;

public abstract class AbstractDrawable implements Drawable {
    /**
     * Position of the button from the top. If not specified, vertical position is calculated
     * based on the {@link #bottom} and {@link #height} params.
     */
    private Integer top;
    /**
     * Position of the button from the left. If not specified, horizontal position is calculated
     * based on the {@link #right} and {@link #width} params.
     */
    private Integer left;
    /**
     * Position of the button from the bottom. If not specified, vertical position is calculated
     * based on the {@link #top} and {@link #height} params.
     */
    private Integer bottom;
    /**
     * Position of the button from the right. If not specified, horizontal position is calculated
     * based on the {@link #left} and {@link #width} params.
     */
    private Integer right;
    /**
     * Width of the button. If not specified, width is calculated
     * based on the {@link #left} and {@link #right} params.
     */
    private Integer width;
    /**
     * Height of the button. If not specified, height is calculated
     * based on the {@link #top} and {@link #bottom} params.
     */
    private Integer height;
    /**
     * Z-index index of the button. The lest one draws closest to the background,
     * the most one - to the foreground.
     */
    private int zIndex;

    public Integer getLeft() {
        synchronized (this) {
            return left;
        }
    }

    public void setLeft(final Integer left) {
        synchronized (this) {
            this.left = left;
        }
    }

    public Integer getTop() {
        synchronized (this) {
            return top;
        }
    }

    public void setTop(final Integer top) {
        synchronized (this) {
            this.top = top;
        }
    }

    public Integer getBottom() {
        synchronized (this) {
            return bottom;
        }
    }

    public void setBottom(final Integer bottom) {
        synchronized (this) {
            this.bottom = bottom;
        }
    }

    public Integer getRight() {
        synchronized (this) {
            return right;
        }
    }

    public void setRight(final Integer right) {
        synchronized (this) {
            this.right = right;
        }
    }

    public Integer getWidth() {
        synchronized (this) {
            return width;
        }
    }

    public void setWidth(final Integer width) {
        synchronized (this) {
            this.width = width;
        }
    }

    public Integer getHeight() {
        synchronized (this) {
            return height;
        }
    }

    public void setHeight(final Integer height) {
        synchronized (this) {
            this.height = height;
        }
    }

    public int getZIndex() {
        synchronized (this) {
            return zIndex;
        }
    }

    public void setZIndex(final int zIndex) {
        synchronized (this) {
            this.zIndex = zIndex;
        }
    }

    public int width(final Canvas canvas) {
        synchronized (this) {
            if (width != null) {
                return width;
            } else if (left != null && right != null) {
                return Math.abs(canvas.getWidth() - left - right);
            } else {
                throw new IllegalStateException("Either width or left with right " +
                        "must be specified for width calculation! Object: " + this);
            }
        }
    }

    public int height(final Canvas canvas) {
        synchronized (this) {
            if (height != null) {
                return height;
            } else if (top != null && bottom != null) {
                return Math.abs(canvas.getHeight() - top - bottom);
            } else {
                throw new IllegalStateException("Either height or top with bottom " +
                        "must be specified for height calculation! Object: " + this);
            }
        }
    }

    public int left(final Canvas canvas) {
        synchronized (this) {
            if (left != null) {
                return left;
            } else if (right != null && width != null) {
                return Math.abs(canvas.getWidth() - right - width);
            } else {
                throw new IllegalStateException("Either left or right with width " +
                        "must be specified for left calculation! Object: " + this);
            }
        }
    }

    public int right(final Canvas canvas) {
        synchronized (this) {
            if (right != null) {
                return right;
            } else if (left != null && width != null) {
                return Math.abs(canvas.getWidth() - left - width);
            } else {
                throw new IllegalStateException("Either right or left with width " +
                        "must be specified for right calculation! Object: " + this);
            }
        }
    }

    public int top(final Canvas canvas) {
        synchronized (this) {
            if (top != null) {
                return top;
            } else if (bottom != null && height != null) {
                return Math.abs(canvas.getHeight() - bottom - height);
            } else {
                throw new IllegalStateException("Either top or bottom with height " +
                        "must be specified for top calculation! Object: " + this);
            }
        }
    }

    public int bottom(final Canvas canvas) {
        synchronized (this) {
            if (bottom != null) {
                return bottom;
            } else if (top != null && height != null) {
                return Math.abs(canvas.getHeight() - top - height);
            } else {
                throw new IllegalStateException("Either bottom or top with height " +
                        "must be specified for bottom calculation! Object: " + this);
            }
        }
    }
}
