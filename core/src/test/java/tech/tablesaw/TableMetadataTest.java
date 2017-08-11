package tech.tablesaw;

import org.junit.Before;
import org.junit.Test;

import tech.tablesaw.api.FloatColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;
import tech.tablesaw.store.TableMetadata;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class TableMetadataTest {

    private Table table;
    private Column column1 = new FloatColumn("f1");
    private Column column2 = new FloatColumn("i1");

    @Before
    public void setUp() throws Exception {
        table = Table.create("t");
        table.addColumn(column1);
        table.addColumn(column2);
    }

    @Test
    public void testToJson() {
        TableMetadata tableMetadata = new TableMetadata(table);
        assertEquals(tableMetadata, TableMetadata.fromJson(tableMetadata.toJson()));
    }
}