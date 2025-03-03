package junit5tests;

import java.util.stream.Stream;

public class ParamsProvider {

    static Stream<String> methodSourceStream() {
//        processing
        return Stream.of("Apple", "Mango", "Pineapple");
    }
}
