package com.arge.issuemanagement.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by dilara.akbas on Sep, 2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
    private Date date;
    private String message;
}
