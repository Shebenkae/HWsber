package java.hw.countmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class CollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List newArrayList() {
        return new ArrayList<T>();
    }

    public static <T> int indexOf(List<? extends T> source, T obj) {
        return source.indexOf(obj);
    }

    public static <T> List<T> limit(List<? extends T> source, int size) {
        return List.copyOf(source.subList(0, size));
    }

    public static <T> void add(List<? super T> source, T obj) {
        source.add(obj);
    }

    public static <T> void removeAll(List<? extends T> removeFrom, List<? extends T> c2) {
        for (int i = 0; i < c2.size(); i++) {
            if (removeFrom.contains(c2.get(i)))
                removeFrom.remove(c2.get(i));
        }
    }

    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        for (int i = 0; i < c2.size(); i++) {
            if (!c1.contains(c2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (int i = 0; i < c2.size(); i++) {
            if (!c1.contains(c2.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static <T extends Comparable<? super T>> List<? super T> range(List<? extends T> source, T min, T max) {
        List<T> newArray = new ArrayList<>();
        for (int i = 0; i < source.size(); i++) {
            if ((source.get(i).compareTo(min) >= 0) && (source.get(i).compareTo(max) <= 0)) {
                newArray.add(source.get(i));
            }
        }
        return newArray;
    }
    public static <T> List<T> range(List<? extends T> source, T min, T max, Comparator<? super T> comparator){
        List<T> newArray = new ArrayList<>();
        for (int i = 0; i < source.size(); i++) {
            if ((comparator.compare(source.get(i), min) >= 0) && (comparator.compare(source.get(i), max) <= 0)) {
                newArray.add(source.get(i));
            }
        }
        return newArray;
    }
}
