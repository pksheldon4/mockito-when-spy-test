package com.pksheldon4.test.mockitowhenspytest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@Slf4j
public class BusinessThingTest {



    @Test
    public void doSomething_returnsAList_whenMock() {

        BusinessThing businessThing = mock(BusinessThing.class);
        when(businessThing.doSomething(anyString())).thenReturn(singletonList("Test Results"));

        List<String> results = businessThing.doSomething("Some Value");
        log.info(results.toString());
        assertThat(results, hasSize(1));
        assertThat(results.get(0), is("Test Results"));
    }

    @Test
    public void doSomething_returnsAList_whenSpy_doReturn() {

        BusinessThing businessThing = spy(BusinessThing.class);
        doReturn(singletonList("Test Results")).when(businessThing).doSomething(anyString());

        List<String> results = businessThing.doSomething("Some Value");
        log.info(results.toString());
        assertThat(results, hasSize(1));
        assertThat(results.get(0), is("Test Results"));
    }

    @Test
    public void doSomething_throwsAnException_whenSpy_whenThenReturn() {

        BusinessThing businessThing = spy(BusinessThing.class);
        when(businessThing.doSomething(anyString())).thenReturn(singletonList("Test Results"));

        List<String> results = businessThing.doSomething("Some Value");
        log.info(results.toString());
        assertThat(results, hasSize(1));
        assertThat(results.get(0), is("Test Results"));
    }

}