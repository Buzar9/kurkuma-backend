//package pl.zhr.scouting.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Qualifier("myUserDetailsService")
//    @Autowired
//    UserDetailsService myUserDetailService;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.userDetailsService(myUserDetailService).passwordEncoder(myPasswordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
////            .antMatchers("/").hasRole("user")
//            .antMatchers("/**").hasAnyAuthority("admin", "user")
//        .and()
//            .formLogin()
//        .and()
//            .csrf().disable();
//    }
//
//    @Bean
//    public PasswordEncoder myPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
//
