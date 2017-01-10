package com.greenlaw110;

import org.osgl.mvc.result.NotFound;
import org.osgl.util.S;

/**
 * Created by luog on 11/01/17.
 */
public class MvcUtil {

    public static final ThreadLocal<String> MSG = new ThreadLocal<>();

    public static void notFoundIf(boolean test, String msg, Object ... args) {
        if (test) {
            throw new NotFound(msg, args);
        }
    }

    public static void notFoundIfTwo(boolean test, String msg, Object... args) {
        if (test) {
            MSG.set(S.fmt(msg, args));
            throw NotFound.INSTANCE;
        }
    }

    public static String msg() {
        return MSG.get();
    }

}
