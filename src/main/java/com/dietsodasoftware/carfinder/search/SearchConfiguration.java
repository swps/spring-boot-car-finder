package com.dietsodasoftware.carfinder.search;

import com.infusionsoft.search.api.InfusionsoftSearchException;
import com.infusionsoft.search.api.schema.annotation.IndexSchema;
import com.infusionsoft.search.api.service.SearchServicesProvider;
import com.infusionsoft.search.api.service.index.IndexingService;
import com.infusionsoft.search.api.service.query.IndexQueryService;
import com.infusionsoft.search.api.service.schema.AggregatingSchemaProvider;
import com.infusionsoft.search.api.service.schema.SchemaProvider;
import com.infusionsoft.search.api.service.schema.SchemaRegistry;
import com.infusionsoft.search.api.service.schema.annotation.AnnotationSchemaProvider;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;

import java.util.Collections;
import java.util.Set;

/**
 * User: wendel.schultz
 * Date: 7/15/14
 */
@Configuration
@ImportResource("classpath:/carfinder-search-context.xml")
public class SearchConfiguration {

    @Autowired
    private SearchServicesProvider searchProvider;

    @Bean(name = "annotationSchemaProvider")
    public AnnotationSchemaProvider annotationSchemaProvider() throws InfusionsoftSearchException {

        final Reflections reflections = new Reflections("com.dietsodasoftware");
        final Set<Class<?>> schemaClasses = reflections.getTypesAnnotatedWith(IndexSchema.class);

        return new AnnotationSchemaProvider(schemaClasses);
    }

    @Bean(name = "searchSchemaProvider")
    @Primary
    public AggregatingSchemaProvider aggregatingSchemaProvider() throws InfusionsoftSearchException {
        return new AggregatingSchemaProvider(annotationSchemaProvider(), Collections.<SchemaProvider>emptyList());
    }

    @Bean // convenience
    public IndexingService indexer(){
        return searchProvider.getIndexingService();
    }

    @Bean // convenience
    public IndexQueryService searcher(){
        return searchProvider.getIndexQueryService();
    }

    @Bean // mandatory
    public SchemaRegistry schemaRegistry() throws InfusionsoftSearchException {
        return new SchemaRegistry(aggregatingSchemaProvider());
    }
}
