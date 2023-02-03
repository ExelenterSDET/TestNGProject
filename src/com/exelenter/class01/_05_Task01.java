package com.exelenter.class01;

import org.testng.annotations.Test;

/**
 *  Task: Create a class that has 5 test methods named as the following:
 *      1. firstMethod
 *      2. firstMethod1
 *      3. secondMethod
 *      4. thirdMethod
 *      5. fourthMethod
 *   And each of them printing the method name
 *   Run and observe the results
 *   Then, add the needed attribute(s) to print them in the following result:
 *      1. fourthMethod
 *      2. thirdMethod
 *      3. secondMethod
 *      4. firstMethod
 */
public class _05_Task01 {

    @Test
    void firstMethod() {
        System.out.println("firstMethod");
    }

    @Test
    void firstMethod1() {
        System.out.println("firstMethod1");
    }

    @Test
    void secondMethod() {
        System.out.println("secondMethod");
    }

    @Test
    void thirdMethod() {
        System.out.println("thirdMethod");
    }

    @Test
    void fourthMethod() {
        System.out.println("fourthMethod");
    }


}
