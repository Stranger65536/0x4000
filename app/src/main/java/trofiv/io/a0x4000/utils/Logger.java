package trofiv.io.a0x4000.utils;

import android.util.Log;

import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

@SuppressWarnings({"unused", "UtilityClassCanBeEnum"})
public final class Logger {

    private static final String PERSONAL_TAG = "Logger";
    @SuppressWarnings("StringBufferField")
    private static final ThreadLocal<StringBuilder> BUILDER_THREAD_LOCAL
            = ThreadLocal.withInitial(() -> new StringBuilder(255));

    private Logger() {
    }

    private static String getTag(final LoggerDepth depth) {
        final StringBuilder stringBuilder = BUILDER_THREAD_LOCAL.get();
        try {
            final String className = Thread.currentThread()
                    .getStackTrace()[depth.getValue()].getClassName();
            stringBuilder.append(' ');
            stringBuilder.append(LocalDateTime.now().format(ISO_LOCAL_DATE));
            stringBuilder.append(" [");
            stringBuilder.append(Thread.currentThread().getName());
            stringBuilder.append("] ");
            stringBuilder.append(className.substring(className.lastIndexOf('.') + 1));
            stringBuilder.append('[');
            stringBuilder.append(Thread.currentThread().getStackTrace()[depth.getValue()]
                    .getMethodName());
            stringBuilder.append(':');
            stringBuilder.append(Thread.currentThread().getStackTrace()[depth.getValue()]
                    .getLineNumber());
            stringBuilder.append("] ");
            return stringBuilder.toString();
        } catch (Exception ex) {
            //noinspection CallToPrintStackTrace
            ex.printStackTrace();
            if (Log.isLoggable(PERSONAL_TAG, Log.DEBUG)) {
                Log.d(PERSONAL_TAG, ex.getMessage());
            }
        } finally {
            stringBuilder.setLength(0);
        }
        return null;
    }

    public static void d(final String msg) {
        try {
            Log.d(getTag(LoggerDepth.ACTUAL_METHOD), msg);
        } catch (Exception exception) {
            Log.e(getTag(LoggerDepth.ACTUAL_METHOD),
                    "Logger failed, exception: " + exception.getMessage());
        }
    }

    public static void d(final String msg, final LoggerDepth depth) {
        try {
            Log.d(getTag(depth), msg);
        } catch (Exception exception) {
            Log.e(getTag(LoggerDepth.ACTUAL_METHOD),
                    "Logger failed, exception: " + exception.getMessage());
        }
    }

    public static void d(final String msg, final Throwable t, final LoggerDepth depth) {
        try {
            Log.d(getTag(depth), msg, t);
        } catch (Exception exception) {
            Log.e(getTag(LoggerDepth.ACTUAL_METHOD),
                    "Logger failed, exception: " + exception.getMessage());
        }
    }

    public static void e(final String msg) {
        try {
            Log.e(getTag(LoggerDepth.ACTUAL_METHOD), msg);
        } catch (Exception exception) {
            Log.e(getTag(LoggerDepth.ACTUAL_METHOD),
                    "Logger failed, exception: " + exception.getMessage());
        }
    }

    public static void e(final String msg, final LoggerDepth depth) {
        try {
            Log.e(getTag(depth), msg);
        } catch (Exception exception) {
            Log.e(getTag(LoggerDepth.ACTUAL_METHOD),
                    "Logger failed, exception: " + exception.getMessage());
        }
    }

    public static void e(final String msg, final Throwable t, final LoggerDepth depth) {
        try {
            Log.e(getTag(depth), msg, t);
        } catch (Exception exception) {
            Log.e(getTag(LoggerDepth.ACTUAL_METHOD),
                    "Logger failed, exception: " + exception.getMessage());
        }
    }

    public static void w(final String msg) {
        try {
            Log.w(getTag(LoggerDepth.ACTUAL_METHOD), msg);
        } catch (Exception exception) {
            Log.e(getTag(LoggerDepth.ACTUAL_METHOD),
                    "Logger failed, exception: " + exception.getMessage());
        }
    }

