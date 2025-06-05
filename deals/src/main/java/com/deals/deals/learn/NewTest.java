package com.deals.deals.learn;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class NewTest implements Test
{
    @Override
    public String getName(String name) {
        return name;
    }
}
