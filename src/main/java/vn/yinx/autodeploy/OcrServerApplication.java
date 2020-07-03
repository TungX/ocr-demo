package vn.yinx.autodeploy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import vn.yinx.autodeploy.repositories.LicenseRepository;

@SpringBootApplication
@EnableMongoAuditing
public class OcrServerApplication implements CommandLineRunner{
	@Autowired
	private LicenseRepository licenseRepository;

	public static void main(String[] args) {
		SpringApplication.run(OcrServerApplication.class, args);
	}

	@Override
	public void run(String... args) {
//		License license = new License();
//		license.setKey("abc");
//		license.setEmail("yinx@gmail.com");
//		licenseRepository.save(license);
//		System.out.println("Save license");
	}
}
