package br.com.mpx.input;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FotoInput {

	private MultipartFile arquivo;
	private String descricao;

}
