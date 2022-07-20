package com.jiawa.wiki;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class wikiApplication {
    private static final Logger LOG =
            LoggerFactory.getLogger(wikiApplication.class);

    public static void main(String[] args) {
        SpringApplication springApplication =
                new SpringApplication(wikiApplication.class);
        Environment environment =
                springApplication.run(args).getEnvironment();

        LOG.info("启动成功");
        LOG.info("地址:\t http://127.0.0.1:{}",
                environment.getProperty("server.port"));

    }


}
