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
        logger.info("Log nivel Informacion ejemplo");
        logger.debug("Log nivel Debug ejemplo");
        logger.error("Error Log ejempo", new Exception("Example exception"));
        return "Logging ha sido demostrado. Revisa la consola y el archivo de logs!";
    }
}
