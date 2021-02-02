package com.solr.demo.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CrawlerExecution {

    private static final Runtime commandExecution = Runtime.getRuntime();

    @Scheduled(cron = "0 1 * * * *")
    public void crawlerProcess() throws IOException, InterruptedException {
        Process pro = commandExecution.exec("docker start solr-spring-app_nutch_1");
        pro.waitFor();
    }

}
