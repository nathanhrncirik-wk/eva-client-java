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

package com.workiva.eva.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/** Context object for working with the Eva Client library. */
public class EvaContext {
  private static final Logger LOGGER = LoggerFactory.getLogger(EvaContext.class);

  private final String correlationId;
  // TODO - add Open Tracing Support
  // private SpanContext spanContext;

  public EvaContext() {
    this(UUID.randomUUID().toString());
    LOGGER.warn(
        String.format(
            "Correlation ID was not provided to Eva Client Library! "
                + "Generating one to correlate Eva and ECS logs - %s",
            correlationId));
  }

  public EvaContext(String correlationId) {
    this.correlationId = correlationId;
  }

  // TODO - add Open Tracing Support
  // public EvaContext(String correlationId, SpanContext spanContext) {
  //   this.correlationId = correlationId;
  //   setSpanContext(spanContext);
  // }

  public String getCorrelationId() {
    return correlationId;
  }

  // TODO - add Open Tracing Support
  // public void setSpanContext(SpanContext spanContext) {
  //   this.spanContext = spanContext;
  // }

  // public SpanContext getSpanContext() {
  //   return spanContext;
  // }

  // TODO - inject tracing headers into request using JaegerTracing
  // public void addTracingHeaders(HttpRequestBase request) {
  //   return;
  // }
}
