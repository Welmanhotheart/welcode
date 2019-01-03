package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

public class ClassLoaderTestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String resourcePath = "lisp/helloworld.lisp";
        URL systemResource = ClassLoader.getSystemResource(resourcePath);
        System.out.println("ClassLoader.getSystemResource(resourcePath)>>>" + systemResource);
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("systemClassLoader>>>>>" + systemClassLoader.toString());
        System.out.println("systemClassLoader.getResource>>>" + systemClassLoader.getResource(resourcePath));
        ClassLoader cuurentThreadClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("cuurentThreadClassLoader>>>>>" + cuurentThreadClassLoader.toString());
        System.out.println("cuurentThreadClassLoader.getResource>>>" + cuurentThreadClassLoader.getResource(resourcePath));
        ClassLoader parentClassLoader = cuurentThreadClassLoader.getParent();
        System.out.println("cuurentThreadClassLoader parent:" + parentClassLoader);
        ClassLoader thisClassLoader = ClassLoaderTestServlet.class.getClassLoader();
        System.out.println("this:" + thisClassLoader);

        System.out.println("String.classLoader:" + String.class.getClassLoader());

    }
}
