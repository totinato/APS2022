package aps.vasco.services;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.inject.Inject;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import aps.vasco.modelo.Represa;
public class ApiService {
	private final String URL_HOJE = "http://sabesp-api.herokuapp.com/v2";
	private final String URL_DIAESPECIFICO = "http://sabesp-api.herokuapp.com/v2/";

	
	
	private String getJson(String url) {
		String json = null;
		HttpClient httpclient = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet(url);
		try {
			HttpResponse response = httpclient.execute(get);
			if (response.getStatusLine().getStatusCode() != 200) {
				try {
					
				}catch (Exception e) {}
				json = null;
			} else {
				try {
					Thread.sleep(50);
				} catch (Exception e) {
				}
				json = EntityUtils.toString(response.getEntity());
				
				if (json.contains("API =  Erro")) {
					
				}
				
				json = json.replace("\"{", "{").replace("}\"", "}").replaceAll("\\\\\"", "\"").replaceAll("\\\\\\\\", "\\\\")
						.replace("StatusAPI = 100, MsgAPI = Status API =  OK, Sucess =", "\"Sucess\" :")
						.replace("StatusAPI = 100, MsgAPI = Status =  OK, Sucess =", "\"Sucess\" :") 
						.replace("StatusAPI = 100, MsgAPI = OK, Sucess =", "\"Sucess\" :")
						.replace("[[", "[")
						.replace("]]", "]");
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return json;
	}
	private String getJsonPost(String url) {
		String json = null;
		
		RequestConfig.Builder requestBuilder = RequestConfig.custom();
		requestBuilder.setConnectTimeout(60*10);
		requestBuilder.setConnectionRequestTimeout(60*10*10);
		
		HttpClient httpclient = HttpClientBuilder.create()
				.setDefaultRequestConfig(requestBuilder.build())
				.build();
		HttpPost get = new HttpPost(url);
		try {
			HttpResponse response = httpclient.execute(get);
			if (response.getStatusLine().getStatusCode() != 200) {
				try {
				}catch (Exception e) {}
				json = null;
			} else {
				try {
					Thread.sleep(50);
				} catch (Exception e) {
				}
				json = EntityUtils.toString(response.getEntity());
				if (json.contains("API =  Erro")) {
					json = null;
				} else {
					json = json.replace("[","").replace("]","");
				}
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return json;
	}
	
	public List<Represa> pegarDiaHoje() {
		String json = getJson(URL_HOJE);
		if (json != null) {
			JSONArray represajson = new JSONArray(json);
			List<Represa> represas = new ArrayList<>();
			for (int l = 0; l < represajson.length(); l++) {
					Map<String, Object> represa = represajson.getJSONObject(l).toMap();
					String dados= (String) represa.get("name");
					Map<String, Object> dados2=(Map<String, Object>) represa.get("data");
					String name = dados;
					String volume_armazenado = dados2.get("volume_armazenado").toString();
					String pluviometria_do_dia = dados2.get("pluviometria_do_dia").toString();
					String pluviometria_acumulada_no_mes = dados2.get("pluviometria_acumulada_no_mes").toString();
					String media_historica_do_mes = dados2.get("media_historica_do_mes").toString();
						Represa repre = new Represa();
						repre.setNome(name);
						repre.setVolume_armazenado(volume_armazenado);
						repre.setPluviometria_acumulada_no_mes(pluviometria_acumulada_no_mes);
						repre.setPluviometria_do_dia(pluviometria_do_dia);
						repre.setMedia_historica_do_mes(media_historica_do_mes);
						represas.add(repre);
					

			}
			return represas;
		}
		return null;

	}

}
