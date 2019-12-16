package serializer;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static String getTabulation(int tabulation) {
        return String.join("", Collections.nCopies(tabulation, " "));
    }

    public static Map<String, Object> getDeclaredFields(Object obj) {
        HashMap<String, Object> map = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                map.put(field.getName(), field.get(obj));
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Impossible accessibility error");
            }
        }
        return map;
    }

    public static String shiftBlockPartially(String s, int tabulation) {
        return String.join("\n" + getTabulation(tabulation), s.split("\n"));
    }

    public static String shiftBlock(String s, int tabulation) {
        return getTabulation(tabulation) + shiftBlockPartially(s, tabulation);
    }
}