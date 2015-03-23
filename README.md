# CompanySpringDataJpa

TODO:

    - update for employee and address!!

20.03.2015

ERROR :))
HTTP Status 500 - Request processing failed; nested exception is org.springframework.dao.InvalidDataAccessApiUsageException: 
detached entity passed to persist: ro.company.domain.Department; nested exception is org.hibernate.PersistentObjectException: 
detached entity passed to persist: ro.company.domain.Department

TODO:

    - all that's left from last week 
    - resolve above error for a working save
    - important task (from Bogdan) : looking back on all that code to understand it at all ! 
    
Update:
    
    - converting String to Object

---------------------------------------------------
TODO:

    - check why doesn't show our validation errors
    - check why addEmployee has different text color
    - check validation for every drop down list
    - IMPORTANT!! make save working with dropdown

Updates(18/03/2015)...

    - add default validation to all entities
    - add drop down list for dept, car, address to addEmployee page
    - add drop down list for employee to addCar page
    - add style over the jsp

Info debug:

    - http://blog.trifork.com/2014/07/14/how-to-remotely-debug-application-running-on-tomcat-from-within-intellij-idea/

-------------------------------------------------
Updates(13/03/2015)...

TODO:
    
    - try resolve updateEntity
    - try resolve deleteEntity
--------------------------------------------------
TODO:

    - try to resolve the same situation with AOP
    - add same to all others entities
    - try make Tomcat run with sprig-instrument jar

Updates(11/03/2015)...

    - add Spring MVC over the project
    - you can see all the data about almost any entity
    - you can update an employee, create an employee

Updates(04/02/2015)...

    - make sure that Save and Update datetime aren't the same in before pointcut
    - change audit, adding serializable objects to database
    - some tests that prove it's working

TODO:

    - try to resolve the same situation with AOP
    - ask Bogdan for more TODO :))

Updates(03/02/2015)...

    - modify all interfaces/services from service to work with entities properties
    - add AuditableAnnotation to give at runtime the MappedSuperClass to all entities
    - modify Audit, adding more constraints to find any object in database

What i've done..

    - i have created services for every entity
    - i have implemented pointcut for methods which starts with "delete"
    - doesn't work to set createddate and modifieddate in DB @Delete, overwriting row with that registration

TODO:

    - every entity table must have 2 more columns: createDate, modifiedDate
    - add connection between those 2 new columns and those from AuditingInterfaceImpl
    - complete @AfterReturning for every entity
    - will see more TODO's in future :))

To work:

    Add to VM Options, this parameter:
      -ea -javaagent:\**pathTo**\spring-instrument-4.1.4.RELEASE.jar
      - where pathTo represents the location of spring-instrument into your host
