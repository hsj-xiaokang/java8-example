package lambda_idea;

/**
 * Created by hsj on 2017/9/11.
 * 自己定义一个lambda表达式
 */
@FunctionalInterface
public interface testSelfFuncDef<T extends Number> {
      T get(T t);
}
