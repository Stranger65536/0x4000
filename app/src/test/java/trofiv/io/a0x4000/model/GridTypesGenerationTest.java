package trofiv.io.a0x4000.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GridTypesGenerationTest {
    @Test
    public void testRegularGeneration() {
        final BoardGrid emptyGrid = GridTypes.REGULAR.generateBoard(0);
        assertThat(emptyGrid.getRowsSize(), equalTo(0));
        assertThat(emptyGrid.getType(), equalTo(GridTypes.REGULAR));

        final BoardGrid oneCellGrid = GridTypes.REGULAR.generateBoard(1);
        assertThat(oneCellGrid.getRowsSize(), equalTo(1));
        assertThat(oneCellGrid.getColumnSize(0), equalTo(1));
        assertThat(oneCellGrid.getItem(0, 0), equalTo(null));
        assertThat(oneCellGrid.getItems(), equalTo(new BoardItem[1][1]));
        assertThat(oneCellGrid.getType(), equalTo(GridTypes.REGULAR));

        final BoardGrid fourCellGrid = GridTypes.REGULAR.generateBoard(2);
        assertThat(fourCellGrid.getRowsSize(), equalTo(2));
        assertThat(fourCellGrid.getColumnSize(0), equalTo(2));
        assertThat(fourCellGrid.getColumnSize(1), equalTo(2));
        assertThat(fourCellGrid.getItem(0, 0), equalTo(null));
        assertThat(fourCellGrid.getItem(0, 1), equalTo(null));
        assertThat(fourCellGrid.getItem(1, 0), equalTo(null));
        assertThat(fourCellGrid.getItem(1, 1), equalTo(null));
        assertThat(fourCellGrid.getItems(), equalTo(new BoardItem[2][2]));
        assertThat(fourCellGrid.getType(), equalTo(GridTypes.REGULAR));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRegularGeneration() {
        GridTypes.REGULAR.generateBoard(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRegularBoardUsageRow() {
        final BoardGrid oneCellGrid = GridTypes.REGULAR.generateBoard(1);
        oneCellGrid.getItem(1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRegularBoardUsageColumn() {
        final BoardGrid oneCellGrid = GridTypes.REGULAR.generateBoard(1);
        oneCellGrid.getItem(0, 1);
    }

    @Test
    public void testHexagonGeneration() {
        final BoardGrid emptyGrid = GridTypes.HEXAGON.generateBoard(0);
        assertThat(emptyGrid.getRowsSize(), equalTo(0));
        assertThat(emptyGrid.getType(), equalTo(GridTypes.HEXAGON));

        final BoardGrid oneCellGrid = GridTypes.HEXAGON.generateBoard(1);
        assertThat(oneCellGrid.getRowsSize(), equalTo(1));
        assertThat(oneCellGrid.getColumnSize(0), equalTo(1));
        assertThat(oneCellGrid.getItem(0, 0), equalTo(null));
        assertThat(oneCellGrid.getItems(), equalTo(new BoardItem[1][1]));
        assertThat(oneCellGrid.getType(), equalTo(GridTypes.HEXAGON));

        final BoardGrid fourCellGrid = GridTypes.HEXAGON.generateBoard(2);
        assertThat(fourCellGrid.getRowsSize(), equalTo(3));
        assertThat(fourCellGrid.getColumnSize(0), equalTo(2));
        assertThat(fourCellGrid.getColumnSize(1), equalTo(3));
        assertThat(fourCellGrid.getColumnSize(2), equalTo(2));
        assertThat(fourCellGrid.getItem(0, 0), equalTo(null));
        assertThat(fourCellGrid.getItem(0, 1), equalTo(null));
        assertThat(fourCellGrid.getItem(1, 0), equalTo(null));
        assertThat(fourCellGrid.getItem(1, 1), equalTo(null));
        assertThat(fourCellGrid.getItem(1, 2), equalTo(null));
        assertThat(fourCellGrid.getItem(2, 0), equalTo(null));
        assertThat(fourCellGrid.getItem(2, 1), equalTo(null));
        assertThat(fourCellGrid.getItems(), equalTo(new BoardItem[][]{
                {null, null},
                {null, null, null},
                {null, null}}));
        assertThat(fourCellGrid.getType(), equalTo(GridTypes.HEXAGON));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidHexagonGeneration() {
        GridTypes.HEXAGON.generateBoard(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidHexagonBoardUsageRow() {
        final BoardGrid oneCellGrid = GridTypes.HEXAGON.generateBoard(1);
        oneCellGrid.getItem(1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidHexagonBoardUsageColumn() {
        final BoardGrid oneCellGrid = GridTypes.HEXAGON.generateBoard(1);
        oneCellGrid.getItem(0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidHexagonBoardUsageColumnShape() {
        final BoardGrid oneCellGrid = GridTypes.HEXAGON.generateBoard(2);
        oneCellGrid.getItem(0, 2);
    }
}
