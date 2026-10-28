package ma.ensaf.springbootjpa.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
	    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	    
	    manager.createUser(User.withUsername("user")
	        .password(passwordEncoder.encode("user")) // Hna drna l'cryptage
	        .roles("USER")
	        .build()
	    );
	    
	    manager.createUser(User.withUsername("admin")
	        .password(passwordEncoder.encode("admin")) // W hna 3awtani
	        .roles("ADMIN")
	        .build()
	    );
	    
	    return manager;
	}
	// Configuration des accès
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	http
	.authorizeHttpRequests(auth-> auth
	.requestMatchers("/login", "/css/**").permitAll() //libre accès
	.requestMatchers("/admin").hasRole("ADMIN") // accès réservé
	.anyRequest().authenticated() // tout le reste : login requis
	)
	.formLogin(form-> form
	.loginPage("/login") // notre page personnalisée
	.defaultSuccessUrl("/home", true) // redirigé après login
	.permitAll() 
	)
	.logout(logout-> logout
	.logoutSuccessUrl("/login?logout")
	.permitAll())
	.csrf(csrf-> csrf.disable()); // désactive CSRF (utile pour tests) à activer en prod !
	return http.build();
	}
	
	// Encodeur de mot de passe
	@Bean
	PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder(); // Pour crypter les mots de passe
	}
}
