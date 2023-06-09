package ${package.Mapper};

import ${package.Entity}.${entity};
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
*  mapper接口 : ${table.comment!}
*  @author ${author}
*  @since ${date}
*/
@Mapper
@Repository
public interface ${table.mapperName} extends BaseMapper<${entity}> {

}
