/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2023 DBeaver Corp and others
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jkiss.dbeaver.model.impl.jdbc.exec;

import org.jkiss.code.NotNull;
import org.jkiss.code.Nullable;
import org.jkiss.dbeaver.model.DBPDataKind;
import org.jkiss.dbeaver.model.exec.DBCAttributeMetaData;
import org.jkiss.dbeaver.model.exec.DBCException;
import org.jkiss.dbeaver.model.exec.DBCResultSet;
import org.jkiss.dbeaver.model.exec.jdbc.JDBCCallableStatement;
import org.jkiss.dbeaver.model.exec.jdbc.JDBCResultSet;
import org.jkiss.dbeaver.model.exec.jdbc.JDBCSession;
import org.jkiss.dbeaver.model.impl.local.LocalResultSet;
import org.jkiss.dbeaver.model.impl.local.LocalResultSetColumn;
import org.jkiss.dbeaver.model.struct.DBSTypedObject;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;

/**
 * Procedure result set
 */
public class JDBCResultSetCallable extends LocalResultSet<JDBCCallableStatement> implements JDBCResultSet {

    public JDBCResultSetCallable(JDBCSession session, JDBCCallableStatementImpl statement)
    {
        super(session, statement);
    }

    @Override
    public JDBCSession getSession() {
        return (JDBCSession) super.getSession();
    }

    @Override
    public ResultSet getOriginal() {
        return null;
    }

    @Override
    public void setMaxRows(long rsMaxRows) {

    }

    @Override
    public Object getAttributeValue(int index) throws DBCException {
        try {
            return this.getObject(index);
        } catch (SQLException e) {
            throw new DBCException(e, session.getExecutionContext());
        }
    }

    @Nullable
    @Override
    public Object getAttributeValue(String name) throws DBCException {
        try {
            return this.getObject(name);
        } catch (SQLException e) {
            throw new DBCException(e, session.getExecutionContext());
        }
    }

    @Override
    public boolean next() throws SQLException {
        return nextRow();
    }

    @Override
    public boolean wasNull() throws SQLException {
        return false;
    }

    @Override
    public Statement getStatement() throws SQLException {
        return statement;
    }

    public String getString(int parameterIndex) throws SQLException {
        return statement.getString(getColumnOriginalIndex(parameterIndex));
    }

    public boolean getBoolean(int parameterIndex) throws SQLException {
        return statement.getBoolean(getColumnOriginalIndex(parameterIndex));
    }

    public byte getByte(int parameterIndex) throws SQLException {
        return statement.getByte(getColumnOriginalIndex(parameterIndex));
    }

    public short getShort(int parameterIndex) throws SQLException {
        return statement.getShort(getColumnOriginalIndex(parameterIndex));
    }

    public int getInt(int parameterIndex) throws SQLException {
        return statement.getInt(getColumnOriginalIndex(parameterIndex));
    }

    public long getLong(int parameterIndex) throws SQLException {
        return statement.getLong(getColumnOriginalIndex(parameterIndex));
    }

    public float getFloat(int parameterIndex) throws SQLException {
        return statement.getFloat(getColumnOriginalIndex(parameterIndex));
    }

    public double getDouble(int parameterIndex) throws SQLException {
        return statement.getDouble(getColumnOriginalIndex(parameterIndex));
    }

    public BigDecimal getBigDecimal(int parameterIndex, int scale) throws SQLException {
        return statement.getBigDecimal(getColumnOriginalIndex(parameterIndex), scale);
    }

    public byte[] getBytes(int parameterIndex) throws SQLException {
        return statement.getBytes(getColumnOriginalIndex(parameterIndex));
    }

    public Date getDate(int parameterIndex) throws SQLException {
        return statement.getDate(getColumnOriginalIndex(parameterIndex));
    }

    public Time getTime(int parameterIndex) throws SQLException {
        return statement.getTime(getColumnOriginalIndex(parameterIndex));
    }

    public Timestamp getTimestamp(int parameterIndex) throws SQLException {
        return statement.getTimestamp(getColumnOriginalIndex(parameterIndex));
    }

    @Override
    public InputStream getAsciiStream(int columnIndex) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public InputStream getUnicodeStream(int columnIndex) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public InputStream getBinaryStream(int columnIndex) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    public URL getURL(int parameterIndex) throws SQLException {
        return statement.getURL(getColumnOriginalIndex(parameterIndex));
    }

    public String getString(String parameterName) throws SQLException {
        return statement.getString(parameterName);
    }

    public boolean getBoolean(String parameterName) throws SQLException {
        return statement.getBoolean(parameterName);
    }

    public byte getByte(String parameterName) throws SQLException {
        return statement.getByte(parameterName);
    }

    public short getShort(String parameterName) throws SQLException {
        return statement.getShort(parameterName);
    }

