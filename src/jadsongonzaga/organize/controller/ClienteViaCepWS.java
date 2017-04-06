/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadsongonzaga.organize.controller;

/**
 *
 * @author jadson
 */
import jadsongonzaga.organize.exception.CepNaoEncontradoException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jadson
 */
public class ClienteViaCepWS {

    private int ibge;
    private int uf;
    private String logradouro;
    private String bairro;
    private boolean sucesso;

    public ClienteViaCepWS(String cep) throws CepNaoEncontradoException {
        Map<String, String> mapa = new HashMap<>();
        cep = Utils.removeFormatacao(cep);
        String json = null;

        try {
            URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));

            json = jsonSb.toString();

        } catch (Exception e) {
            throw new CepNaoEncontradoException();
        }

        if (json != null) {
            Matcher matcher = Pattern.compile("\"\\D.*?\": \".*?\"").matcher(json);
            while (matcher.find()) {
                String[] group = matcher.group().split(":");
                mapa.put(group[0].replaceAll("\"", "").trim(), group[1].replaceAll("\"", "").trim());
            }

            if (mapa.isEmpty()) {
                throw new CepNaoEncontradoException();
            }
            mapa.put("uf", mapa.get("ibge").substring(0, 2));
            setIbge(Integer.parseInt(mapa.get("ibge")));
            setBairro(mapa.get("bairro"));
            setLogradouro(mapa.get("logradouro"));
            setUf(Integer.parseInt(mapa.get("ibge").substring(0, 2)));
        }

    }

    private void setIbge(int ibge) {
        this.ibge = ibge;
    }

    private void setUf(int uf) {
        this.uf = uf;
    }

    private void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    private void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getIbge() {
        return ibge;
    }

    public int getUf() {
        return uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }
    
    public static void main(String[] args) throws CepNaoEncontradoException {
        ClienteViaCepWS v = new ClienteViaCepWS("44330000");
        System.out.println(v.getUf());
    }

}
