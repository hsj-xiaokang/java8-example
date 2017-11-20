package lambda_Test_05_selfFunctionDefined;
/**
 * 自定义函数接口
 * @author 何胜金
 * @date 2016-11-03
 *
 */
@FunctionalInterface
public interface self_Function_defined<T,X,Y> {
	
         T self_run(X x ,Y y);
         
         //返回self_run的实现
         default self_Function_defined<T,X,Y> rt(){
        	 return (X x ,Y y)->{//匿名的lambda返回self_run的实现
        		 //调用自己的实现
        		 return self_run( x , y);
        	 };
         }
         
}
