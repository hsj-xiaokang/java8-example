package lamdaTest_02_interface_default_static_implement;

import lamdaTest_02_interface_default_static.Defaulable;

/**
 * 覆盖实现Defaulable
 * @author hsj
 *
 */
public class OverridableImpl implements Defaulable{
	@Override
	public String notRequired(){
 	   return "Override implementation";
    }
}
