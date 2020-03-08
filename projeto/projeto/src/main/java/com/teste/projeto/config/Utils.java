package com.teste.projeto.config;

import java.text.DecimalFormat;
import org.springframework.stereotype.Component;

@Component
public class Utils {

	

	public float formatarFloat(float numero) {

		DecimalFormat df = new DecimalFormat("0.00");
		df.format(numero);

		String numeroFormatado = df.format(numero).replace(",", ".");

		float numeroFormatadoefloat = Float.parseFloat(numeroFormatado);

		return numeroFormatadoefloat;
	}
	
  
}
