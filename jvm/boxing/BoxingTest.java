package boxing;

import java.util.Arrays;
import java.util.List;

public class BoxingTest {
    public static void main(String[]args){
        List<Integer> list= Arrays.asList(1,2,3,4);
//如果在JDK 1.7中,还有另外一颗语法糖[1]
//能让上面这句代码进一步简写成List<Integer>list=[1,2,3,4];
        int sum=0;
        for(int i:list){
            sum+=i;
        }
        System.out.println(sum);
    }
}
