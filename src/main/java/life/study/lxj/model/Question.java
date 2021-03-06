package life.study.lxj.model;

import lombok.Data;

@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private long gmtcreate;
    private long gmtmodified;
    private Integer creator;
    private Integer viewcount;
    private Integer likecount;
    private Integer commentcount;
}
