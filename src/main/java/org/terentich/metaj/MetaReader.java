package org.terentich.metaj;

import java.io.IOException;
import java.net.URL;
import java.util.Map.Entry;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class MetaReader {
	private Attributes attributes;

	public MetaReader(Class<?> clazz) throws IOException {
		URL url = clazz.getProtectionDomain().getCodeSource().getLocation();
		JarFile file = new JarFile(url.getFile());
		Manifest manifest = new Manifest(file.getManifest());

		attributes = manifest.getMainAttributes();
	}

	public Attributes getAttributes() {
		return attributes;
	}
	
	public String getAttribute(Attributes.Name attribute) {
		return attributes.getValue(attribute);
	}

	public String getMetaAttribute(MetaAttributes attribute) {
		return attributes.getValue(attribute.getName());
	}

	public String getArchiverVersion() {
		return getMetaAttribute(MetaAttributes.ARCHIVER_VERSION);
	}

	public String getBuiltBy() {
		return getMetaAttribute(MetaAttributes.BUILT_BY);
	}

	public String getBuildJdk() {
		return getMetaAttribute(MetaAttributes.BUILD_JDK);
	}

	public String getClasspath() {
		return getAttribute(Attributes.Name.CLASS_PATH);
	}

	public String getContentType() {
		return getAttribute(Attributes.Name.CONTENT_TYPE);
	}

	public String getExtensionInstallation() {
		return getAttribute(Attributes.Name.EXTENSION_INSTALLATION);
	}

	public String getExtensionList() {
		return getAttribute(Attributes.Name.EXTENSION_LIST);
	}

	public String getExtensionName() {
		return getAttribute(Attributes.Name.EXTENSION_NAME);
	}

	public String getCreatedBy() {
		return getMetaAttribute(MetaAttributes.CREATED_BY);
	}

	public String getImplementationBuild() {
		return getMetaAttribute(MetaAttributes.IMPLEMENTATION_BUILD);
	}

	public String getImplementationRevision() {
		return getMetaAttribute(MetaAttributes.IMPLEMENTATION_REVISION);
	}

	public String getImplementationTimestamp() {
		return getMetaAttribute(MetaAttributes.IMPLEMENTATION_TIMESTAMP);
	}

	public String getImplementationTitle() {
		return getAttribute(Attributes.Name.IMPLEMENTATION_TITLE);
	}

	public String getImplementationUrl() {
		return getAttribute(Attributes.Name.IMPLEMENTATION_URL);
	}

	public String getImplementationVendor() {
		return getAttribute(Attributes.Name.IMPLEMENTATION_VENDOR);
	}

	public String getImplementationVendorId() {
		return getAttribute(Attributes.Name.IMPLEMENTATION_VENDOR_ID);
	}

	public String getImplementationVersion() {
		return getAttribute(Attributes.Name.IMPLEMENTATION_VERSION);
	}

	public String getMainClass() {
		return getAttribute(Attributes.Name.MAIN_CLASS);
	}

	public String getManifestVersion() {
		return getAttribute(Attributes.Name.MANIFEST_VERSION);
	}

	public String getPackage() {
		return getMetaAttribute(MetaAttributes.PACKAGE);
	}

	public String getSealed() {
		return getAttribute(Attributes.Name.SEALED);
	}

	public String getSignatureVersion() {
		return getAttribute(Attributes.Name.SIGNATURE_VERSION);
	}

	public String getSpecificationTitle() {
		return getAttribute(Attributes.Name.SPECIFICATION_TITLE);
	}

	public String getSpecificationVersion() {
		return getAttribute(Attributes.Name.SPECIFICATION_VERSION);
	}

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
