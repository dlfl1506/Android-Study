package com.cos.myapplication2;


import com.google.android.material.appbar.AppBarLayout;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Note {
    private Integer id;
    private String title;
    private String subtitle;
    private Integer min;
}
