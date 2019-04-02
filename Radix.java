@SuppressWarnings("unchecked")
public class Radix{
public class MyLinkedList<E>
{
  public class Node
  {
    public E data;
    public Node next;
    public Node previous;
    public Node(E newData, Node nNext, Node nPrevious)
    {
      data = newData;
      nNext = next;
      nPrevious = previous;
    }

    public E getData()
    {
      return data;
    }
    public Node getNext()
    {
      return next;
    }

    public Node getPrevious()
    {
      return previous;
    }
    public void setNext(Node input)
    {
      next = input;
    }
    public void setPrevious(Node input)
    {
      previous = input;
    }
    public void setData(E input)
    {
      data  = input;
    }
    public String toString(Node input)
    {
      String output = ("" + input.getData());
      return output;
    }
  }
  private int size = 0;
  private Node start;
  private Node end;

  public MyLinkedList()
  {
    size = 0;
  }
  public void clear(){
    start = null;
    end = null;}
  public int size()
  {
    return size;
  }
  public boolean add(E value)
  {
    if(size == 0)
    {
      Node holder = null;
      start = new Node(value, null, holder);
      end = start;
      size ++;
      return true;
    }
     if(size == 1)
    {
      Node holder = null;
      end = new Node(value, holder, null);
      end.setPrevious(start);
      start.setNext(end);
      size ++;
      return true;
    }
    Node setUp = new Node(value, null, null);
    setUp.setPrevious(end);
    end.setNext(setUp);
    end = setUp;
    size ++;
    return true;
  }
  public void add(int index, E value)
  {
    if(index > this.size() || index < 0)
    {
      throw new IndexOutOfBoundsException();
    }
    if(size < 2 || index == size)
    {
      add(value);
    }
    else
    {
    //Node input = new Node(value, getNode(index).getNext(), getNode(index));
    Node input = new Node(value, null, null);
    //getNode(index).getNext().setPrevious(input);
    input.setNext(getNode(index + 1));
    input.setPrevious(getNode(index));
    getNode(index).setNext(input);
    size ++;
  }
  }

  public boolean contains(E item)
  {
    Node power = start;
    while(power != null)
    {
        if(power.getData() == item)
        {
          return true;
        }
        power = power.getNext();
    }
    return false;
  }
  public E remove(int index)
  {
    if(index > this.size() || index < 0)
    {
      throw new IndexOutOfBoundsException();
    }
    if(index == 0)
    {
      E output = start.getData();
      start = start.getNext();
      start.setPrevious(null);
      size --;
      return output;
    }
    if(index == size - 1)
    {
      E output = end.getData();
      end = end.getPrevious();
      end.setNext(null);
      size --;
      return output;
    }
    Node output = this.getNode(index);
    E val = output.getData();
    output.getNext().setPrevious(output.getPrevious());
    output.getPrevious().setNext(output.getNext());
    output.setNext(null);
    output.setPrevious(null);
    size --;
    return val;
  }
  public int indexOf(E value)
  {
    if(! this.contains(value))
    {
      return -1;
    }
    Node power = start;
    int counter = 0;
    while( power.getData() != value)
    {
      counter ++;
      power = power.getNext();
    }
    return counter;
  }
  public boolean removeValue(E value)
  {
    if(this.indexOf(value) == -1)
    {
      return false;
    }
    remove(this.indexOf(value));
    return true;
  }
  public E get(int index)
  {
    return getNode(index).getData();
  }
  private Node getNode(int index)
  {
  if(index > this.size() || index < 0)
  {throw new IndexOutOfBoundsException();}
  int counter = 0;
  Node power = start;
  while(counter != index)
  {
    counter ++;
    power = power.getNext();
  }
  return power;
}

  public E set(int index, E value)
  {
    if(index > size || index < 0)
    {
      throw new IndexOutOfBoundsException();
    }
  E bounce = this.get(index);
  this.getNode(index).setData(value);
    return bounce;
  }

  public String toString()
  {
    Node power = start;
    String output = "[";
    while(power != null)
    {
      output += (" " + power.getData() + ",");
      power = power.getNext();
    }
    output += "]";
    return output;
  }
  public Node getStart()
  {
    return start;
  }
  public Node getEnd()
  {
    return end;
  }
  public void extend(MyLinkedList other)
  {
    other.getStart().setPrevious(end);
    end.setNext(other.start);
    size += other.size;
    end = other.getEnd();
    other.size = 0;
    other.start = null;
    other.end = null;
  }
}

    public void radixsort(int[] data){
      MyLinkedList<Integer>[] bucket = new MyLinkedList<Integer>[20];
      MyLinkedList<Integer> sorted = new MyLinkedList<Integer>();
      for(int k = 0; k < bucket.length; k++){
        bucket[k] = new MyLinkedList<Integer>();}
      while(true){
      int n = 1;
      for(int i = 0; i < data.length; i++){
        if(data[i] > 0){
          bucket[(data[i] % (Math.pow(10, n)) - Math.pow(10, n - 1) + 10)].add(data[i]);}
        else{
          bucket[9 - (data[i] % Math.pow(10, n) - Math.pow(10, n - 1)].add(data[i]);}}
      if(bucket[10].size == 10){
        return;}
      for(int j = 0; j < bucket.length; j++){
        sorted.extend(bucket[j]);
        bucket[j].clear();}
      for(int j = 0; j < data.length; j++){
        data[j] = sorted.remove(0);}
      n ++;}
    }
}
