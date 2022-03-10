package uz.pdp.pdp_food_delivery;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("C:\\");
        List<Path> result = findByFileName(path, "U");
        result.forEach(System.out::println);

    }

    public static List<Path> findByFileName(Path path, String fileName)
            throws IOException {

        List<Path> result;
        try (Stream<Path> pathStream = Files.find(path,
                Integer.MAX_VALUE,
                (p, basicFileAttributes) ->
                        p.getFileName().toString().startsWith(fileName))
        ) {
            result = pathStream.collect(Collectors.toList());
        }
        return result;
    }
}