    public int getInt(String parameterName) throws SQLException {
        return statement.getInt(parameterName);
    }

    public long getLong(String parameterName) throws SQLException {
        return statement.getLong(parameterName);
    }

    public float getFloat(String parameterName) throws SQLException {
        return statement.getFloat(parameterName);
    }

    public double getDouble(String parameterName) throws SQLException {
        return statement.getDouble(parameterName);
    }

    @Override
    public BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException {
        return statement.getBigDecimal(columnLabel);
    }

    public byte[] getBytes(String parameterName) throws SQLException {
        return statement.getBytes(parameterName);
    }

    public Date getDate(String parameterName) throws SQLException {
        return statement.getDate(parameterName);
    }

    public Time getTime(String parameterName) throws SQLException {
        return statement.getTime(parameterName);
    }

    public Timestamp getTimestamp(String parameterName) throws SQLException {
        return statement.getTimestamp(parameterName);
    }

    @Override
    public InputStream getAsciiStream(String columnLabel) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public InputStream getUnicodeStream(String columnLabel) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public InputStream getBinaryStream(String columnLabel) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    public Object getObject(String parameterName) throws SQLException {
        return statement.getObject(parameterName);
    }

    @Override
    public int findColumn(String columnLabel) throws SQLException {
        return -1;
    }

    public BigDecimal getBigDecimal(String parameterName) throws SQLException {
        return statement.getBigDecimal(parameterName);
    }

    public Object getObject(String parameterName, Map<String, Class<?>> map) throws SQLException {
        return statement.getObject(parameterName, map);
    }

    public Ref getRef(String parameterName) throws SQLException {
        return statement.getRef(parameterName);
    }

    public Blob getBlob(String parameterName) throws SQLException {
        return statement.getBlob(parameterName);
    }

    public Clob getClob(String parameterName) throws SQLException {
        return statement.getClob(parameterName);
    }

    public Array getArray(String parameterName) throws SQLException {
        return statement.getArray(parameterName);
    }

    @Override
    public Date getDate(int columnIndex, Calendar cal) throws SQLException {
        return statement.getDate(getColumnOriginalIndex(columnIndex));
    }

    public Date getDate(String parameterName, Calendar cal) throws SQLException {
        return statement.getDate(parameterName, cal);
    }

    @Override
    public Time getTime(int columnIndex, Calendar cal) throws SQLException {
        return statement.getTime(getColumnOriginalIndex(columnIndex));
    }

    public Time getTime(String parameterName, Calendar cal) throws SQLException {
        return statement.getTime(parameterName, cal);
    }

