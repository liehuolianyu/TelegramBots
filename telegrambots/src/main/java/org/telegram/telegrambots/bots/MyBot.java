package org.telegram.telegrambots.bots;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){
            SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                    .setChatId(update.getMessage().getChatId())
                    .setText(update.getMessage().getText());
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
