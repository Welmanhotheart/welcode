<%@page import="java.lang.*"%>
<%@page import="java.io.*"%>
<%@page import="bytecode.remoteexecution.*"%>
<%
InputStream is=new FileInputStream("c:/Try_catch_demo.class");
byte[]b=new byte[is.available()];
is.read(b);
is.close();
out.println("<textarea style='width：1000;height=800'>");
out.println(JavaClassExecuter.execute(b));
out.println(Thread.currentThread().getContextClassLoader());
    out.println("jsp class:" + this.getClass());
    out.println("</textarea>");
%>