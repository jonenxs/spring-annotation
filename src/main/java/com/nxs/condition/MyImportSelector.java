package com.nxs.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @program: spring-annotation
 * @description: 自定义路基返回需要导入的组件
 * @author: NieXiaoshuang
 * @create: 2018-07-01 21:03
 **/
public class MyImportSelector implements ImportSelector {

    /**
     *
     * @param importingClassMetadata 当前标注@Import注解的类的所有注解信息
     * @return 导入容器的组件全类名
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//        importingClassMetadata.get
        return new String[]{"com.nxs.bean.Blue","com.nxs.bean.Yellow"};
    }
}
