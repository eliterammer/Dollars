
package com.trendanora.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ImportResource(value = {"classpath*:/services-context.xml"})
@Configuration 
@ComponentScan("com.trendanora") 
@EnableWebMvc   
public class AppConfig {  
} 

