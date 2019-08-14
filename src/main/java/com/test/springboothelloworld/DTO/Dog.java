package com.test.springboothelloworld.DTO;

/**
 * description
 *
 * @author 24360 2019/08/14 16:24
 */
public class Dog {
    private String name ;

    private Integer age ;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
