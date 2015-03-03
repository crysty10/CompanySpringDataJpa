package ro.company.domain.util;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * Created by Cristian.Dumitru on 3/3/2015.
 */
public class ObjectSerializer {

    public static byte[] objectToByteStream(Object object) {

        final int objectSize = (int) ObjectSizeCalculator.getObjectSize(object);
        ByteArrayOutputStream bOutput =
                new ByteArrayOutputStream(objectSize);
        ObjectOutput objectOutput = null;
        byte[] objectSerializable = new byte[objectSize];

        try {
            objectOutput = new ObjectOutputStream(bOutput);
            objectOutput.writeObject(object);
            objectSerializable = bOutput.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Failed to serialize!",e);
        }

        return objectSerializable;
    }
}
