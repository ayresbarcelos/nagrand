package io.github.noahshen.nagrand.builders.postgresql

import io.github.noahshen.nagrand.builders.BaseDeleteSqlBuilder
import io.github.noahshen.nagrand.builders.BuildResult
import io.github.noahshen.nagrand.metadata.ClassMetaData

class PostgreSQLDeleteSqlBuilder extends BaseDeleteSqlBuilder {

    PostgreSQLDeleteSqlBuilder(ClassMetaData classMetaData) {
        super(classMetaData)
    }

    @Override
    BuildResult buildSqlAndValues() {
        def values = []
        def where = PostgreSQLStatementBuilders.generateQuerySql(queryCondition, classMetaData, values)
        def sql = "DELETE FROM `${classMetaData.tableName}`${where}"
        new BuildResult(sql: sql, values: values)
    }
}
