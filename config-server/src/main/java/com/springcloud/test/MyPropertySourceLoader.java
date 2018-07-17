package com.springcloud.test;

import org.apache.commons.codec.CharEncoding;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Description:
 * <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: 2018/7/17 12:41
 * @since JDK 1.8
 */
public class MyPropertySourceLoader
        implements PropertySourceLoader {

    public MyPropertySourceLoader() {
        System.out.println("....");
    }

    @Override
    public String[] getFileExtensions() {
        return new String[]{"properties", "xml"};
    }

    @Override
    public PropertySource<?> load(String name,
                                  Resource resource,
                                  String profile)
            throws IOException {
        if (profile == null) {
            Properties properties = getProperties(resource);
            if (!properties.isEmpty()) {
                return new PropertiesPropertySource(name, properties);
            }
        }
        return null;
    }

    private Properties getProperties(Resource resource) {
        Properties properties = new Properties();
        try (InputStream inputStream = resource.getInputStream()) {
            properties.load(new InputStreamReader(inputStream, CharEncoding.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
