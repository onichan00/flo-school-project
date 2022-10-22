package com.hva.helios.repositories;

import com.hva.helios.models.Language;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Component
@Repository
public class LanguageRepository implements CrudRepository<Language> {
    Language language1, language2, language3;
    private ArrayList<Language> languages;

    public LanguageRepository() {
        language1 = new Language(30001, "JavaScript", 2);
        language2 = new Language(30002, "Java", 3);
        language3 = new Language(30003, "Flutter", 3);

        languages = new ArrayList<>(List.of(language1, language2, language3));
    }

    public ArrayList<Language> getLanguages() {
        return languages;
    }

    /**
     * Method to delete object with the same ID
     *
     * @param id - ID of object to delete
     * @return - Deleted object
     */
    @Override
    public Language deleteById(int id) {
        int index = languages.indexOf(new Language(id));

        Language language = languages.get(index);

        languages.remove(index);

        return language;
    }

    /**
     * Method to find and return specific object from list
     *
     * @param id - ID of object to find
     * @return - Object with given ID
     */
    @Override
    public Language getById(int id) {
        Language item = new Language(id);

        for (Language language : languages) {
            if (language.equals(item)) item = language;
        }

        return item;
    }
}
