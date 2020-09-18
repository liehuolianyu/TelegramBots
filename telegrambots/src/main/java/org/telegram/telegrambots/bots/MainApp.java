package org.telegram.telegrambots.bots;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class MainApp {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        DefaultBotOptions options = new DefaultBotOptions();
        options.setProxyHost("test.yangge666.top");
        options.setProxyPort(666);
        options.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);
        MyBot bot = new MyBot(options);

        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(bot);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }


}
