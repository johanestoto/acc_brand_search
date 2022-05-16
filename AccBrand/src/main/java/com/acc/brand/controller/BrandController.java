package com.acc.brand.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.acc.brand.repository.BrandRepository;
import com.acc.brand.request.SearchRequest;
import com.acc.brand.response.ResponseAcc;
import com.acc.brand.annotation.AllowAnnonymous;
import com.acc.brand.annotation.SearchValidation;
import com.acc.brand.constant.StatusType;
import com.acc.brand.json.result.BrandResult;
import com.acc.brand.model.*;

@RestController
public class BrandController {
	@Autowired
	private BrandRepository brandRepository;
 
	   //@AllowAnnonymous	
	   @SearchValidation
	   @GetMapping("/search")
	    public ResponseAcc  searchBrand(@RequestBody SearchRequest request) {
		   String pSearch = request.getGetListFilterUnitBrand().getPsearch();
		   List<BrandResult> listBrandResult =new ArrayList<BrandResult>();
		   if(StringUtils.hasLength(pSearch)) {
					        listBrandResult = brandRepository.findByDescBrandContainingIgnoreCaseOrderByCdBrandAsc(pSearch).stream().collect(Collectors.mapping( b ->  new BrandResult(b.getCdBrand(),b.getDescBrand()),Collectors.toList()));
		   } else {
		        listBrandResult = brandRepository.findAllByOrderByCdBrandAsc().stream().collect(Collectors.mapping( b ->  new BrandResult(b.getCdBrand(),b.getDescBrand()),Collectors.toList()));
		   }
		   return ResponseAcc.buildResponse(listBrandResult, StatusType.RESULT_SUCCESS.getCode(),
					StatusType.RESULT_SUCCESS.getMessage());
		}
   
 
	   
}
