package br.com.mpx;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mpx.input.FotoInput;

@RestController
@RequestMapping("/fotos")
public class FotoController {

	@PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void atualizarFoto(FotoInput fotoInput) {
		Path fileStorageLocation = Paths.get("src/main/resources/fotos")
                .toAbsolutePath().normalize();
		
		String fileName = fotoInput.getArquivo().getOriginalFilename();

		Path targetLocation = fileStorageLocation.resolve(fileName);
        try {
			Files.copy(fotoInput.getArquivo().getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

}
