package trofiv.io.a0x4000.model;

import com.google.common.base.MoreObjects;

import java.util.Arrays;
import java.util.Optional;

public enum SlideDirections {
    RIGHT(0) {
        @Override
        public SlideDirections rotate() {
            return UP_RIGHT;
        }
    },
    UP_RIGHT(45) {
        @Override
        public SlideDirections rotate() {
            return UP;
        }
    },
    UP(90) {
        @Override
        public SlideDirections rotate() {
            return UP_LEFT;
        }
    },
    UP_LEFT(135) {
        @Override
        public SlideDirections rotate() {
            return LEFT;
        }
    },
    LEFT(180) {
        @Override
        public SlideDirections rotate() {
            return DOWN_LEFT;
        }
    },
    DOWN_LEFT(225) {
        @Override
        public SlideDirections rotate() {
            return DOWN;
        }
    },
    DOWN(270) {
        @Override
        public SlideDirections rotate() {
            return DOWN_RIGHT;
        }
    },
    DOWN_RIGHT(315) {
        @Override
        public SlideDirections rotate() {
            return RIGHT;
        }
    };

    final int degree;

    SlideDirections(final int degree) {
        this.degree = degree;
    }

    public static SlideDirections of(final int degree) {
        final Optional<SlideDirections> opt = Arrays.stream(values())
                .filter(v -> v.degree == degree).findFirst();
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new IllegalArgumentException("No such slide direction with degree: " + degree);
        }
    }

    public abstract SlideDirections rotate();

    public int getDegree() {
        return degree;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("degree", degree)
                .toString();
    }
}
