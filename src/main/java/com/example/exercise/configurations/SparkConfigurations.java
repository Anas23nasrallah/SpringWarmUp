package com.example.exercise.configurations;

import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:spark.properties")
public class SparkConfigurations {

    @Value("${spark.app.name}")
    private String appName;

    @Value("${spark.master}")
    private String master;

    @Value("${spark.hdfs_url}")
    private String hdfs_url;

    @Bean
    public SparkSession sparkSession() {
        return SparkSession
                .builder()
                .config("spark.app.name", appName)
                .config("spark.master", master)
                .config("spark.hdfs_url", hdfs_url)
                .getOrCreate();
    }

}
