package trofiv.io.a0x4000.service.generation.tiles;

import trofiv.io.a0x4000.model.BoardItem;

/**
 * Modified 2048 tiles probability-based generator.
 * Likewise the {@link ProbabilityTileGenerator},
 * produces tiles greater than baseline by one or two,
 * but also makes them negative with some chance.
 * //TODO
 */
public class RandomSignProbabilityTileGenerator implements NewTilesGenerator {
    @Override
    public BoardItem generate() {
        return null;
    }
}
