package com.t13max.design.builder2;

/**
 * @Author 呆呆
 * @Datetime 2022/4/18 7:48
 */
public class Person {

    private int id;

    private String name;

    private int age;


    public Person(Builder builder) {

        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
    }

    public static class Builder {
        private int id;

        private String name;

        private int age;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public static Builder newBuilder() {

            return new Builder();
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder String(String name) {
            this.name = name;
            return this;
        }

        public Person build() {
            Person person = new Person(this);

            return person;
        }
    }
}
