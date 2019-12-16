package serializer.example;

import serializer.SerializationFormatJSON;
import serializer.Serializer;
import serializer.SerializerOfObject;
import serializer.SerializationFormatXML;
public class Main {
    public static void main(String[] args) {
        Person person = new Person("Gig", "Ramz", 54, new Address(14, "GlavnayaStreet"));

        Serializer jsonSerializer = new SerializerOfObject(new SerializationFormatJSON());
        jsonSerializer.serialize(person);
        Serializer xmlSerializer = new SerializerOfObject(new SerializationFormatXML());
        System.out.println(xmlSerializer.serialize(person));

    }
}
