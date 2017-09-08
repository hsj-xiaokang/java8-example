package lambda_test_04_otherFunctionDefined;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * java8函数式编程
 * 就可以当成js使用啦
 * 要求jdk1.8.x以上
 * @author hsj
 * @date 2016-10-19
 * 
 * [java里面使用闭包]
 * 
 */
public class lambda_test_04 {
	/**
	 * 注意：最佳实践，java-lambda就像匿名内部类一样，用到的变量使用final关键字进行标注
	 * java8 不强制final在方法类中的必须显示，编译器已经帮我们做好了
	 */
//	public final static String  str = " final String";
	public  static String  str = " final String";
	
	/**
	 * 该类里面创建方法
	 */
	public Runnable rb =() -> {
		System.out.println(" lambda run    -> "+str);
	};
	
	/**
	 * 接收一个方法
	 * ############注意这样直接run没有开启一个线程哦！！！！！##############
	 * @param Runnable rb
	 */
	public void r(Runnable rb){
		rb.run();
	}
	
	/**有点像工厂方法
	 * 创建一个方法【有点JavaScript的闭包感觉】[闭包]
	 * @return Runnable
	 */
	public Runnable createRunAble(){
		//java8 不强制final在方法类中的必须显示，编译器已经帮我们做好了
//		final int a = 5500;//方法结束了还可以用
	    int a = 5500;//方法结束了还可以用
		Runnable rb_1_0 =() -> {
			System.out.println(" lambda run_create    -> "+str+"   "+a);
		};
		return rb_1_0;
	}
	
	/**
	 * main方法
	 * @param args
	 */
  public static void main(String[] args) {
	  
	  lambda_test_04 _ = new lambda_test_04();
	  
	  /**
	   * 运行类里面创建的方法
	   * ############注意这样直接run没有开启一个线程哦！！！！！##############
	   */
	_.rb.run();
	
	
	
	
	  /**
	   * 运行接收方法的类方法
	   * lambda强大的推断机制------>注意第二个可以进行匿名的方法传入然后推断成Runnable的函数接口
	   */
	_.r(_.rb);
	_.r(() -> {
		System.out.println(" lambda run 匿名方法,java推断后就是Runnable    -> "+str);
	});
	
	
	
	  /**①
	   * 运行创建方法的类方法【有点JavaScript的闭包感觉】运行在后面哦**[闭包]
	   */
	 Runnable runA = _.createRunAble();
	
	
	  /**方法内部创建方法就在该方法内部运行
	   * Runnable 是一个函数接口 
	   * 等同于 Supplier也是函数接口
	   *  @FunctionalInterface
       *   public interface Supplier<T> {
       *         T get();
       *    }
	   */
	Runnable rb_1 =() -> {
		System.out.println(" lambda run again     -> "+str);
	};
	rb_1.run();
	
	
	
	/**①
	 * 在这里运行**[闭包]
	 * ############注意这样直接run没有开启一个线程哦！！！！！##############
	 */
	runA.run();
	
	
	
	/**java8 内置的函数接口
	 * predicate
	 * 
	 */
	Predicate<Integer> atLeast5 = x -> x > 5;
	System.out.println(" Predicate  = "+atLeast5.test(6000));
	
	
	
	
	/**java8 内置的函数接口
	 * BinaryOperator
	 */
	BinaryOperator<Long> addLongs = (x, y) ->{Long l =  x + y; return l;};
	System.out.println(" BinaryOperator  = "+addLongs.apply(5000L, 1000L));
	
	
	
	
	/**
	 * 使用别的类lambda_test_04_otherClassCreateFun创建的函数
	 * 
	 * [闭包]
	 */
	lambda_test_04_otherClassCreateFun oth = new lambda_test_04_otherClassCreateFun();
	Runnable ra_oth = oth.createRuunnable();
	//############注意这样直接run没有开启一个线程哦！！！！！##############
	_.r(ra_oth);
	
  }
  
}
