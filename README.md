# filter_engine
一个基于规则的过滤引擎

## 项目名称：filter_engine

## 描述：
一个基于规则的过滤引擎，设计用于灵活和动态的数据过滤。它支持多种规则类型（例如，等于、不等于、在...之中、为空、不为空）和规则组合（与、或）。它与Spring Boot集成用于提供Web服务，并使用关系数据库进行规则存储。

## 功能：
- 动态规则定义和管理。
- 支持多种规则类型。
- 支持使用AND/OR组合的复合规则。
- 数据库集成以实现规则持久化。
- 通过Spring Boot提供Web服务接口。

## 使用的技术：
- Java
- Spring Boot
- 关系数据库（例如，MySQL）

## 文件结构概览：
- src/main/java/org/lidachui/filter/ : 主要包，包含过滤规则引擎的核心部分。
- src/main/java/org/lidachui/filter/condition/ : 包含复合规则定义的包。
- src/main/java/org/lidachui/filter/core/ : 包含核心规则和规则引擎类的包。
- src/main/java/org/lidachui/filter/core/rules/: 包含不同类型规则的包。
- src/main/java/org/lidachui/filter/dal/: 包含数据访问层代码的包，例如数据库操作的mapper和model。
- src/main/java/org/lidachui/filter/service/: 包含服务层代码的包。
- src/main/java/org/lidachui/filter/web/: 包含Web控制器的包。
- src/main/resources/application.properties: Spring Boot应用程序配置文件。
- pom.xml: Maven项目文件。
