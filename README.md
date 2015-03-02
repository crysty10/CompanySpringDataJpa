# CompanySpringDataJpa
TODO:
  1. every entity table must have 2 more columns: createDate, modifiedDate
  2. add connection between those 2 new columns and those from AuditingInterfaceImpl
  3. complete @AfterReturning for every entity
  4. will see moew TODO's in future :))

To work:
  Add to VM Options, this parameter:
    -ea -javaagent:\**pathTo**\spring-instrument-4.1.4.RELEASE.jar
    
  
What i've done..
    - i have created services for every entity
    - i have implemented pointcut for methods which starts with "delete"
    
    Doesn't work to set createddate and modifieddate in DB
    @Delete, overwriting row with that registration

