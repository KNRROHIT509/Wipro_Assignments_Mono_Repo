package com.wipro.knr.quizApp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.knr.quizApp.entities.QuestionWrapper;
import com.wipro.knr.quizApp.entities.Quiz;
import com.wipro.knr.quizApp.entities.Response;
import com.wipro.knr.quizApp.service.QuizService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/quiz")
@Tag(name = "Quiz Management", description = "APIs for creating, fetching, and submitting quizzes")
public class QuizController {

    private final QuizService quizService;

    @Operation(summary = "Create a new quiz", description = "Creates a new quiz with a specified number of questions from a given category and difficulty.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Quiz Created Successfully", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Quiz.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid parameters supplied", content = @Content)
    })
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Quiz createQuiz(
            @Parameter(description = "Category of the questions for the quiz", required = true, example = "Java") @RequestParam String category,
            @Parameter(description = "Difficulty level of the questions", required = true, example = "Medium") @RequestParam String difficulty,
            @Parameter(description = "Title for the new quiz", required = true, example = "Core Java Quiz") @RequestParam String title) {
        
        return quizService.createQuiz(category, difficulty, title);
    }

    @Operation(summary = "Get quiz questions by ID", description = "Fetches a list of questions for a specific quiz, wrapped to hide the correct answers.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved quiz questions", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = QuestionWrapper.class)) }),
            @ApiResponse(responseCode = "404", description = "Quiz not found with the given ID", content = @Content)
    })
    @GetMapping("/getQuizByID/{id}")
    public List<QuestionWrapper> getQuizQuestions(@Parameter(description = "ID of the quiz to retrieve questions for") @PathVariable Long id) {
        return quizService.getQuizQuestions(id);
    }

    @Operation(summary = "Submit a quiz and get the score", description = "Submits user responses for a quiz and returns the calculated score.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully calculated and returned the score"),
            @ApiResponse(responseCode = "404", description = "Quiz not found with the given ID", content = @Content)
    })
    @PostMapping("/submitQuiz/{id}")
    public Integer submitQuiz(
            @Parameter(description = "ID of the quiz being submitted") @PathVariable long id, 
            @RequestBody List<Response> responses){
        
        return quizService.calculateResult(id, responses);
    }
}