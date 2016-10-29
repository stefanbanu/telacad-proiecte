package ro.marian.vicea.server;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.marian.vicea.config.ProjectConfig;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);
    }
}
