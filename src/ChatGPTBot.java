/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;
import org.json.JSONArray;
/**
 *
 * @author xx
 */
public class ChatGPTBot {
   public static String sendMessageToGPT(String message) throws IOException {
        String apiUrl = "https://api.openai.com/v1/chat/completions";
        String apiKey = "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"; 

        String jsonInputString = """
        {
            "model": "gpt-3.5-turbo",
            "messages": [
                { "role": "user", "content": "%s" }
            ]
        }
        """.formatted(message);

        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", "Bearer " + apiKey);
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int status = conn.getResponseCode();
        InputStream inputStream = (status == 200) ? conn.getInputStream() : conn.getErrorStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
        StringBuilder response = new StringBuilder();
        String responseLine;
        while ((responseLine = br.readLine()) != null) {
            response.append(responseLine.trim());
        }

        conn.disconnect();

        try {
            JSONObject json = new JSONObject(response.toString());

            if (json.has("choices")) {
                return json.getJSONArray("choices")
                           .getJSONObject(0)
                           .getJSONObject("message")
                           .getString("content");
            } else if (json.has("error")) {
                return "Error from API: " + json.getJSONObject("error").getString("message");
            } else {
                return "Sorry, I couldn't understand the response.";
            }

        } catch (Exception e) {
            return "Sorry, I couldn't understand the response.";
        }
    }
}