    public static void w(final String msg, final LoggerDepth depth) {
        try {
            Log.w(getTag(depth), msg);
        } catch (Exception exception) {
            Log.e(getTag(LoggerDepth.ACTUAL_METHOD),
                    "Logger failed, exception: " + exception.getMessage());
        }
    }

    public static void w(final String msg, final Throwable t, final LoggerDepth depth) {
        try {
            Log.w(getTag(depth), msg, t);
        } catch (Exception exception) {
            Log.e(getTag(LoggerDepth.ACTUAL_METHOD),
                    "Logger failed, exception: " + exception.getMessage());
        }
    }

    public static void v(final String msg) {
        try {
            Log.v(getTag(LoggerDepth.ACTUAL_METHOD), msg);
        } catch (Exception exception) {
            Log.e(getTag(LoggerDepth.ACTUAL_METHOD),
                    "Logger failed, exception: " + exception.getMessage());
        }
    }

    public static void v(final String msg, final LoggerDepth depth) {
        try {
            Log.v(getTag(depth), msg);
        } catch (Exception exception) {
            Log.e(getTag(LoggerDepth.ACTUAL_METHOD),
                    "Logger failed, exception: " + exception.getMessage());
        }
    }

    public static void v(final String msg, final Throwable t, final LoggerDepth depth) {
        try {
            Log.v(getTag(depth), msg, t);
        } catch (Exception exception) {
            Log.e(getTag(LoggerDepth.ACTUAL_METHOD),
                    "Logger failed, exception: " + exception.getMessage());
        }
    }

    public static void i(final String msg) {
        try {
            Log.i(getTag(LoggerDepth.ACTUAL_METHOD), msg);
        } catch (Exception exception) {
            Log.e(getTag(LoggerDepth.ACTUAL_METHOD),
                    "Logger failed, exception: " + exception.getMessage());
        }
    }

    public static void i(final String msg, final LoggerDepth depth) {
        try {
            Log.i(getTag(depth), msg);
        } catch (Exception exception) {
            Log.e(getTag(LoggerDepth.ACTUAL_METHOD),
                    "Logger failed, exception: " + exception.getMessage());
        }
    }

    public static void i(final String msg, final Throwable t, final LoggerDepth depth) {
        try {
            Log.i(getTag(depth), msg, t);
        } catch (Exception exception) {
            Log.e(getTag(LoggerDepth.ACTUAL_METHOD),
                    "Logger failed, exception: " + exception.getMessage());
        }
    }

    public static void wtf(final String msg) {
        try {
            Log.wtf(getTag(LoggerDepth.ACTUAL_METHOD), msg);
        } catch (Exception exception) {
            Log.e(getTag(LoggerDepth.ACTUAL_METHOD),
                    "Logger failed, exception: " + exception.getMessage());
        }
    }

    public static void wtf(final String msg, final LoggerDepth depth) {
        try {
            Log.wtf(getTag(depth), msg);
        } catch (Exception exception) {
            Log.e(getTag(LoggerDepth.ACTUAL_METHOD),
                    "Logger failed, exception: " + exception.getMessage());
        }
    }

    public static void wtf(final String msg, final Throwable t, final LoggerDepth depth) {
        try {
            Log.wtf(getTag(depth), msg, t);
        } catch (Exception exception) {
            Log.e(getTag(LoggerDepth.ACTUAL_METHOD),
                    "Logger failed, exception: " + exception.getMessage());
        }
    }

    @SuppressWarnings("PublicInnerClass")
    public enum LoggerDepth {
        ACTUAL_METHOD(4),
        LOGGER_METHOD(3),
        STACK_TRACE_METHOD(1),
        JVM_METHOD(0);

        private final int value;

        LoggerDepth(final int newValue) {
            value = newValue;
        }

        public int getValue() {
            return value;
        }
    }
}