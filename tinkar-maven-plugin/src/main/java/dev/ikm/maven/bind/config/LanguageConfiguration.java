/*
 * Copyright © 2015 Integrated Knowledge Management (support@ikm.dev)
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
package dev.ikm.maven.bind.config;

import dev.ikm.tinkar.coordinate.Coordinates;
import dev.ikm.tinkar.coordinate.language.LanguageCoordinateRecord;

public enum LanguageConfiguration {

	US_ENGLISH_FULLY_QUALIFIED_NAME(Coordinates.Language.UsEnglishFullyQualifiedName()),
	US_ENGLISH_REGULAR_NAME(Coordinates.Language.UsEnglishRegularName()),
	ANY_LANGUAGE_DEFINITION(Coordinates.Language.AnyLanguageDefinition()),
	ANY_LANGUAGE_FULLY_QUALIFIED_NAME(Coordinates.Language.AnyLanguageFullyQualifiedName()),
	ANY_LANGUAGE_REGULAR_NAME(Coordinates.Language.AnyLanguageRegularName()),
	GB_ENGLISH_FULLY_QUALIFIED_NAME(Coordinates.Language.GbEnglishFullyQualifiedName()),
	GB_ENGLISH_PREFERRED_NAME(Coordinates.Language.GbEnglishPreferredName()),
	SPANISH_FULLY_QUALIFIED_NAME(Coordinates.Language.SpanishFullyQualifiedName()),
	SPANISH_PREFERRED_NAME(Coordinates.Language.SpanishPreferredName());

	private LanguageCoordinateRecord languageCoordinateRecord;

	LanguageConfiguration(LanguageCoordinateRecord languageCoordinate) {
		this.languageCoordinateRecord = languageCoordinate;
	}

	public LanguageCoordinateRecord getLanguageCoordinateRecord() {
		return languageCoordinateRecord;
	}
}
