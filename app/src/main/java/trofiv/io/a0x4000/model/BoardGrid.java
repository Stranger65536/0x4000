package trofiv.io.a0x4000.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

/**
 * Stores information about {@link BoardItem} entities and their positions.
 */
public class BoardGrid {
    /**
     * Type of the gaming board. Affects on gestures handling and transitions computation.
     */
    private final GridTypes type;
    /**
     * Size of this game board.
     */
    private final int size;
    /**
     * Array of the {@link BoardItem} entities.
     * Zero dimension relates to game board rows from top to bottom direction.
     * (zero element relates to the upper game board row).
     */
    private final BoardItem[][] items;

    public BoardGrid(
            final GridTypes type,
            final int size,
            final BoardItem[][] items) {
        this.type = type;
        this.size = size;
        this.items = items;
    }

    /**
     * @return Size of the board
     */
    public int getSize() {
        return size;
    }

    /**
     * @return How many rows the game board consists of.
     */
    public int getRowsSize() {
        return items.length;
    }

    /**
     * @param row specified row number from top to bottom.
     * @return how many columns the specified row has.
     * @throws IllegalArgumentException if row parameter is out of range
     */
    public int getColumnSize(final int row) {
        Preconditions.checkArgument(row >= 0, "Row parameter must be not negative! Got: " + row);
        Preconditions.checkArgument(row < items.length,
                "Row parameter must be in the board size range! " +
                        "Board rows: " + items.length + ", Got: " + row);
        return items[row].length;
    }

    public GridTypes getType() {
        return type;
    }

    public BoardItem[][] getItems() {
        return items;
    }

    /**
     * Returns game board item by its position.
     * Rows are counted from top to bottom. Columns from left to right.
     *
     * @param row    row number.
     * @param column column number.
     * @return {@link BoardItem} of the specified position.
     * @throws IllegalArgumentException if position is out the board size range.
     */
    public BoardItem getItem(final int row, final int column) {
        Preconditions.checkArgument(row >= 0,
                "Row parameter must be not negative! Got: " + row);
        Preconditions.checkArgument(row < items.length || row == 0 && items.length == 0,
                "Row parameter must be in the board size range! " +
                        "Board rows: " + items.length + ", Got: " + row);
        final BoardItem[] arrRow = items[row];
        Preconditions.checkArgument(column >= 0,
                "Column parameter must be not negative! Got: " + column);
        Preconditions.checkArgument(column < arrRow.length || column == 0 && arrRow.length == 0,
                "Column parameter must be in the row size range! " +
                        "Row columns: " + arrRow.length + ", Got: " + column);
        return arrRow[column];
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("type", type)
                .add("size", size)
                .add("items", items)
                .toString();
    }
}
