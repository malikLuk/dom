package ru.dom.lukmanovcarhiring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * exclude нужны, так как автоконфиги перетирают мои собственные (Разобратья)
 * */
@SpringBootApplication(scanBasePackages = {"ru"} , exclude = {JpaRepositoriesAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableTransactionManagement
public class LukmanovCarHiringApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(LukmanovCarHiringApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LukmanovCarHiringApplication.class);
    }


}
