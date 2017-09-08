package lambda_stream_test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**collection
 * 测试stream
 * 解决foreach循环的问题
 * 
 * ********下面的测试是串行的流********
 * 
 * 
 * @author heshengjin
 * @date 2016-11-04
 *
 */
public class test_stream {
	public static void main(String[] args) {
		
		//list可以使用流
		List<shape> shapes = new ArrayList<>();
		shapes.add(new shape().setColor(shape.RED));
		shapes.add(new shape().setColor(shape.RED));
		shapes.add(new shape().setColor(shape.RED));
		shapes.add(new shape().setColor(shape.RED));
		//设置颜色
		shapes.stream().filter(s -> s.getColor() == shape.RED).forEach(s -> s.setColor(shape.YELLOW));
		//调用循环
		shapes.stream().forEach(s -> {System.out.println("stream out :"+ s.getColor());});
		
		
		
		
		
		//数组不可以使用流
		shape[] shapes_ = new shape[]{new shape().setColor(shape.RED),
				new shape().setColor(shape.RED),
				new shape().setColor(shape.RED),
				new shape().setColor(shape.RED)};
		for(shape sp : shapes_){
			if(sp.getColor() == shape.RED){
				sp.setColor(shape.GREEN);
			}
		}
		for(shape sp : shapes_){
			System.out.println("for array shape :" + sp.getColor());
		}

		
		
		
		
		
		
		//set可以使用流
		Set<shape> ss = new HashSet<>();
		ss.add(new shape().setColor(shape.RED));
		ss.add(new shape().setColor(shape.RED));
		ss.add(new shape().setColor(shape.RED));
		ss.add(new shape().setColor(shape.RED));
		
		
//		ss.stream().filter(s -> s.getColor() == shape.RED).forEach(s ->  s.setColor(shape.ORANGE));
//		ss.stream().forEach(s -> System.out.println("set out :"+s.getColor()));
		
		
		Optional<shape> firstRED = ss.stream().filter(s -> s.getColor() == shape.RED).findFirst();
		firstRED.get().setWeight(100);
		ss.stream().forEach(s -> System.out.println("set out :"+s.getWeight()));
	}
}
