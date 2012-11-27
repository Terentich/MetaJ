package com.github.terentich.metaj;

import java.io.IOException;
import java.net.URL;
import java.util.Map.Entry;
import java.util.jar.Attributes;
import java.util.jar.Attributes.Name;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * The reader used for retrieving Meta-information inside JAR-file or in the
 * file system for unpacked applications (MANIFEST.MF). <br/>
 *
 * The main goal of an usage - get Meta-information in the runtime from the
 * current JAR-file in desktop/server applications: <br/>
 *
 * <pre>
 * ...
 * Attributes attributes = new MetaReader(ClassInJar.class).getAttributes();
 * ...
 * </pre>
 *
 * or
 *
 * <pre>
 * public class ExampleServlet extends HttpServlet {
 *         ...
 *         Attributes attributes = new MetaReader(this.getClass()).getAttributes();
 *         ...
 * }
 * </pre>
 *
 * @author Alexey V. Terentyev
 * @date 08.10.2012
 */
public class MetaReader {
    private static final String JAR_EXTENSION = ".jar";

    private Attributes attributes;

    /**
     * Create the MetaReader by specified class from the JAR-file or any other
     * class for the unpacked application.
     *
     * @param clazz
     *            the given class from the JAR-file
     * @throws IOException
     *             if some I/O exception occurs
     */
    public MetaReader(Class<?> clazz) throws IOException {
        URL url = clazz.getProtectionDomain().getCodeSource().getLocation();
        Manifest manifest;

        if (url.getFile().endsWith(JAR_EXTENSION)) {
            JarFile file = new JarFile(url.getFile());
            manifest = file.getManifest();
        } else {
            url = new URL(url.toString().concat(JarFile.MANIFEST_NAME));
            manifest = new Manifest(url.openStream());
        }

        attributes = manifest.getMainAttributes();
    }

    /**
     * Returns the main Manifest attributes.
     *
     * @see Manifest#getMainAttributes()
     * @return the attributes
     */
    public Attributes getAttributes() {
        return attributes;
    }

    /**
     * Returns the attribute from the main Manifest attributes by the specified
     * attribute's name.
     *
     * @param attribute
     *            the given name
     * @return the attribute
     */
    public String getAttribute(Attributes.Name attribute) {
        return attributes.getValue(attribute);
    }

    /**
     * Returns the meta-attribute (see {@link MetaAttributes}) by the specified
     * attribute's name.
     *
     * @param attribute
     *            the given name
     * @return the meta-attribute
     */
    public String getMetaAttribute(MetaAttributes attribute) {
        return attributes.getValue(attribute.getName());
    }

    /**
     * Returns archiver version.
     *
     * @see MetaAttributes#ARCHIVER_VERSION
     * @return the version
     */
    public String getArchiverVersion() {
        return getMetaAttribute(MetaAttributes.ARCHIVER_VERSION);
    }

    /**
     * Returns the built by information.
     *
     * @see MetaAttributes#BUILT_BY
     * @return the built information
     */
    public String getBuiltBy() {
        return getMetaAttribute(MetaAttributes.BUILT_BY);
    }

    /**
     * Returns the JDK-build information.
     *
     * @see MetaAttributes#BUILD_JDK
     * @return the JDK information
     */
    public String getBuildJdk() {
        return getMetaAttribute(MetaAttributes.BUILD_JDK);
    }

    /**
     * Returns the classpath information.
     *
     * @see Name#CLASS_PATH
     * @return the classpath
     */
    public String getClasspath() {
        return getAttribute(Attributes.Name.CLASS_PATH);
    }

    /**
     * Returns the content-type information.
     *
     * @see Name#CONTENT_TYPE
     * @return the content type
     */
    public String getContentType() {
        return getAttribute(Attributes.Name.CONTENT_TYPE);
    }

    /**
     * Returns the extension installation information.
     *
     * @see Name#EXTENSION_INSTALLATION
     * @return the extension installation
     */
    public String getExtensionInstallation() {
        return getAttribute(Attributes.Name.EXTENSION_INSTALLATION);
    }

    /**
     * Returns the extension list.
     *
     * @see Name#EXTENSION_LIST
     * @return the extension list
     */
    public String getExtensionList() {
        return getAttribute(Attributes.Name.EXTENSION_LIST);
    }

    /**
     * Returns the extension name.
     *
     * @see Name#EXTENSION_NAME
     * @return the extension name
     */
    public String getExtensionName() {
        return getAttribute(Attributes.Name.EXTENSION_NAME);
    }

