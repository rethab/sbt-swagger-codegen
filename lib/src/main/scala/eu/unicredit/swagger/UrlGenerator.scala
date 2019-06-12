/* Copyright 2015 UniCredit S.p.A.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.unicredit.swagger

object UrlGenerator {

  private def sanitizePath(s: String): String =
    s.replaceAll("\\{([^}]+)\\}", ":$1").trim

  private def cleanDuplicateSlash(s: String): String =
    s.replaceAll("//+", "/")

  private def cleanUrl(s: String): String =
    s.replace("/?", "?").replaceAll("/$", "")

  def generateUrl(basePath: String, path: String): String =
    cleanUrl(cleanDuplicateSlash(basePath + sanitizePath(path)))
}