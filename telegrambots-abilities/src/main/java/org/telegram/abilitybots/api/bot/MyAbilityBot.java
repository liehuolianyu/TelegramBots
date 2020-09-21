package org.telegram.abilitybots.api.bot;

import jdk.nashorn.internal.parser.Token;
import org.json.JSONObject;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Locality;
import org.telegram.abilitybots.api.objects.Privacy;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class MyAbilityBot extends AbilityBot {
    public static final String Token = "1375825521:AAEU1pio1gsTxp4glYVV6x1q5VktDDck7Ys";
    public static final String USERNAME = "fulihao_bot";

    @Override
    public int creatorId() {
        return 1375825521;
    }

    public MyAbilityBot(DefaultBotOptions options){
        super(Token,USERNAME,options);
    }
    public Ability sayHelloWorld() {
        return Ability
                .builder()
                .name("hello")
                .info("says hello world!")
                .locality(Locality.ALL)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> silent.send("Hello world!", ctx.chatId()))
                .build();
    }
}