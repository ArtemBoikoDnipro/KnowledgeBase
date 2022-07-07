package jakartaee;

import org.apache.logging.log4j.LogManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ContextListener_KB implements ServletContextListener {
    private static ServletContextEvent initEvent;

    public static ServletContextEvent getInitEvent() {
        return initEvent;
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        initEvent = event;
        ServletContext servletContext = event.getServletContext();
        initLog4J(servletContext);
        initDatabase(servletContext);
        initLanguages(servletContext);
        initI18N(servletContext);

    }

    private void initLog4J(ServletContext servletContext) {
    }

    private void initDatabase(ServletContext servletContext) {
    }

    private void initLanguages(ServletContext servletContext) {
    }

    private void initI18N(ServletContext servletContext) {
        String localesValue = servletContext.getInitParameter("Constants.LOCALES");
        if (localesValue == null || localesValue.isEmpty()) {
            LogManager.getLogger(this.getClass()).error("Constants.CANNOT_INIT_LANGUAGES");
            throw new IllegalStateException("Constants.CANNOT_INIT_LANGUAGES");
        }
        List<String> locales = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(localesValue);
        while (tokenizer.hasMoreTokens()) {
            String localeName = tokenizer.nextToken();
            locales.add(localeName);
        }
        servletContext.setAttribute("Constants.LOCALES", locales);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        LogManager.getLogger(this.getClass()).debug("app end");
    }
}
