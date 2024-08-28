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

import dev.ikm.tinkar.common.service.CachingService;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.common.service.ServiceKeys;
import dev.ikm.tinkar.common.service.ServiceProperties;
import dev.ikm.tinkar.common.util.io.FileUtil;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Mojo(name = "start-spinedarray-datastore", defaultPhase = LifecyclePhase.INSTALL)
public class StartSpinedArrayDatastoreMojo extends AbstractMojo {

    @Parameter(name = "datastoreDirectory", defaultValue = "${project.build.directory}", readonly = true)
    File datastoreDirectory;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

        if (datastoreDirectory.isDirectory()) {
            FileUtil.recursiveDelete(datastoreDirectory);
        } else {
            try {
                Files.createDirectories(datastoreDirectory.toPath());
            } catch (IOException e) {
                throw new MojoFailureException(e.getMessage(), e);
            }
        }

        try {
            CachingService.clearAll();
            ServiceProperties.set(ServiceKeys.DATA_STORE_ROOT, datastoreDirectory);
            PrimitiveData.selectControllerByName("Open SpinedArrayStore");
            PrimitiveData.start();
        } catch (Exception e) {
            getLog().error(e.getMessage(), e);
            throw new MojoExecutionException(e.getMessage(), e);
        }
    }
}
