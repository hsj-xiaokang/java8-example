package lambda_idea;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Created by hsj on 2017/9/11.
 * qq:2356899074
 * 博客地址：http://www.cnblogs.com/WJ5888/p/4618465.html
 *
 * 在这里说明一下：lambda最终也是一个语法糖而已java通过内部类的方式实现的lambda表达式
 *
 * sout       -> 等价eclipse的syso
 * alt+insert -> 等价eclipse的getter setter
 * psvm->     -> 等价eclipse的main
 * ctrl+q     -> 等价eclipse的类返回值的查看
 * alt+enter  -> 等价eclipse的快速导入相关的类
 *
 */
public class lambdaTest {

    public static testSelfFuncDef<Integer> tcr = (x) -> new Integer(x).intValue();

    public static void main(String[] args) throws Exception {
        /**
         * 1.线程的简写
         */
        new Thread(() -> System.out.println("Hello World!")).start();

        /**
         * 2.集合排序
         */
            String []datas = new String[] {"peng","zhao","li"};
            Arrays.sort(datas,(v1 , v2) -> Integer.compare(v1.length(), v2.length()));
            Stream.of(datas).forEach(param -> System.out.println(param));

        /**
         * 3.lambda里面的类型推断，当能够推断的时候就不需要进行参数的类型指定；
         * 下面的会自己推断datas1立里面的类型是String的，此时不需要指定也可以的，就像上面的2.集合排序
         */
        String[] datas1 = new String[] {"peng1","zhao1","li1"};
        Arrays.sort(datas1,(String v1, String v2) -> Integer.compare(v1.length(), v2.length()));
        //当只有一个参数的时候可以省略小括号
        Stream.of(datas1).forEach((param) -> System.out.println(param));


        /**
         * 4.函数式接口 接口上面标志@FunctionalInterface注解
         */
        String[] datas2 = new String[] {"peng2","zhao2","li2"};
        Comparator<String> comp = (v1, v2) -> Integer.compare(v1.length(), v2.length());
        Arrays.sort(datas2,comp);
        Stream.of(datas2).forEach(param -> {System.out.println(param);});

        /**
         * 5.方法引用 ,只能够在lambda表达式里面才能够使用
         * 4种：5.1 静态方法引用
         *       .2 类方法引用
         *       .3 实例方法引用
         *       .4 构造方法引用
         */
        String []datas3 = new String[] {"peng3","Zhao3","li3"};
        Arrays.sort(datas3,String::compareToIgnoreCase);//类方法引用
        Stream.of(datas3).forEach(System.out::println);//类方法引用

        /**
         * 6.自定义lambda测试
         */
        int result = tcr.get(100);
        System.out.println(result);

        /**
         * 7.一个内部类的测试
         */
        lambaTest_inner i = new lambdaTest().new lambaTest_inner(25,"小康");
        System.out.println("-------------------name:"+i.getName()+" age:"+i.getAge());
    }

    class lambaTest_inner{

        private int age;
        private String name;

        public lambaTest_inner() {
        }

        public lambaTest_inner(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
