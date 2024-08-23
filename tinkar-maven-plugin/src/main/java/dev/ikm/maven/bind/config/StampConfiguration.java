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
import dev.ikm.tinkar.coordinate.stamp.StampCoordinateRecord;

public enum StampConfiguration {
	DEVELOPMENT_LATEST(Coordinates.Stamp.DevelopmentLatest()),
	MASTER_LATEST(Coordinates.Stamp.MasterLatest()),
	DEVELOPMENT_LATEST_ACTIVE_ONLY(Coordinates.Stamp.DevelopmentLatestActiveOnly()),
	MASTER_LATEST_ACTIVE_ONLY(Coordinates.Stamp.MasterLatestActiveOnly());

	private StampCoordinateRecord stampCoordinateRecord;

	StampConfiguration(StampCoordinateRecord stampCoordinateRecord) {
		this.stampCoordinateRecord = stampCoordinateRecord;
	}

	public StampCoordinateRecord getStampCoordinateRecord() {
		return stampCoordinateRecord;
	}
}
