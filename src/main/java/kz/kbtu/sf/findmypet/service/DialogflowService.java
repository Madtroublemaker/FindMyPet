package kz.kbtu.sf.findmypet.service;

import com.google.cloud.dialogflow.v2.*;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DialogflowService {
    public String detectIntent(String text) throws Exception {
        String projectId = "your-dialogflow-project-id";
        SessionsClient sessionsClient = SessionsClient.create();
        SessionName session = SessionName.of(projectId, UUID.randomUUID().toString());

        TextInput.Builder textInput = TextInput.newBuilder().setText(text).setLanguageCode("ru");
        QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();

        DetectIntentRequest request = DetectIntentRequest.newBuilder()
                .setSession(session.toString())
                .setQueryInput(queryInput)
                .build();

        DetectIntentResponse response = sessionsClient.detectIntent(request);
        sessionsClient.close();

        return response.getQueryResult().getFulfillmentText();
    }
}
