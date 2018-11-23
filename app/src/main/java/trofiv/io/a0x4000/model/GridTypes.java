package trofiv.io.a0x4000.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

import java.util.Arrays;
import java.util.Optional;

public enum GridTypes {
    REGULAR("regular") {
        @Override
        public BoardGrid generateBoard(final int size) {
            Preconditions.checkArgument(size >= 0, "Regular board size must be positive!");
            return new BoardGrid(this, size, new BoardItem[size][size]);
        }
    },
    HEXAGON("hexagon") {
        @Override
        public BoardGrid generateBoard(final int size) {
            Preconditions.checkArgument(size >= 0, "Hexagon board size must be positive!");
            if (size == 0) {
                return new BoardGrid(this, size, new BoardItem[0][0]);
            }
            final BoardItem[][] board = new BoardItem[2 * size - 1][];
            for (int i = 0; i < size; i++) {
                board[i] = new BoardItem[size + i];
                board[2 * size - i - 2] = new BoardItem[size + i];
            }
            return new BoardGrid(this, size, board);
        }
    };

    private final String value;

    GridTypes(final String value) {
        this.value = value;
    }

    public static GridTypes of(final String value) {
        final Optional<GridTypes> opt = Arrays.stream(values())
                .filter(v -> v.value.equals(value)).findFirst();
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new IllegalArgumentException("No such grid type with name: " + value);
        }
    }

    public abstract BoardGrid generateBoard(final int size);

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("value", value)
                .toString();
    }
}
