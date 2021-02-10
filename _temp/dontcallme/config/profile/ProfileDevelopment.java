package com.practice.dontcallme.config.profile;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile(value="dev")
@PropertySource({"classpath:application-dev.properties"})
public class ProfileDevelopment {
    // Skipped Configurations
}
