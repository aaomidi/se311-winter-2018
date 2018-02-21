# SE311
## Homework 2

### Running & Compiling

The build process of this project uses the maven build system. However, due to the requirements of this class, I will be providing instructions on how to do this through Eclipse as well as CLI for Maven.

The project is written for Java 8, if you use any older Java version you will encounter errors. Newer Java versions should be fine.

#### Maven

1. In the directory of this readme, execute the following command: `mvn clean package`
2. Once this is complete, another directory called `jar` will be made.
3. Run `java -jar jar/HW2.jar config.json`

#### Eclipse

1. Make sure you have Eclipse Oxygen 4.7.2. (Different versions may work, but there are no guarantees.)
2. File -> Open Projects from File System or Archive
3. Enter the path to the directory where the project is located.
4. Press Finish.
5. Run.

### Configuration

A config sample is included with the project. The path variable in both input and output is only required if the type is set to file.

### UML

A uml is included in the same directory as this readme.

### Future Considerations

I think this class definitely needs to adopt a standard build process. The two popular ones (around 90% market share) are maven and gradle. Eclipse, or any other IDE for that matter, isn't a standard tool and shouldn't be used as such.

### Video

To demonstrate this project, I have included a video: https://youtu.be/IKjvVBd0HqM
