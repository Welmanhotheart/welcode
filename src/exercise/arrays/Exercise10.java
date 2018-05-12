package exercise.arrays;

import java.util.ArrayList;
import java.util.List;

import exercise.arrays.BerylliumSphere;


public class Exercise10 {
    public static void main(String[] args) {
        List<List<String>> ls;
        List<List> la = new ArrayList<List>(10);
//    ls = la; // compile error:cannot convert from List<List> to List<List<String>>

        ls = new ArrayList<List<String>>();
        ls.add(new ArrayList<String>());// amazing this is ok, actually the parameter of add is Object

        /*
         *  So assignment is not OK, This shows that generic are't covariant
         *  compile error : cannot convert from List<List<String>> to List<Object>
         */
//    List<Object> objects = ls; 
        List<Object> objects = new ArrayList<Object>();

        // Compiles and runs without complaint: This is really amazing
        objects.add(new ArrayList<Integer>());

        // However, if your needs are straightforward it is
        // possible to create an array of generics, albeit
        // with an "unchecked" warning:
        List<BerylliumSphere>[] spheres =
                (List<BerylliumSphere>[]) new List[10];
        for (int i = 0; i < spheres.length; i++)
            spheres[i] = new ArrayList<BerylliumSphere>();
    }
}
