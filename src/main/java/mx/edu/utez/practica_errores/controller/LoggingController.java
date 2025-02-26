package mx.edu.utez.practica_errores.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class LoggingController {

    private static final Logger logger = LogManager.getLogger(LoggingController.class);

    @GetMapping("/log")
    public String logExample() {
        logger.info(" ♦ Esto es un log INFO");
        logger.debug(" ♦ Esto es un log DEBUG");
        logger.error(" ♦ Esto es un log ERROR", new Exception("Error de prueba"));
        return "Prueba de logging completada. Ya debe de aparecer en consola y el archivo de logs";
    }
}
