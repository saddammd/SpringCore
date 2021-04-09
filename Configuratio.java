package com.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("com.spring.core.*")
@PropertySource("classpath:rough.properties")
public class Configuratio {

	//This code enables the property reading feature incase of spring 4.2 or lower
	@Bean
    public static PropertySourcesPlaceholderConfigurer
                    propertySourcesPlaceHolderConfigurer() {
        
        return new PropertySourcesPlaceholderConfigurer();
    }


	@Bean
	@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public EngineOil engineOil() {
		
		 return new EngineOil();
	}
	
	
	@Bean
	@Scope("singleton")
	public Engine engine() {
		
		Engine eng = new Engine(engineOil());
		
		return eng;
	}
	

}
