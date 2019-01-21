package com.WebFluxReactive.test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class test {
     public static class Person{
         public Person(String name,int age) {
             this.name = name;
             this.age=age;
         }

         public int getAge() {
             return age;
         }

         public void setAge(int age) {
             this.age = age;
         }

         private  int age;
         public String getName() {
             return name;
         }

         public void setName(String name) {
             this.name = name;
         }

         private String name;

     }

    public static void main(String[] args) {
       /* Mono.just(new Pserson("admin")).subscribe(System.out::println);*/
        /*数据序列*/
        /**
         *doOnComplete基于事件
         */
/*
        Flux.just(1,2,3,4,5,6).doOnComplete(new Runnable() {
            @Override
            public void run() {
                System.out.println("完成");
            }
        }).subscribe(System.out::println);
*/
/**
 * map  对管道中Flux 的数据序列的线程统一+2
 */
        Flux.just(1,2,3,4,5,6).filter(i -> i % 2==0).map(integer -> integer+2).doOnComplete(new Runnable() {
            @Override
            public void run() {
                System.out.println("完成");
            }
        }).subscribeOn(Schedulers.newElastic("线程1")).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+",");
            }

        });

        /**
         * webFlux根据年龄大小进行排序
         * 思路：加过滤器filter进行条件查询，
         * 使用map把年龄转化成int类型
         * sorted：进行排序
         *
         */

      /*  int age = Stream.of(new Person[]{new Person("a",18),new Person("b",21),new Person("c",30)})
                .filter(person -> person.age < 30 & person.age > 20).mapToInt(value -> value.age).sorted().findFirst().getAsInt();
        System.out.println(age);*/

    }
}
