package exercise.access.accesspackage;

public class classWithPackageAccess {
    public static classWithPackageAccessHelper getHelper() {
        return new classWithPackageAccessHelper();
    }
}

class classWithPackageAccessHelper {
    public static void  print(Object o){
        System.out.print(o);
    }
}
