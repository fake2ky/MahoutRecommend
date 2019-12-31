# MahoutRecommend

#### 介绍
- 基于MahoutRecommend推荐算法
- GenericUserBasedRecommender：基于用户的推荐器
- GenericItemBasedRecommender：基于商品推荐器

#### 软件架构
| Spring Boot | 2.1.9.RELEASE |
| ----------- | ------------- |
| **Mybatis** | **3.4.6**     |
| **Mahout**  | **0.9**       |


#### 模块结构

```
├─config
├─controller
├─entity
├─mapper
├─recommender
└─service
    └─impl
```

#### 使用说明

1.  idea导入项目,修改数据库地址
2.  新建导入数据库SQL
3.  idea启动项目，访问http://localhost:8080
