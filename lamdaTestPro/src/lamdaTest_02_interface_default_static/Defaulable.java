package lamdaTest_02_interface_default_static;
/**
 * 含有默认方法的接口jdk1.8
 * @author hsj
 *
 */
public interface Defaulable {
		//默认方法
       default String notRequired(){
    	   return "Default implementation";
       }
}
