package lamdaTest_02_interface_default_static;

import java.util.function.Supplier;

/**
 * 含有静态方法的接口
 * @author hsj
 *
 */
public interface DefaulableFactory {
    
	/**
	 * java 8提供了接口定义函数lambda表达式[
	 *       1.匿名
	 *       2.有名------使用接口方式定义@FunctionalInterface
	 * ]
	 * 新的地方：1.提供了默认方法default
	 *         2.静态方法static
	 *         
	 *         
	 *         
	    @FunctionalInterface
        public interface Supplier<T> {
                T get();
}
	 *
	 * 1.方法体写给接口名
	 * 2.参数名写给接口里面的方法
	 */
	
	//静态方法
	static Defaulable create( Supplier< Defaulable > supplier ) {
		return supplier.get();
	}
}
