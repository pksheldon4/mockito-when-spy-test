package com.pksheldon4.test.mockitowhenspytest;

import java.util.List;

public class BusinessThing {


    public List<String> doSomething(String value) {
        throw new UnsupportedOperationException("This should never be called during this test");
    }
}
