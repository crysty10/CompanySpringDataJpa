package ro.company.domain.util;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * Created by Florin.Cojocaru on 3/3/2015.
 */
public class ObjectSerializer {
    
    public static byte[] convert(Object obj) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream((int) ObjectSizeCalculator.getObjectSize(obj));
        ObjectOutput o = new ObjectOutputStream(b);
        o.writeObject(obj);

        return b.toByteArray();
    }
}
