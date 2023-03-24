package ibf2022.tfip.ssf.day13workshopSpringBootEmployee;

import java.io.File;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day13WorkshopSpringBootEmployeeApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(Day13WorkshopSpringBootEmployeeApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
        if(args.containsOption("dataDir")){
			final String dataDir = args.getOptionValues("dataDir").get(0);

			File fileDir = new File(dataDir);

			if(!fileDir.exists()){
				fileDir.mkdir();
			}
			else{
				System.out.println(fileDir.getAbsoluteFile());
			}
		}
    }
}