    /**
     * Returns the information about creator.
     *
     * @see MetaAttributes#CREATED_BY
     * @return the creator information
     */
    public String getCreatedBy() {
        return getMetaAttribute(MetaAttributes.CREATED_BY);
    }

    /**
     * Returns the information about CI-server build version.
     *
     * @see MetaAttributes#IMPLEMENTATION_BUILD
     * @return the build version
     */
    public String getImplementationBuild() {
        return getMetaAttribute(MetaAttributes.IMPLEMENTATION_BUILD);
    }

    /**
     * Returns the SCM-revision version.
     *
     * @see MetaAttributes#IMPLEMENTATION_REVISION
     * @return the revision
     */
    public String getImplementationRevision() {
        return getMetaAttribute(MetaAttributes.IMPLEMENTATION_REVISION);
    }

    /**
     * Returns the extension name.
     *
     * @see MetaAttributes#IMPLEMENTATION_BUILD
     * @return the extension name
     */
    public String getImplementationTimestamp() {
        return getMetaAttribute(MetaAttributes.IMPLEMENTATION_TIMESTAMP);
    }

    /**
     * Returns the implementation title.
     *
     * @see Name#IMPLEMENTATION_TITLE
     * @return the implementation title
     */
    public String getImplementationTitle() {
        return getAttribute(Attributes.Name.IMPLEMENTATION_TITLE);
    }

    /**
     * Returns the implementation URL.
     *
     * @see Name#IMPLEMENTATION_URL
     * @return the implementation URL
     */
    public String getImplementationUrl() {
        return getAttribute(Attributes.Name.IMPLEMENTATION_URL);
    }

    /**
     * Returns the implementation vendor.
     *
     * @see Name#IMPLEMENTATION_VENDOR
     * @return the implementation vendor
     */
    public String getImplementationVendor() {
        return getAttribute(Attributes.Name.IMPLEMENTATION_VENDOR);
    }

    /**
     * Returns the implementation vendor identifier.
     *
     * @see Name#IMPLEMENTATION_VENDOR_ID
     * @return the implementation vendor identifier
     */
    public String getImplementationVendorId() {
        return getAttribute(Attributes.Name.IMPLEMENTATION_VENDOR_ID);
    }

    /**
     * Returns the implementation version.
     *
     * @see Name#IMPLEMENTATION_VERSION
     * @return the implementation version
     */
    public String getImplementationVersion() {
        return getAttribute(Attributes.Name.IMPLEMENTATION_VERSION);
    }

    /**
     * Returns the main class.
     *
     * @see Name#MAIN_CLASS
     * @return the main class
     */
    public String getMainClass() {
        return getAttribute(Attributes.Name.MAIN_CLASS);
    }

    /**
     * Returns the manifest version.
     *
     * @see Name#MANIFEST_VERSION
     * @return the manifest version
     */
    public String getManifestVersion() {
        return getAttribute(Attributes.Name.MANIFEST_VERSION);
    }

    /**
     * Returns the package information.
     *
     * @see MetaAttributes#PACKAGE
     * @return the package information
     */
    public String getPackage() {
        return getMetaAttribute(MetaAttributes.PACKAGE);
    }

    /**
     * Returns the sealed information.
     *
     * @see Name#SEALED
     * @return the sealed information
     */
    public String getSealed() {
        return getAttribute(Attributes.Name.SEALED);
    }

    /**
     * Returns the signature version.
     *
     * @see Name#SIGNATURE_VERSION
     * @return the signature version
     */
    public String getSignatureVersion() {
        return getAttribute(Attributes.Name.SIGNATURE_VERSION);
    }

    /**
     * Returns the specification.
     *
     * @see Name#SPECIFICATION_TITLE
     * @return the specification title
     */
    public String getSpecificationTitle() {
        return getAttribute(Attributes.Name.SPECIFICATION_TITLE);
    }

    /**
     * Returns the specification version.
     *
     * @see Name#SPECIFICATION_VERSION
     * @return the specification version
     */
    public String getSpecificationVersion() {
        return getAttribute(Attributes.Name.SPECIFICATION_VERSION);
    }

    /**
     * Returns the specification vendor.
     *
     * @see Name#SPECIFICATION_VENDOR
     * @return the specification vendor
     */
    public String getSpecificationVendor() {
        return getAttribute(Attributes.Name.SPECIFICATION_VENDOR);
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder(getClass().getSimpleName()
                + " [\n");

        for (Entry<Object, Object> attribute : attributes.entrySet()) {
            message.append(attribute + "\n");
        }

        return message.append("]").toString();
    }
}
