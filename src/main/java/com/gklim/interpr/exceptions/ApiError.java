package com.gklim.interpr.exceptions;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ApiError {

    String message;
    LocalDate localDate;

    public ApiError(String message) {
        this.message = message;
        this.localDate = LocalDate.now();
    }
}
