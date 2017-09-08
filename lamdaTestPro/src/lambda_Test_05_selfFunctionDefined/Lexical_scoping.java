package lambda_Test_05_selfFunctionDefined;
/**
 * java lambda 词法作用域
 * @author heshengjin
 * @date 2016-11-04
 */
public class Lexical_scoping {
	  Runnable r1 = () -> { System.out.println(this);};
	  Runnable r2 = () -> { System.out.println(toString()); };

	  public String toString() {  return "Hello, world"; }

	  public static void main(String... args) {
	    new Lexical_scoping().r1.run();
	    new Lexical_scoping().r2.run();
	  }
}
