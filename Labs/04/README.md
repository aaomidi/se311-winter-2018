# SE311
## Lab 4

### Notice

This project might seem like its a single project, however I assure you it is not. It uses a maven module system so it can share code with a commons library.

For more information on multi-module maven projects: https://maven.apache.org/guides/mini/guide-multiple-modules.html

### Running & Compiling

The build process of this project uses the maven build system. However, due to the requirements of this class, I will be providing instructions on how to do this through Eclipse as well as CLI for Maven.

The project is written for Java 8, if you use any older Java version you will encounter errors. Newer Java versions should be fine.

#### Maven

1. In the directory of this readme, execute the following command: `mvn clean package`
2. Once this is complete, another directory called `jar` will be made.
3. Run `java -jar server/jar/Server.jar`
4. Run `java -jar client/jar/Client.jar`
5. Follow the instructions.
    
#### Eclipse

1. Make sure you have Eclipse Oxygen 4.7.2. (Different versions may work, but there are no guarantees.)
2. File -> Import -> Existing Maven Project -> Next
3. Select the root directory of the project (its the directory where server/, client/ and commons/ exists.)
4. Make sure all of the projects and the parent pom.xml is ticked.
5. Press Finish
6. Right click server, run as, java application.
7. Right click client, run as, java application.
8. Follow the onscreen instructions.

### Video

The eclipse process and the demonstration of this project is done in this video:



To demonstrate this project, I have included a video: https://youtu.be/_UsIHP3Zldo
