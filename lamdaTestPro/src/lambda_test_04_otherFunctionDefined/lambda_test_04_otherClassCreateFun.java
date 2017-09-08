package lambda_test_04_otherFunctionDefined;
/**
 * 另外一个类创建的函数就像类一样可以被其他的类使用
 * 要求jdk1.8.x以上
 * @author hsj
 * @date 2016-10-19
 */
public class lambda_test_04_otherClassCreateFun {
	/**
	 * [闭包]创建
	 * @return
	 */
      public Runnable createRuunnable(){
    	final int ab = 60000;//方法结束了还可以用
   		Runnable rb_1_other =() -> {
   			System.out.println(" lambda run_create_other    -> "+"   "+ab);
   		};
   		return rb_1_other;
       }
}
