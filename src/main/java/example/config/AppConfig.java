package example.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.Arrays;

@Configuration
//@EnableWebMvc
public class AppConfig /*implements WebMvcConfigurer*/ {
    @Bean
    RestTemplate restTemplate(ProtobufHttpMessageConverter hmc) {
        return new RestTemplate(Arrays.asList(hmc));
    }

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/" };

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**")
//                .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
//    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/custom/");
//    }

    //    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**").allowedMethods("*");
//    }
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**").allowedMethods("*");
//    }
//    @Bean
//    public FilterRegistrationBean corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("*");
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        source.registerCorsConfiguration("/**", config);
//        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//        bean.setOrder(0);
//        return bean;
//    }
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        HttpServletResponse response = (HttpServletResponse) res;
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Content-Length, X-Requested-With");
//        chain.doFilter(req, res);
//    }
}
