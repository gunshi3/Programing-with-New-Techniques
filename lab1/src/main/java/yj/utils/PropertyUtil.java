package yj.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
    public static String getValue(String key) {
        String res = null;
        try {
            //关于目录问题，可以直接放在resource目录下，不用
            InputStream in = PropertyUtil.class.getResourceAsStream("/config.properties");
            Properties properties = new Properties();
            properties.load(in);
            res = properties.getProperty(key);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
