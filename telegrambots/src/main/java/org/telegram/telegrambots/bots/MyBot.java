package org.telegram.telegrambots.bots;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Connection;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.util.httpsPost;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class MyBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){
            SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                    .setChatId(update.getMessage().getChatId());
            if (update.getMessage().getText().equals("stop"))
            {
                StringBuilder response = new StringBuilder();
                Connection.Response resp = null;
                String POST_URL = "https://api.golinkapi.com/connect/stop-counting";
                Map<String, String> headers = new HashMap<>();
                Map<String, String> param = new HashMap<>();
                headers.put("Host", "api.golinkapi.com");
                headers.put("Accept", "*/*");
                headers.put("cache-control", "no-cache");
                headers.put("Content-Type", "application/x-www-form-urlencoded");
                headers.put("format", "JSON_ESCAPED_UNICODE");
                headers.put("Content-Length", "711");
                param.put("token", "123");
                param.put("mask", "27242727727775772D7276272C232770232125227276712D2220752571257672");
                param.put("version", "253A243A213A26");
                param.put("platform", "20");
                param.put("ip", "202D3A2525273A25252D3A2521203434");
                try {
                    resp = httpsPost.post(headers, POST_URL, param);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if ("200".equals(String.valueOf(resp.statusCode()))) {
                    System.out.println(resp.body());
                    System.out.println(URLDecoder.decode(resp.body()));
                    System.out.println(" 返回状态" + JSONObject.parseObject(resp.body()).getString("code"));
                    System.out.println(" 返回数据" + JSONObject.parseObject(resp.body()).getString("data").toString());
                    response.append("返回码：").append(JSONObject.parseObject(resp.body()).getString("code") + "\n")
                            .append("返回数据：").append(JSONObject.parseObject(resp.body()).getString("data").toString());
                    message.setText(response.toString());
                } else {
                    response.append("操作失败，请查看日志");
                }
            }
            else {
                message.setText(update.getMessage().getText());
            }
/*            SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                    .setChatId(update.getMessage().getChatId())
                    .setText(update.getMessage().getText());
            */


            try {
                execute(message); // Call method to send the message
            } catch ( TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public MyBot(DefaultBotOptions options){
        super(options);
    }
    @Override
    public String getBotUsername() {
        return "fulihao_bot";
    }

    @Override
    public String getBotToken() {
        return "1375825521:AAEU1pio1gsTxp4glYVV6x1q5VktDDck7Ys";
    }
}
