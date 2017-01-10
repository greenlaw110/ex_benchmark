/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.greenlaw110;

import org.openjdk.jmh.annotations.Benchmark;
import org.osgl.mvc.result.Result;
import org.osgl.util.E;

public class MyBenchmark {

    private static ReflectedControllerInvoker invoker;

    @Benchmark
    public void testMethod() {
        try {
            invoker.invoke("abc");
        } catch (Result result) {
            if (!"abc".equals(result.getMessage())) {
                throw E.unexpected("msg not match");
            }
        } catch (Throwable e) {
            throw E.unexpected(e);
        }
    }

    @Benchmark
    public void testMethodTwo() {
        try {
            invoker.invokeTwo("abc");
        } catch (Result result) {
            if (!"abc".equals(MvcUtil.msg())) {
                throw E.unexpected("msg not match");
            }
        } catch (Throwable e) {
            throw E.unexpected(e);
        }
    }

    @Benchmark
    public void testMethodThree() {
        try {
            Result result = invoker.invokeThree("abc");
            if (!"abc".equals(result.getMessage())) {
                throw E.unexpected("msg not match");
            }
        } catch (Throwable throwable) {
            throw E.unexpected(throwable);
        }
    }

    public static void main(String[] args) {
        new MyBenchmark().testMethod();
        new MyBenchmark().testMethodTwo();
        new MyBenchmark().testMethodThree();
    }

}
