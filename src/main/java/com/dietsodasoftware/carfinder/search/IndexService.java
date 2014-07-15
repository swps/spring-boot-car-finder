package com.dietsodasoftware.carfinder.search;

import com.dietsodasoftware.carfinder.model.VehicleOffering;
import com.infusionsoft.search.api.IndexDocument;
import com.infusionsoft.search.api.IndexDocumentSchema;
import com.infusionsoft.search.api.InfusionsoftSearchException;
import com.infusionsoft.search.api.service.index.IndexingService;
import com.infusionsoft.search.api.service.schema.SchemaProvider;
import com.infusionsoft.search.api.service.schema.SchemaRegistry;
import com.infusionsoft.search.api.service.schema.SchemaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * User: wendel.schultz
 * Date: 7/15/14
 */
@Service
public class IndexService {

    static final String CARFINDER_INDEX_NAME = "carfinder";
    static final String VEHICLE_OFFERING_TYPE_NAME = SchemaUtils.getDocumentType(VehicleOffering.class.getName());

    @Autowired
    private IndexingService indexer;

    @Autowired
    private SchemaProvider schemaProvider;

    @Autowired
    private SchemaRegistry schemaRegistry;

    public void index(VehicleOffering offering) throws InfusionsoftSearchException {

        String documentType = VEHICLE_OFFERING_TYPE_NAME;


        IndexDocumentSchema schema = schemaRegistry.getSchema(documentType);

        final Map<String, Object> data = schemaProvider.getData(offering);

        final IndexDocument document = new IndexDocument(offering.getId(),
                schema,
                offering.getIndexVersion(),
                data);

        indexer.index(CARFINDER_INDEX_NAME, document);
    }
}
