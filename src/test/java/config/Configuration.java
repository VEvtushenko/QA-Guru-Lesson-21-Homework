package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/owner/browserstack.properties")

public interface Configuration extends Config  {
  String server();
  String username();
  @Key("access_key")
  String accessKey();
  String app();
  String device();
  @Key("os_version")
  String osVersion();
  String project();
  String build();
  @Key("test_name")
  String testName();
}
