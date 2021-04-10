package br.edu.utfpr.jhony.testes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class TesteUnitarioAplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteUnitarioAplication.class, args);
	}

    public static class MatematicaUtil {

        public int calculaSoma(int[] data) {
            return Arrays.stream(data).reduce(Integer::sum).orElse(0);
        }
    }
}
