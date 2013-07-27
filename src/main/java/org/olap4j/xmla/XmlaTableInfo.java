package org.olap4j.xmla;

import java.util.List;

/**
 * XML for Analysis entity representing information about a Table.
 *
 * <p>Corresponds to the XML/A {@code DBSCHEMA_TABLES_INFO} schema rowset.</p>
 */
// TODO: Is this needed????
public class XmlaTableInfo extends Entity {
    public static final XmlaTableInfo INSTANCE =
        new XmlaTableInfo();

    public RowsetDefinition def() {
        return RowsetDefinition.DBSCHEMA_TABLES_INFO;
    }

    public List<Column> columns() {
        return list(
            TableCatalog,
            TableSchema,
            TableName,
            TableType,
            TableGuid,
            Bookmarks,
            BookmarkType,
            BookmarkDataType,
            BookmarkMaximumLength,
            BookmarkInformation,
            TableVersion,
            Cardinality,
            Description,
            TablePropId);
    }

    public List<Column> sortColumns() {
        return list(); // cannot find doc -- presume unsorted
    }

    public final Column TableCatalog =
        new Column(
            "TABLE_CATALOG",
            XmlaType.String,
            null,
            Column.RESTRICTION,
            Column.OPTIONAL,
            "Catalog name. NULL if the provider does not support "
            + "catalogs.");
    public final Column TableSchema =
        new Column(
            "TABLE_SCHEMA",
            XmlaType.String,
            null,
            Column.RESTRICTION,
            Column.OPTIONAL,
            "Unqualified schema name. NULL if the provider does not "
            + "support schemas.");
    public final Column TableName =
        new Column(
            "TABLE_NAME",
            XmlaType.String,
            null,
            Column.RESTRICTION,
            Column.REQUIRED,
            "Table name.");
    public final Column TableType =
        new Column(
            "TABLE_TYPE",
            XmlaType.String,
            null,
            Column.RESTRICTION,
            Column.REQUIRED,
            "Table type. One of the following or a provider-specific "
            + "value: ALIAS, TABLE, SYNONYM, SYSTEM TABLE, VIEW, GLOBAL "
            + "TEMPORARY, LOCAL TEMPORARY, EXTERNAL TABLE, SYSTEM VIEW");
    public final Column TableGuid =
        new Column(
            "TABLE_GUID",
            XmlaType.UUID,
            null,
            Column.NOT_RESTRICTION,
            Column.OPTIONAL,
            "GUID that uniquely identifies the table. Providers that do "
            + "not use GUIDs to identify tables should return NULL in this "
            + "column.");
    public final Column Bookmarks =
        new Column(
            "BOOKMARKS",
            XmlaType.Boolean,
            null,
            Column.NOT_RESTRICTION,
            Column.REQUIRED,
            "Whether this table supports bookmarks. Allways is false.");
    public final Column BookmarkType =
        new Column(
            "BOOKMARK_TYPE",
            XmlaType.Integer,
            null,
            Column.NOT_RESTRICTION,
            Column.OPTIONAL,
            "Default bookmark type supported on this table.");
    public final Column BookmarkDataType =
        new Column(
            "BOOKMARK_DATATYPE",
            XmlaType.UnsignedShort,
            null,
            Column.NOT_RESTRICTION,
            Column.OPTIONAL,
            "The indicator of the bookmark's native data type.");
    public final Column BookmarkMaximumLength =
        new Column(
            "BOOKMARK_MAXIMUM_LENGTH",
            XmlaType.UnsignedInteger,
            null,
            Column.NOT_RESTRICTION,
            Column.OPTIONAL,
            "Maximum length of the bookmark in bytes.");
    public final Column BookmarkInformation =
        new Column(
            "BOOKMARK_INFORMATION",
            XmlaType.UnsignedInteger,
            null,
            Column.NOT_RESTRICTION,
            Column.OPTIONAL,
            "A bitmask specifying additional information about bookmarks "
            + "over the rowset. ");
    public final Column TableVersion =
        new Column(
            "TABLE_VERSION",
            XmlaType.Long,
            null,
            Column.NOT_RESTRICTION,
            Column.OPTIONAL,
            "Version number for this table or NULL if the provider does "
            + "not support returning table version information.");
    public final Column Cardinality =
        new Column(
            "CARDINALITY",
            XmlaType.UnsignedLong,
            null,
            Column.NOT_RESTRICTION,
            Column.REQUIRED,
            "Cardinality (number of rows) of the table.");
    public final Column Description =
        new Column(
            "DESCRIPTION",
            XmlaType.String,
            null,
            Column.NOT_RESTRICTION,
            Column.OPTIONAL,
            "Human-readable description of the table.");
    public final Column TablePropId =
        new Column(
            "TABLE_PROPID",
            XmlaType.UnsignedInteger,
            null,
            Column.NOT_RESTRICTION,
            Column.OPTIONAL,
            "Property ID of the table. Return null.");
}

// End XmlaTableInfo.java