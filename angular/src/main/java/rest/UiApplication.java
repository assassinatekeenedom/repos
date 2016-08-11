package rest;

import action.DataBase;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UiApplication implements Runnable {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping("/resource")
    public Map<String, Object> home() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }

    @RequestMapping("/userstories")
    public List<String> getUserStories() {
        return DataBase.getUserStories();
    }

    @RequestMapping("/browsers/{userstory}")
    public List<String> getBrowsers(@PathVariable("userstory") String story) {
        return DataBase.getBrowsers(story);
    }
    
    @RequestMapping("/session/{browser}/{userstory}")
    public List<String> getSessions(@PathVariable("browser") String browser, @PathVariable("userstory") String story) {
        return DataBase.getSessionIds(browser, story);
    }
    
    @RequestMapping("/actions/{session}/{userstory}")
    public List<Object[][]> getSteps(@PathVariable("session") String session,@PathVariable("userstory") String userstory) {
        return DataBase.getSteps(session,userstory);
    }
    
    @RequestMapping("/image/{id}")
    public String getImage(@PathVariable("id") int id) {
        return DataBase.getImage(id);
    }

    public static void main(String[] args) {
        new Thread(new UiApplication()).start();
    }

    public void run() {
        SpringApplication.run(UiApplication.class);
    }

    @Configuration
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .httpBasic()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/index.html", "/home.html", "/login.html", "/tests.html", "/").permitAll()
                    .anyRequest().authenticated().and()
                    .csrf()
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        }
    }

}
