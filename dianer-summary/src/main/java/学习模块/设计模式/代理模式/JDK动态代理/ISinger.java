package 学习模块.设计模式.代理模式.JDK动态代理;

import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ISinger {
    void sing();
    void sing2();
}
