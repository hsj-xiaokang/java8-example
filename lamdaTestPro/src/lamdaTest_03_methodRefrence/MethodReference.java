package lamdaTest_03_methodRefrence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.sun.org.apache.regexp.internal.recompile;
/**
 * 
 * Java 8中方法也是一种对象，可以By名字来引用。不过方法引用的唯一用途是支持Lambda的简写，使用方法名称来表示Lambda。不能通过方法引用来获得诸如方法签名的相关信息。

方法引用的分类

方法引用分为4类，常用的是前两种。方法引用也受到访问控制权限的限制，可以通过在引用位置是否能够调用被引用方法来判断。具体分类信息如下：

引用静态方法 
ContainingClass::staticMethodName 
例子: String::valueOf，对应的Lambda：(s) -> String.valueOf(s) 
比较容易理解，和静态方法调用相比，只是把.换为::

引用特定对象的实例方法 
containingObject::instanceMethodName 
例子: x::toString，对应的Lambda：() -> this.toString() 
与引用静态方法相比，都换为实例的而已

引用特定类型的任意对象的实例方法 
ContainingType::methodName 
例子: String::toString，对应的Lambda：(s) -> s.toString() 
太难以理解了。难以理解的东西，也难以维护。建议还是不要用该种方法引用。 
实例方法要通过对象来调用，方法引用对应Lambda，Lambda的第一个参数会成为调用实例方法的对象。

引用构造函数 
ClassName::new 
例子: String::new，对应的Lambda：() -> new String() 
构造函数本质上是静态方法，只是方法名字比较特殊。
 *
 */
public class MethodReference {
    public static void main(String[] args) {
    	
        // 方法引用::引用构造函数
        PersonFactory factory = new PersonFactory(Person::new );

        List<Person> personList = new ArrayList<Person>();

        Person p1 = factory.getPerson();
        p1.setName("Kobe");
        personList.add(p1);
        Person p2 = factory.getPerson();
        p2.setName("James");
        personList.add(p2);
        Person p3 = factory.getPerson();
        p3.setName("Paul");
        personList.add(p3);

        Person[] persons1 = personList.toArray(new Person[personList.size()]);
        System.out.print("排序前: ");
        printArray(persons1);

        // 方法引用::引用静态方法
        Arrays.sort(persons1, MethodReference::myCompare);
        System.out.print("排序后: ");
        printArray(persons1);
        System.out.println();

        Person[] persons2 = personList.toArray(new Person[personList.size()]);
        System.out.print("排序前: ");
        printArray(persons2);

        // 方法引用::用特定对象的实例方法
        Arrays.sort(persons2, p1::compare);
        System.out.print("排序后: ");
        printArray(persons2);
        System.out.println();

        Person[] persons3 = personList.toArray(new Person[personList.size()]);
        System.out.print("排序前: ");
        printArray(persons3);

        // 方法引用::引用特定类型的任意对象的实例方法
        Arrays.sort(persons3, Person::compareTo);
        System.out.print("排序后: ");
        printArray(persons3);
    }

    public static void printArray(Person[] persons) {
        for (Person p : persons) {
            System.out.print(p.name + "  ");
        }
        System.out.println();
    }

    public static int myCompare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
    }

    
    /**
     * 静态内部类
     * @author heshengjin
     *
     */
    static class Person {
        private String name;

        public Person() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int compare(Person p1, Person p2) {
            return p1.getName().compareTo(p2.getName());
        }

        public int compareTo(Person p) {
            return this.getName().compareTo(p.getName());
        }
    }

    /**
     * 静态内部类
     * @author heshengjin
     *
     */
    static class PersonFactory {
        private Supplier<Person> supplier;
      

        public PersonFactory(Supplier<Person> supplier) {
            this.supplier = supplier;
        }

        public Person getPerson() {
            return supplier.get();
        }
    }
}