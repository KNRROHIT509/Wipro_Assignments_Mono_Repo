package com.wipro.knr.quizApp.entities;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
@Schema(description = "A 'wrapped' version of a Question, hiding the correct answer for quizzes.")
public class QuestionWrapper {

    @Schema(description = "The unique ID of the question.", example = "101")
    private Long id;

    @Schema(description = "The text of the question.", example = "What is the capital of France?")
    private String questionTitle;

    @Schema(description = "The first possible option.", example = "Berlin")
    private String option1;

    @Schema(description = "The second possible option.", example = "Madrid")
    private String option2;

    @Schema(description = "The third possible option.", example = "Paris")
    private String option3;

    @Schema(description = "The fourth possible option.", example = "Rome")
    private String option4;
}