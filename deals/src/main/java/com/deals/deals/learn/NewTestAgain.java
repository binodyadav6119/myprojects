package com.deals.deals.learn;


import org.springframework.stereotype.Service;

@Service
public class NewTestAgain implements Test
{
    @Override
    public String getName(String name) {
        System.out.println("--------------------");
        System.out.println(name);
        return name;
    }
}
