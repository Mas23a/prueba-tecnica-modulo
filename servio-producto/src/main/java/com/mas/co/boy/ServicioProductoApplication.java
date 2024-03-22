package com.mas.co.boy;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.lang.Nullable;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsProcessor;
import org.springframework.web.cors.DefaultCorsProcessor;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@Configuration
public class ServicioProductoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioProductoApplication.class, args);
	}
        
                   
     public class CustomCorsProcessor extends DefaultCorsProcessor implements CorsProcessor {

    private static final String ACCESS_CONTROL_REQUEST_PRIVATE_NETWORK = "Access-Control-Request-Private-Network";
    private static final String ACCESS_CONTROL_ALLOW_PRIVATE_NETWORK = "Access-Control-Allow-Private-Network";
    
    
    @Override
    public boolean processRequest(@Nullable CorsConfiguration config, HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        
        boolean superResult = super.processRequest(config, request, response);//super.processRequest(config, request, response);
        if (superResult == false) return false;
        
        ServletServerHttpRequest serverRequest =  new ServletServerHttpRequest(request);
        
        if(serverRequest.getHeaders().containsKey(ACCESS_CONTROL_REQUEST_PRIVATE_NETWORK)) {
            response.addHeader(ACCESS_CONTROL_ALLOW_PRIVATE_NETWORK, Boolean.toString(true));
        }
        
        return true;
    }
}   
     @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200" ));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        
         CorsFilter corsFilter = new CorsFilter(urlBasedCorsConfigurationSource);
        
         corsFilter.setCorsProcessor(new CustomCorsProcessor());
        return corsFilter;
    }

}
