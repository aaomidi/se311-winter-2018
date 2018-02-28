# SE311
## Lab 3

### Running & Compiling

The build process of this project uses the maven build system. However, due to the requirements of this class, I will be providing instructions on how to do this through Eclipse as well as CLI for Maven.

The project is written for Java 8, if you use any older Java version you will encounter errors. Newer Java versions should be fine.

#### Eclipse

1. Make sure you have Eclipse Oxygen 4.7.2. (Different versions may work, but there are no guarantees.)
2. File -> Open Projects from File System or Archive
3. Enter the path to the directory where the project is located.
4. Press Finish.
5. Run.


#### Maven

1. In the directory of this readme, execute the following command: `mvn clean package`
2. Once this is complete, another directory called `jar` will be made.
3. Run `java -jar jar/Lab3.jar`


### UML

A uml is included in the same directory as this readme.
