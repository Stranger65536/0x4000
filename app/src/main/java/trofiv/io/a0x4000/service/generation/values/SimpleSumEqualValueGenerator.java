package trofiv.io.a0x4000.service.generation.values;

/**
 * Classic 2048 value generator - equal numbers are simply summed.
 * //TODO
 */
public class SimpleSumEqualValueGenerator implements ValueGenerator {
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
