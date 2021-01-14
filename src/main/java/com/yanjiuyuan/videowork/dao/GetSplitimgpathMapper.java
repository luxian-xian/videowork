package com.yanjiuyuan.videowork.dao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
@Component
public interface GetSplitimgpathMapper {
    List<String> getsearchimglist(String Searchname);
}
