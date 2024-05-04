// AppConfig.java
package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:beanconf.xml")
public class AppConfig {
    // Другие настройки вашего приложения
}