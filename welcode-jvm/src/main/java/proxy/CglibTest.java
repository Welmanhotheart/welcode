package proxy;

public class CglibTest {
    public static void main(String[] args) {
        BookFacadeCglib proxy = new BookFacadeCglib();
        BookFacadeImpl bookFacade = new BookFacadeImpl();
        BookFacadeImpl bookCglib = (BookFacadeImpl) proxy.getInstance(bookFacade);
        System.out.println(bookCglib.getClass().getClassLoader());
        System.out.println(bookCglib.getClass());
        bookCglib.addBook();
    }
}
