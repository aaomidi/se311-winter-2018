# SE311
## Lab 1

### Running & Compiling

The build process of this project uses the maven build system. However, due to the requirements of this class, I will be providing instructions on how to do this through Eclipse as well as CLI for Maven.

The project is written for Java 8, if you use any older Java version you will encounter errors. Newer Java versions should be fine.

#### Maven

1. In the directory of this readme, execute the following command: `mvn clean package`
2. Once this is complete, another directory called `jar` will be made.
3. Run `java -jar jar/Lab1.jar TestFile.txt`

#### Eclipse

1. Make sure you have Eclipse Oxygen 4.7.2. (Different versions may work, but there are no guarantees.)
2. File -> Import -> Maven -> Existing Maven Projects
3. Root Directory -> Folder where this readme is located.
4. Make sure Projects and Add Project(s) to working set is checked. -> Finish
6. Right click on the main class (MasterControl.java)
7. Run it with the argument `TestFile.txt`

### UML

A uml is included in the same directory as this readme.
