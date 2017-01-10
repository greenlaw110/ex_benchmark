package com.greenlaw110;

import org.osgl.mvc.result.NotFound;
import org.osgl.mvc.result.Result;

/**
 * This emulate a normal act app controller class
 */
public class Controller extends MvcUtil {

    public void handler(String msg) {
        notFoundIf(true, msg);
    }

    public void handlerTwo(String msg) {
        notFoundIfTwo(true, msg);
    }

    public Result handlerThree(String msg) {
        return new NotFound(msg);
    }

    public Result handlerFour(String msg) {
        MvcUtil.MSG.set(msg);
        return NotFound.INSTANCE;
    }

}
