package com.github.terentich.metaj;

import java.util.jar.Attributes;
import java.util.jar.Manifest;

/**
 * The possible Meta-attributes inside the manifest-file in a JAR.
 *
 * @see Manifest
 * @see Attributes
 * @see Package#getImplementationTitle()
 * @see Package#getImplementationVendor()
 * @see Package#getImplementationVersion()
 * @see Package#getSpecificationTitle()
 * @see Package#getSpecificationVendor()
 * @see Package#getSpecificationVersion()
 *
 * @author Alexey V. Terentyev
 * @date 08.10.2012
 */
public enum MetaAttributes {
    /**
     * The version of the JAR-archiver.
     */
    ARCHIVER_VERSION("Archiver-Version"),

    /**
     * The build automation tool (e. x. Maven) which was used for creating
     * JAR-file.
     */
    BUILT_BY("Built-By"),

    /**
     * The JDK information which was used for compiling classes in the JAR-file.
     */
    BUILD_JDK("Build-Jdk"),

    /**
     * The name of an OS-user which created the JAR-file. *
     */
    CREATED_BY("Created-By"),

    /**
     * The implementation CI-server build version.
     */
    IMPLEMENTATION_BUILD("Implementation-Build"),

    /**
     * The implementation SCM-revision.
     */
    IMPLEMENTATION_REVISION("Implementation-Revision"),

    /**
     * The time stamp when the JAR-file was build.
     */
    IMPLEMENTATION_TIMESTAMP("Implementation-Timestamp"),

    /**
     * The package's name of the JAR-file.
     */
    PACKAGE("Package");

    private String name;

    private MetaAttributes(String name) {
        this.name = name;
    }

    /**
     * Returns the attribute's name.
     *
     * @return the attribute's name
     */
    public String getName() {
        return name;
    }
}
