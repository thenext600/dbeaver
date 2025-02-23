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
package org.jkiss.dbeaver.ext.bigquery.model;

import org.jkiss.code.NotNull;
import org.jkiss.dbeaver.DBException;
import org.jkiss.dbeaver.ext.generic.model.GenericDataSource;
import org.jkiss.dbeaver.ext.generic.model.meta.GenericMetaModel;
import org.jkiss.dbeaver.model.DBPDataSourceContainer;
import org.jkiss.dbeaver.model.connection.DBPConnectionConfiguration;
import org.jkiss.dbeaver.model.connection.DBPDriver;
import org.jkiss.dbeaver.model.exec.DBCException;
import org.jkiss.dbeaver.model.impl.jdbc.JDBCExecutionContext;
import org.jkiss.dbeaver.model.runtime.DBRProgressMonitor;
import org.jkiss.utils.CommonUtils;

import java.util.HashMap;
import java.util.Map;

public class BigQueryDataSource extends GenericDataSource {

    public BigQueryDataSource(
        @NotNull DBRProgressMonitor monitor,
        @NotNull DBPDataSourceContainer container,
        @NotNull GenericMetaModel metaModel
    ) throws DBException {
        super(monitor, container, metaModel, new BigQuerySQLDialect());
    }

    @Override
    protected String getConnectionURL(DBPConnectionConfiguration connectionInfo) {
        String connectionURL = super.getConnectionURL(connectionInfo);
        if (CommonUtils.isNotEmpty(connectionURL) &&
            (connectionURL.contains("OAuthPvtKeyPath={server};") || connectionURL.contains("OAuthServiceAcctEmail=;"))
        ) {
            // Backward compatibility. We do not want to use this incorrect pattern as a URL. Better to create a new URL.
            DBPDriver driver = getContainer().getDriver();
            return driver.getDataSourceProvider().getConnectionURL(driver, connectionInfo);
        }
        return connectionURL;
    }

    @Override
    protected Map<String, String> getInternalConnectionProperties(DBRProgressMonitor monitor, DBPDriver driver, JDBCExecutionContext context, String purpose, DBPConnectionConfiguration connectionInfo) throws DBCException {
        Map<String, String> props = new HashMap<>();
        props.put(BigQueryConstants.DRIVER_PROP_PROJECT_ID, connectionInfo.getDatabaseName());
        if (connectionInfo.getUserName() != null) {
            props.put(BigQueryConstants.DRIVER_PROP_ACCOUNT, connectionInfo.getUserName());
        } else {
            props.put(BigQueryConstants.DRIVER_PROP_ACCOUNT, "");
        }

        return props;
    }

}
