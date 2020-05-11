package com.itstyle.seckill;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 创建时间	2018年5月12日
 * API接口测试：http://localhost:8080/seckill/swagger-ui.html
 * 跑之前 一定要看文库：https://gitee.com/52itstyle/spring-boot-seckill/wikis
 */
@SpringBootApplication
@Slf4j
public class Application {
	/**
	 * 1. 数据库乐观锁；
     * 2. 基于Redis的分布式锁；
     * 3. 基于ZooKeeper的分布式锁
	 * 4. redis 订阅监听；
     * 5. kafka消息队列
	 * 启动前 请配置application.properties中相关redis、zk以及kafka相关地址
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		log.info("===== 项目启动成功 =====");
	}
}