package com.wipro.knr.quizApp.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.knr.quizApp.entities.Question;
import com.wipro.knr.quizApp.service.QuestionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/v1")
@Tag(name = "Question Management", description = "APIs for creating, retrieving, updating, and deleting questions")
public class QuestionController {

    private final QuestionService service;

    @Operation(summary = "Add a new question", description = "Creates and saves a new question to the database.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Question created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid question data provided")
    })
    @PostMapping("/addQuestion")
    @ResponseStatus(HttpStatus.CREATED)
    public Question addQuestion(@Valid @RequestBody Question question) {
        log.info("Entered endpoint to add a new question");
        return service.saveQuestion(question);
    }

    @Operation(summary = "Get a question by its ID", description = "Retrieves a single question based on its unique ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the question"),
            @ApiResponse(responseCode = "404", description = "Question not found with the given ID")
    })
    @GetMapping("/getQuestionById/{id}")
    public Question getQuestion(@Parameter(description = "ID of the question to retrieve") @PathVariable Long id) {
        return service.getQuestion(id);
    }

    @Operation(summary = "Get all questions with pagination", description = "Retrieves a paginated list of all available questions. Use 'page', 'size', and 'sort' query parameters for pagination and sorting.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of questions")
    @GetMapping("/getAllQuestions")
    public Page<Question> findAllQuestion(Pageable pg) {
        return service.findAllQuestions(pg);
    }

    @Operation(summary = "Delete a question by its ID", description = "Deletes a question from the database using its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Question deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Question not found with the given ID")
    })
    @DeleteMapping("/deleteQuestion/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuestion(@Parameter(description = "ID of the question to delete") @PathVariable Long id) {
         service.deleteQuestion(id);
    }

    @Operation(summary = "Update a question partially by its ID", description = "Updates one or more fields of an existing question. Fields not provided in the request body will remain unchanged.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Question updated successfully"),
            @ApiResponse(responseCode = "404", description = "Question not found with the given ID")
    })
    @PatchMapping("/patchQuestion/{id}")
    public Question patchQuestion(
            @Parameter(description = "ID of the question to update") @PathVariable Long id, 
            @RequestBody Question q) {
        return service.patchQuestionById(id, q);
    }
}