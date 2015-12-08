package com.company;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import java.io.InputStream;

public class Request {
    private String _apiKey;
    public Logger logger;

    public Request(String key, Logger logger) {
        this._apiKey = key;
        this.logger = logger;
    }

    public String getUrl(String uri) throws Exception {
        HttpGet req = new HttpGet(uri);
        req.setHeader("X-API-Key", this._apiKey);
        try (CloseableHttpClient client = HttpClients.createDefault();
             CloseableHttpResponse response = client.execute(req)) {
            InputStream inputStream = response.getEntity().getContent();
            String result = IOUtils.toString(inputStream, "utf-8");
            logger.debug(uri + " - " + result);
            return result;
        }
    }
}
