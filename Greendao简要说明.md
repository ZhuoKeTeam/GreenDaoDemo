该Demo主要是greendao的一个简单使用
主要是一对多简单关系的CRUD

# 集成greendao
1.在project的`build.gradle`中加入
```
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'org.greenrobot:greendao-gradle-plugin:3.2.1'
    }
}
```

2.在module的`build.gradle`加入

```
apply plugin: 'org.greenrobot.greendao'

dependencies {
    compile 'org.greenrobot:greendao:3.2.0'
}
```

3.在module的`build.gradle`中配置数据库相关信息

```
greendao {
    schemaVersion 1                             //数据库 版本号
    daoPackage 'baochen.greendao.dao.gen'       //生成DaoMaster类包名
    targetGenDir 'src/main/java'                //生成DaoMaster类文件夹
}
```

4.创建实体类
```
@Entity
public class Student {
    // 设置id为自增长
    @Id(autoincrement = true)
    private Long id;
    private String name;

    private Long classRoomId;
    // 设置对应的classRoomId
    @ToOne(joinProperty = "classRoomId")
    private ClassRoom classRoom;
}
```
```

@Entity
public class ClassRoom {

    @Id(autoincrement = true)
    private Long id;

    private String className;

    private Long creatTime;
    // 设置一对多的关系
    @ToMany(referencedJoinProperty = "classRoomId")
    private List<Student> students;
}
```

5.对数据库进行相关操作
对应的CRUD可以查看代码，相关代码在AndroidTest中
