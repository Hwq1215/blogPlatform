package com.example.coinsblog;

import com.example.coinsblog.pojo.Hole;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CoinsBlogApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testDate(){
        Timestamp setTime = new Timestamp(2006-1900,11,15,12,25,36,55);
        Hole hole = new Hole(1,"none",setTime,1,"www.baidu.com");
        System.out.println(hole.getLastDay());
    }
}
