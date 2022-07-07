package io;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Examples of how to read text file.
 * Most of the examples got from:
 * https://www.baeldung.com/reading-file-in-java
 *
 * @author Artem Boiko
 */
@Slf4j
public class ReadTextFile {
    private static final String DIRECTORY_LOCATION = "src/main/resources";
    private static final String FILE_NAME = "/textFile.txt";

    public static void main(String[] args) {
        System.out.println("Executing: listOfLinesViaBufferedReader");
        List<String> listOfLinesViaBufferedReader = getTextLinesViaBufferedReader(FILE_NAME);
        listOfLinesViaBufferedReader.forEach(System.out::println);


        System.out.println("Executing: getTextLinesViaNIO");
        List<String> listOfLinesViaNIO = getTextLinesViaNIO(FILE_NAME);
        listOfLinesViaNIO.forEach(System.out::println);


        System.out.println("Executing: listOfLinesViaStream");
        List<String> listOfLinesViaStream = getTextFileViaStream(FILE_NAME);
        listOfLinesViaStream.forEach(System.out::println);


        System.out.println("Executing: getTextLinesViaScanner");
        List<String> getTextLinesViaScanner = getTextLinesViaScanner(FILE_NAME);
        getTextLinesViaScanner.forEach(System.out::println);
    }

    /**
     * I prefer this way.
     * First got the resource.
     * Then check it's not null.
     * Then do the job.
     * Fast, short and clear.
     * <p>
     * We get inputStream via getClass().getResourceAsStream(fileName)
     * because of when JAR file is packaged, our resource isn't in the resource folder,
     * it's in classes folder.
     */
    private static List<String> getTextLinesViaBufferedReader(String fileName) {
        List<String> listOfLines = new ArrayList<>();


        InputStream inputStream = ReadTextFile.class.getResourceAsStream(fileName);
        if (inputStream != null) {
            try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                bufferedReader.lines().forEach(listOfLines::add);
            } catch (IOException exception) {
                log.error("Cannot read file properly. Cause: {}", exception.getCause(), exception);
            }
        }


        return listOfLines;
    }

    /**
     * When we use BufferedReader with Path we need to set relative path
     * starting from src folder.
     */
    private static List<String> getTextLinesViaNIO(String fileName) {
        List<String> listOfLines = new ArrayList<>();


        Path path = Paths.get(DIRECTORY_LOCATION + fileName);
        try {
            BufferedReader reader = Files.newBufferedReader(path);
            reader.lines().forEach(listOfLines::add);
        } catch (IOException exception) {
            log.error("Source is not found. Cause: {}", exception.getCause(), exception);
        }


        return listOfLines;
    }

    /**
     * When we use Paths we need to set relative path
     * starting from src folder.
     */
    private static List<String> getTextFileViaStream(String fileName) {
        List<String> listOfLines = new ArrayList<>();


        try (Stream<String> stream = Files.lines(Paths.get(DIRECTORY_LOCATION + fileName))) {
            stream.forEach(listOfLines::add);
        } catch (IOException exception) {
            log.error("I/O error occurs opening the file. Cause: {}", exception.getCause(), exception);
        }


        return listOfLines;
    }

    /**
     * When we use Scanner we need to set relative path
     * starting from src folder.
     */
    private static List<String> getTextLinesViaScanner(String fileName) {
        List<String> listOfLines = new ArrayList<>();


        try (Scanner scanner = new Scanner(new File(DIRECTORY_LOCATION + fileName))) {
            while (scanner.hasNext()) {
                String nextLine = scanner.nextLine();
                listOfLines.add(nextLine);
            }
        } catch (FileNotFoundException exception) {
            log.error("Source is not found. Cause: {}", exception.getCause(), exception);
        }


        return listOfLines;
    }
}
