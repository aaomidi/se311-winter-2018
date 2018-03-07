# SE311
## Lab 4

### Notice

This project might seem like its a single project, however I assure you it is not. It uses a maven module system so it can share code with a commons library.

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
2. File -> Open Projects from File System or Archive
3. Enter the path to the directory where the project is located.
4. Press Finish.
5. Run.

### Video

To demonstrate this project, I have included a video: https://youtu.be/XV8lMefbFKU
