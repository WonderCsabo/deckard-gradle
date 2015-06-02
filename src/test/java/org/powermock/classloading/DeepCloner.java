package org.powermock.classloading;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;

import org.powermock.classloading.spi.DeepClonerSPI;

public class DeepCloner implements DeepClonerSPI {
    private final XStream xStream;

    public DeepCloner(ClassLoader classLoader) {
        xStream = new XStream(null, null, new Xpp3Driver());
        xStream.omitField(ClassloaderExecutor.class, "classloader");
        xStream.setClassLoader(classLoader);
    }

    public <T> T clone(T objectToClone) {
        final String serialized = xStream.toXML(objectToClone);
        return (T) xStream.fromXML(serialized);
    }
}