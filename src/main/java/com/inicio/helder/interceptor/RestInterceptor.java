package com.inicio.helder.interceptor;


import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.http.HttpRequest;
        import org.springframework.http.client.ClientHttpRequestExecution;
        import org.springframework.http.client.ClientHttpRequestInterceptor;
        import org.springframework.http.client.ClientHttpResponse;

        import java.io.IOException;

public class RestInterceptor implements ClientHttpRequestInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(RestInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
//        logger.info("Request URI: {}", request.getURI());
//        logger.info("Request Method: {}", request.getMethod());
//        logger.info("Request Headers: {}", request.getHeaders());

        ClientHttpResponse response = null;

        try {
            response = execution.execute(request, body);
//            logger.info("Response Status Code: {}", response.getStatusCode());
//            logger.info("Response Headers: {}", response.getHeaders());
        } catch (IOException e) {
            logger.error("Error occurred while making request: {}", e.getMessage());
            throw e; // Rethrow the exception if you want it to propagate
        }

        return response;
    }
}
