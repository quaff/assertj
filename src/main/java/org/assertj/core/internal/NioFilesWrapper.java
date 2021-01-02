/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2021 the original author or authors.
 */
package org.assertj.core.internal;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.function.Predicate;

/**
 * Wrapper for <code>{@link java.nio.file.Files}</code> to test {@link Paths}.
 */
public class NioFilesWrapper {

  private static final NioFilesWrapper INSTANCE = new NioFilesWrapper();

  /**
   * Returns the singleton instance of this class.
   * @return the singleton instance of this class.
   */
  static NioFilesWrapper instance() {
    return INSTANCE;
  }

  private NioFilesWrapper() {}

  public boolean isRegularFile(Path path) {
    return Files.isRegularFile(path);
  }

  public boolean isSymbolicLink(Path path) {
    return Files.isSymbolicLink(path);
  }

  public boolean isDirectory(Path path) {
    return Files.isDirectory(path);
  }

  public boolean exists(Path path, LinkOption... options) {
    return Files.exists(path, options);
  }

  public boolean notExists(Path path, LinkOption... options) {
    return Files.notExists(path, options);
  }

  public boolean isReadable(Path path) {
    return Files.isReadable(path);
  }

  public boolean isWritable(Path path) {
    return Files.isWritable(path);
  }

  public boolean isExecutable(Path path) {
    return Files.isExecutable(path);
  }

  public InputStream newInputStream(Path path, OpenOption... options) throws IOException {
    return Files.newInputStream(path, options);
  }

  public DirectoryStream<Path> newDirectoryStream(Path path, Predicate<Path> matcher) throws IOException {
    return Files.newDirectoryStream(path, matcher::test);
  }

  public long size(Path path) throws IOException {
    return Files.size(path);
  }

}
