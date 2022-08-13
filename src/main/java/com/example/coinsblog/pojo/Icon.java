package com.example.coinsblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Icon {
    String iconName;
    String imgPath;
    String urlPath;
    String htmlClass;
}
