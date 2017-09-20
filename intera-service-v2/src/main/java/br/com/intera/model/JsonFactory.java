package br.com.intera.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * Classe para representar a implementacao do GSOM package MODEL.
 * 
 * @author Joaquim
 *
 */
public class JsonFactory {

	private static JsonFactory instance = new JsonFactory();

	private JsonFactory() {

	}

	public static JsonFactory getInstance() {
		return instance;
	}

	public Gson getGsonImplementation() {

		GsonBuilder builder = new GsonBuilder();
		
		builder.setDateFormat("dd/MM/yyyy HH:mm:ss");
		builder.registerTypeAdapter(Reserva.class, "Apartamento");
		builder.registerTypeAdapter(Reserva.class, "Condominio");
		builder.registerTypeAdapter(Reserva.class, "Login");
		builder.registerTypeAdapter(Reserva.class, "Reserva");
		builder.registerTypeAdapter(Reserva.class, "ResultadoModel");
		builder.registerTypeAdapter(Reserva.class, "SalaBloco");
		builder.registerTypeAdapter(Reserva.class, "SalaCondominio");
		builder.registerTypeAdapter(Reserva.class, "Usuario");

		return builder.create();
	}

}
