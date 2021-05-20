package org.example.nodes;

import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyListTest {


    @Before
    public void setUp() {

    }

    @Test
    public void testEmptyNode() {
        MyList myList = new MyList();
        assertThat(myList, IsNull.notNullValue());
        assertThat(myList.isEmpty(), is(true));
    }

    @Test
    public void testAppendNotEmpty() {
        MyList<String> myList = new MyList();
        myList.offer("1");
        assertThat(myList.isEmpty(), is(false));
    }

    @Test
    public void testAppendOneElement() {
        MyList<String> myList = new MyList<>();
        myList.offer("1");
        myList.offer("2");
        myList.offer("3");
        assertThat(myList.get(0), is("1"));
        assertThat(myList.get(1), is("2"));
        assertThat(myList.get(2), is("3"));
    }
}
