
public class ArrayStack<T> implements Stack<T>{
    private T[] arr;
    private int size;
    //private Object[] tempArray;

    protected void grow_array(){

        //changing T to an object array
        T[] temp= (T[])(new Object[arr.length*2]);
        System.arraycopy(arr, 0, temp, 0, arr.length-1);
//        System.out.println(arr.toString());
//        System.out.println(temp.toString());
        //copies the data
        this.arr=temp;
//        System.out.println(arr.toString());
    }

    public ArrayStack() {
        arr = (T[])(new Object[10]);
        size = 0;
        //tempArray = new Object[10];
    }

    public void push(T item) {
        if (size == arr.length - 1) {
            grow_array();
        }
        //pushes item to queue
//        if (size<=arr.length-1 && size >= 0)
        arr[size++]=item;
    }
    public T pop() {
        if (empty())
            return null;
        return arr[--size];
    }
    public T peek() {
        if(empty())
            return null;
        return arr[size];

    }
    public boolean empty() {
        //sets it back inbounds in case it goes out of bounds
        if (size <= 0) {
            size = 0;
            return true;
        }
        return false;
    }
}
