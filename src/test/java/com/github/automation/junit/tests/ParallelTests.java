package com.github.automation.junit.tests;

import lombok.NonNull;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelTests {

    @Test
    public void fun() throws Exception {

        List<Callable<String>> tasks = new ArrayList<>();

        List<Integer> num = new ArrayList<>();
        num.add(1);
        num.add(2);

        for(int n : num) tasks.add(() -> parallel(n));

        executeAndWaitForResponse(tasks);
    }

    private String parallel(int x) {
        for(int i = 1; i <= 10; i++) {
            System.out.println(x + " " + i*x);
        }
        return "Task " + x;
    }

    private static <T> List<T> executeAndWaitForResponse(@NonNull List<Callable<T>> tasks) throws Exception {
        try {
            final ExecutorService executor = Executors.newFixedThreadPool(tasks.size());
            final List<Future<T>> futures = executor.invokeAll(tasks);
            final List<T> results = new ArrayList<>();

            for (Future<T> future : futures) {
                results.add(future.get());
            }

            return results;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}
