package trofiv.io.a0x4000.service.generation.values;

/**
 * Intended to be used to perform tiles combination possibility check
 * alongside with combination value calculation.
 * Also defines a baseline tile value.
 * Must support negative values.
 */
public interface ValueGenerator {
    /**
     * Defines a baseline tile value.
     *
     * @return integer value of a baseline tile value.
     */
    int baseline();

    /**
     * Checks whether two tiles after sliding have to be combined into a new one.
     * Allows to differentiate behavior based on a standing / sliding tile value
     * (may be useful when you want to introduce non-standard rule of allowing
     * of combining a sliding tile to a standing tile with greater value only).
     * Notice a caching of this method results.
     *
     * @param standingTileValue value of a standing tile
     * @param slidingTileValue  value of a sliding tile
     * @return true if combination is allowed, else otherwise
     */
    boolean isCombinationAllowed(final int standingTileValue, final int slidingTileValue);

    /**
     * Performs a tiles combination calculation. Relies on a validity of the performing combination.
     * Allows to differentiate behavior based on a standing / sliding tile value
     * (may be useful when you want to introduce non-standard rule of allowing
     * of combining a sliding tile to a standing tile with greater value only).
     * Notice a caching of this method results.
     *
     * @param standingTileValue value of a standing tile
     * @param slidingTileValue  value of a sliding tile
     * @return value of a new tile which has to be generated
     * in a result of the specified combination.
     */
    int combine(final int standingTileValue, final int slidingTileValue);
}
