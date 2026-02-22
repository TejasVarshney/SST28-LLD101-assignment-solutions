import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Responsibility: parse a raw "key=value;..." string into a ParsedInput object.
 * Contains no validation logic and no IO.
 */
public class StudentInputParser {

    public ParsedInput parse(String raw) {
        Map<String, String> kv = new LinkedHashMap<>();
        for (String part : raw.split(";")) {
            String[] tokens = part.split("=", 2);
            if (tokens.length == 2) {
                kv.put(tokens[0].trim(), tokens[1].trim());
            }
        }
        return new ParsedInput(
            kv.getOrDefault("name",    ""),
            kv.getOrDefault("email",   ""),
            kv.getOrDefault("phone",   ""),
            kv.getOrDefault("program", "")
        );
    }
}
