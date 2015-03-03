# CompanySpringDataJpa
TODO:

    - every entity table must have 2 more columns: createDate, modifiedDate
    - add connection between those 2 new columns and those from AuditingInterfaceImpl
    - complete @AfterReturning for every entity
    - will see moew TODO's in future :))

To work:

    Add to VM Options, this parameter:
      -ea -javaagent:\**pathTo**\spring-instrument-4.1.4.RELEASE.jar
    
  
What i've done..

    - i have created services for every entity
    - i have implemented pointcut for methods which starts with "delete"
    Doesn't work to set createddate and modifieddate in DB
    @Delete, overwriting row with that registration

Updates(03/02/2015)...

    - modify all interfaces/services from service to work with entities properties
    - add AuditableAnnotation to give at runtime the MappedSuperClass to all entities
    - modify Audit, adding more constraints to find any object in database

Updates(04/02/2015)...

    - make sure that Save and Update datetime aren't the same in before pointcut

TODO's...

    - try to resolve the same situation with AOP
    - ask Bogdan for more TODO :))
