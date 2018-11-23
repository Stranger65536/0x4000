package trofiv.io.a0x4000.service.generation.values;

/**
 * According to this value generation rule, only neighboring elements in the Fibonacci sequence
 * can be combined with a result of a next Fibonacci sequence number.
 */
public class FibonacciValueGenerator implements ValueGenerator {
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
