package com.yanjiuyuan.videowork.dao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
@Component
public interface GetPathMapper {
    List<Map<String,String>> getpath();
}
