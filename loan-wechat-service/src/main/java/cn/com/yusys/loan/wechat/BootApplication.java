package cn.com.yusys.loan.wechat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class BootApplication implements CommandLineRunner {

    public static void main(String[] args) {
        log.info("系统开始启动");
        SpringApplication.run(BootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("系统完成启动");
    }

}
