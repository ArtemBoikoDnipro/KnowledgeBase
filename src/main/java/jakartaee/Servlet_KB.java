package jakartaee;

import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.io.IOException;

public class Servlet_KB {
    public static void main(String[] args) throws Throwable {
        /*
        package javax.servlet;

        public interface Servlet {...}
         */
        Servlet servlet = new DispatcherServlet();


        methods(servlet);

        implementations(servlet);
    }

    private static void methods(Servlet servlet) throws ServletException, IOException {
        /*
        Just demo objects
         */
        ServletRequest request = (ServletRequest) new Object();
        ServletResponse response = (ServletResponse) new Object();



        /*
        ServletConfig getServletConfig();
         */
        ServletConfig servletConfig = servlet.getServletConfig();



        /*
        void init(ServletConfig config) throws ServletException;
         */
        servlet.init(servletConfig);
        /*
        метод нужен, чтобы сохранить ServletConfig

        важно прописать в методе первой строкой:
        super.init(config);
         */



        /*
        void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException;
         */
        servlet.service(request, response);



        /*
        public String getServletInfo();
         */
        String servletInfo = servlet.getServletInfo();
        System.out.println(servletInfo);



        /*
        void destroy();
         */
        servlet.destroy();
    }

    private static void implementations(Servlet servlet) {
        /*
        Spring framework implementation.
         */
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
    }
}
