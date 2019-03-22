
public class ArrayQueue<T> implements Queue<T>{
    private T[] arr= (T[])(new Object [10]);
    int head=0;
    int tail=0;
    //if tail moves your doing enqueue
    //if head moves your popping
    protected void grow_array(){

        T[] temp= (T[])(new Object[arr.length*2]);
        int i, count=0;

        if(tail< head){
            for(i=head; i< arr.length; i++){
                temp[count]= arr[i];
                count++;
            }
        }
        for(i= 0; i<tail; i++){
            temp[count]= arr[i];
            count++;
        }

        head=0;
        tail=count;
        this.arr=temp;
    }

    public boolean empty(){
        //is empty
        if(head == tail)
            return true;
        return false;
    }
    public T dequeue(){
        if(empty()){
            return null;
        }
        T temp = arr[head];
        head = (head+1)% arr.length;
        //circular array if reaches end it goes back to the end
        return temp;
    }
    public void enqueue(T item){
        if((tail + 1) % arr.length == head)
            grow_array();
        arr[tail] = item;
        //putting item in the queue *end of the line
        tail = (tail + 1) % arr.length;
    }
}