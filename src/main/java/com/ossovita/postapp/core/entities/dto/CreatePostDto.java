package com.ossovita.postapp.core.entities.dto;

import com.ossovita.postapp.core.entities.Category;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class CreatePostDto {

    @NotNull
    @Size(min = 1, max = 255)
    private String author;

    @NotNull
    @Size(min = 1, max = 255)
    private String title;

    @NotNull
    @Size(min = 1, max = 255)
    private String text;

    @NotNull
    @Size(min = 1, max = 255)
    private String createdBy;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Category category;


}
