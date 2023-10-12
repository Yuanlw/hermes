package com.star.hermes.util;

import com.alibaba.fastjson2.JSON;
import com.unfbx.chatgpt.OpenAiClient;
import com.unfbx.chatgpt.OpenAiStreamClient;
import com.unfbx.chatgpt.entity.completions.CompletionResponse;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * TODO
 *
 * @Author yuanlw
 **/
@Component
public class ChatUtil {

    private final static String API_KEY = "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";
    private final static String API_BASE = "https://www.pagodaplanet.top/";

    @Resource
    OpenAiStreamClient openAiStreamClient;

    @Resource
    OpenAiClient openAiClient;

    void init() {
        openAiClient = new OpenAiClient.Builder().apiHost(API_BASE).apiKey(Arrays.asList(API_KEY)).build();
        setOpenAiClient(openAiClient);
    }

    public void setOpenAiClient(OpenAiClient openAiClient) {
        this.openAiClient = openAiClient;
    }

    public void question(String question) {
        CompletionResponse completionResponse = openAiClient.completions(question);
        System.out.println(JSON.toJSONString(completionResponse));
    }

    public static void main(String[] args) {
        ChatUtil chatUtil = new ChatUtil();

        chatUtil.init();
        chatUtil.question("hello");
    }
}
