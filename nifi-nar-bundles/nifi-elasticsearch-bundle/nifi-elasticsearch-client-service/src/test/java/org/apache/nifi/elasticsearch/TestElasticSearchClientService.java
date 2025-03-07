/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License") you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.nifi.elasticsearch;

import org.apache.nifi.controller.AbstractControllerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestElasticSearchClientService extends AbstractControllerService implements ElasticSearchClientService {
    private Map<String, Object> data;

    public TestElasticSearchClientService() {
        data = new HashMap<>();
        data.put("username", "john.smith");
        data.put("password", "testing1234");
        data.put("email", "john.smith@test.com");
        data.put("position", "Software Engineer");
    }

    @Override
    public IndexOperationResponse add(IndexOperationRequest operation, Map<String, String> requestParameters) {
        return null;
    }

    @Override
    public IndexOperationResponse bulk(List<IndexOperationRequest> operations, Map<String, String> requestParameters) {
        return null;
    }

    @Override
    public Long count(String query, String index, String type, Map<String, String> requestParameters) {
        return null;
    }

    @Override
    public DeleteOperationResponse deleteById(String index, String type, String id, Map<String, String> requestParameters) {
        return null;
    }

    @Override
    public DeleteOperationResponse deleteById(String index, String type, List<String> ids, Map<String, String> requestParameters) {
        return null;
    }

    @Override
    public DeleteOperationResponse deleteByQuery(String query, String index, String type, Map<String, String> requestParameters) {
        return null;
    }

    @Override
    public UpdateOperationResponse updateByQuery(String query, String index, String type, Map<String, String> requestParameters) {
        return null;
    }

    @Override
    public void refresh(final String index, final Map<String, String> requestParameters) {
    }

    @Override
    public Map<String, Object> get(String index, String type, String id, Map<String, String> requestParameters) {
        return data;
    }

    @Override
    public SearchResponse search(String query, String index, String type, Map<String, String> requestParameters) {
        List<Map<String, Object>> hits = new ArrayList<>();
        Map<String, Object> source = new HashMap<>();
        source.put("_source", data);
        hits.add(source);
        return new SearchResponse(hits, null, null, null, null,
                1, 100, false, null);
    }

    @Override
    public SearchResponse scroll(String scroll) {
        return search(null, null, null, null);
    }

    @Override
    public String initialisePointInTime(String index, String keepAlive) {
        return null;
    }

    @Override
    public DeleteOperationResponse deletePointInTime(String pitId) {
        return null;
    }

    @Override
    public DeleteOperationResponse deleteScroll(String scrollId) {
        return null;
    }

    @Override
    public String getTransitUrl(String index, String type) {
        return "";
    }

    public Map<String, Object> getData() {
        return data;
    }
}
