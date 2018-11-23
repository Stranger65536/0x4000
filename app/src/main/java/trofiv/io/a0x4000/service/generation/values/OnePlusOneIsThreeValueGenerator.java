package trofiv.io.a0x4000.service.generation.values;

/**
 * 1+1=3 game rules value generator.
 * //TODO
 */
public class OnePlusOneIsThreeValueGenerator implements ValueGenerator {
    @Override
    public int baseline() {
        return 0;
    }

    @Override
    public boolean isCombinationAllowed(final int standingTileValue, final int slidingTileValue) {
        return false;
    }

    @Override
    public int combine(final int standingTileValue, final int slidingTileValue) {
        return 0;
    }
}
