/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.transactional.services;

import com.codingnomads.springdata.example.dml.transactional.models.Point;
import com.codingnomads.springdata.example.dml.transactional.repositories.PointRepo;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PointService {

    @Autowired
    PointRepo pointRepo;

    @Autowired
    AuditService auditService;

    // @Transactional I

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void doSomeWork() {
        Point p = new Point(1, 1);
        pointRepo.save(p);

        p = new Point(2, 2);
        pointRepo.save(p);

        /*
           In order to call the foo() method - we must have an existing transaction (MANDATORY)
        */
        foo();
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void foo() {
        pointRepo.getOne(1L);
    }

    // @Transactional II

    @Transactional(timeout = 5)
    public void savePoint() {
        // create new point (1,1)
        Point p = new Point(1, 1);

        // save new point
        pointRepo.save(p);
    }

    @Transactional(timeout = 5)
    public void timeOutAfter5() {
        Point p = new Point(2, 2);
        pointRepo.save(p);
    }

    @Transactional(timeout = 1)
    public void triggerTimeout() throws InterruptedException {
        Thread.sleep(950);
        Point p = new Point(1, 1);
        pointRepo.save(p);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Point getPointById(Long id) {
        return pointRepo.getOne(id);
    }

    @Transactional(readOnly = true)
    public void noExceptionExpected() {
        Point p = pointRepo.getOne(1L);

        p.setX(5);

        pointRepo.save(p);
    }

    @Transactional(rollbackFor = {IOException.class, ArithmeticException.class})
    public void rollbackFor() throws IOException, ArithmeticException {
        Point p = pointRepo.getOne(1L);
        p.setX(100);
        p.setX(100);
        pointRepo.save(p);
        throw new IOException();
        // no change to DB
    }

    @Transactional(noRollbackFor = InterruptedException.class)
    public void noRollbackFor() throws InterruptedException {
        Point p = pointRepo.getOne(2L);
        p.setX(4);
        p.setX(20);
        pointRepo.save(p);
        throw new InterruptedException();
        // changes still commit
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void savePointWithAudit(Long id, int x, int y) {
        Point p = pointRepo.findById(id).orElse(new Point());

        p.setX(x);
        p.setY(y);

        pointRepo.save(p);

        // Log the operation in a separate transaction
        auditService.logAudit(id, "Point updated to x=" + x + ", y=" + y);

        // Simulate an error in the main transaction to test rollback
        if (x < 0 || y < 0) {
            throw new RuntimeException("Invalid coordinates: x and y must be non-negative.");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void createAndLogPoints() {
        // Create a new point in a transaction
        Point p = new Point(10, 20);
        pointRepo.save(p);

        // Log points without transaction involvement
        fetchAndLogPoints();

        // Simulate a failure in the parent transaction
        throw new RuntimeException("Simulating failure to rollback create operation");
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void fetchAndLogPoints() {
        // This method runs outside of any transaction
        List<Point> points = pointRepo.findAll();

        System.out.println("Logging points: ");
        for (Point point : points) {
            System.out.println(point);
        }
    }
}
