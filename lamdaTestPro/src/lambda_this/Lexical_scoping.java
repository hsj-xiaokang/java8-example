package lambda_this;

/**
 * Created by hsj on 2017/9/11.
 */
public class Lexical_scoping {
    Runnable r1 = () -> { System.out.println(this);};
    Runnable r2 = () -> { System.out.println(toString()); };

    public String toString() {  return "Hello, world"; }


    /**
     * 专门的写了一个lambda测试this
     * this有点像JavaScript里面的就是最外层的类的对象
     * @param args
     */
    public thisFunc tf = () -> {
        System.out.println(this);
    };

    public static void main(String... args) {
        new Lexical_scoping().r1.run();
        new Lexical_scoping().r2.run();
        //测试this
        new Lexical_scoping().tf.testThis();
    }
}
