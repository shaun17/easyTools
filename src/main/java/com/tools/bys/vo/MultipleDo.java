package com.tools.bys.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MultipleDo {
    private int column1;
    private String column2;
    private Date column3;
    private List<Sub> subList;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Sub{
        private int mainId;
        private int column1;
        private String column2;
        private Date column3;
    }
}
