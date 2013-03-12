package kr.pe.goodwilldd.core.scanner;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;
import org.springframework.util.SystemPropertyUtils;

/**
 * Package Class Scan
 */
public class PackageClassScanner {
	private static final Logger logger = LoggerFactory
			.getLogger(PackageClassScanner.class);
	private static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";
	private String resourcePattern = DEFAULT_RESOURCE_PATTERN;
	private String _basePackage = "";

	public PackageClassScanner() {
	}

	public void setPackageName(String basePackage) {
		_basePackage = basePackage;
	}

	public Set<BeanDefinition> getClasses() {
		Set<BeanDefinition> candidates = new LinkedHashSet<BeanDefinition>();

		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(
				resourcePatternResolver);

		String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
				+ ClassUtils.convertClassNameToResourcePath(SystemPropertyUtils
						.resolvePlaceholders(_basePackage)) + resourcePattern;

		try {
			Resource[] resources = resourcePatternResolver
					.getResources(packageSearchPath);
			for (Resource resource : resources) {
				if (resource.isReadable()) {
					try {
						MetadataReader metadataReader = metadataReaderFactory
								.getMetadataReader(resource);
						ScannedGenericBeanDefinition sbd = new ScannedGenericBeanDefinition(
								metadataReader);
						sbd.setResource(resource);
						sbd.setSource(resource);
						candidates.add(sbd);
					} catch (Throwable ex) {
						throw new BeanDefinitionStoreException(
								"Failed to read candidate component class: "
										+ resource, ex);
					}
				} else {
					logger.trace("Ignored because not readable: " + resource);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return candidates;
	}
}
