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

package org.jkiss.dbeaver.model.logical;

import org.jkiss.dbeaver.model.struct.DBSObjectContainer;

import java.util.List;

/**
 * Logical schema
 */
public class DBSLogicalSchema extends DBSLogicalObject<DBSObjectContainer> {

    private List<DBSLogicalEntity> entities;

    public List<DBSLogicalEntity> getEntities() {
        return entities;
    }

    public void setEntities(List<DBSLogicalEntity> entities) {
        this.entities = entities;
    }
}
