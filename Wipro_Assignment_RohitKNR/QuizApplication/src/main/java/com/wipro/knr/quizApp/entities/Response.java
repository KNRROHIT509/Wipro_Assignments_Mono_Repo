package com.wipro.knr.quizApp.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Represents a user's single response to a quiz question.")
public class Response {

    @Schema(description = "The unique ID of the question being answered.", example = "1")
    private Long id;

    @Schema(description = "The user's selected answer.", example = "String")
    private String response;
}