package com.cos.firestoreapp.model;


import com.cos.firestoreapp.model.Board;
import com.cos.firestoreapp.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDetailDto {
    private Board board;
    private User user;
}
