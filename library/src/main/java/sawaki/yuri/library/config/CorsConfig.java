package sawaki.yuri.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:63342/library/static/index.html?_ijt=p02a46s97it5jrj0kjlrivl64v&_ij_reload=RELOAD_ON_SAVE")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}
