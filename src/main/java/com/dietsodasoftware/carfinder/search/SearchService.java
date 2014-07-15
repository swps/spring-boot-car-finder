package com.dietsodasoftware.carfinder.search;

import com.dietsodasoftware.carfinder.model.VehicleOffering;
import com.dietsodasoftware.carfinder.service.VehicleOfferingService;
import com.google.common.collect.Lists;
import com.infusionsoft.search.api.IndexDocumentSchema;
import com.infusionsoft.search.api.InfusionsoftSearchException;
import com.infusionsoft.search.api.service.query.IndexQueryService;
import com.infusionsoft.search.api.service.query.QueryResponse;
import com.infusionsoft.search.api.service.schema.SchemaRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: wendel.schultz
 * Date: 7/15/14
 */
@Service
public class SearchService {

    @Autowired
    private VehicleOfferingService offeringService;

    @Autowired
    private SchemaRegistry schemaRegistry;

    @Autowired
    private IndexQueryService searcher;

    public SearchResult<VehicleOffering> searchForOffering(String term) throws InfusionsoftSearchException {

        IndexDocumentSchema offeringSchema = schemaRegistry.getSchema(IndexService.VEHICLE_OFFERING_TYPE_NAME);

        QueryResponse response = searcher.queryAllFields(IndexService.CARFINDER_INDEX_NAME,
                term,
                Lists.newArrayList(offeringSchema));

        List<Long> ids = SearchResult.getIds(response);

        List<VehicleOffering> results = offeringService.findAll(ids);
        int resultCount = response.getQueryResults().size();
        int totalCount = response.getResultCount();

        return new SearchResult<VehicleOffering>(results, resultCount, totalCount);

    }

}
