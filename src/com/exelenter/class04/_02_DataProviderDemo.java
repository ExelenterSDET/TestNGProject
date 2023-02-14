package com.exelenter.class04;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _02_DataProviderDemo {
    // DataProvide it works with 2D Array and accepts Object as data type.
    @Test
    void printData() {
        userList();
        data();
    }


    // Manipulating data without DataProvider.
    public void userList() {
        List<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("John");
        stringArrayList.add("Sam");
        //stringArrayList.add(25);
        List<Object> objectsList = new ArrayList<>();
        objectsList.add("John");
        objectsList.add(25);
        objectsList.add(0.95);
        System.out.println("stringArrayList = " + stringArrayList);
        System.out.println("objectsList = " + objectsList);
    }

    public void data() {
        // One single data type only per each variable.
        String str = "Hello";                                     // Only one data type
        int i = 10;

        // Single object
        Object user = 10;                                         // all data types accepted here, BUT only ONE at a time.

        // Array of objects
        Object[] users = {"John Doe", "Sam Lee", 'c', 45, 25};    // Now I can accept more than one value AND all data types.

        // 2D Array, Array of Arrays.
        Object[][] users2D = {
                {"John Doe", "Sam Lee", 'c', 45, 0.99},
                {"John Doe", "Sam Lee", 'c', 45, 5.67},
                {"John Doe", "Sam Lee", 'c', 45, 66.99}
        };
        System.out.println("users2D = " + Arrays.deepToString(users2D));
        Arrays.stream(users2D).forEach(a -> System.out.println(Arrays.toString(a)));
    }

    // Manipulating DATA using DataProvider

    @Test(dataProvider = "users")
    public void printData2(String firstName, String lastName, int age) {
        System.out.println(firstName + " " + lastName + " " + age);
    }

    @DataProvider
    public Object[][] users() {
        Object[][] user = {
                {"John", "Doe", 20},
                {"Sam", "Lee", 35},
                {"Jack", "Sparrow", 40}
        };
        return user;
    }

}
