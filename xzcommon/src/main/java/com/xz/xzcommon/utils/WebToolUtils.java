package com.xz.xzcommon.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Map;

/**
* @Description:
 * @Param:
 * @return:
 * @Author: xz
 * @Date: 2019/9/20
 */
@Slf4j
public class WebToolUtils {

    private WebToolUtils() {

    }

    /**
     * @param: strUrl, paramsJson, header
     * @description: POST请求
     * @return:
     * @author:
     * @create: 2019/5/28
     */
    public static String httpPost(String strUrl, String paramsJson, Map<String, Object> header) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault();) {
            // POST请求
            HttpPost post = new HttpPost(strUrl);
            if (null != header) {
                // header
                for (Map.Entry<String, Object> entry : header.entrySet()) {
                    post.setHeader(entry.getKey(), entry.getValue().toString());
                }
            }

            if (null != paramsJson && paramsJson.length() != 0) {
                // body
                StringEntity stringEntity = new StringEntity(paramsJson, ContentType.create("application/json", "UTF-8"));
                post.setEntity(stringEntity);
            }
            return httpResult(httpClient, post);
        } catch (IOException e) {

            throw e;
        }
    }

    /**
     * @throws URISyntaxException
     * @param: strUrl, paramsJson, header
     * @description: GET请求
     * @return:
     * @author:
     * @create: 2019年5月28日
     */
    public static String httpGet(String strUrl, Map<String, Object> header) throws IOException, URISyntaxException {
        long requireTime = System.currentTimeMillis();
        try (CloseableHttpClient httpClient = HttpClients.createDefault();) {
            // get请求
            HttpGet get = new HttpGet();
            get.setURI(new URI(strUrl));
            if (null != header) {
                // header
                for (Map.Entry<String, Object> entry : header.entrySet()) {
                    get.setHeader(entry.getKey(), entry.getValue().toString());
                }
            }
//            RequestConfig build = RequestConfig.custom().setConnectionRequestTimeout(60000)
//                    .setConnectTimeout(120000)
//                    .setSocketTimeout(180000)
//                    .build();
//            get.setConfig(build);
            CloseableHttpResponse response = httpClient.execute(get);
            // 获取entity
            HttpEntity httpEntity = response.getEntity();
            // 获取返回内容
            Charset charset = ContentType.getOrDefault(httpEntity).getCharset();
            return EntityUtils.toString(httpEntity, charset);
        } catch (Exception e) {
            String re = strUrl+"请求时间==="+(System.currentTimeMillis()-requireTime);

            throw e;
        }
    }


    /**
     * 设置 连接超时、 请求超时 、 读取超时  毫秒
     *
     * @param requestConfig
     * @return
     */
    private static RequestConfig setTimeOutConfig(RequestConfig requestConfig) {
        return RequestConfig.copy(requestConfig)
                .setConnectionRequestTimeout(60000)
                .setConnectTimeout(120000)
                .setSocketTimeout(10000)
                .build();
    }

    /**
     * @Description: 发送delete请求
     * @param:
     * @company: 软通动力技术服务有限公司
     * @author: wk
     * @date: 2019/5/28 16:32
     * @version: V1.0
     * @return:
     */
    public static String httpDelete(String strUrl, Map<String, Object> header) throws IOException, URISyntaxException {

        try (CloseableHttpClient httpClient = HttpClients.createDefault();) {
            // delete请求
            HttpDelete delete = new HttpDelete();
            delete.setURI(new URI(strUrl));
            if (null != header) {
                // header
                for (Map.Entry<String, Object> entry : header.entrySet()) {
                    delete.setHeader(entry.getKey(), entry.getValue().toString());
                }
            }
            CloseableHttpResponse response = httpClient.execute(delete);
            // 获取entity
            HttpEntity httpEntity = response.getEntity();
            // 获取返回内容
            Charset charset = ContentType.getOrDefault(httpEntity).getCharset();
            return EntityUtils.toString(httpEntity, charset);
        } catch (IOException e) {

            throw e;
        }
    }

    private static String httpResult(CloseableHttpClient httpClient, HttpPost post) throws IOException {
        CloseableHttpResponse response = httpClient.execute(post);
        // 获取entity
        HttpEntity httpEntity = response.getEntity();
        // 获取返回内容
        Charset charset = ContentType.getOrDefault(httpEntity).getCharset();
        return EntityUtils.toString(httpEntity, charset);
    }
}
