package com.test.UnitTestApp.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertExample {

    @Test
    public void assertTest(){
//        int val1=11;
//        int val2=11;
//        float val1=11.2f;
//        float val2=11.2f;
//        Assertions.assertEquals(val1,val2);

//        int arr[]={1,2,3};
//        int arr1[]={1,2,3};
//        Assertions.assertArrayEquals(arr,arr1);

//        String str=new String();
//        Assertions.assertNull(str);
//        Assertions.assertNotNull(str);

//        String str1="hello";
//        String str2="hello";
//        Assertions.assertSame(str1,str2);
        String s1=new String("Hello");
        String s2=new String("Hello");
//        Assertions.assertSame(s1,s2);
        Assertions.assertNotSame(s1,s2);
}
    }
