package serializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static serializer.Utils.shiftBlock;
import static serializer.Utils.shiftBlockPartially;

public class SerializationFormatJSON implements SerializationFormat {

    @Override
    public String combineMap(Map<String, String> keyToElement) {
        ArrayList<String> mapElements = new ArrayList<>();
        keyToElement.forEach((k, v) -> mapElements.add(shiftBlock(combineKeyValue(k, v), 2)));
        return "{\n" + String.join(",\n", mapElements) + "\n}";
    }

    @Override
    public String combineList(List<String> elements) {
        String delimiter = checkIfSimple(elements) ? ", " : ",\n ";
        List<String> shiftedElements = elements.stream()
                .map(e -> shiftBlockPartially(e, 1))
                .collect(Collectors.toList());
        return "[" +
                String.join(delimiter, shiftedElements) +
                "]";
    }

    @Override
    public String serializePrimitive(Object value) {
        return getPrimitiveString(value);
    }

    @Override
    public String finishSerialization(Object obj, String body) {
        return body;
    }

    private boolean checkIfSimple(List<String> elements) {
        return elements.stream().noneMatch(s -> s.contains("\n"));
    }

    private String combineKeyValue(String key, String value) {
        String jsonKey = "\"" + key + "\": ";
        return jsonKey + shiftBlockPartially(value, jsonKey.length());
    }

    private String getPrimitiveString(Object obj) {
        if (obj == null) {
            return "null";
        } else {
            String s = obj.toString();
            if (obj instanceof Number || obj instanceof Boolean) {
                return s;
            } else {
                return "\"" + s + "\"";
            }
        }
    }
}

