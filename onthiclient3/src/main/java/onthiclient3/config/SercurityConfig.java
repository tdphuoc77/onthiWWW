package onthiclient3.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SercurityConfig  extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder=PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser("user")
		.password(encoder.encode("user"))
		.roles("USER")
		.and()
		.withUser("admin")
		.password(encoder.encode("admin"))
		.roles("ADMIN");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers("/tacpham/update/**")
//		.authenticated()
//		.antMatchers("/tacpham/delete/**")
//		.authenticated()
//		.antMatchers("/tacpham/add").authenticated()
//		.and()
//		.csrf()
//		.disable()
//		.formLogin()
//		.permitAll()
//		.and()
//		.logout()
//		.permitAll();
//		2
		http
        .authorizeRequests()
        .anyRequest()
        .authenticated()
        .and()
        .csrf()
        .disable()
        .formLogin()
        .permitAll()
        .and()
        .logout()
        .permitAll();
		
	};	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/images");
	}
}
