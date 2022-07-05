import java.util.Arrays;

public class DynamicArray {
    private int[] array;
    private int size;
    private int capacity;

    public DynamicArray() {
        array = new int[2]; // начальный массив
        size = 0; // количество добавленных элементов
        capacity = 2; // вместимость масcива
    }
    // Создали конструктор с начальными входными данными.

    public int capacity(){
        return capacity;
    }
    // Метод возвращающий capacity.

    public void ensureCapacity(int minCapacity){
        int temp[] = new int[capacity*minCapacity];
        for (int i=0; i < capacity; i++){
            temp[i] = array[i];
        }
        array = temp;
        capacity = capacity * minCapacity;
    }
    // Метод расширяющий вместимость массива. Создаём новый массив temp c размером capacity*minCapacity, перезапиываем элементы массива array в temp,
    // приравниваем array к temp, перезаписываем(увеличиваем) capacity.

    public void addElement(int element) {
        if (size == capacity) {
            ensureCapacity(2);
        }
        array[size] = element;
        size++;
    }
    // Метод добавляющий элемент в конец массива. Сравниваем size с capacity, если количество элементов развно размеру массива, увеличиваем массив
    // вызывая метод ensureCapacity с индексом 2 (в данном случае, то есть увеличиваем вместимость в 2 раза), если нет, добавляем элемент
    // c индексом size и сразу увеличиваем size++.

    public void addElement(int index, int element){
        if (size == capacity){
            ensureCapacity(2);
        }
        for(int i=size-1;i>=index;i--){
            array[i+1] = array[i];
        }
        array[index] = element;
        size++;
    }
    // Метод добавляющий элемент по индексу. Реализация абсолютна схожа с обычным AddElement за тем исключением, что мы сдвигаем все элементы вправо от индекса
    // добавленного элемента и подставляем элемент array[index] = element , а не array[size] = element (как в обычнои AddElement).

    public int getElement(int index){
        return array[index];
    }
    // Возвращает элемент по индексу.

    public void remove(int index){
        if(index>=size || index<0){
            System.out.println("No element at this index");
        }else{
            for(int i=index;i<size-1;i++){
                array[i] = array[i+1];
            }
            array[size-1]=0;
            size--;
        }
    }
    // Метод удаления элемента. Для начала проверяем чтобы не был index => количеству элементов или меньше нуля. Далее, приравниваем все элементы стоящие после
    // удаленного элемента к элементам стоящим на один индекс меньше. Простыми словами сдвигаем всё что справа от удаленного массива на шаг левее. Удалеяем посдений
    // элемент(ну этот момент уже нулевой) и уменьшаем size(кол-во элементов) на еденицу.

    public void trimToSize(){
        System.out.println("Trimming the array");
        int temp[] = new int[size];
        for (int i=0; i < size; i++){
            temp[i] = array[i];
        }
        array = temp;
        capacity = array.length;
    }
    // Уменьшаем размер динамического массива до текущего размера удаляя ненужное пространство.

    public void printElements(){
        System.out.println("elements in array are :"+ Arrays.toString(array));
    }
}






