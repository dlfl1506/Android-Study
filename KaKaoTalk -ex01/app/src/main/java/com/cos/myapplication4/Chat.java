package com.cos.myapplication4;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Chat {
    private Integer id;
    private Integer pic;
    private String username;
    private String content;
    private String time;
}
