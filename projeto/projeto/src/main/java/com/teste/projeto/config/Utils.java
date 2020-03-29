package com.teste.projeto.config;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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

	public String DiferencaEntreDatas(LocalDateTime Datainsert) {

		LocalDateTime agora = LocalDateTime.now();
		long intervalo = ChronoUnit.DAYS.between(Datainsert, agora);

		if (intervalo >= 1) {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			String DataInseridaFormatada = Datainsert.format(formatter);

			return DataInseridaFormatada;

		} else {
			long intervaloHoras = ChronoUnit.HOURS.between(agora,Datainsert);

			if (intervaloHoras <= 23 && intervaloHoras >= 1) {

				return intervaloHoras + " horas atrás";

			} else {
				long intervaloMinutos = ChronoUnit.MINUTES.between(agora, Datainsert);
				
				return intervaloMinutos + " minutos atás";
			}

		}

	}
	
}