    @Override
    public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
        return statement.getTimestamp(getColumnOriginalIndex(columnIndex));
    }

    public Timestamp getTimestamp(String parameterName, Calendar cal) throws SQLException {
        return statement.getTimestamp(parameterName, cal);
    }

    public URL getURL(String parameterName) throws SQLException {
        return statement.getURL(parameterName);
    }

    @Override
    public Object getObject(int columnIndex, Map<String, Class<?>> map) throws SQLException {
        return statement.getObject(getColumnOriginalIndex(columnIndex));
    }

    @Override
    public Ref getRef(int columnIndex) throws SQLException {
        return statement.getRef(getColumnOriginalIndex(columnIndex));
    }

    @Override
    public Blob getBlob(int columnIndex) throws SQLException {
        return statement.getBlob(getColumnOriginalIndex(columnIndex));
    }

    @Override
    public Clob getClob(int columnIndex) throws SQLException {
        return statement.getClob(getColumnOriginalIndex(columnIndex));
    }

    @Override
    public Array getArray(int columnIndex) throws SQLException {
        return statement.getArray(getColumnOriginalIndex(columnIndex));
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return null;
    }

    @Override
    public void clearWarnings() throws SQLException {

    }

    @Override
    public String getCursorName() throws SQLException {
        return null;
    }

    @Override
    public ResultSetMetaData getMetaData() throws SQLException {
        return null;
    }

    @Override
    public Object getObject(int columnIndex) throws SQLException {
        return statement.getObject(getColumnOriginalIndex(columnIndex));
    }

    @Override
    public boolean isBeforeFirst() throws SQLException {
        return curPosition < 0;
    }

    @Override
    public boolean isAfterLast() throws SQLException {
        return curPosition >= rows.size();
    }

    @Override
    public boolean isFirst() throws SQLException {
        return curPosition == 0;
    }

    @Override
    public boolean isLast() throws SQLException {
        return curPosition == 0;
    }

    @Override
    public void beforeFirst() throws SQLException {
        curPosition = -1;
    }

    @Override
    public void afterLast() throws SQLException {
        curPosition = rows.size();
    }

    @Override
    public boolean first() throws SQLException {
        curPosition = 0;
        return true;
    }

    @Override
    public boolean last() throws SQLException {
        curPosition = rows.size() - 1;
        return true;
    }

    @Override
    public int getRow() throws SQLException {
        return curPosition;
    }

    @Override
    public boolean absolute(int row) throws SQLException {
        curPosition = row;
        return true;
    }

    @Override
    public boolean relative(int rows) throws SQLException {
        curPosition += rows;
        return true;
    }

    @Override
    public boolean previous() throws SQLException {
        curPosition--;
        return true;
    }

    @Override
    public void setFetchDirection(int direction) throws SQLException {

    }

    @Override
    public int getFetchDirection() throws SQLException {
        return FETCH_FORWARD;
    }

    @Override
    public void setFetchSize(int rows) throws SQLException {

    }

    @Override
    public int getFetchSize() throws SQLException {
        return 1;
    }

    @Override
    public int getType() throws SQLException {
        return TYPE_SCROLL_SENSITIVE;
    }

    @Override
    public int getConcurrency() throws SQLException {
        return CONCUR_READ_ONLY;
    }

    @Override
    public boolean rowUpdated() throws SQLException {
        return false;
    }

    @Override
    public boolean rowInserted() throws SQLException {
        return false;
    }

    @Override
    public boolean rowDeleted() throws SQLException {
        return false;
    }

    @Override
    public void updateNull(int columnIndex) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBoolean(int columnIndex, boolean x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateByte(int columnIndex, byte x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateShort(int columnIndex, short x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateInt(int columnIndex, int x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateLong(int columnIndex, long x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateFloat(int columnIndex, float x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateDouble(int columnIndex, double x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateString(int columnIndex, String x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBytes(int columnIndex, byte[] x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateDate(int columnIndex, Date x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateTime(int columnIndex, Time x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateObject(int columnIndex, Object x, int scaleOrLength) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateObject(int columnIndex, Object x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateNull(String columnLabel) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBoolean(String columnLabel, boolean x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateByte(String columnLabel, byte x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateShort(String columnLabel, short x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateInt(String columnLabel, int x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateLong(String columnLabel, long x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateFloat(String columnLabel, float x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateDouble(String columnLabel, double x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBigDecimal(String columnLabel, BigDecimal x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateString(String columnLabel, String x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBytes(String columnLabel, byte[] x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateDate(String columnLabel, Date x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateTime(String columnLabel, Time x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateTimestamp(String columnLabel, Timestamp x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateAsciiStream(String columnLabel, InputStream x, int length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBinaryStream(String columnLabel, InputStream x, int length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateCharacterStream(String columnLabel, Reader reader, int length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateObject(String columnLabel, Object x, int scaleOrLength) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateObject(String columnLabel, Object x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void insertRow() throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateRow() throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void deleteRow() throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void refreshRow() throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void cancelRowUpdates() throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void moveToInsertRow() throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void moveToCurrentRow() throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateRef(int columnIndex, Ref x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateRef(String columnLabel, Ref x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBlob(int columnIndex, Blob x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBlob(String columnLabel, Blob x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateClob(int columnIndex, Clob x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateClob(String columnLabel, Clob x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateArray(int columnIndex, Array x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateArray(String columnLabel, Array x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public RowId getRowId(int columnIndex) throws SQLException {
        return statement.getRowId(getColumnOriginalIndex(columnIndex));
    }

    @Override
    public RowId getRowId(String columnLabel) throws SQLException {
        return statement.getRowId(columnLabel);
    }

    public NClob getNClob(int parameterIndex) throws SQLException {
        return statement.getNClob(getColumnOriginalIndex(parameterIndex));
    }

    public NClob getNClob(String parameterName) throws SQLException {
        return statement.getNClob(parameterName);
    }

    public SQLXML getSQLXML(int parameterIndex) throws SQLException {
        return statement.getSQLXML(getColumnOriginalIndex(parameterIndex));
    }

    public SQLXML getSQLXML(String parameterName) throws SQLException {
        return statement.getSQLXML(parameterName);
    }

    public String getNString(int parameterIndex) throws SQLException {
        return statement.getNString(getColumnOriginalIndex(parameterIndex));
    }

    public String getNString(String parameterName) throws SQLException {
        return statement.getNString(parameterName);
    }

    public Reader getNCharacterStream(int parameterIndex) throws SQLException {
        return statement.getNCharacterStream(getColumnOriginalIndex(parameterIndex));
    }

    public Reader getNCharacterStream(String parameterName) throws SQLException {
        return statement.getNCharacterStream(parameterName);
    }

    public Reader getCharacterStream(int parameterIndex) throws SQLException {
        return statement.getCharacterStream(getColumnOriginalIndex(parameterIndex));
    }

    public Reader getCharacterStream(String parameterName) throws SQLException {
        return statement.getCharacterStream(parameterName);
    }

    @Override
    public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
        return statement.getBigDecimal(getColumnOriginalIndex(columnIndex));
    }

    @Override
    public void updateRowId(int columnIndex, RowId x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateRowId(String columnLabel, RowId x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public int getHoldability() throws SQLException {
        return HOLD_CURSORS_OVER_COMMIT;
    }

    @Override
    public boolean isClosed() throws SQLException {
        return false;
    }

    @Override
    public void updateNString(int columnIndex, String nString) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateNString(String columnLabel, String nString) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateNClob(String columnLabel, NClob nClob) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateClob(int columnIndex, Reader reader, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateClob(String columnLabel, Reader reader, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateNClob(int columnIndex, Reader reader, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateNClob(String columnLabel, Reader reader, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateNCharacterStream(int columnIndex, Reader x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateAsciiStream(int columnIndex, InputStream x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBinaryStream(int columnIndex, InputStream x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateCharacterStream(int columnIndex, Reader x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateAsciiStream(String columnLabel, InputStream x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBinaryStream(String columnLabel, InputStream x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateCharacterStream(String columnLabel, Reader reader) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBlob(int columnIndex, InputStream inputStream) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBlob(String columnLabel, InputStream inputStream) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateClob(int columnIndex, Reader reader) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateClob(String columnLabel, Reader reader) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateNClob(int columnIndex, Reader reader) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateNClob(String columnLabel, Reader reader) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
        return statement.getObject(getColumnOriginalIndex(columnIndex), type);
    }

    @Override
    public <T> T getObject(String columnLabel, Class<T> type) throws SQLException {
        return statement.getObject(columnLabel, type);
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    /** @deprecated Use {@link JDBCResultSetCallable#addColumn(String, DBPDataKind, int, int)} instead */
    @Override
    public DBCAttributeMetaData addColumn(String label, DBPDataKind dataKind) {
        return addColumn(label, dataKind, getColumnCount(), getColumnCount());
    }

    /** @deprecated Use {@link JDBCResultSetCallable#addColumn(String, DBSTypedObject, int, int)} instead */
    @Override
    public DBCAttributeMetaData addColumn(String label, DBSTypedObject typedObject) {
        return addColumn(label, typedObject, getColumnCount(), getColumnCount());
    }

    DBCAttributeMetaData addColumn(@NotNull String label, @NotNull DBSTypedObject typedObject, int localIndex, int originalIndex) {
        final MappedLocalResultSetColumn column = new MappedLocalResultSetColumn(this, label, typedObject, localIndex, originalIndex);
        addColumn(column);
        return column;
    }

    DBCAttributeMetaData addColumn(@NotNull String label, @NotNull DBPDataKind dataKind, int localIndex, int originalIndex) {
        final MappedLocalResultSetColumn column = new MappedLocalResultSetColumn(this, label, dataKind, localIndex, originalIndex);
        addColumn(column);
        return column;
    }

    private int getColumnOriginalIndex(int localIndex) throws SQLException {
        final DBCAttributeMetaData metaColumn = getMetaColumn(localIndex - 1);
        if (!(metaColumn instanceof MappedLocalResultSetColumn)) {
            // Should **never** reach here
            throw new SQLException("Can't get original index from local index: " + localIndex);
        }
        return ((MappedLocalResultSetColumn) metaColumn).getOriginalIndex();
    }

    /**
     * Column containing is local result set index along with original result set index.
     * <p>
     * It is useful when not every parameter of a procedure produce scalar values
     * but also cursors which we remove from local result set and instead process
     * in a new tab, making holes in the local result set.
     * <p>
     * Consider following example:
     * <pre>
     *     CREATE PROCEDURE test(OUT tab1 Table, OUT val1 INT, OUT tab2 Table, OUT val2 INT) AS
     *     BEGIN
     *        ...
     *     END
     * </pre>
     * After removing cursors (tab1, tab2), our local result set may look like: (val1, val2) which have zero-based
     * indexes (0, 1), but their real indexes are (1, 3).
     */
    private static class MappedLocalResultSetColumn extends LocalResultSetColumn {
        private final int originalIndex;

        private MappedLocalResultSetColumn(DBCResultSet resultSet, String label, DBPDataKind dataKind, int index, int originalIndex) {
            super(resultSet, index, label, dataKind);
            this.originalIndex = originalIndex;
        }

        private MappedLocalResultSetColumn(DBCResultSet resultSet, String label, DBSTypedObject typedObject, int index, int originalIndex) {
            super(resultSet, index, label, typedObject);
            this.originalIndex = originalIndex;
        }

        private int getOriginalIndex() {
            return originalIndex;
        }
    }
}
