package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private UniversalRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        UniversalObject laptop1 = new UniversalObject("Laptop");
        UniversalObject procesor1 = new UniversalObject("CPU");
        procesor1.addObject("name", "intel core i5 4200m");
        procesor1.addObject("cores", 2);
        procesor1.addObject("frequency", "2.50 GH - 3.10 GH");
        laptop1.addObject("name", "Lenovo y50-70");
        laptop1.addObject("cpu", procesor1);
        repository.save(procesor1);
        repository.save(laptop1);

        UniversalObject laptop2 = new UniversalObject("Laptop");
        UniversalObject procesor2 = new UniversalObject("CPU");
        procesor2.addObject("name", "intel core i7 666hq");
        procesor2.addObject("cores", 4);
        procesor2.addObject("frequency", "3.50 GH - 4.20 GH");
        laptop2.addObject("name", "Lenovo t90-80j");
        laptop2.addObject("cpu", procesor2);
        repository.save(procesor2);
        repository.save(laptop2);

        UniversalObject laptop = new UniversalObject("Laptop");
        UniversalObject procesor = new UniversalObject("CPU");
        procesor.addObject("name", "intel");
        procesor.addObject("cores", 8);
        procesor.addObject("frequency", "3.50 GH - 4.20 GH");
        laptop.addObject("name", "Lenovo");
        laptop.addObject("cpu", procesor);
        repository.save(procesor);
        repository.save(laptop);

        List<UniversalObject> list  = repository.findWithQuery("{name : 'Laptop'}");
        list.forEach(System.out::println);
        list  = repository.findWithQuery("{'objects.name' : 'Lenovo'}");
        list.forEach(System.out::println);
    }

}