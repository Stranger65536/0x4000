package trofiv.io.a0x4000.model;

import com.google.common.base.MoreObjects;

/**
 * Represents an entity on a gaming board
 */
public class BoardItem {
    private final int value;

    public BoardItem(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("value", value)
                .toString();
    }
}
