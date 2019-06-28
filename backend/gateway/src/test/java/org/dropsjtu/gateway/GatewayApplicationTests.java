package org.dropsjtu.gateway;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.Duration;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class GatewayApplicationTests {

    /*
    private WebTestClient client;
    private String gatewayHost = "http://localhost:8080";

    @Before
    public void setup() {
        client = WebTestClient.bindToServer()
                .baseUrl(gatewayHost)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .responseTimeout(Duration.ofMillis(30000))
                .build();

        // 加载测试路由配置 reload the test configuration
        // TestUtils.LoadLocalTestConfig(gatewayHost);
    }

    @Test
    public void getTest() {
        WebTestClient.ResponseSpec response = client.get().uri("/login")
                .exchange();
        response.expectStatus().is4xxClientError();
    }

    @Test
    public void simplePostTest() {
        WebTestClient.ResponseSpec response = client.post().uri("/login")
                .exchange();
        response.expectStatus().is4xxClientError();
    }

    @Test
    public void loginPostTest() throws Exception{
        WebTestClient.ResponseSpec response = client.post().uri(uriBuilder -> uriBuilder.path("/login")
                    .queryParam("username", "SE418")
                    .queryParam("password", "SE418")
                    .build())
                .exchange();
        response.expectStatus().isOk()
                .expectBody(String.class)
                .consumeWith(result -> {
                    System.out.println(result.getResponseBody());
                    String content = result.getResponseBody();
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(content);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    int code = 0;
                    try {
                        code = jsonObject.getInt("code");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    assertEquals(0, code);
                });;
    }
    */

}
