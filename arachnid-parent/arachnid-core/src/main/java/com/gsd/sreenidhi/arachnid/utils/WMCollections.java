package com.gsd.sreenidhi.arachnid.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public class WMCollections {

    public static <T> Set<T> newHashSet(T... t){
        Set<T> set = new HashSet<T>(t.length);
        for (T t1 : t) {
            set.add(t1);
        }
        return set;
    }

    public static <T> List<T> newArrayList(T... t){
        List<T> set = new ArrayList<T>(t.length);
        for (T t1 : t) {
            set.add(t1);
        }
        return set;
    }
}
