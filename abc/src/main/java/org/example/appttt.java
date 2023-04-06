package org.example;

import java.net.URI;
import java.net.URISyntaxException;

import com.adobe.aem.graphql.client.AEMHeadlessClient;
import com.adobe.aem.graphql.client.AEMHeadlessClientException;
import com.adobe.aem.graphql.client.GraphQlResponse;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws URISyntaxException {
        System.out.println("Hello World!");

        // AEMHeadlessClient aemHeadlessClient = AEMHeadlessClient.builder()
        // .endpoint(new
        // URI("http://localhost:4502/content/cq%3Agraphql/wknd-shared/endpoint.json"))
        // .basicAuth("admin", "admin")
        // .build();

        AEMHeadlessClient aemHeadlessClient = AEMHeadlessClient.builder()
                .endpoint(new URI("http://localhost:4502/graphql/execute.json"))
                .basicAuth("admin", "admin")
                .build();

        // String query = "{\n" +
        // " teamList{\n" +
        // " items{ \n" +
        // " _path\n" +
        // " } \n" +
        // " }\n" +
        // "}";

        try {
            // GraphQlResponse response = aemHeadlessClient.runQuery(query);
            GraphQlResponse response = aemHeadlessClient.runPersistedQuery("/my-project/all-teams");
            JsonNode data = response.getData();
            System.out.println(data.asText());
            // ... use the data
        } catch (AEMHeadlessClientException e) {
            // e.getMessage() will contain an error message (independent of type of error)
            // if a response was received, e.getGraphQlResponse() will return it (otherwise
            // null)

            if (e.getGraphQlResponse() != null) {
                System.out.println(e.getGraphQlResponse());
            } else {
                System.out.println(e.getMessage());
            }
        }

    }

}
