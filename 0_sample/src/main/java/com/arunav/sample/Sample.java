package com.arunav.sample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Sample {

    public static void main(String[] args) {

        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(tz);
        String nowAsISO = df.format(new Date());
        System.out.println(nowAsISO);

        Integer arr[] = {3, 8, 2, 3, 3, 2};
        Integer arr1[] = {5, 5, 5, 5, 5};

        Map<Integer, Long> collect = Arrays.stream(arr)
                .collect(groupingBy(item -> item, counting()));

        int max = 0;
        for (Integer key : collect.keySet()) {
            if (key.intValue() == collect.get(key))
                max = Math.max(max, key);
        }

        System.out.println(max);
        System.out.println(collect);
    }
}
