package trofiv.io.a0x4000.service.generation.tiles;

import com.google.common.base.MoreObjects;

import trofiv.io.a0x4000.model.BoardItem;

/**
 * A very simple tile generator which always returns the least tile allowed.
 */
public class ConstantTileGenerator implements NewTilesGenerator {
    private final int leastTileAllowed;

    public ConstantTileGenerator(final int leastTileAllowed) {
        this.leastTileAllowed = leastTileAllowed;
    }

    @Override
    public BoardItem generate() {
        return new BoardItem(leastTileAllowed);
    }

    public int getLeastTileAllowed() {
        return leastTileAllowed;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("leastTileAllowed", leastTileAllowed)
                .toString();
    }
}
