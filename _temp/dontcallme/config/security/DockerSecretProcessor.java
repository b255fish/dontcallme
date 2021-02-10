package com.practice.dontcallme.config.security;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

/**
 * Implementation for Docker Secrets in Docker Swarm.
 */
@Component
public class DockerSecretProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        String bindPathProperty = environment.getProperty("docker-secret.bind-path");

        if (bindPathProperty == null) {
            bindPathProperty = "/run/secrets";
        }
        Path bindPath = Paths.get(bindPathProperty);
        if (Files.isDirectory(bindPath)) {
            Map<String, Object> dockerSecrets;
            try {
                dockerSecrets = Files.list(bindPath).collect(   // filter,map,reduce
                        Collectors.toMap(
                                path -> {
                                    File secretFile = path.toFile();
                                    return "docker-secret-" + secretFile.getName();
                                },
                                path -> {
                                    File secretFile = path.toFile();
                                    try {
                                        byte[] content = FileCopyUtils.copyToByteArray(secretFile);
                                        return new String(content);
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                        ));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // check value in RAM not directory
//            dockerSecrets.forEach((key, value)
//                    -> System.out.println(key + "=\"" + value + "\""));

            MapPropertySource propertySource = new MapPropertySource("docker-secrets", dockerSecrets);

            environment.getPropertySources().addLast(propertySource);

        }
    }
}

/* This Requires
resources - META-INF - spinrg.factories
    org.springframework.boot.env.EnvironmentPostProcessor=com.practice.dontcallme.config.security.DockerSecretProcessor

    Refernece
         https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#howto-customize-the-environment-or-application-context
         EnvironmentPostProcessor



// YAML configuration file from the classpat
public class EnvironmentPostProcessorExample implements EnvironmentPostProcessor {

    private final YamlPropertySourceLoader loader = new YamlPropertySourceLoader();

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Resource path = new ClassPathResource("com/example/myapp/config.yml");
        PropertySource<?> propertySource = loadYaml(path);
        environment.getPropertySources().addLast(propertySource);
    }

    private PropertySource<?> loadYaml(Resource path) {
        if (!path.exists()) {
            throw new IllegalArgumentException("Resource " + path + " does not exist");
        }
        try {
            return this.loader.load("custom-resource", path).get(0);
        }
        catch (IOException ex) {
            throw new IllegalStateException("Failed to load yaml configuration from " + path, ex);
        }
    }

}

public class DockerSecretsDatabasePasswordProcessor implements EnvironmentPostProcessor {
    private final Logger logger = LoggerFactory.getLogger(DockerSecretsDatabasePasswordProcessor.class);

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Resource resource = new FileSystemResource("/run/secrets/db-password");

        if (resource.exists()) {
            try {
                if (logger.isInfoEnabled()) {
                    logger.info("Using database password from injected Docker secret file");
                }

                String dbPassword = StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset());
                Properties props = new Properties();
                props.put("spring.datasource.password", dbPassword);
                environment.getPropertySources().addLast(new PropertiesPropertySource("dbProps", props));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
*/


