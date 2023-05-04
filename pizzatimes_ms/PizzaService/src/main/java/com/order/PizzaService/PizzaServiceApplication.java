package com.order.PizzaService;

import com.order.PizzaService.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableFeignClients
public class PizzaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaServiceApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean jwtFilterBean(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new JwtFilter());
		filterRegistrationBean.addUrlPatterns("/pizzaTimes/product/user/*","/pizzaTimes/product/admin/*");
		return filterRegistrationBean;
	}

//	@Bean
//	public FilterRegistrationBean filterRegistrationBean(){
//		final CorsConfiguration config = new CorsConfiguration();
//		config.setAllowCredentials(true);
//		config.addAllowedOrigin("http://localhost:9000");
//		config.addAllowedHeader("*");
//		config.addAllowedMethod("*");
//		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**",config);
//		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//		return bean;
//	}
}
