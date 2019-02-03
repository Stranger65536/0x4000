package trofiv.io.a0x4000.drawing.common;

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
        return left;
    }

    public void setLeft(final Integer left) {
        this.left = left;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(final Integer top) {
        this.top = top;
    }

    public Integer getBottom() {
        return bottom;
    }

    public void setBottom(final Integer bottom) {
        this.bottom = bottom;
    }

    public Integer getRight() {
        return right;
    }

    public void setRight(final Integer right) {
        this.right = right;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(final Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(final Integer height) {
        this.height = height;
    }

    public int getZIndex() {
        return zIndex;
    }

    public void setZIndex(final int zIndex) {
        this.zIndex = zIndex;
    }

    public int width() {
        if (width != null) {
            return width;
        } else if (left != null && right != null) {
            return right - left;
        } else {
            throw new IllegalStateException("Either width or left with right " +
                    "must be specified for width calculation! Object: " + this);
        }
    }

    public int height() {
        if (height != null) {
            return height;
        } else if (top != null && bottom != null) {
            return bottom - top;
        } else {
            throw new IllegalStateException("Either height or top with bottom " +
                    "must be specified for height calculation! Object: " + this);
        }
    }

    public int left() {
        if (left != null) {
            return left;
        } else if (right != null && width != null) {
            return right - width;
        } else {
            throw new IllegalStateException("Either left or right with width " +
                    "must be specified for left calculation! Object: " + this);
        }
    }

    public int right() {
        if (right != null) {
            return right;
        } else if (left != null && width != null) {
            return left + width;
        } else {
            throw new IllegalStateException("Either right or left with width " +
                    "must be specified for right calculation! Object: " + this);
        }
    }

    public int top() {
        if (top != null) {
            return top;
        } else if (bottom != null && height != null) {
            return bottom - height;
        } else {
            throw new IllegalStateException("Either top or bottom with height " +
                    "must be specified for top calculation! Object: " + this);
        }
    }

    public int bottom() {
        if (bottom != null) {
            return bottom;
        } else if (top != null && height != null) {
            return top + height;
        } else {
            throw new IllegalStateException("Either bottom or top with height " +
                    "must be specified for bottom calculation! Object: " + this);
        }
    }
}
