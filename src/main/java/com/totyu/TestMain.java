package com.totyu;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMain {
    public static void printList1(List<Object> list) {
        for (Object elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

    public static <T> void printList2(List<T> list) {
        for (T elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

    public static  void printList3(List<?> list) {
        for (int i = 0;i<list.size();i++)
            System.out.println(list.get(i) + " ");
        System.out.println();
    }

    public static <T> T getBean(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        T t = clazz.newInstance();
        return t;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<ArrayList> clazz = ArrayList.class;
        List bean = getBean(clazz);
        Method add = clazz.getMethod("add", Object.class);
        add.invoke(bean,"dhsadufhsauhfksad");
        System.out.println(bean);
    }
}
