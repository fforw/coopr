package org.coopr;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.webbitserver.WebServer;
import org.webbitserver.WebServers;
import org.webbitserver.handler.logging.LoggingHandler;
import org.webbitserver.handler.logging.SimpleLogSink;

@Configuration
@ImportResource({"data-access.xml","security.xml"})
public class ApplicationConfig
    implements ApplicationListener<ContextStoppedEvent>
{
    private static Logger log = LoggerFactory.getLogger(ApplicationConfig.class);
    private WebServer webServer;
    
    @Bean
    public InternalResourceViewResolver viewResolver()
    {
        log.info("resolver");
        
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    
    @Bean
    public WebServer test() throws InterruptedException, ExecutionException
    {
        webServer = WebServers.createWebServer(9876)
//            .add(new LoggingHandler(new SimpleLogSink(ApplicationWebSocketHandler.USERNAME_KEY)))
            .add("/appsocket", new ApplicationWebSocketHandler())
//            .add(new StaticFileHandler("./src/test/java/samples/chatroom/content"))
            .start().get();
        return webServer;
    }

    @Override
    public void onApplicationEvent(ContextStoppedEvent event)
    {
        webServer.stop();
    }
    
}
