package dev.ikm.maven.common;

import dev.ikm.tinkar.common.service.CachingService;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.common.service.ServiceKeys;
import dev.ikm.tinkar.common.service.ServiceProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.File;
import java.nio.file.Files;
import java.util.function.Supplier;

public class DatastoreProxy implements Closeable {

    private static final Logger LOG = LoggerFactory.getLogger(DatastoreProxy.class);
    private final File datastoreDirectory = new File(System.getProperty("project.build.directory"), "datastore");

    public boolean start(Supplier<Boolean> startCriteria) {
        boolean canStart = startCriteria.get();
        if (canStart) {
            start();
        }
        return canStart;
    }

    public void start() {
        try {
            if (!datastoreDirectory.exists()) {
                Files.createDirectories(datastoreDirectory.toPath());
            }
            CachingService.clearAll();
            ServiceProperties.set(ServiceKeys.DATA_STORE_ROOT, datastoreDirectory);
            PrimitiveData.selectControllerByName("Open SpinedArrayStore");
            PrimitiveData.start();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        PrimitiveData.stop();
    }
}
