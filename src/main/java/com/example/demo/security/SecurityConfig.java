import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration  // marks this as a configuration class
public class SecurityConfig {

    @Bean  // tells Spring "here is a bean you can inject anywhere"
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // standard password hashing algorithm
    }
}
