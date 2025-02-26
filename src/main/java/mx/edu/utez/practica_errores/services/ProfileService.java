package mx.edu.utez.practica_errores.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ProfileService {

    private final Environment environment;

    public ProfileService(Environment environment) {
        this.environment = environment;
    }

    public String getActiveProfile() {
        return Arrays.toString(environment.getActiveProfiles());
    }
}
