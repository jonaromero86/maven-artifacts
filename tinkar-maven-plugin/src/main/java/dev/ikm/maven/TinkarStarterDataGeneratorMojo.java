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
package dev.ikm.maven;

import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.entity.Entity;
import dev.ikm.tinkar.entity.EntityVersion;
//import dev.ikm.tinkar.sandbox.TinkarStarterData;
//import dev.ikm.tinkar.starterdata.StarterData;
//import dev.ikm.tinkar.starterdata.UUIDUtility;
import dev.ikm.tinkar.terms.TinkarTerm;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

@Mojo(name = "generate-starter-data", defaultPhase = LifecyclePhase.INSTALL)
public class TinkarStarterDataGeneratorMojo extends AbstractMojo {

    @Parameter(name = "datastoreDirectory", defaultValue = "${project.build.directory}/tinkar-export-starter-data", readonly = true)
    File datastoreDirectory;
   /* @Parameter(name = "tinkarExportPbFile", defaultValue = "${project.build.directory}/tinkar-export-starter-data-pb.zip", readonly = true)
    File tinkarExportPbFile;
    @Parameter(name = "tinkarImportDirectory", defaultValue = "${project.build.directory}/tinkar-import-starter-data", readonly = true)
    File tinkarImportDirectory;*/

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

//        TinkarStarterData tinkarStarterData = new TinkarStarterData(datastoreDirectory);
//        tinkarStarterData.generateTinkarStarterData();

    }


}
