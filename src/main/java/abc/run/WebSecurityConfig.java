package abc.run;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableMethodSecurity
// (securedEnabled = true,
// jsr250Enabled = true,
// prePostEnabled = true) // by default
public class WebSecurityConfig { // extends WebSecurityConfigurerAdapter {
	
	
  	
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	  CorsConfiguration corsConfiguration = new CorsConfiguration();
      corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
      corsConfiguration.setAllowedOrigins(List.of("*"));
      corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PUT","OPTIONS","PATCH", "DELETE"));
      corsConfiguration.setAllowCredentials(true);
      corsConfiguration.setExposedHeaders(List.of("Authorization"));

    http.csrf(csrf -> csrf.disable())
    	.cors(Customizer.withDefaults())
        .authorizeHttpRequests(auth -> auth
//        	.requestMatchers("/guest/**").permitAll()
//        	.requestMatchers("/user/**").hasRole("USER")
//        	.requestMatchers("/admin1/**").hasAnyRole("ADMIN_1", "ADMIN_2", "ADMIN_3")
//        	.requestMatchers("/admin2/**").hasAnyRole("ADMIN_2", "ADMIN_3")
//        	.requestMatchers("/admin3/**").hasRole("ADMIN_3")
        	.anyRequest().permitAll()
//            .anyRequest().authenticated()
        );
   
    
	return http.build();
  }
}
