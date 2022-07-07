package jakartaee;

import javax.servlet.ServletContextEvent;

public class ServletContext_KB {
    public static void main(String[] args) {
        ServletContext_KB instance = new ServletContext_KB();
        instance.reloadTomcatApplication();
    }

    public void reloadTomcatApplication() {
        ServletContextEvent newInitEvent = ContextListener_KB.getInitEvent();
        ContextListener_KB contextListener = new ContextListener_KB();
        contextListener.contextInitialized(newInitEvent);
    }
}
