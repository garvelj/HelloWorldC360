package ex.demo.Lang;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Languages{
    @Id
    private String language;
    private String translation;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public Languages(String language, String translation) {
        this.language = language;
        this.translation = translation;
    }
}
