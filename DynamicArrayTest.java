import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {

    @Test
    void testCapacity() {
        DynamicArray array = new DynamicArray();
        assertEquals(2,2);
        array.capacity();
    }

    @Test
    void testAddElement() {
        DynamicArray array = new DynamicArray();
        array.addElement(1);
        array.addElement(2);
        assertEquals(array.getElement(0),1);
        assertEquals(array.getElement(1),2);
    }

    @Test
    void testAddElement2() {
        DynamicArray array = new DynamicArray();
        array.addElement(0,3);
        array.addElement(1,4);
        array.addElement(2,5);
        assertEquals(array.getElement(0),3);
        assertEquals(array.getElement(1),4);
        assertEquals(array.getElement(2),5);
    }

    @Test
    void getElement() {
        DynamicArray array = new DynamicArray();
        array.addElement(1);
        array.addElement(2);
        assertEquals(array.getElement(0),1);
        assertEquals(array.getElement(1),2);
    }

    @Test
    void remove() {
        DynamicArray array = new DynamicArray();
        array.addElement(1);
        array.addElement(2);
        array.addElement(3);
        array.remove(0);
        assertEquals(array.getElement(0),2);
        assertEquals(array.getElement(1),3);
        array.trimToSize();
        assertEquals(array.capacity(),2);
    }

    @Test
    void trimToSize() {
        DynamicArray array = new DynamicArray();
        array.addElement(1);
        array.addElement(2);
        array.addElement(3);
        array.addElement(3);
        array.addElement(3);
        array.addElement(3);
        array.remove(5);
        array.remove(4);
        array.remove(3);
        array.trimToSize();
        assertEquals(array.capacity(),3);
    }
}