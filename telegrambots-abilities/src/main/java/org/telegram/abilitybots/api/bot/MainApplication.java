package org.telegram.abilitybots.api.bot;

import org.telegram.abilitybots.api.bot.MyAbilityBot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MainApplication {
    private static String BOT_NAME = "My test bot";
    private static String BOT_TOKEN = "..." /* your bot's token here */;

    private static String PROXY_HOST = "192.168.0.103" /* proxy host */;
    private static Integer PROXY_PORT = 666 /* proxy port */;

        public static void main(String[] args) {
            // Initializes dependencies necessary for the base bot - Guice
            ApiContextInitializer.init();
            DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);
            // Create the TelegramBotsApi object to register your bots
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
            botOptions.setProxyHost(PROXY_HOST);
            botOptions.setProxyPort(PROXY_PORT);
            // Select proxy type: [HTTP|SOCKS4|SOCKS5] (default: NO_PROXY)
            botOptions.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);
            MyAbilityBot myAbilityBot = new MyAbilityBot(botOptions);

            try {
                // Register your newly created AbilityBot
                telegramBotsApi.registerBot(myAbilityBot);
            } catch (TelegramApiException e) {
                e.printStackTrace();

        }
    }
}
