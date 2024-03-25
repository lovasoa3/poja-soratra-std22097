package hei.school.soratra.endpoint.rest.controller.health;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SoratraController {

    private Map<String, String> phrases = new HashMap<>();

    @PutMapping("/soratra/{id}")
    public ResponseEntity<Object> putSoratra(@PathVariable String id, @RequestBody Map<String, String> data) {
        String phrasePoetique = data.get("phrase_poetique");
        phrases.put(id, phrasePoetique);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/soratra/{id}")
    public ResponseEntity<Object> getSoratra(@PathVariable String id) {
        String phrasePoetique = phrases.get(id);
        if (phrasePoetique == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


        String originalUrl = "https://original.url/soratra/" + id + "/original.txt";
        String transformedUrl = "https://transformed.url/soratra/" + id + "/transformed.txt";

        Map<String, String> response = new HashMap<>();
        response.put("original_url", originalUrl);
        response.put("transformed_url", transformedUrl);

        return ResponseEntity.ok(response);
    }
}
