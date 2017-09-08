package lamdaTest_01_Function_apply;

import java.util.function.Function;

/**
 * lamda测试
 * @author hsj
 *
 */
public class lamdatest_01 {
   public static void main(String[] args) {
	   //现在写的 方法是apply方法；Function里面有且仅仅有一个
	   
	   Function<String, Integer> toInteger = Integer::valueOf;//::valueOf调用方法
	   //等同于上面的简便写法
//	   Function<String, Integer> toInteger  =  (str) -> {return Integer.valueOf(str);};
	   // 调用输出"123
	   System.out.println( toInteger.apply("123456"));
  }
}
