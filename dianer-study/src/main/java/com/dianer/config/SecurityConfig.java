package com.dianer.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 自定义Security配置类
 * 两个主要区域是“认证”和“授权”（或者访问控制）
 * “认证”（Authentication），是建立一个他声明的主体的过程（一个“主体”一般是指用户，设备或一些可以在你的应用程序中执行动作的其他系统）
 * “授权”（Authorization）指确定一个主体是否允许在你的应用程序执行一个动作的过程。为了抵达需要授权的店，主体的身份已经有认证过程建立。
 *
 * @author azure
 * @since 2019/10/12
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 认证
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication() // 项目启动 账户-密码-角色 信息保存进内存中
                .withUser("zhangsan").password("{noop}123456").roles("VIP1")
                .and().withUser("lisi").password("{noop}123456").roles("VIP1, VIP2")
                .and().withUser("wangwu").password("{noop}123456").roles("VIP1", "VIP2", "VIP3");
        /*
          说明：
            1.这里采用的的是把用户角色保存在内存中，数据是写死的，当然数据可以从数据库中查出再写入内存中；
            2.随后定义的三个用户，没有用户定义了其用户名，密码和角色
            3.Security5默认要求密码使用加密，不加密的话就使用"{noop}123456"这样的写法，加密的话需要使用
                PasswordEncoder的实现类进行加密
         */
    }

    /**
     * 授权
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()        // 禁止隧道
                .cors().disable()    // 禁止跨域
                .headers().disable();// 禁止头部
        http.authorizeRequests()
                .antMatchers("/", "/webjars/**", "/static/**").permitAll() // 所有的人都可以访问的路径
                .antMatchers("/level1/**").hasRole("VIP1") // VIP1的用户可以访问level1下的所有路径
                .antMatchers("/level2/**").hasRole("VIP2") // VIP2的用户可以访问level2下的所有路径
                .antMatchers("/level3/**").hasRole("VIP3");// VIP3的用户可以访问level3下所有的路径

        /*
         开启自动配置的登录功能，如果没有登录就会来到登录页面
            1. 会自动生成登录页面 /login
            2. 登录失败会自动重定向到 /login?error
         */
        /**
         * 自定义登录页面设置
         *  1. 登录的路径还是设置成
         *     /login，否则算是自定义登录路径，其他的设置也需要改变
         *     /login（get）：到登录页，， 自定义的话就是 /authenticate（get）
         *     /login（post）：登录检查，，自定义的话就是 /authenticate（post）
         *  2. 可以自定义form表达提交的参数名称
         *     默认username字段提交用户名，可以通过usernameParameter自定义
         *     默认password字段提交密码，可以用过passwordParameter自定义
         *  3. loginProcessingUrl("/xxx") 可以自定义登录成功后跳转的路径
         *
         */
        http.formLogin().loginPage("/login");

        /*
        开启自动配置的记住我功能
            1.登录成功后，将cookie发送给浏览器保存，以后登录带上这个cookie，只要通过检查就可以免登录
            2.点击注销之后会删除cookie
            3.rememberMe功能跟前端约定的表单提交名称是remember-me,可以通过rememberMeParameter自定义
         */
        http.rememberMe(); //.rememberMeParameter("remember")自定义表单提交名称为remember

        /*
         开启自动配置的退出功能：
            1. 访问/logout请求，用户注销，清除session
            2. 注销成功后重定向到 login?logout，可以通过logoutSuccessUrl("/")自定义
         */
        http.logout().logoutSuccessUrl("/");
    }
}