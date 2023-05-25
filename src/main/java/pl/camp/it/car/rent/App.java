package pl.camp.it.car.rent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.camp.it.car.rent.configuration.AppConfiguration;
import pl.camp.it.car.rent.core.Core;
import pl.camp.it.car.rent.core.ICore;

public class App {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        AppConfiguration.class);

        ICore core = context.getBean(ICore.class);
        core.start();
    }
}
