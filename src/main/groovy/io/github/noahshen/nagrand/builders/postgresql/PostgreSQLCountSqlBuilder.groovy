package io.github.noahshen.nagrand.builders.postgresql
import io.github.noahshen.nagrand.builders.BaseCountSqlBuilder
import io.github.noahshen.nagrand.builders.BuildResult
import io.github.noahshen.nagrand.metadata.ClassMetaData

class PostgreSQLCountSqlBuilder extends BaseCountSqlBuilder {

    PostgreSQLCountSqlBuilder(ClassMetaData classMetaData) {
        super(classMetaData)
    }

    @Override
    BuildResult buildSqlAndValues() {
        def values = []
        def where = PostgreSQLStatementBuilders.generateQuerySql(queryCondition, classMetaData, values)
        def sql = "SELECT COUNT(1) as \"count\" FROM `${classMetaData.tableName}`${where}"
        new BuildResult(sql: sql, values: values)
    }
}
