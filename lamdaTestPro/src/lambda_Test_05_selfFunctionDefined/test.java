package lambda_Test_05_selfFunctionDefined;

import java.util.function.Supplier;
import java.util.logging.Logger;

/**
 * 测试自己定义的函数接口
 * @author heshnegjin
 * @date 2016-11-03
 */
public class test {
	/**
	 * 闭包使用
	 * 使用的变量一定要加上的  final 修饰
	 * @return self_Function_defined<Integer,String,String>
	 */
   public self_Function_defined<Integer,String,String> sfd_close_package(){
	   final String param_1 = "1";
	   final String param_2 = "1";
	   self_Function_defined<Integer,String,String> sfd_ = (String x,String y )->{
		   return Integer.parseInt(x)
				   + Integer.parseInt(y) 
				   + Integer.parseInt(param_1) 
				   + Integer.parseInt(param_2);
	   };
	return sfd_;
   }
   
   public void printf(){
	   System.out.println(" test supplier only " );
   }
   /**
    * mian方法
    * @param args
    */
   public static void main(String[] args) {
	   
	   self_Function_defined<Integer,String,String> sfd = ( x, y )->{
		   return Integer.parseInt(x) + Integer.parseInt(y);
	   };
	   //执行该自定义的方法
	   int resulte = sfd.self_run("10", "10");
	   System.out.println("resulte   "+resulte);//20
	   
	   //自定义的函数default调用自己
	   self_Function_defined<Integer,String,String> sfd_1 = sfd.rt();
	   int resulte_1 = sfd_1.self_run("20", "20");
	   System.out.println("resulte_1   "+ resulte_1);//40
	   
	   
	   //闭包使用
	   test tt = new test();
	   int resulte_3 = tt.sfd_close_package().self_run("1", "1");
	   System.out.println("resulte_3   "+resulte_3);//4
	   
	   
	   
	   
	   
	   Supplier<test> c =  () -> { //lambda常规写法
		   return new test();
		   };
	   Supplier<test> c_ = test::new;//简写
	   
	   
	   
	   c.get().printf();
	   c_.get().printf();
  }
}
