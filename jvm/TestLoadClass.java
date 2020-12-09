public class TestLoadClass {
    public static void main (String[] args) {
        ClassLoader  loader = new ClassLoader (){
            @Override
            public Class <?> loadClass (String name) throws ClassNotFoundException {

                return super.loadClass ( name );
            }
        };
    }
}
