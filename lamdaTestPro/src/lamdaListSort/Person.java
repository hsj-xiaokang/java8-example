package lamdaListSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.regexp.internal.recompile;

public class Person {
    private String name;
    private Integer order;
 
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
 
    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
 
    /**
     * @return the order
     */
    public Integer getOrder() {
        return order;
    }
 
    /**
     * @param order
     *            the order to set
     */
    public void setOrder(Integer order) {
        this.order = order;
    }
    
    
//    public selef<Person,Integer> s = (Person p) -> { return p.getOrder();};
    public selef<Person,Integer> s = (p) ->  p.getOrder();
    
    public static void main(String[] args) {
        List<Person> listA = new ArrayList<Person>(5);
        Person p1 = new Person();  
        Person p2 = new Person();
        Person p3 = new Person();
 
        p1.setName("name1");
        p1.setOrder(1);
        p2.setName("name33");
        p2.setOrder(33);
        p3.setName("name3");
        p3.setOrder(3);
        
        System.out.println(p1.s.c(p1));
 
        listA.add(p2);
        listA.add(p1);
        listA.add(p3);
         
//        Collections.sort(listA, new Comparator<Person>() {
//            public int compare(Person arg0, Person arg1) {
//                return -arg0.getOrder().compareTo(arg1.getOrder());
//            }
//        });
        
//            listA.sort(( arg0,  arg1) -> arg0.getOrder().compareTo(arg1.getOrder()));
        
//          Collections.sort(listA, (Person o1, Person o2) -> { return o1.getOrder().compareTo(o2.getOrder());});//实现函数体
        
        Collections.sort(listA, (o1, o2) -> { return o1.getOrder().compareTo(o2.getOrder());});//实现函数体

        
        for (Person p : listA) {
            System.out.println(p.getName());
        }
        
        
        
      
       
    }
 
}
/**
 * 自己定义的lamda表达式实现
 * @author hsj
 *
 * @param <T>
 * @param <X>
 */
@FunctionalInterface
interface selef<T,X>{
	X c(T t);
}
