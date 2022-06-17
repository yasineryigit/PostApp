package com.ossovita.postapp.core.entities.dto;

import com.ossovita.postapp.core.entities.Category;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
@Data
public class UpdatePostDto {

    @NotNull
    @Size(min = 1, max = 255)
    private String author;

    @NotNull
    @Size(min = 1, max = 255)
    private String title;

    @NotNull
    @Size(min = 1, max = 255)
    private String updatedBy;

    @NotNull
    @Size(min = 1, max = 255)
    private String text;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Category category;
}
