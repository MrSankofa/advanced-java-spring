/* CodingNomads (C)2024 */
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

        /*
        * Yes, it is true that you cannot run pointService.foo()
        * by itself without causing an exception.
        * This is because the @Transactional(propagation = Propagation.MANDATORY) annotation on foo()
        * requires that the method be called within an existing transaction.
        *  If you try to call it directly from TransactionalApplication.run()
        * (which doesn’t create a transaction),
        * Spring will throw an exception indicating that no transaction exists.
        * */
//        pointService.foo();
         pointService.doSomeWork();

        // @Transactional II make sure you have the previous transaction working so that the next works

         pointService.timeOutAfter5();
//         pointService.triggerTimeout();

        /*
        * The org.hibernate.LazyInitializationException occurs because Hibernate tries to lazily load an entity
        *  (Point in this case) outside of an active Session or transaction. Lazy loading requires an active Session
        * to fetch the data, and when the Session is closed (e.g., after the transactional context ends),
        * Hibernate cannot initialize the proxy object for the entity.
        *
        * to solve this you need to execute this query within a session
        *
        * */
//         System.out.println(pointService.getPointById(1L).toString());
         pointService.noExceptionExpected();


         /*
         * Testing the Behavior
            Test Case 1: Valid Input

            * Input:pointService.savePointWithAudit(1L, 5, 5);

            * Expected Outcome:

            A Point with x=5 and y=5 is saved to the database.
            An audit log entry is created: "Point updated to x=5, y=5".

            * Test Case 2: Invalid Input

            * Input: pointService.savePointWithAudit(2L, -1, 5);

            * Expected Outcome:

            The main transaction rolls back (the Point is not saved).
            The audit log persists successfully with the message: "Point updated to x=-1, y=5".

         *
         * */
        pointService.savePointWithAudit(1L, 5, 5);
//        pointService.savePointWithAudit(2L, -1, 5);


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
