package com.greenlaw110;

import com.esotericsoftware.reflectasm.MethodAccess;
import org.osgl.mvc.result.Result;

/**
 * This emulate ActFramework's ReflectedHandlerInvoker
 */
public class ReflectedControllerInvoker {

    static MethodAccess methodAccess;
    static int handler;
    static int handlerTwo;
    static int handlerThree;
    static int handlerFour;
    static Controller controller;

    static {
        init();
    }

    public static void invoke(String msg) throws Throwable {
        methodAccess.invoke(controller, handler, msg);
    }

    public static void invokeTwo(String msg) throws Throwable {
        methodAccess.invoke(controller, handlerTwo, msg);
    }

    public static Result invokeThree(String msg) throws Throwable {
        return (Result) methodAccess.invoke(controller, handlerThree, msg);
    }

    public static Result invokeFour(String msg) throws Throwable {
        return (Result) methodAccess.invoke(controller, handlerFour, msg);
    }

    static void init() {
        methodAccess = MethodAccess.get(Controller.class);

        handler = methodAccess.getIndex("handler", String.class);
        handlerTwo = methodAccess.getIndex("handlerTwo", String.class);
        handlerThree = methodAccess.getIndex("handlerThree", String.class);
        handlerFour = methodAccess.getIndex("handlerFour", String.class);

        controller = new Controller();
    }

}
