package life.study.lxj.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlInlineBinaryData;

@Data
public class User {
    private Integer id;
    private String name;
    private String accountid;
    private String token;
    private long gmtcreate;
    private long gmtmodified;
    private String avatarurl;
}
