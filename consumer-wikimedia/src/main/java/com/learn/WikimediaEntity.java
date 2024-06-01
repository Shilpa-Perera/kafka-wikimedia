package com.learn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "recent_changes")
@Getter
@Setter
public class WikimediaEntity {
    @Id
    private String id;
    private String wikimediaData;
    WikimediaEntity(String wikimediaData){
        this.wikimediaData = wikimediaData;
    }

}
