package trofiv.io.a0x4000.service.generation.tiles;

import trofiv.io.a0x4000.model.BoardItem;

/**
 * Intended to be used as a new tiles generator on the gaming board.
 */
@FunctionalInterface
public interface NewTilesGenerator {
    /**
     * Generates a new tile on the board.
     *
     * @return new {@link BoardItem} entity.
     */
    BoardItem generate();
}
