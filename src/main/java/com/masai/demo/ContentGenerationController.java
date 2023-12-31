package com.masai.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "https://glowing-quokka-3e0054.netlify.app/")
public class ContentGenerationController {

    @Autowired
    private OpenAIHelper openaiHelper;

    @GetMapping("/")
    public String getMethodName() {
        return "Hello";
    }
    

    @PostMapping("/generate-text")
    public String generateText(@RequestBody TextGenerationRequest request) {
        String generatedText = openaiHelper.generateText(request.getTopic());
        return generatedText;
    }

    @PostMapping("/summarize-text")
    public String summarizeText(@RequestBody TextSummarizationRequest request) {
        String summarizedText = openaiHelper.summarizeText(request.getText());
        return summarizedText;
    }

    @PostMapping("/translate-text")
    public String translateText(@RequestBody LanguageTranslationRequest request) {
        String translatedText = openaiHelper.translateText(request.getText(), request.getSourceLanguage(), request.getTargetLanguage());
        return translatedText;
    }
}

