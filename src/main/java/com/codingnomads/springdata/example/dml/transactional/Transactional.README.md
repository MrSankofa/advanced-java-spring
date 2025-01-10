

Key Concepts in the Code
1. @Transactional Basics
   What It Does: Ensures that the method it annotates runs in a transaction.
   Parameters Used in the Code:
   isolation: Defines how the transaction interacts with other concurrent transactions.
   propagation: Determines how the transaction interacts with existing transactions.
   timeout: Specifies the maximum time (in seconds) a transaction can run before timing out.
   readOnly: Optimizes for read operations, ensuring no writes occur.
   rollbackFor: Specifies which exceptions should trigger a rollback.
   noRollbackFor: Specifies exceptions that should not trigger a rollback.
2. Transactional Methods in PointService
   Below is an explanation of each method:

Transactional Group I
doSomeWork()

Isolation: Isolation.SERIALIZABLE ensures the highest level of transaction isolation, preventing dirty reads, non-repeatable reads, and phantom reads.
Behavior: Creates two Point entities and saves them to the database. Calls the foo() method, which requires an existing transaction (Propagation.MANDATORY).
Key Dependency: If called without an active transaction, foo() will throw an exception.
foo()

Propagation: Propagation.MANDATORY means it must be invoked within an existing transaction. If no transaction exists, an exception is thrown.
Behavior: Fetches a Point by ID (using a lazy-loading method, getOne).
Transactional Group II
savePoint()

Timeout: 5 seconds.
Behavior: Saves a new Point entity to the database. Likely to complete successfully as this is a simple operation.
timeOutAfter5()

Timeout: 5 seconds.
Behavior: Saves a Point and is unlikely to time out.
triggerTimeout()

Timeout: 1 second.
Behavior: Introduces a delay using Thread.sleep(950). This delay combined with database operations could potentially cause a timeout if the total execution exceeds the 1-second limit.
Transactional Read-Only and Exception Handling
getPointById(Long id)

Read-Only: true.
Behavior: Optimized for fetching data without making changes to the database.
noExceptionExpected()

Read-Only: true.
Behavior: Fetches a Point and modifies it. The read-only nature means no database updates should occur unless overridden by the repository.
rollbackFor()

Rollback For: Rolls back the transaction if IOException or ArithmeticException occurs.
Behavior: Fetches and modifies a Point, then throws an IOException, ensuring the database is not updated.
noRollbackFor()

No Rollback For: InterruptedException.
Behavior: Fetches and modifies a Point. Changes are committed even if an InterruptedException is thrown.
Application Entry Point
TransactionalApplication Class

Bootstraps the Spring application.
Implements CommandLineRunner to execute transactional methods when the application starts.
run(String... args)

Calls various transactional methods in PointService:
pointService.foo(): Likely throws an exception due to MANDATORY propagation without an active transaction.
pointService.rollbackFor(): Rolls back changes due to the IOException thrown.
pointService.noRollbackFor(): Commits changes even though an InterruptedException is thrown.
Key Highlights of Transactional Behavior
Propagation Behavior:

MANDATORY ensures foo() is only called within an existing transaction.
REQUIRES_NEW (not used here) would create a new transaction independent of the caller.
Timeout Handling:

Transactions with timeouts ensure that hanging operations are canceled, freeing resources.
Rollback and No-Rollback Scenarios:

Fine-grained control over which exceptions trigger rollbacks enhances flexibility.
How It Works Together
Transactional Groups: Methods in the same transactional group inherit the transaction scope based on propagation rules.
Database Integrity: The use of @Transactional ensures atomicity and prevents partial updates or data corruption.
Timeout and Exception Handling: Protects against resource contention and unwanted state changes.
This code demonstrates advanced use of Spring's transactional annotations to handle diverse scenarios in a database-driven application.