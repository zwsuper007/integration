package com.zhaowei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Auther: wei.zhao
 * @Date: Create in  2018/12/5 11:21
 * @Description:
 * @Modified By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Word implements Serializable {
    private String single;
    private String word;
    private Integer rate;

}
