package Facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SimpleApiFacade implements ApiFacade {
    @Override
    public String getAttributeValueFromJson(String urlString, String attributeName) throws IllegalArgumentException, IOException {
        String jsonResponse = fetchJsonResponse(urlString);
        return extractAttributeFromJson(jsonResponse, attributeName);
    }

    private String fetchJsonResponse(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        int status = connection.getResponseCode();
        if (status != 200) {
            throw new IOException("HTTP request failed with status code: " + status);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        } finally {
            connection.disconnect();
        }
    }

    private String extractAttributeFromJson(String jsonResponse, String attributeName) throws IllegalArgumentException {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonResponse);

            Object attributeValue = jsonObject.get(attributeName);
            if (attributeValue == null) {
                throw new IllegalArgumentException("Attribute not found: " + attributeName);
            }

            return attributeValue.toString();
        } catch (ParseException e) {
            throw new IllegalArgumentException("Failed to parse JSON response.", e);
        }
    }
}

