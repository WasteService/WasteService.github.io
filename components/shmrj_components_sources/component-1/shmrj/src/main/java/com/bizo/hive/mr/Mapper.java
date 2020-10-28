package com.bizo.hive.mr;
/*
 * Copyright 2009 bizo.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
/**
 * Mapper.
 * 
 * @author larry <larry@bizo.com>
 */
public interface Mapper {
  /**
   * Maps a single row into an intermediate rows. 
   * 
   * @param record input record
   * @param output collect mapped rows.
   * @throws Exception on error
   */
  void map(String[] record, Output output) throws Exception;
}