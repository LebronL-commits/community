package life.study.lxj.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class PageDto {
    private List<QuestionDto> question;
    private boolean showPrevision;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer Page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;

    public void setPagenation(Integer totalcount, Integer page, Integer size) {
        int x = totalcount / size;
        if(totalcount%size == 0){
            totalPage = x;
        }else{
            totalPage = x+1;
        }
        if(page<1){
            page =1 ;
        }
        if(page>totalPage){
            page = totalPage;
        }
        this.Page = page;
        pages.add(page);
        for(int i = 1;i<=3;i++){
            if(page - i >0){
                pages.add(0,page-i);
            }
            if(page + i <= totalPage){
                pages.add(page+i);
            }
        }
        if(page == 1){
            showPrevision = false;
        }else {
            showPrevision = true;
            //showNext = true;
        }
        if(page == totalPage){
            showNext = false;
        }else {
            showNext = true;
        }

        //是否展示第一页
        if(pages.contains(1)){
            showFirstPage = false;
        }else {
            showFirstPage = true;
        }

        if(pages.contains(totalPage)){
            showEndPage = false;
        }else{
            showEndPage = true;
        }


    }
}
