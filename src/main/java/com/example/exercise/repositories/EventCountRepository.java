package com.example.exercise.repositories;

import com.example.exercise.exceptions.InvalidDateException;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:application.properties")
public class EventCountRepository {

    private final SparkSession spark;

    private final String db_url = "hdfs://taz-il/mario/ecomm_event/";

//    @Value("${db_url}")           //it disappears while testing, need to figure out why
//    private String db_url;

    public EventCountRepository(SparkSession spark) {
        this.spark = spark;
    }

    public Long getCount(int year, int month, int day, int hour) throws InvalidDateException {

        String monthString = month < 10 ? "0" + month : Integer.toString(month);
        String dayString = day < 10 ? "0" + day : Integer.toString(day);
        String hourString = hour < 10 ? "0" + hour : Integer.toString(hour);

        try{
            String url = db_url + year + "/" + monthString + "/" + dayString + "/" + hourString + "/*";
            System.out.println(url);
            System.out.println(spark);
            Dataset<Row> ecomm =  spark.read().parquet(url);
            ecomm.createOrReplaceTempView("ecomm");
            return ecomm.count();
        }catch (Exception e){
            throw new InvalidDateException();
        }

    }
}
