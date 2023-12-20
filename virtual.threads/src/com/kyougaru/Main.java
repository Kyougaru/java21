package com.kyougaru;

import com.kyougaru.model.Developer;

import java.util.concurrent.*;

public class Main {
    static CopyOnWriteArrayList<Developer> developers = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //Virtual threads
        try(var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(() -> {
                developers.add(new Developer("Maria", 20, 173));
            });
            executor.submit(() -> {
                developers.add(new Developer("João", 20, 180));
            });

            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.SECONDS);
            for (Developer developer : developers) {
                System.out.println(developer);
            }
        }

        //Structured Concurrency
        try(var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            StructuredTaskScope.Subtask<Double> task = scope.fork(() -> developers.get(0).calculateSalary());
            StructuredTaskScope.Subtask<Double> task2 = scope.fork(() -> developers.get(1).calculateSalary());

            scope.join();
            scope.throwIfFailed();

            System.out.println(task.get());
            System.out.println(task2.get());
        }
    }
}