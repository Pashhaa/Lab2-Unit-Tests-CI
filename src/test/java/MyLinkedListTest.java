import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    MyLinkedList list = new MyLinkedList();
    MyLinkedList newList = new MyLinkedList();
    String str = "abcdefghjklmnop";


    @BeforeEach
    void start() {
        for (int i = 0; i < 7; i++) {
            list.append(str.charAt(i));
        }
        newList.append('r');
    }

    @Test
    void length() {
        Assertions.assertEquals(7,list.length);
    }

    @Test
    void append() {
        list.append('8');
        Assertions.assertEquals(8,list.length);
    }

    @Test
    void insert() {
        list.insert('o',2);
        Assertions.assertEquals('o',list.get(2));
    }

    @Test
    void delete() {
        list.delete(2);
        Assertions.assertEquals('d',list.get(2));
    }

    @Test
    void deleteAll() {
        list.append('c');
        list.append('c');
        list.deleteAll('c');
        Assertions.assertEquals(6,list.length());
    }

    @Test
    void get() {
        Assertions.assertEquals('a',list.get(0));
    }

    @Test
    void testClone() {
        MyLinkedList clonedList = list.clone();
        Assertions.assertEquals('a', clonedList.get(0));
    }


    @Test
    void reverse() {
        list.reverse();
        Assertions.assertEquals('a',list.get(6));
    }

    @Test
    void findFirst() {
        Assertions.assertEquals(0, list.findFirst('a'));
    }

    @Test
    void findLast() {
        Assertions.assertEquals(0, list.findFirst('a'));
    }

    @Test
    void clear() {
        list.clear();

        Assertions.assertEquals(null, list.testMethod() );
    }

    @Test
    void extend() {
        list.extend(newList);
        Assertions.assertEquals('r',list.get(7));
    }
}