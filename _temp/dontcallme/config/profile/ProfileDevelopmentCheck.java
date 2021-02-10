package com.practice.dontcallme.config.profile;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile(value="dev-check")
@PropertySource({"classpath:application-dev-check.properties"})
public class ProfileDevelopmentCheck {
    // Skipped Configurations
}
