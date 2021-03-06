// Copyright 2018-2019 Workiva Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.workiva.eva.client.builders;

import org.apache.commons.lang3.ArrayUtils;

import com.workiva.eva.client.Database;
import com.workiva.eva.client.RequestBuilder;

import java.util.List;

/** Creates Query requests. */
public class QueryBuilder extends RequestBuilder<QueryBuilder, Object> {
  final List query;
  Object[] args;
  private Database db;

  public QueryBuilder(Database db, List query) {
    super(db);
    this.db = db;
    this.query = query;
  }

  public QueryBuilder withArgs(Object... args) {
    this.args = args;
    return this;
  }

  public Object execute() {
    buildContext();
    if (args == null) {
      args = new Object[0];
    }

    Object[] argsWithDb = ArrayUtils.add(args, 0, db);
    return clientHelper.query(buildContext(), getRequestHeaders(), query, argsWithDb);
  }
}
