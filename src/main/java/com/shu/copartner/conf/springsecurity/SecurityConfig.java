
package com.shu.copartner.conf.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @author cxy
 * @date 2020/12/6 13:17
 * @Description springsecurity配置类
 * @return
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private MyAuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private MyAuthenticationFailHandler authenticationFailHandler;

    @Autowired
    private MyUserDetailServiceImpl myUserDetailService;

    @Autowired
    private PersistentTokenRepository persistentTokenRepository;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors()
                .and().csrf().disable().headers().frameOptions().sameOrigin()
                .and().exceptionHandling().authenticationEntryPoint(new EntryPoint())
                .and().authorizeRequests()
                /**
                 * 前端权限
                 */
                .antMatchers("/html/webui/personal/**").hasAnyRole("PERSON", "TEACHER", "STUDENT", "MANAGER")
                .antMatchers("/html/webui/managerui/**").hasAnyRole("MANAGER")
                //首页
                .antMatchers("/index.html").permitAll()
                //前端页面除了个人工作台
                .antMatchers("/html/webui/**").permitAll()
                //layui
                .antMatchers("/html/managerui/js/**").permitAll()

                /**
                 * 后端api权限
                 */
                .antMatchers("/public/**").permitAll()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/vip/**").hasAnyRole("PERSON", "TEACHER", "STUDENT", "MANAGER")
                .antMatchers("/manager/**").hasRole("MANAGER")

                .anyRequest().authenticated()
                .and().formLogin().loginProcessingUrl("/public/login")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailHandler)
                .and().rememberMe().tokenValiditySeconds(60 * 60 * 24).tokenRepository(persistentTokenRepository)
                .userDetailsService(myUserDetailService)
                .and().logout().logoutSuccessHandler(new MyLogoutSuccessHandler()).deleteCookies("JSESSIONID");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }
}

