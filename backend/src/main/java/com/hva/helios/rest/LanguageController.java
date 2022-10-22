package com.hva.helios.rest;

import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.models.Language;
import com.hva.helios.repositories.LanguageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    private final LanguageRepository languageRepo;

    public LanguageController(LanguageRepository languageRepo) {
        this.languageRepo = languageRepo;
    }

    @GetMapping("")
    public List<Language> getAll() {
        return languageRepo.getAll(languageRepo.getLanguages());
    }

    @GetMapping(path = "{id}", produces = "application/json")
    public Language getLanguage(@PathVariable int id) {
        // Create item with id
        Language item = new Language(id);

        return languageRepo.getByItem(item, languageRepo.getLanguages());
    }

    @PostMapping("")
    public Language saveLanguage(@RequestBody Language language) {
        Language item = languageRepo.saveItem(language, languageRepo.getLanguages());

        // Create body by calling the getLanguage by route
        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}")
                .buildAndExpand(item.getId()).toUri();

        // Return the item created by the getLanguage route
        return ResponseEntity.created(location).body(item).getBody();
    }

    @DeleteMapping(path = "{id}", produces = "application/json")
    public Language deleteLanguage(@PathVariable int id) {
        Language item = languageRepo.deleteById(id);

        // If item can't be found throw error
        if (item == null) {
            throw new NotFoundException("Language not found with id=" + id);
        }

        return ResponseEntity.ok(item).getBody();
    }
}
