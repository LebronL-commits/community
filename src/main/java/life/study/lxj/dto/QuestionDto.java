package life.study.lxj.dto;

import life.study.lxj.model.User;
import lombok.Data;

@Data
public class QuestionDto {
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
    private User user;
}
