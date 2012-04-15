package org.coopr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ImportResource("data-access.xml")
@Lazy(false)
public class ApplicationConfig
{
    private static Logger log = LoggerFactory.getLogger(ApplicationConfig.class);
    
    @Bean
    public InternalResourceViewResolver viewResolver()
    {
        log.info("resolver");
        
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    
    
}
