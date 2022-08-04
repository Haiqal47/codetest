package com.haiqalrama.codetest;

import com.haiqalrama.codetest.entity.User;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(0L, "Haiqal"));
        userList.add(new User(1L, "Ramanizar"));
        userList.add(new User(2L, "Al Fajri"));

        for (User user : userList) {
            System.out.println(user);
        }
    }
}
