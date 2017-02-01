package org.takaooo.utils;

import jersey.repackaged.com.google.common.collect.Maps;
import jersey.repackaged.com.google.common.collect.Sets;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MarshallerUtil {

    /**
     * Turns two iterables into a single map where values from first iterables
     * is the key and maps to the values in the second iterable.
     * The size of the unique values in the first iterable must be equal to the
     * full size of the second.
     * @param c1 keys to put into map.
     * @param c2 values to put into map.
     * @return map of c1 -> c2
     */
    public static <A,B> Map<A,B> Mapify(Iterable<A> c1, Iterable<B> c2){
        Set<A> keys = Sets.newLinkedHashSet(c1);
        if(keys.size()!= Iterables.size(c2)){
            throw new IllegalArgumentException("values should be same size as unique keys");
        }
        return safeMapify(keys,c2);
    }

    private static <A,B> Map<A,B> safeMapify(Iterable<A> keys, Iterable<B> values){
        Map<A,B> retval = Maps.newHashMap();
        Iterator<B> itVal = values.iterator();
        for(A key : keys){
            retval.put(key,itVal.next());
        }

        return retval;
    }
}
