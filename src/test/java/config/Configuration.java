package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/owner/browserstack.properties")

public interface Configuration extends Config  {
  String server();
  String username();
  String access_key();
}