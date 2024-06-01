package com.learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DatabaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConsumer.class);
    @Autowired
    private  WikimediaRepository wikimediaRepository;

    @KafkaListener(topics = "wikimedia_recentchanges", groupId = "learnGrp")
    public void consumer(String eventMessage){
        LOGGER.info(String.format("Message received -> %s",eventMessage));
        WikimediaEntity wikimediaEntity = new WikimediaEntity(eventMessage);
        wikimediaRepository.save(wikimediaEntity);


    }


}
