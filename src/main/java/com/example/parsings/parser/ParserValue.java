package com.example.parsings.parser;

import com.example.parsings.models.Values;
import com.example.parsings.service.ParsingService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;

public class ParserValue {
    @Autowired
    ParsingService parsingService;

    @Scheduled(fixedDelay = 10000)
    public void parseValues()  {
        String url = "https://cex.io/api/last_price/{symbol1}/{symbol2}";

        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Opera")
                    .timeout(5000)
                    .referrer("https://cex.io/api/last_price/{symbol1}/{symbol2}")
                    .get();

            Elements values = doc.getElementsByClass("{symbol1}/{symbol2}");
            for (Element el : values){
                String titleValues = el.ownText();
                if (!parsingService.isExist(titleValues)){
                    Values val = new Values();
                    val.setTitle(titleValues);
                    parsingService.save(val);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
