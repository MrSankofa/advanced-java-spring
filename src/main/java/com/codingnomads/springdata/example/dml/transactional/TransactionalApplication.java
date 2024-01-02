/* CodingNomads (C)2023 */
package com.codingnomads.springdata.example.dml.transactional;

import com.codingnomads.springdata.example.dml.transactional.services.PointService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionalApplication implements CommandLineRunner {

    @Autowired
    PointService pointService;

    public static void main(String[] args) {
        SpringApplication.run(TransactionalApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {

        // @Transactional I

        pointService.foo();
        // pointService.doSomeWork();

        // @Transactional II

        // pointService.timeOutAfter5();
        // pointService.triggerTimeout();

        // System.out.println(pointService.getPointById(1L).toString());
        // pointService.noExceptionExpected();

        try {
            pointService.rollbackFor();
        } catch (IOException e) {
            // do nothing... move on
        }

        try {
            pointService.noRollbackFor();
        } catch (InterruptedException e) {
            // do nothing... move on
        }
    }
}
