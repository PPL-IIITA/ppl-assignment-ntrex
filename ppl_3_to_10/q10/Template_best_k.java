package q10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/**
 *Template to find the best k entities
 * @author hp
 */
public class Template_best_k <T>{
    private ArrayList<T> arr=new ArrayList<>();
    public int size() {
       return arr.size();
    }

    public boolean isEmpty() {
        return arr.isEmpty();
    }


 
    public boolean add(Object e) {
       return arr.add((T)e);
    }

   
    public boolean remove(Object o) {
       return arr.remove((T)o);
    }

    public void clear() {
      arr.clear();
    }

    public T get(int index) {
      return arr.get(index);
    }

    public Object remove(int index) {
      return arr.remove(index);
    }

    public int indexOf(Object o) {
        return arr.indexOf(o);
    }


    public ListIterator listIterator() {
      return arr.listIterator();
    }
  
    public List subList(int fromIndex, int toIndex) {
        return arr.subList(fromIndex, toIndex);
    }
    
    public T best_ran_item(int k)
    {
        Random rand=new Random();
        return arr.get(rand.nextInt(k));
    }
    
    public void sort(Comparator<? super T> c)
    {
        Collections.sort(arr, c);
    }
}
