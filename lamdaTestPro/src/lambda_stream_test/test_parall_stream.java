package lambda_stream_test;

import java.util.ArrayList;
import java.util.List;

/**collection
 * 测试stream
 * 解决foreach循环的问题
 * 
 * ********下面的测试是并行的流********
 * 
 * 
 * @author heshengjin
 * @date 2016-11-04
 *
 */
public class test_parall_stream {
       public static void main(String[] args) {
    	 //list可以使用流
   		List<shape> shapes = new ArrayList<>(10);
   		shapes.add(new shape().setColor(shape.RED).setWeight(1));
   		shapes.add(new shape().setColor(shape.RED).setWeight(1));
   		shapes.add(new shape().setColor(shape.RED).setWeight(1));
   		shapes.add(new shape().setColor(shape.RED).setWeight(1));
   		
   		int sum = shapes.parallelStream().filter(s -> s.getColor() == shape.RED).mapToInt(s -> s.getWeight()).sum();
   		System.out.println("parall stream sum:" + sum);
	}
}
