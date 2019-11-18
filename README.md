
  ### Getting started  
  

##### Java, Java SDK  
* version 8 or higher  
* [documentation](https://docs.oracle.com/javase/8/docs/)  
  
##### Maven  
* version: 3.5.*  or higher
* [documentation](http://maven.apache.org/guides/)  
  
##### Browsers   
* Chrome  
* [official site](https://www.google.com/intl/pl_pl/chrome/)   
  
##### All dependencies from POM.xml  
```sh  
$ mvn dependency:resolve  
```  
  
### Documentation  
```sh  
$ -generate javadoc: mvn javadoc:javadoc  
```  
  
### Test Reports  
```sh  
$ turn on reports mode: mvn site -DgenerateReports=false  
$ run tests: mvn test 
$ generate reports: mvn surefire-report:report-only 
```  

### Run parameters  
To execute project with parameters, in command line type:   
```sh  
$ -Dname_of_parameter=value_of_parameter  
```  