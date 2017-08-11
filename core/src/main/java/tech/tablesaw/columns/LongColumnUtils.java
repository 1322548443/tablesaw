package tech.tablesaw.columns;

import it.unimi.dsi.fastutil.longs.LongIterable;
import tech.tablesaw.api.LongColumn;
import tech.tablesaw.filtering.LongBiPredicate;
import tech.tablesaw.filtering.LongPredicate;

/**
 * Pre-made predicates for common integer use cases, and other helpful things
 */
public interface LongColumnUtils extends Column, LongIterable {

    LongPredicate isZero = i -> i == 0;

    LongPredicate isNegative = i -> i < 0;

    LongPredicate isPositive = i -> i > 0;

    LongPredicate isNonNegative = i -> i >= 0;

    LongPredicate isEven = i -> (i & 1) == 0;

    LongPredicate isOdd = i -> (i & 1) != 0;

    LongBiPredicate isGreaterThan = (valueToTest, valueToCompareAgainst) -> valueToTest > valueToCompareAgainst;

    LongBiPredicate isGreaterThanOrEqualTo = (valueToTest, valueToCompareAgainst) -> valueToTest >=
            valueToCompareAgainst;

    LongBiPredicate isLessThan = (valueToTest, valueToCompareAgainst) -> valueToTest < valueToCompareAgainst;

    LongBiPredicate isLessThanOrEqualTo = (valueToTest, valueToCompareAgainst) -> valueToTest <= valueToCompareAgainst;

    LongBiPredicate isEqualTo = (long valueToTest, long valueToCompareAgainst) -> valueToTest == valueToCompareAgainst;

    LongBiPredicate isNotEqualTo = (long valueToTest, long valueToCompareAgainst) -> valueToTest != valueToCompareAgainst;

    LongPredicate isMissing = i -> i == LongColumn.MISSING_VALUE;
    LongPredicate isNotMissing = i -> i != LongColumn.MISSING_VALUE;

}
