package mx.edu.utez.practica_errores.controller;

import mx.edu.utez.practica_errores.services.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/perfiles")
    public String getProfile() {
        return "Perfil activo: " + profileService.getActiveProfile();
    }
}
