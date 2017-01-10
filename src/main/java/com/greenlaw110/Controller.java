package com.greenlaw110;

import org.osgl.mvc.result.NotFound;
import org.osgl.mvc.result.Result;

/**
 * Created by luog on 11/01/17.
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
        return NotFound.INSTANCE;
    }

}
