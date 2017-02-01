package org.takaooo.utils;

public class Iterables {

    public static <T> int size(Iterable<T> i){
        int retval = 0;
        for(T value : i){
            retval++;
        }
        return retval;
    }
}
