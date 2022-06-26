package config;

import org.aeonbits.owner.ConfigFactory;

public class BrowserstackConnection {

    public static Configuration config = ConfigFactory.create(Configuration.class, System.getProperties());

}
