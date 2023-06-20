package com.maxima.teste;

import com.maxima.teste.entity.Address;
import com.maxima.teste.entity.Client;
import com.maxima.teste.repository.AddressRepository;
import com.maxima.teste.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TesteApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(TesteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Client client = new Client(null,"João Neves","88.141.511/0001-74","2223");
		Address address = new Address(null, "Rua Nossa Senhora da Conceição", "Vila Vicente Fialho", "São Luís", "MA", "BR", "399", "Casa 01", "65073-550", -2.5106486340571648, -44.238608203875366);
		address = addressRepository.save(address);
		client.setAddress(address);
		clientRepository.save(client);

		client = new Client(null,"João Silva","26.076.705/0001-86","2223");
		address = new Address(null, "Rua Taiamã", "Jardim Village do Cerrado", "Rondonópolis", "MT", "BR", "399", "Casa 02", "78731-614", -11.843329183496222, -55.5465492884243);
		address = addressRepository.save(address);
		client.setAddress(address);
		clientRepository.save(client);

		client = new Client(null,"Jonas Silveira","63.053.886/0001-51","2223");
		address = new Address(null, "Rua Professor Agripino Oliveira", "Morros", "Teresina", "PI", "BR", "299", "Casa A", "64062-040", -5.0320505782786755, -42.7648529287508);
		address = addressRepository.save(address);
		client.setAddress(address);
		clientRepository.save(client);

		client = new Client(null,"Jaqueline Teles","63.053.886/0001-51","2223");
		address = new Address(null, "Passarela Bom Jesus", "Araxá", "Macapá", "AP", "BR", "299", "Casa A", "68903-864", 0.001880, -51.061797);
		address = addressRepository.save(address);
		client.setAddress(address);
		clientRepository.save(client);
	}

}
