package br.com.alura.linguagens.api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "principaisLinguagens")
public class Linguagem {

    @Id
    private String id;
    private String title;
    private String image;
    private int ranking;

    Linguagem() {
        
    }

    public Linguagem(String title, String image, int ranking) {
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }
    
    public String getTitle() {
        return title;

    }

    public String getImage() {
        return image;

    }

    public int getRating() {
        return ranking;

    }

    public void setTitle(String title) {
        this.title = title;

    }

    public void setImage(String image) {
        this.image = image;

    }

    public void setRating(int rating) {
        this.ranking = rating;

    }

    public String getId() {
        return id;

    }

    @Override
    public String toString() {
        return "Linguagem{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", ranking=" + ranking +
                '}';
   
    }
}

