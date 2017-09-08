package lamdaTest_02_interface_default_static_implement;

import lamdaTest_02_interface_default_static.Defaulable;
import lamdaTest_02_interface_default_static.DefaulableFactory;

/**
 * 测试01
 * @author hsj
 *
 */
public class Test_01_main {
  public static void main(String[] args) {
	  //默认
	  Defaulable defaulable = DefaulableFactory.create( DefaultableImpl::new );
	  System.out.println( defaulable.notRequired() );
	  //覆盖
	  defaulable = DefaulableFactory.create( OverridableImpl::new );
	  System.out.println( defaulable.notRequired() );
 }
}
