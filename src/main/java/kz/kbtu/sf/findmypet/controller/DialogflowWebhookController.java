package kz.kbtu.sf.findmypet.controller;

import kz.kbtu.sf.findmypet.model.Pet;
import org.springframework.web.bind.annotation.*;
import kz.kbtu.sf.findmypet.repository.PetRepository;
import java.util.*;
import java.util.regex.*;

@RestController
@RequestMapping("/webhook")
public class DialogflowWebhookController {
    private final PetRepository petRepository;

    public DialogflowWebhookController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @PostMapping
    public Map<String, Object> handleDialogflowRequest(@RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Получаем текст запроса от пользователя
            Object result = request.get("queryResult");
            Map<String, Object> queryResult;
            if (result instanceof Map) {
                queryResult = (Map<String, Object>) result;
            } else {
                throw new IllegalArgumentException("Invalid queryResult format");
            }
            String userMessage = (String) queryResult.get("queryText");

            // Извлекаем имя питомца с помощью регулярки (можно улучшить)
            String petName = extractPetName(userMessage);

            if (petName != null) {
                Optional<Pet> pet = petRepository.findByName(petName);
                if (pet.isPresent()) {
                    response.put("fulfillmentText", "Питомец " + petName + " был последний раз замечен в " );
                } else {
                    response.put("fulfillmentText", "Здравствуйте, к сожалению, мы не располагаем местоположением кота " + petName + ". Пожалуйста, создайте пост о пропаже.");
                }
            } else {
                response.put("fulfillmentText", "Пожалуйста, укажите кличку питомца, чтобы мы могли его найти.");
            }
        } catch (Exception e) {
            response.put("fulfillmentText", "Произошла ошибка при обработке запроса.");
        }
        return response;
    }

    // Метод для извлечения имени питомца из текста
    private String extractPetName(String text) {
        // Регулярка ищет слово после "кот", "собака", "щенок", "попугай" и т. д.
        Pattern pattern = Pattern.compile("(Dog|CAt|кот|собака|щенок|попугай|кошка)\\s+(\\p{Lu}\\p{L}+)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find() ? matcher.group(2) : null;
    }
}
